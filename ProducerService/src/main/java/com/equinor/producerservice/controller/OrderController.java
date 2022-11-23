package com.equinor.producerservice.controller;

import com.equinor.producerservice.model.Order;
import com.equinor.producerservice.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@PostMapping("/post")
	public void order(@RequestBody Order order) {
		kafkaProducerService.send(order);
	}

}
