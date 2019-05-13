#! /bin/bash

set -e

cd /opt/startup/apache-config-generator

groovy /opt/startup/apache-config-generator/generate-configs.groovy "/opt/startup/webserver.json"

# Remove PID files if pre-existing
rm -f /run/httpd/httpd.pid

exec httpd -DFOREGROUND