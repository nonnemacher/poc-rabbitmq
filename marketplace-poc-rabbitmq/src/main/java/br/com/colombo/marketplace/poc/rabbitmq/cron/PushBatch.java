package br.com.colombo.marketplace.poc.rabbitmq.cron;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import br.com.colombo.marketplace.poc.rabbitmq.service.SenderService;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.time.LocalDateTime.now;

/**
 * @author carloshenrique
 */
@AllArgsConstructor
@Component
public class PushBatch {

	private final SenderService senderService;

	@Scheduled(fixedDelay = 3000, initialDelay = 500)
	public void push() {
		IntStream.range(1, 10000).boxed().forEach(i -> {
			senderService.send(Message.builder()
					.description("SEND " + i)
					.localDateTime(now())
					.build());
		});
	}

}
