package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@SpringBootApplication
public class SpringKafkaConsumer {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaConsumer.class, args);
	}

		private static final String TOPIC_NAME = "your_kafka_topic_name";
		private static final String FILTER_STRING = "your_filter_string";

		private static final String OUTPUT_FILE_PATH = "/path/to/filtered_records.json";


	@KafkaListener(topics = TOPIC_NAME)
		public void consume(ConsumerRecord<String, String> record) {
			if (record.value().contains(FILTER_STRING)) {
				// write filtered record to a separate file
				// replace with your own file writing logic
				// ...
				System.out.println("Filtered record: " + record.value());
				writeToFile(record.value());
			}
		}

	private void writeToFile(String value) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH, true));
			writer.append(value);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
