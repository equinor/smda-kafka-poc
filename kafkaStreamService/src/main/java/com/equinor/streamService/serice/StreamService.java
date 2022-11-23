package com.equinor.streamService.serice;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.equinor.streamService.bindings.StreamBindings;
import com.equinor.streamService.model.Order;

@EnableBinding(StreamBindings.class)
@Service
public class StreamService {

	@StreamListener("order-input-channel")
	@SendTo("order-takeaway-output-channel")
	public KStream<String, Order> takeAway(KStream<String, Order> order) {
		return order.filter((k,v)-> v.getDeliveryType().equalsIgnoreCase("takeaway"));
	}

	@StreamListener("order-input-channel")
	@SendTo("order-homedelivery-output-channel")
	public KStream<String, Order> homeDelivery(KStream<String, Order> order) {
		return order.filter((k,v)-> v.getDeliveryType().equalsIgnoreCase("homedelivery"));
	}

}
