package com.jdevsean.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MyProducer {

    public static void main(String[] args) {
        // properties里面的参数内容：org.apache.kafka.clients.producer.ProducerConfig、org.apache.kafka.clients.CommonClientConfigs
        Properties props = new Properties();
        props.put("bootstrap.servers", "173.254.200.119:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        for (int i = 0; i < 100; i++) {
            System.out.println("send :" + Integer.toString(i) + ", value = " + Integer.valueOf(i));
            producer.send(new ProducerRecord<>("test1", Integer.toString(i), Integer.toString(i)));
        }

        producer.close();
    }

}
