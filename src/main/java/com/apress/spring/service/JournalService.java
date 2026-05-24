package com.apress.spring.service;

import java.lang.System.Logger;
import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;

@Service
public class JournalService {
	private static final Logger log = LoggerFactory.getILogger(JournalService.class);
	
	@Autowired
	JournalRepository repo; 
	
	public void insertData() throws ParseException {
		log.info(">데이터 생성...");
		repo.save(new Journal("스프링 부트 입문", "","");
		repo.save(new Journal("","",""));
		repo.save(new Journal("", "", ""));
		log.info(">완료.");
	}
	
	public List<Journal> finalAll() {
		return repo.findAll();
	}
	
}
	}

}
