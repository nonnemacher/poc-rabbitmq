package com.github.nonnemacher.poc.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author carloshenrique
 */
//@Configuration
public class QueueConfiguration {

	@Value("${spring.rabbitmq.queue.name:hello}")
	private String name;

	@Value("${spring.rabbitmq.queue.durable:true}")
	private boolean durable;

	@Value("${spring.rabbitmq.queue.exclusive:false}")
	private boolean exclusive;

	@Value("${spring.rabbitmq.queue.autoDelete:false}")
	private boolean autoDelete;

	@Bean
	public Queue queue() {
		return new Queue(name, durable, exclusive, autoDelete);
	}

}
