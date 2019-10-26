package com.logesh.mulitiplication.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.logesh.model.MultiplicationSolvedEvent;

@Component
public class EventListener {
	@RabbitListener(queues = "${multiplication.queue}")
	void eventReceiver(MultiplicationSolvedEvent event) {
		System.out.println("event listener...");
		System.out.println(event);
	}
}
