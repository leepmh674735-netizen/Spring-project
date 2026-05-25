package com.apress.spring.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("26/05/25 09:36:14");
	
	@Autowired
	private SimpleMessagingTemplate template;
	
	public void sendMessageTo(String topic, String message) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(dateFormatter.format(new Date());
		builder.append(" ] ");
		builder.append(message);
		
		this.template.convertAndSend("/topic/" + topic, builder.toString());
	}
}