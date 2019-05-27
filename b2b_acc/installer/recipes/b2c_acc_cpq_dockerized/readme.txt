Prerequisite
============
Make sure you have the base image installed, if not you can generate the default one following the description under /recipes/base_images/readme.txt.
(the default base image name is ybase_jdk, based on centos and sapjvm, you have to provide).
Instead of generating this image you can select another one by overriding the property 'baseImage; inside your recipe, for your platform/hsql/solr image definition, e.g.:
 property 'baseImage',  'anapsix/alpine-java:8_jdk'

Information
============

Simple setup with b2c accelerator and cpq with configuration and pricing services for Hybris Commerce Cloud which shows how to create Docker Images of the platform and run them as docker containers
For Kyma integration + ApiRegistry, event sending is turned off by default by apiregistryservices.events.exporting=false property. Optionally and before initialization, deployment.api.endpoint property should be set to a server url reachable by kyma instead of https://localhost:9002.
The Images: hsql, solr, zookeeper, loadbalancer, filebeat and platform (with several aspects inside).

To perform follow this scenario:
================================

-> ./install.sh -r b2c_acc_cpq_dockerized createImagesStructure
--> *Note* To run with solrCloud run ./install.sh -r b2c_acc_cpq_dockerized createImagesStructure -A solrMode=cloud 
-> cd work/output_images/b2caccDeployment
-> ./build-images.sh
-> cd - && cd recipes/b2c_acc_cpq_dockerized
-> docker-compose -f docker-compose-platform-init.yaml up - recommended for the first platform init
--> *Note* To run with solrCloud: docker-compose -f docker-compose-platform—init-solrc.yaml up
-> docker-compose up -d solr load_balancer_frontend
-> docker-compose up -d load_balancer_backend

To add background processing nodes:
===================================
-> docker-compose scale platform_background_processing=1

Alternative platform init
==========================
-> docker-compose up solr platform_hac
-> Go to https://localhost/ and manually initialize

To access the storefronts on running docker containers, where {VM_IP} is the IP of the host machine:
===============================
-> https://{VM_IP}:444/   - hac, directly
-> https://{VM_IP}.xip.io/yacceleratorstorefront/?site=apparel-uk  - accstorefronts behind the frontend load balancer
-> https://{VM_IP}:444/backoffice/ - backoffice storefronts behind the backend load balancer

If /etc/hosts is correctly configured can also access:
-> https://electronics.{VM_IP}.xip.io/yacceleratorstorefront
-> https://apparel-uk.{VM_IP}.xip.io/yacceleratorstorefront

To forward logs to the centralized logging (see centralized_logging recipe):
============================================================================
-> docker-compose -f docker-compose.yml -f docker-compose.logging.yaml up

============================================================================
Load Balancer Configuration

The load balancers are using the apache base image (with mod_cluster).  VirtualHost configurations are generated on container startup and defined by custom json files (see resources/lbconfig/webserver-frontend.json).  For more information please see the help documentation.