package com.spring.hibernate.api.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.hibernate.api.dto.DeliveryEx;
import com.spring.hibernate.api.dto.OrderRequest;
import com.spring.hibernate.api.dto.OrderResponse;
import com.spring.hibernate.api.dto.ProductResponse;
import com.spring.hibernate.api.entity.CustomerDetails;
import com.spring.hibernate.api.entity.DeliveryDetails;
import com.spring.hibernate.api.entity.ProductDetails;
import com.spring.hibernate.api.kafka.app.KafkaPublisher;
import com.spring.hibernate.api.repository.CustomerRepository;
import com.spring.hibernate.api.repository.DeliveryRepository;
import com.spring.hibernate.api.repository.ProductRepository;

@Component
public class OrderWrapper {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private KafkaPublisher kafkaPublisher;
	
	
	public OrderResponse placeOrder( OrderRequest request) {
		CustomerDetails savedCustomerDetails = customerRepository.save(request.getCustomer());
		request.setCustomer(savedCustomerDetails);
		String message = kafkaPublisher.publishMessage(request, this.determineDeliveryPriority(savedCustomerDetails));
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setCustomer(savedCustomerDetails);
		orderResponse.setMessage(message);
		return orderResponse;
	}
	
	private int determineDeliveryPriority(CustomerDetails savedCustomerDetails) {
		List<Integer> productPriorities = new ArrayList<>();
		savedCustomerDetails.getProducts().forEach(product -> {
			int productPriority = 0;
			switch(product.getProductCategory()) {
			case "Medicine": productPriority = 1; break;
			case "Grocery" : productPriority = 2; break;
			case "Stationary":  productPriority = 3; break;
			}
			if(productPriorities != null) {
				if(productPriorities.size()==0) {
					productPriorities.add(productPriority);
				} else {
					if(!productPriorities.contains(productPriority)) {
						productPriorities.add(productPriority);
					}
				}
			}
		});
		Collections.sort(productPriorities);
		return productPriorities.get(0);
	}

	public List<CustomerDetails> findAllOrders(){
		return customerRepository.findAll();
	}
	
	public List<ProductDetails> findAllProducts(){
		return productRepository.findAll();
	}
	
	public List<ProductDetails> findProductsByCategory(@PathParam(value = "category") String category){
		return productRepository.findByCategory(category);
	} 
	
	public List<ProductResponse> findProductsByCustomer(){
		return customerRepository.getProductsPerCustomer();
	}
	
	public String findOrderStatus(String orderId) {
		DeliveryDetails deliveryDetails = deliveryRepository.findByOrderId(orderId);
		String message = null;
		if(deliveryDetails != null) {
			DeliveryEx details = deliveryDetails.getDetails();
			message = "Your Order will be delivered by "+details.getDeliveryExName()
			+" with Contact Number "+details.getDeliveryExMob()
			+ " in approximately in "+details.getDeliveryTime()+" minutes";
		} else { 
			message = "Delivery Executive is being assigned. Please wait for further details";
		}
		return message;
	}

}
