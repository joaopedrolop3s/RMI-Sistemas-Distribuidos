FROM ubuntu:latest

RUN apt-get update && \
    apt-get install -y default-jdk && \
    apt-get install -y iputils-ping && \
    apt-get install -y telnet