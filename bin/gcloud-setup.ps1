$DEFAULT_REGION = "us-central1"
# $DEFAULT_ZONE = "$DEFAULT_REGION-a"

# Enable Google Cloud APIs
# storage-component: Cloud Storage, should be enabled by default
gcloud services enable `
  artifactregistry.googleapis.com `
  clouddeploy.googleapis.com `
  cloudbuild.googleapis.com `
  storage-component.googleapis.com `
  run.googleapis.com

# Create Docker repository with Artifact Registry
gcloud artifacts repositories create waw-services `
  --repository-format=docker `
  --location="$DEFAULT_REGION"

# TODO: Create Cloud Build cache bucket in Cloud Storage
# See more info in Cloud Build scripts

# TODO: Create Cloud Deploy pipelines
# gcloud deploy apply --file .\api-employers\deploy\clouddeploy.yaml --region us-central1

# TODO: Allow unauthenticated access to Cloud Run services: https://cloud.google.com/run/docs/authenticating/public#gcloud

# TODO: Setup a custom service account that will be used to access multiple services from Cloud Run,
# including Cloud SQL, Pub/Sub, Secret Manager and this account could have the permission to

# TODO: Create releases
# gcloud deploy releases create test-release-003 --region=us-central1 --delivery-pipeline=api-legacy-delivery-pipeline "--images=app-image=us-central1-docker.pkg.dev/waw-nexgenius/waw-services/api-legacy@sha256:35656776df66068ae1ee33b2ccc4926ce7311991bfa9d514e355dd5d90a64224" --skaffold-file=./config/deploy/skaffold.yaml
