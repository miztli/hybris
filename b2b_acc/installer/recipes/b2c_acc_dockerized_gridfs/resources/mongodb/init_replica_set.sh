#!/bin/bash
set -e

status=$(mongo --host ${HOSTNAME} --quiet --eval 'rs.status().codeName')
if [ ${status} == "NotYetInitialized" ]; then
  # Replicaset not yet configured
  echo "Replicaset not yet configured, initialiting..."
  mongo --host ${HOSTNAME} --eval 'rs.initiate()';  
fi