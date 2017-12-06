package com.github.nonnemacher.poc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nonnemacher.poc.dto.SenderMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
@RequiredArgsConstructor
public class SenderServiceImpl implements SenderService {

	private final RabbitTemplate rabbitTemplate;
	private final Queue queue;
	private final ObjectMapper objectMapper;

	@Override
	public void publish(SenderMessage sender) {
		final MessageProperties messageProperties = new MessageProperties();
		messageProperties.setType(MessageProperties.CONTENT_TYPE_JSON);
		final Message message;
		try {
			message = new Message(objectMapper.writeValueAsBytes(sender), messageProperties);
			rabbitTemplate.send(queue.getName(), message);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(SenderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
