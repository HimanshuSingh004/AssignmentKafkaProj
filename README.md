# KafkaProj
Assignment Project 3

Name: Himanshu Singh\
Email Id: himanshu.k.singh04@gmail.com\
Date: 08/05/2022\

*----------------------------------------------------------------------------------*

1. The project is made in eclipse.
2. It is a maven project.
3. First thing done when the project was created was to add dependencies for kafka.
4.  Created a class file(KafkaProd.java) to create a producer to send messages.
5. Create and set properties and connection for the kafka producer.
6. Created a KafkaProducer to establish connection.
7. Then Create the messages and send to the Consumer.
8. Close the KafkaProducer connection.
9.  Created a class file(KafkaCons.java) to consume messages from producer.
10. Add a simple-json-1.1.1 dependency to get the data from json file for future filteration of records.  
11. Create and set properties and connection for the kafka consumer.
12. Create a KafkaConsumer to establish connection.
13. Set offset to earliest
14. create a infinite loop to listen the messages all time.
15. And when the message comes check for the filter condition
16. And Call the class created to store data in the MySql Table
