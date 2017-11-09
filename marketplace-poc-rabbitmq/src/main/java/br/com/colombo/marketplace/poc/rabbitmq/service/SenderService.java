package br.com.colombo.marketplace.poc.rabbitmq.service;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import java.util.Optional;

/**
 * @author carloshenrique
 */
public interface SenderService {

	default void send(Message message) {
		Optional.ofNullable(message).ifPresent(System.out::println);
	}

}
