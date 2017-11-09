package br.com.colombo.marketplace.poc.rabbitmq.dto;

import java.time.LocalDateTime;
import org.junit.Test;

import static java.time.LocalDateTime.now;
import static org.junit.Assert.assertEquals;

/**
 * @author carloshenrique
 */
public class MessageTest {

	/**
	 * Test of getDescription method, of class Message.
	 */
	@Test
	public void testGetDescription() {
		final Message message = Message.builder().description(MessageTest.class.getName()).build();

		assertEquals(MessageTest.class.getName(), message.getDescription());
	}

	/**
	 * Test of getLocalDateTime method, of class Message.
	 */
	@Test
	public void testGetLocalDateTime() {
		final LocalDateTime localDateTime = now();
		final Message message = Message.builder().localDateTime(localDateTime).build();

		assertEquals(localDateTime, message.getLocalDateTime());
	}

	/**
	 * Test of setDescription method, of class Message.
	 */
	@Test
	public void testSetDescription() {
		final Message message = Message.builder().build();
		message.setDescription(MessageTest.class.getName());

		assertEquals(MessageTest.class.getName(), message.getDescription());
	}

	/**
	 * Test of setLocalDateTime method, of class Message.
	 */
	@Test
	public void testSetLocalDateTime() {
		final LocalDateTime localDateTime = now();
		final Message message = Message.builder().build();
		message.setLocalDateTime(localDateTime);

		assertEquals(localDateTime, message.getLocalDateTime());
	}

	/**
	 * Test of builder method, of class Message.
	 */
	@Test
	public void testBuilder() {
		final LocalDateTime localDateTime = now();
		final Message build = Message.builder()
				.description(MessageTest.class.getName())
				.localDateTime(localDateTime)
				.build();
		final Message message = new Message(MessageTest.class.getName(), localDateTime);

		assertEquals(message, build);
	}

}
