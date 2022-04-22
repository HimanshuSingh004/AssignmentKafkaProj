package JavaKafka.KafkaProj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;


public class KafkaCons 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
	{
		//parse and read from the json file
		JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("filterFILE.json"));
        JSONObject jsonObject = (JSONObject)obj;
        JSONArray states = (JSONArray)jsonObject.get("event_states");
        
        
		//Create Properties
		Properties prop=new Properties();
		prop.setProperty("bootstrap.servers", "pkc-4nym6.us-east-1.aws.confluent.cloud:9092");
		
		//to Convert object to byte
		prop.setProperty("key.deserializer", StringDeserializer.class.getName());
		prop.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		String topic="greendeck";
		
		//for Authentication
		prop.setProperty("security.protocol", "SASL_SSL");
		prop.setProperty("sasl.mechanism", "PLAIN");
		String pass="e6hxwh/1vyPyac1CQ+oCOmYZD3rFN+dfIoSUsXaKdOqsTgOcLGKTjIgTzy0Yhrhx";
		prop.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"H2CD74CM3TDLRDYC\" password=\""+pass+"\";");
		prop.setProperty("group.id", "consumer");
		
		//to set offset to 0
		prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		//create a consumer to consume msg
		KafkaConsumer<String,String> myconsumer=new KafkaConsumer<>(prop);
		
		//Subscribe to topics
		myconsumer.subscribe(Arrays.asList(topic));
		
		//a infinite loop to get messages continuously
		while(true)
		{
			//to get messages every second
			ConsumerRecords<String,String> msg=myconsumer.poll(1000);
			//System.out.println(msg.records(topic)); ;
			for(ConsumerRecord<String,String> newmsg:msg)
			{
				// to filter the records
				for(Object n:states)
		        {
					if(newmsg.value().equals(n) && newmsg.key().equals("event_states"))
					{
						StoreData.savedata(newmsg.key(), newmsg.value(),newmsg.offset(),newmsg.partition());
					}
		        }
			}
		}
		
	}
}
