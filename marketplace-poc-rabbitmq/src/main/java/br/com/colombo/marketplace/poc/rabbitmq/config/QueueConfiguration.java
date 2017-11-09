package br.com.colombo.marketplace.poc.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author carloshenrique
 */
@Configuration
public class QueueConfiguration {

	@Value("${rabbitmq.queue.name:hello}")
	private String name;

	@Value("${rabbitmq.queue.durable:true}")
	private boolean durable;

	@Value("${rabbitmq.queue.exclusive:false}")
	private boolean exclusive;

	@Value("${rabbitmq.queue.autoDelete:false}")
	private boolean autoDelete;

	@Bean
	public Queue queue() {
		return new Queue(name, durable, exclusive, autoDelete);
	}

}
