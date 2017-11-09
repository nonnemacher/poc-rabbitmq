package br.com.colombo.marketplace.poc.rabbitmq.cron;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import br.com.colombo.marketplace.poc.rabbitmq.service.PublisherService;
import static java.time.LocalDateTime.now;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author carloshenrique
 */
@AllArgsConstructor
@ConditionalOnProperty(name = "scheduler.enabled", havingValue = "true")
@Component
public class PushBatch {

    private final PublisherService senderService;

    @Scheduled(fixedDelay = 3000, initialDelay = 500)
    public void push() {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        IntStream.range(1, 10000)
                .boxed()
                .forEach(i -> {
                    senderService.publish(
                            Message.builder()
                                    .description("SEND " + i)
                                    .localDateTime(now())
                                    .build()
                    );
                });
        stopWatch.stop();
        System.out.println(" [x Time do push 10k message in queue " + stopWatch.getTotalTimeSeconds() + "s");
    }

}
