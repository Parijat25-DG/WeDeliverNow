package com.spring.hibernate.api.kafka.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.spring.hibernate.api.dto.DeliveryEx;
import com.spring.hibernate.api.entity.DeliveryDetails;
import com.spring.hibernate.api.repository.DeliveryRepository;

@Component
public class KafkaConsumer {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	DeliveryEx consumedFromTopic = null;

	public DeliveryEx consumeJsonMessage() {
		return consumedFromTopic;
	}

	@KafkaListener(groupId = "wearehere", topics = "wearehere.consume.delivery.details", containerFactory = "customerKafkaListenerContainerFactory")
	public DeliveryEx consumeMessage(DeliveryEx deliveryEx, String orderId) {
		consumedFromTopic = deliveryEx;
		DeliveryDetails deliveryDetails = new DeliveryDetails();
		deliveryDetails.setDetails(deliveryEx);
		deliveryDetails.setOrderId(orderId);
		deliveryRepository.save(deliveryDetails);
		return consumedFromTopic;
	}

}
