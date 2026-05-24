package com.apress.spring.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;

public class JsonDataSerializer extends JsonSerializer<Date> {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("");
	
	
	@Override
	public void Serialize(Date date, JsonGenerator gen , SerialiserProvider )
	provider) throws  IOException, JsonProcessiongException {
		String formattedDate = dataFormat.formate(date);
		gen.writeString(formattedDate);
	}
}
