FROM ybase_os
ADD java/sapjvm*.rpm /opt/sapjvm/sapjvm.rpm
RUN yum localinstall /opt/sapjvm/sapjvm.rpm -y && \
    rm /opt/sapjvm/sapjvm.rpm
ENV JAVA_HOME /usr/java/sapjvm_8_latest
RUN alternatives --install /usr/bin/java java /usr/java/sapjvm_8_latest/bin/java 100 && \
	alternatives --install /usr/bin/jar jar /usr/java/sapjvm_8_latest/bin/jar 100 && \
	alternatives --install /usr/bin/javac javac /usr/java/sapjvm_8_latest/bin/javac 100 && \
	alternatives --install /usr/bin/jmap jmap /usr/java/sapjvm_8_latest/bin/jmap 100 && \
	alternatives --install /usr/bin/jstack jstack /usr/java/sapjvm_8_latest/bin/jstack 100 && \
	alternatives --install /usr/bin/jps jps /usr/java/sapjvm_8_latest/bin/jps 100 && \
	alternatives --install /usr/bin/keytool keytool /usr/java/sapjvm_8_latest/bin/keytool 100 && \
	alternatives --install /usr/bin/jcmd jcmd /usr/java/sapjvm_8_latest/bin/jcmd 100
