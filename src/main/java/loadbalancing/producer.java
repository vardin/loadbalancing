package loadbalancing;

import com.google.common.io.Resources;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class producer {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("metadata.broker.list", "kafka1:9092,kafka2:9092,kafka3:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        ProducerConfig producerConfig = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(producerConfig);
        KeyedMessage<String, String> message = new KeyedMessage<String, String>("test", "Hello, World!");  
        producer.send(message);
        producer.close();
    }
}