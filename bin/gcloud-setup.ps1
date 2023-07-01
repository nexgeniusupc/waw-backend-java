#!/usr/bin/env pwsh

# $PROJECT_ID=$(gcloud config get-value project)
# $PROJECT_NUMBER=$(gcloud projects describe $PROJECT_ID --format='value(projectNumber)')

$DEFAULT_REGION = "us-central1"
# $DEFAULT_ZONE = "$DEFAULT_REGION-a"

# Enable Google Cloud APIs
# storage-component: Cloud Storage, should be enabled by default
gcloud services enable `
  artifactregistry.googleapis.com `
  clouddeploy.googleapis.com `
  cloudbuild.googleapis.com `
  storage-component.googleapis.com `
  run.googleapis.com `
  secretmanager.googleapis.com

# Create Docker repository with Artifact Registry
gcloud artifacts repositories create waw-services `
  --repository-format=docker `
  --location="$DEFAULT_REGION"

# TODO: Create Cloud Build cache bucket in Cloud Storage
# See more info in Cloud Build scripts

# TODO: Create Cloud Build sources bucket in Cloud Storage
# Normally named `${PROJECT_ID}_cloudbuild`

# TODO: Create Cloud Deploy pipelines
# gcloud deploy apply --file .\api-employers\deploy\clouddeploy.yaml --region us-central1

# TODO: Allow unauthenticated access to Cloud Run services: https://cloud.google.com/run/docs/authenticating/public#gcloud

# TODO: Setup a custom service account that will be used to access multiple services from Cloud Run,
# including Cloud SQL, Pub/Sub, Secret Manager and this account could have the permission to
