package br.com.colombo.marketplace.poc.rabbitmq.service;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import java.util.Optional;

/**
 * @author carloshenrique
 */
public interface ReciverService {

    default void receive(Message message) throws InterruptedException {
        Optional.ofNullable(message).ifPresent(System.out::println);
    }

}
