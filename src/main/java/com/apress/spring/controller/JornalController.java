package com.apress.spring.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apress.spring.domain.JournalEntry;

@RestController
public class JournalController {
	
	private static List<JournalEntry> entries = new ArrayList<JournalEntry>();
	
	static {
		try {
			entries.add(new JournalEntry("", "", ""));
			entries.add(new JournalEntry("", "", "", ""));
			entries.add(new JournalEntry("", "", "", ""));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/journal/all")
	public List<JournalEntry> getAll() throws ParseException {
		return entries;
	}
	
	@RequestMapping("/journal/findBy/{title}")
	public List<JournalEntry> findByTitleContains(@PathVariable String title) throws ParseException {
		return entries.stream()
				.filter(entry -> entry.getTitle().toLowerCase().contains(title.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/journal", method = RequestMethod.POST)
	public JournalEntry add(@RequestBody JournalEntry entry) {
		entries.add(entry);
		return entry;
	}
}