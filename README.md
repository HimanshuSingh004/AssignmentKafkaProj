# KafkaProj
Assignment Project 3

Name: Himanshu Singh
Email Id: s.himanshu.k.singh@gmail.com
Date: 22/04/2022

*----------------------------------------------------------------------------------*


1. The project is made in eclipse.
2. It is a maven project.
3. First thing done when the project was created was to add dependencies for kafka.

4.  Created a class file(KafkaProd.java) to create a producer to send messages.
4.1. Create and set properties and connection for the kafka producer.
4.2 Created a KafkaProducer to establish connection.
4.3 Then Create the messages and send to the Consumer.
4.4 Close the KafkaProducer connection.

5.  Created a class file(KafkaCons.java) to consume messages from producer.
5.1 Add a simple-json-1.1.1 dependency to get the data from json file for future filteration of records.  
5.2 Create and set properties and connection for the kafka consumer.
5.3 Create a KafkaConsumer to establish connection.
5.4 Set offset to earliest
5.5 create a infinite loop to listen the messages all time.
5.6 And when the message comes check for the filter condition
5.7 And Call the class created to store data in the MySql Table
