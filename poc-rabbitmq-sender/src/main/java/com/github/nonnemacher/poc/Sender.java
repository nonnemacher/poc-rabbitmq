package com.github.nonnemacher.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author carloshenrique
 */
@EnableScheduling
@SpringBootApplication
public class Sender {

	public static void main(String[] args) {
		SpringApplication.run(Sender.class, args);
	}

}
