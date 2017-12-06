package com.github.nonnemacher.poc.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * @author carloshenrique
 */
@Builder
@Data
public class ReceiverMessage implements Serializable {

	private String description;

	private LocalDateTime localDateTime;

}
