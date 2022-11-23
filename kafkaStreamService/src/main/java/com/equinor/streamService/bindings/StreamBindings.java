package com.equinor.streamService.bindings;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

import com.equinor.streamService.model.Order;

public interface StreamBindings {

	@Input("order-input-channel")
	KStream<String, Order> inputStream();

	@Output("order-takeaway-output-channel")
	KStream<String, Order> takeAwayStream();



}