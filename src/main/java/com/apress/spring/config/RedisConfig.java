package com.apress.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apress.spring.redis.Consummer;

@Configuration
public class RedisConfig {
	
	@Value("${topic}")
	String topic;
	
	@Bean
	RedisMessageListerenContainer contain(RedisConnectionFactory connectionFactory
			           ,MessgeListenerAdapter listenerAdaptor) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainner();
		contaioner.setConectionFactory(connectionFactory);
		contaioner.addMessageLister(listenerAdapter, new PatternTopic(topic));
		
		return container;
		
	}
	
	@Bean
	MessageListenerAdapter listenerAdapter(Consummer consummer) {
		return new MessageListenerAdapter(consummer, "messageHandler");
	}

}
