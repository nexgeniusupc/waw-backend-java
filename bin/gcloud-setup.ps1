#!/usr/bin/env pwsh

$PROJECT_ID = $(gcloud config get-value project)
# $PROJECT_NUMBER=$(gcloud projects describe $PROJECT_ID --format='value(projectNumber)')

$DEFAULT_REGION = "us-central1"
# $DEFAULT_ZONE = "$DEFAULT_REGION-a"

$DEFAULT_RUN_IMAGE = "us-docker.pkg.dev/cloudrun/container/hello:latest"

# Enable Google Cloud APIs
# storage-component: Cloud Storage, should be enabled by default
$SERVICE_LIST = @(
  "artifactregistry.googleapis.com",
  "clouddeploy.googleapis.com",
  "cloudbuild.googleapis.com",
  "storage-component.googleapis.com",
  "run.googleapis.com",
  "secretmanager.googleapis.com"
)
$JOINED_SERVICES = $SERVICE_LIST -Join " "
gcloud services enable $JOINED_SERVICES

# Create Docker repository with Artifact Registry
$ARTIFACT_REGISTRY_REPOSITORY_NAME = "services"
gcloud artifacts repositories create $ARTIFACT_REGISTRY_REPOSITORY_NAME `
  --location="$DEFAULT_REGION" `
  --repository-format=docker
  
# Create Cloud Build sources bucket in Cloud Storage
# Normally named `${PROJECT_ID}_cloudbuild`
gcloud storage buckets create "gs://${PROJECT_ID}_cloudbuild" `
  --location="$DEFAULT_REGION" `
  --no-public-access-prevention

# Create Cloud Build cache bucket in Cloud Storage.
# TODO: Set lifecycle policies for objects for auto-deletion:
# https://cloud.google.com/sdk/gcloud/reference/storage/buckets/update#--lifecycle-file
gcloud storage buckets create "gs://${PROJECT_ID}_caches_cloudbuild" `
  --location $DEFAULT_REGION `
  --no-public-access-prevention

# Create Cloud Deploy pipelines
gcloud deploy apply `
  --region="$DEFAULT_REGION" `
  --file api-employers/deploy/clouddeploy.yaml

gcloud deploy apply `
  --region="$DEFAULT_REGION" `
  --file api-jobs/deploy/clouddeploy.yaml

# Deploy sample containers and promote to production
gcloud deploy releases create "api-employers-initial-release" `
  --region="$DEFAULT_REGION" `
  --delivery-pipeline="api-employers-delivery-pipeline" `
  --images="app-image=$DEFAULT_RUN_IMAGE" `
  --skaffold-file="./api-employers/deploy/skaffold.yaml"

gcloud deploy releases promote `
  --region="$DEFAULT_REGION" `
  --delivery-pipeline="api-employers-delivery-pipeline" `
  --release="api-employers-initial-release" `
  --quiet

gcloud deploy releases create "api-jobs-initial-release" `
  --region="$DEFAULT_REGION" `
  --delivery-pipeline="api-jobs-delivery-pipeline" `
  --images="app-image=$DEFAULT_RUN_IMAGE" `
  --skaffold-file="./api-jobs/deploy/skaffold.yaml"

gcloud deploy releases promote `
  --region="$DEFAULT_REGION" `
  --delivery-pipeline="api-jobs-delivery-pipeline" `
  --release="api-jobs-initial-release" `
  --quiet

# Allow unauthenticated access to Cloud Run services: https://cloud.google.com/run/docs/authenticating/public#gcloud
gcloud run services add-iam-policy-binding api-employers-dev `
  --region="$DEFAULT_REGION" `
  --member="allUsers" `
  --role="roles/run.invoker"
  
gcloud run services add-iam-policy-binding api-employers-prod `
  --region="$DEFAULT_REGION" `
  --member="allUsers" `
  --role="roles/run.invoker"

gcloud run services add-iam-policy-binding api-jobs-dev `
  --region="$DEFAULT_REGION" `
  --member="allUsers" `
  --role="roles/run.invoker"
  
gcloud run services add-iam-policy-binding api-jobs-prod `
  --region="$DEFAULT_REGION" `
  --member="allUsers" `
  --role="roles/run.invoker"

# TODO: Setup a custom service account that will be used to access multiple services from Cloud Run,
# including Cloud SQL, Pub/Sub, Secret Manager and this account could have the permission to

# TODO: Setup Cloud SQL database and initialize with script

# TODO: Setup Cloud Run to use Cloud SQL database
# Associate with Run instance: https://cloud.google.com/run/docs/reference/yaml/v1

# TODO: Create connection with GitHub and repository
# https://cloud.google.com/sdk/gcloud/reference/beta/builds/connections/create/github
