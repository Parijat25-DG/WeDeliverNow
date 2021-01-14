package com.spring.hibernate.api.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.spring.hibernate.api.entity.CustomerDetails;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	// config for json data

	@Bean
	public ConsumerFactory<String, CustomerDetails> userConsumerFactory() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "wearehere");
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(CustomerDetails.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, CustomerDetails> userKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, CustomerDetails> factory = new ConcurrentKafkaListenerContainerFactory<String, CustomerDetails>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}

}
