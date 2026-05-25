package com.apress.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apress.spring.message.Producer;

public class WebSocketController {
	
	@Autowired
	Producer producer;
	
	@RequestMapping("/send/{topic}")
	public String sender(@PathVariable String topic, @ReqestParam)
	

}
