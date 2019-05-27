Prerequisite
============
Make sure you have the base image installed, if not you can generate the default one following the description under /recipes/base_images/readme.txt.
(the default base image name is ybase_jdk, based on centos and sapjvm, you have to provide).
Instead of generating this image you can select another one by overriding the property 'baseImage; inside your recipe, for your platform/hsql/solr image definition, e.g.:
 property 'baseImage',  'anapsix/alpine-java:8_jdk'

Information
============

Simple setup with b2c accelerator  and mongo GridFS as media storage strategy.
For Kyma integration + ApiRegistry, event sending is turned off by default by apiregistryservices.events.exporting=false property. Optionally and before initialization, deployment.api.endpoint property should be set to a server url reachable by kyma instead of https://localhost:9002.
Shows how to create Docker Images of the platform and run them as docker containers.
The Images: hsql, solr, zookeeper, loadbalancer, mongo, filebeat and platform (with several aspects inside).
Only "static" load balancer in use here

To perform follow this scenario:
================================

-> ./install.sh -r b2c_acc_dockerized_gridfs createImagesStructure
-> cd work/output_images/b2caccDeployment
-> ./build-images.sh
-> cd - && cd recipes/b2c_acc_dockerized
-> docker-compose up solr platform_hac   - recommended for the first platform init on hac
-> docker-compose scale mongo=3 - now you have 3 mongo containers running
-> configure the replica set. You need to call 'rs.initiate()' on the first node, which will became primary. either login to the running container and execute the init_replica_set.sh script OR just login to mongo console as follows:

mongo --port (your mongo container port - can find it by calling docker ps -a)
rs.initiate()
call rs.add(host), where host=your another mongo container id
by rs.status() or rs.conf() you can verify you replica sets status


-> docker-compose up -d solr load_balancer_frontend
-> docker-compose up -d load_balancer_backend


Alternative platform init
==========================
-> docker-compose -f docker-compose-platform-init.yaml up 

To add background processing nodes:
===================================
-> docker-compose scale platform_background_processing=1

Login into Mongo console
=======================================
mongo --port (your mongo port)

To access the storefronts on running docker containers:
===============================
-> https://localhost:9111   - hac, directly
-> https://localhost/yacceleratorstorefront/?site=apparel-uk   - accstorefronts behind the frontend load balancer
-> https://localhost:444/backoffice/ - backoffice storefronts behind the backend load balancer

===============================
To run with solrCloud, replace links to solr with solrc1 (if cluster desired add solrc2).  Additionally specify y_solr_server_mode=cloud and solr endpointUrls with y_solr_config_{storefront}SolrServerConfig_urls=zookeeper1:2181,zookeeper2:2181,zookeeper3:2181 as environment variables for the platform container you will initialize on.

============================================================================
Load Balancer Configuration

The load balancers are using the apache base image (with mod_cluster).  VirtualHost configurations are generated on container startup and defined by custom json files (see resources/lbconfig/webserver-frontend.json).  For more information please see the help documentation.
