package com.spring.hibernate.api.kafka.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hibernate.api.dto.OrderRequest;

@RestController
public class KafkaPublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "wearehere.publish.order";

	public String publishMessage(OrderRequest order, int priority) {
		template.send(topic, "Hi.. Here is the next order "+order+ "with priority + "+ priority);
		return "Order Details Sent";
	}

}
