package com.dk.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dk.mail.model.Mail;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long>{

}
