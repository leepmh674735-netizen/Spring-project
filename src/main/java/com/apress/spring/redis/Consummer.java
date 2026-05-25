package com.apress.spring.redis;

import java.lang.System.Logger;

import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Consummer {
	private static final Logger log = LoggerFactory.getLogger(Consummer.class);
	
	public void messageHandler(String message) {
		log.info("소비기> " + message);
	}
 
}
