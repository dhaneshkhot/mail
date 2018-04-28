package com.dk.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dk.mail.model.Mail;

public interface MailRepository extends JpaRepository<Mail, Long>{

}
