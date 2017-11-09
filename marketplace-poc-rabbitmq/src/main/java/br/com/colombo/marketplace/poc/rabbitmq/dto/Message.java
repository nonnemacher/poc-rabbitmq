package br.com.colombo.marketplace.poc.rabbitmq.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * @author carloshenrique
 */
@Builder
@Data
public class Message implements Serializable {

	private String description;

	private LocalDateTime localDateTime;

}
