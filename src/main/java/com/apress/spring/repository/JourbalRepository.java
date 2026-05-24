package com.apress.spring.repository;

import java.util.Date;
import java.util.List;

import com.apress.spring.repository.JpaRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.apress.spring.domain.JournalEntry;

public interface JourbalRepository extends JpaRepository <JournalEntry, Long>{
	
	List<JournalEntry> findByCreatedAfter(@Param("after") @DateTimeFormat(iso=ISO.DATE) Date date);
	List<JournalEntry> findByCreatedBetween(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date after, 
			@Param("before") @DateTimeFormat(iso = ISO.DATE) Date before);
			List<JournalEntry> findByTitleContaining(@Param("word")String word);
		    List<JournalEntry> findBySummaryContatining(@Param("word") String word);
	
}
