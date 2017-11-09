package br.com.colombo.marketplace.poc.rabbitmq.controller;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.colombo.marketplace.poc.rabbitmq.service.PublisherService;

/**
 * @author carloshenrique
 */
@AllArgsConstructor
@RestController
public class SenderController {

	private final PublisherService senderService;

	@PostMapping("/sender")
	void sender(@RequestBody Message message) {
		senderService.publish(message);
	}
}
