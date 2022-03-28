# kafka-producer # kafka-consumer

This project uses both Zookeeper and Kafka Docker images.  No local installation of Kafka
or Zookeper is needed.

**************************************************************
We don't need to create Topic manually. The Topic is created
by the application. This is just additional note understand
Kafka better.  
**************************************************************

If you want to create the Kafka Topic from the Kafka container'c command-line, run the below command
after doing a 'docker exec -it <container-id> /bin/bash':
---> kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic dakbangla
| Here we have created a topic name <dakbangla>

Note: 
A topic is a category or feed name to which records are published. 
Topics in Kafka are always multi-subscriber; that is, a topic can 
have zero, one, or many consumers that subscribe to the data written to it.

Initialize Producer console:
|
| Now we will initialize the Kafka producer console, which will listen to 
| localhost at port 9092 at topic <dakbangla>:
|
---> kafka-console-producer --broker-list localhost:9092 --topic dakbangla

Initialize Consumer console:
|
| Now we will initialize the Kafka consumer console, which will listen to bootstrap 
| server localhost at port 9092 at topic <dakbangla> from beginning:
|
---> kafka-console-consumer --bootstrap-server localhost:9092 --topic dakbangla --from-beginning


Finally, run the spring boot application and use two rest endpoints /send and /getAll 
to send the message to Kafka and to get message from Kafka. 
