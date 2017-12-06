package com.github.nonnemacher.poc.service;

import java.util.Optional;
import org.springframework.amqp.core.Message;

/**
 * @author carloshenrique
 */
public interface ReceiverService {

	default void receive(Message message) throws InterruptedException {
		Optional.ofNullable(message).ifPresent(System.out::println);
	}

}
