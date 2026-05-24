package com.apress.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="entry")
public class JournalEntry {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private Date created;
    private String summary;
    
    // JPA가 데이터베이스 컬럼으로 인식하지 않도록 설정
    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    
    // 기본 생성자 (JPA 필수, access level은 엔티티 특성에 따라 protected 또는 public 추천)
    protected JournalEntry() {}
    
    public JournalEntry(String title, String summary, String data) throws ParseException {
        this.title = title;
        this.summary = summary;
        this.created = format.parse(data);
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    // 오타 수정: getTiltle -> getTitle
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    } 
    
    public Date getCreated() {
        return created;
    }
    
    // 자바 문법 오류 및 오타 수정 (try-catch, 변수 선언)
    public void setCreated(String date) throws ParseException {
         Long _date = null;
         try {
             _date = Long.parseLong(date);
             this.created = new Date(_date);
             return;
         } catch (Exception ex) {
             // 숫자가 아닌 포맷 문자열인 경우 아래 구문으로 넘어감
         }
         this.created = format.parse(date);
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    
    public String getSummary() {
        return summary;
    }
    
    // 매개변수 누락 오류 수정 (String summary 추가)
    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("*JournalEntry("); // 오타 수정: JornalEntry -> JournalEntry
        value.append("제목: ");
        value.append(title);
        value.append(", 요약: ");
        value.append(summary);
        value.append(", 작성일자: ");
        value.append(created != null ? format.format(created) : "null"); // NullPointerException 방지
        value.append(")");
        
        return value.toString();
    }
}