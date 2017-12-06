package com.github.nonnemacher.poc.service;

import com.github.nonnemacher.poc.dto.SenderMessage;
import java.util.Optional;

/**
 * @author carloshenrique
 */
public interface SenderService {

    default void publish(SenderMessage message) {
        Optional.ofNullable(message).ifPresent(System.out::println);
    }

}
