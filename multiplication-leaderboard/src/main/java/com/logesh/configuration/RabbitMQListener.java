package com.logesh.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class RabbitMQListener implements RabbitListenerConfigurer {

	@Bean
	public TopicExchange topicExchange(@Value("${multiplication.exchange}") String exchange) {
		return new TopicExchange(exchange);
	}

	@Bean
	public Queue queue(@Value("${multiplication.queue}") final String queueName) {
		return new Queue(queueName, true);
	}
	@Bean
	public Binding bindings(Queue queue, TopicExchange exchange,
			@Value("${multiplication.anything.queue}") String routingKey) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}

	@Bean
	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(jsonMessageConverter());
		return factory;
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new MappingJackson2MessageConverter();
	}

}
