FROM jplock/zookeeper:3.4.8


COPY zoo.cfg /opt/zookeeper/conf/zoo.cfg
COPY addNodesAndRun.sh /opt/zookeeper/bin/addNodesAndRun.sh
RUN chmod +x /opt/zookeeper/bin/addNodesAndRun.sh

ENTRYPOINT ["bash", "/opt/zookeeper/bin/addNodesAndRun.sh"]