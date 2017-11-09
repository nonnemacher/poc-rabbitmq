package br.com.colombo.marketplace.poc.rabbitmq.service;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import java.util.Optional;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * @author carloshenrique
 */
@RabbitListener(queues = "${rabbitmq.queue.name:hello}")
//@Service
public class ServiceReciverImpl {

	@RabbitHandler
	public void receive(Message message) throws InterruptedException {
		StopWatch watch = new StopWatch();
		watch.start();
		Optional.ofNullable(message).ifPresent(System.out::println);
		watch.stop();
		System.out.println(" [x] Done in " + watch.getTotalTimeSeconds() + "s");

		throw new InterruptedException(">>> ok");
	}

}
