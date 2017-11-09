package br.com.colombo.marketplace.poc.rabbitmq.service;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@ConditionalOnProperty(name = "spring.rabbitmq.publisher", havingValue = "true")
@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void publish(Message message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }

}
