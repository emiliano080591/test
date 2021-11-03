import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Productor {
    public static void main(String[] args) {
        Properties props = new Properties();

        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks","all");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put("retries",0);
        props.put("batch.size",16384);
        props.put("buffer.memory",33554432);

        KafkaProducer<String,String> prod = new KafkaProducer<>(props);
        String topic = "topic-test";
        int partitions = 0;
        String key = "testKey";
        String value = "testValue";
        final ProducerRecord<String,String> record = new ProducerRecord<>(topic,key,value);
        prod.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e !=null){
                    System.out.println("Send failed for record");
                }
            }
        });

        prod.close();

    }
}
