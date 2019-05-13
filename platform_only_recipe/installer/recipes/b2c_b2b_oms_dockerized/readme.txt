* Scenario for dockerized OMS Standalone
* For Kyma integration + ApiRegistry, event sending is turned off by default by apiregistryservices.events.exporting=false property. Optionally and before initialization, deployment.api.endpoint property should be set to a server url reachable by kyma instead of https://localhost:9002.

Prerequisite
============
Make sure you have the base image installed, if not you can generate the default one following the description under /recipes/base_images/readme.txt.
(the default base image name is ybase_jdk, based on centos and sapjvm, you have to provide).
Instead of generating this image you can select another one by overriding the property 'baseImage; inside your recipe, for your platform/hsql/solr image definition, e.g.:
property 'baseImage', 'anapsix/alpine-java:8_jdk'

To perform follow this scenario:
================================

-> ./install.sh -r b2c_b2b_oms_dockerized createImagesStructure
-> cd work/output_images/b2c_b2b_oms_dockerized/
-> ./build-images.sh
-> cd - && cd recipes/b2c_b2b_oms_dockerized

# Initialize the platform.
-> docker-compose -d -f docker-compose-platform-init.yaml up
# To view init logs
-> docker-compose logs -f platform_admin_init

# To start has with OMS web services on port 9002:
-> docker-compose up -d
# To view web services logs
-> docker-compose logs -f platform_webservices