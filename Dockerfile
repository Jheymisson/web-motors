FROM selenium/standalone-chrome

USER root

ENV MAVEN_VERSION=3.6.3
ENV MAVEN_HOME=/opt/apache-maven-${MAVEN_VERSION}

RUN apt-get update && \
    apt-get install -y software-properties-common && \
    rm -rf /var/lib/apt/lists/*
    
RUN add-apt-repository ppa:openjdk-r/ppa -y && apt-get update && apt install openjdk-11-jdk xmlstarlet -y && apt-get clean

RUN \
	mkdir -p /download && \
	curl -o /download/apache-maven-${MAVEN_VERSION}-bin.tar.gz http://apache.cs.utah.edu/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
	mkdir -p /download && \
	cd /opt && \
	tar -zxf /download/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
	rm -rf /download/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
	ln -sf "${MAVEN_HOME}/bin/mvn" /usr/bin/mvn

RUN \ 
	curl -L --output /usr/local/bin/gitlab-runner https://gitlab-runner-downloads.s3.amazonaws.com/latest/binaries/gitlab-runner-linux-amd64 && \
	chmod +x /usr/local/bin/gitlab-runner && \
	useradd --comment 'GitLab Runner' --create-home gitlab-runner --shell /bin/bash && \
	gitlab-runner install --user=gitlab-runner --working-directory=/home/gitlab-runner && \
	gitlab-runner start && \
	gitlab-runner register \
		--non-interactive \
		--url "http://git-sqa.alterdata.matriz/" \
		--registration-token "u8sLeVVRU2yqHzxbMiA5" \
		--executor "shell" \
		--shell "/bin/bash/" 
		--description "docker-runner" \
		--tag-list "test" \
		--run-untagged="true" \
		--locked="false" \
		--access-level="not_protected"
	
USER seluser

EXPOSE 4444

ENTRYPOINT ["/opt/bin/entry_point.sh"]