Simple setup with Platform only which shows how to create Docker Images of the Platform.

Prerequisite
============
Make sure you have the base image installed, if not you can generate the default one following the description under /recipes/base_images/readme.txt.
(the default base image name is ybase_jdk, based on centos and sapjvm, you have to provide).
Instead of generating this image you can select another one by overriding the property 'baseImage; inside your recipe, for your platform/hsql/solr image definition, e.g.:
 property 'baseImage',  'anapsix/alpine-java:8_jdk'


To perform follow this scenario:
================================

1) Build docker images:
-> ./install.sh -r platform_only_dockerized buildImages

or alternatively:
-> ./install.sh -r platform_only_dockerized createImagesStructure
-> cd work/output_images/simpleDeployment
-> ./build-images.sh
-> cd -

2) Run containers with docker-compose:
-> cd recipes/platform_only_dockerized
initialize platform:
-> docker-compose -f docker-compose-platform-init.yaml up
-> docker-compose up -d 
-> docker-compose scale load_balancer=1 platform_hac=2

3) Navigate to 
* https://localhost/ - hac
* http://localhost:7777/mod_cluster-manager - mod cluster manager. Available via localhost by default

To add background processing nodes:
===================================
-> docker-compose scale platform_background_processing=1

