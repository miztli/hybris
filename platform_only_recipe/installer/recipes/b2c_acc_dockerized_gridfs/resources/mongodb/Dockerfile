FROM mongo:latest

RUN mkdir -p /opt/mongodb

ENV DEFAULT_PORT=27017
ENV REPL_SET="" 

# Expose port from the container to the host
EXPOSE ${DEFAULT_PORT}

COPY start.sh /opt/mongodb
RUN chmod +x /opt/mongodb/start.sh

COPY init_replica_set.sh /opt/mongodb
RUN chmod +x /opt/mongodb/init_replica_set.sh

ENTRYPOINT ["/opt/mongodb/start.sh"]
