package br.com.colombo.marketplace.poc.rabbitmq.controller;

import br.com.colombo.marketplace.poc.rabbitmq.dto.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static java.time.LocalDateTime.now;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpMethod.POST;

/**
 *
 * @author carloshenrique
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SenderControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void exampleTest() {

		final HttpEntity entity = new HttpEntity(Message.builder()
				.description("Hello")
				.localDateTime(now())
				.build());

		final ResponseEntity<Void> response = testRestTemplate.exchange("/sender", POST, entity, Void.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
