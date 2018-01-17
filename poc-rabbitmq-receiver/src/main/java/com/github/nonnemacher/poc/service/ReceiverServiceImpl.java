package com.github.nonnemacher.poc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nonnemacher.poc.dto.ReceiverMessage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * @author carloshenrique
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ReceiverServiceImpl implements ReceiverService {

	private final ObjectMapper objectMapper;

	@Override
	@RabbitListener(queues = "${spring.rabbitmq.queue.name}")
	public void receive(Message message) throws InterruptedException {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		ReceiverService.super.receive(message);

		final ReceiverMessage receiverMessage;
		try {
			log.info(">> {}", new String(message.getBody()));
			receiverMessage = objectMapper.readValue(message.getBody(), ReceiverMessage.class);
			stopWatch.stop();
			log.info(" [x] Message {} in {}s" + receiverMessage.getDescription(), stopWatch.getTotalTimeSeconds());
		} catch (IOException ex) {
			Logger.getLogger(ReceiverServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
			stopWatch.stop();
		}
	}

}
