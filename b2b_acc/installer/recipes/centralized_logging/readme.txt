This recipe generates ELK stack images

To perform follow this scenario:
================================
-> ./install.sh -r centralized_logging createImagesStructure
-> cd work/output_images/logging
-> ./build-images.sh

To run your ELK stack:
======================
-> cd recipes/centralized_logging
-> docker-compose up

To access the Kibana web UI:
============================
-> http://localhost:5601 - credentials: elastic, changeme
   (see: https://www.elastic.co/guide/en/x-pack/current/setting-up-authentication.html#built-in-users)

To scale up the Elasticsearch cluster:
======================================
-> docker-compose scale elasticsearch=3
