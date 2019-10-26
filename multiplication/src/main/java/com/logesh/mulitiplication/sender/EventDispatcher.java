package com.logesh.mulitiplication.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.logesh.model.MultiplicationSolvedEvent;

@Component
public class EventDispatcher {

	private String mulitiplicationExchange;

	private String mulitiplicationRoutingKey;
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	public EventDispatcher(@Value("${multiplication.exchange}") String multiplicationExchange,
			@Value("${multiplication.solved.key}") String multiplicationRoutingKey, RabbitTemplate template) {
		// TODO Auto-generated constructor stub
		this.mulitiplicationExchange = multiplicationExchange;
		this.mulitiplicationRoutingKey = multiplicationRoutingKey;
		this.rabbitTemplate = template;
	}

	public void send(MultiplicationSolvedEvent event) {
		rabbitTemplate.convertAndSend(mulitiplicationExchange, mulitiplicationRoutingKey, event);
		System.out.println("SENT");
	}
}
