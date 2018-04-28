package com.dk.mail.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sentmails")
public class Mail{
	

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;
    

    @Column(name = "mailfrom")
    private String from;
    @Column(name = "mailto")
    private String to;
    @Column(name = "mailsubject")
    private String subject;
    @Column(name = "content")
    private String content;

    public Mail() {
    }

    public Mail(String to, String from, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public Mail(String id, String to, String from, String subject, String content) {
    	this.id = id;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
