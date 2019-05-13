This recipe setups y2ysync scenarion in Docker environment.

Prerequisite
============
Make sure you have the base image installed, if not you can generate the default one following the description under /recipes/base_images/readme.txt.
(the default base image name is ybase_jdk, based on centos and sapjvm, you have to provide).
Instead of generating this image you can select another one by overriding the property 'baseImage; inside your recipe, for your platform/hsql/solr image definition, e.g.:
 property 'baseImage',  'anapsix/alpine-java:8_jdk'
 

Overview:
================================
After building you'll find following images in your local Docker registry:

- y2y_sync_source_hsql
- y2y_sync_target_hsql
- y2y_sync_source_platform
- y2y_sync_target_platform
- y2y_sync_datahub-webapp

To perform follow this scenario:
================================

1) Build docker images:
-> ./install.sh -r y2ysync_dockerized buildImages

or alternatively:
-> ./install.sh -r y2ysync_dockerized createImagesStructure
-> cd work/output_images/y2ySync/
-> ./build-images.sh
-> cd -

2) Run containers with docker-compose:
-> cd recipes/y2ysync_dockerized
-> docker-compose -f docker-compose-platform-init.yaml up source_platform_init
-> docker-compose -f docker-compose-platform-init.yaml up target_platform_init
-> docker-compose up upload_datahub_extension
-> docker-compose up sourceplatform targetplatform

To browse open in a browser:
=================================
- Source platform https://localhost:8080/backoffice
- Target platform https://localhost:8081/backoffice

To run the sync proceed with standard y2ysync scenario steps.

