package com.apress.spring.domain;

import org.springframework.data.jpa.repositpry.JpaRepository;
import org.apress.spring.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long>  {  }
