package com.apress.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apress.spring.domain.JournalRepository;

@Controller // 1. @RestController에서 @Controller로 변경
public class JournalController { 
	
	private static final String VIEW_INDEX = "index";
	private static final String VIEW_LOGIN = "login";
	
	@Autowired
	private JournalRepository repo; // 3. 접근 제어자(private) 추가

	// 4. @RequestMapping 대신 직관적인 @GetMapping 활용
	@GetMapping("/")
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName(VIEW_INDEX);
		modelAndView.addObject("journal", repo.findAll());
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView login(ModelAndView modelAndView) {
		modelAndView.setViewName(VIEW_LOGIN);
		return modelAndView;
	}
} 