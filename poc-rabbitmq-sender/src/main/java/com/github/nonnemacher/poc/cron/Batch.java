package com.github.nonnemacher.poc.cron;

import com.github.nonnemacher.poc.dto.SenderMessage;
import com.github.nonnemacher.poc.service.SenderService;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import static java.time.LocalDateTime.now;

/**
 * @author carloshenrique
 */
@AllArgsConstructor
@Component
@Slf4j
public class Batch {

	private final SenderService senderService;

	@Scheduled(fixedDelay = 10000, initialDelay = 3000)
	public void push() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		IntStream.range(1, 1000).boxed().forEach(i -> {
			final SenderMessage senderMessage = SenderMessage.builder()
					.description("SEND " + i)
					.localDateTime(now())
					.build();
			senderService.publish(senderMessage);
		});
		stopWatch.stop();
		log.info("[x Time do push 1k message in queue {}s]", stopWatch.getTotalTimeSeconds());
	}

}
