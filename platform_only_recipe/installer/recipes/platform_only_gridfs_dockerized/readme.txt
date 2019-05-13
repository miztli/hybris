Simple setup with Platform only showing how to use MongoDB GridFS media storage.

Prerequisite
============
Make sure you have the base image installed, if not you can generate the default one following the description under /recipes/base_images/readme.txt.
(the default base image name is ybase_jdk, based on centos and sapjvm, you have to provide).
Instead of generating this image you can select another one by overriding the property 'baseImage; inside your recipe, for your platform/hsql/solr image definition, e.g.:
 property 'baseImage',  'anapsix/alpine-java:8_jdk'
  

To perform follow this scenario:
================================

1) Build docker images:
-> ./install.sh -r platform_only_gridfs_dockerized buildImages

or alternatively:
-> ./install.sh -r platform_only_gridfs_dockerized createImagesStructure
-> cd work/output_images/simpleDeployment
-> ./build-images.sh
-> cd -

2) Run containers with docker-compose:
-> cd recipes/platform_only_dockerized
-> docker-compose up -d mongo_master
-> docker-compose exec mongo_master mongo --eval "rs.initiate()"
-> docker-compose exec mongo_master mongo admin --eval "db.createUser({ user: 'admin', pwd: 'admin123', roles: [ { role: 'root', db: 'admin' } ] });"
-> docker-compose exec mongo_master mongo -u "admin" -p "admin123" --authenticationDatabase "admin" --eval "db = db.getSiblingDB('hybris_storage'); db.createUser({user: 'hybris', pwd: 'hybris123',roles: [ { role: 'readWrite', db: 'hybris_storage' } ]});"
-> docker-compose -f docker-compose-platform-init.yaml up
-> docker-compose up

To scale up mongo:
================================
This scenario set ups MongoDB in replicaSet mode by default so you can easily add slaves to the cluster:

-> docker-compose scale mongo_slave=3

Now you have 3 slave nodes spinned up. To add them to the cluster run command:

-> docker-compose exec mongo_master mongo -u "admin" -p "admin123" --authenticationDatabase "admin" --eval "rs.add('platformonlygridfsdockerized_mongo_slave_1'); rs.add('platformonlygridfsdockerized_mongo_slave_2'); rs.add('platformonlygridfsdockerized_mongo_slave_3')"

To see the cluster status run command:

-> docker-compose exec mongo_master mongo -u "admin" -p "admin123" --authenticationDatabase "admin" --eval "rs.status()"


Login into Mongo master console
================================

-> docker-compose exec mongo_master mongo -u "admin" -p "admin123" --authenticationDatabase "admin"



