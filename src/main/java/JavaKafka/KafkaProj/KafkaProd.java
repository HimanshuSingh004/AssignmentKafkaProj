package JavaKafka.KafkaProj;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProd 
{
	public static void main(String[] args)
	{
		//topic 
		String topic="greendeck";
		//Create Properties
		Properties prop=new Properties();
		prop.setProperty("bootstrap.servers", "pkc-4nym6.us-east-1.aws.confluent.cloud:9092");
		
		
		//to Convert object to byte
		prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		
		//for Authentication
		prop.setProperty("security.protocol", "SASL_SSL");
		prop.setProperty("sasl.mechanism", "PLAIN");
		String pass="e6hxwh/1vyPyac1CQ+oCOmYZD3rFN+dfIoSUsXaKdOqsTgOcLGKTjIgTzy0Yhrhx";
		prop.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"H2CD74CM3TDLRDYC\" password=\""+pass+"\";");
		
		//create a producer to produce messages
		KafkaProducer<String,String> prod=new KafkaProducer<>(prop);
		
		//to send messages to the consumer
		ProducerRecord<String,String> sendmsg=new ProducerRecord<>(topic,"event_states","state3");
		ProducerRecord<String,String> sendmsg0=new ProducerRecord<>(topic,"event_states","state2");
		ProducerRecord<String,String> sendmsg1=new ProducerRecord<>(topic,"event_states","state1");
		prod.send(sendmsg);
		prod.send(sendmsg1);
		prod.send(sendmsg0);
		prod.flush();
		prod.close();
	}
}