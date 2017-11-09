package br.com.colombo.marketplace.poc.rabbitmq.service;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import java.time.LocalDateTime;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SenderServiceImpl implements SenderService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;

	@Override
	public void send(Message message) {
		rabbitTemplate.convertAndSend(queue.getName(), message);
	}

}
