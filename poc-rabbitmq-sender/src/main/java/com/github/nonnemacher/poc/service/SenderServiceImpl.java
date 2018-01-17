package com.github.nonnemacher.poc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nonnemacher.poc.dto.SenderMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import static org.springframework.amqp.core.MessageProperties.CONTENT_TYPE_JSON;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
@RequiredArgsConstructor
public class SenderServiceImpl implements SenderService {

	private final RabbitTemplate rabbitTemplate;
//	private final Queue queue;
	private final ObjectMapper objectMapper;

	@Value("${spring.rabbitmq.queue.name:hello}")
	private String queueName;

	@Override
	public void publish(SenderMessage sender) {
		try {
			final Message message = MessageBuilder
					.withBody(objectMapper.writeValueAsBytes(sender))
					.andProperties(MessagePropertiesBuilder
							.newInstance()
							.setContentType(CONTENT_TYPE_JSON)
							.build())
					.build();
			rabbitTemplate.send(queueName, message);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(SenderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
