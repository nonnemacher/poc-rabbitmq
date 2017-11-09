package br.com.colombo.marketplace.poc.rabbitmq.controller;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import br.com.colombo.marketplace.poc.rabbitmq.service.SenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carloshenrique
 */
@AllArgsConstructor
@RestController
public class SenderController {

	private final SenderService senderService;

	@PostMapping("/sender")
	void sender(@RequestBody Message message) {
		senderService.send(message);
	}
}
