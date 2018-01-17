package com.github.nonnemacher.poc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

/**
 * @author carloshenrique
 */
@Slf4j
@Configuration
public class QueueProviderConfig {

	public QueueProviderConfig() {
		log.info("init success");
	}

	@Slf4j
	public static class MarketplaceQueue implements BeanPostProcessor, Ordered {

		@Override
		public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

			log.info("postProcessBeforeInitialization beanName {}", beanName);

			return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		public int getOrder() {
			return HIGHEST_PRECEDENCE;
		}
	}

	@Bean
	public MarketplaceQueue marketplaceQueue() {
		return new MarketplaceQueue();
	}

}
