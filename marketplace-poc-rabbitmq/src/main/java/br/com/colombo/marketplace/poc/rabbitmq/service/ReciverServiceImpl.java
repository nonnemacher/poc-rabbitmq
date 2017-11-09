package br.com.colombo.marketplace.poc.rabbitmq.service;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * @author carloshenrique
 */
@ConditionalOnProperty(name = "spring.rabbitmq.reciver", havingValue = "true")
@RabbitListener(queues = "${rabbitmq.queue.name:hello}")
@Service
public class ReciverServiceImpl implements ReciverService {

    @RabbitHandler
    @Override
    public void receive(Message message) throws InterruptedException {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ReciverService.super.receive(message);
        stopWatch.stop();
        System.out.println(" [x] Message " + message.getDescription() + " in " + stopWatch.getTotalTimeSeconds() + "s");
    }

}
