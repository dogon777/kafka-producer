FROM d41d8cd98f/maven
COPY target/kafka-producer-0.0.1-SNAPSHOT.jar /usr/app/kafka-producer-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/usr/app/kafka-producer-0.0.1-SNAPSHOT.jar"]