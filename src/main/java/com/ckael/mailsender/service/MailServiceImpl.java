package com.ckael.mailsender.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ckael.mailsender.model.Email;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public Email sendMail(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getSenderAdress());
		message.setText("Numero:"+email.getSenderNumber()+ email.getMailContent());
		message.setSubject("From portfolio");
		message.setFrom("Ranckael6@gmail.com");
		
		mailSender.send(message);
		
		
		return email;
	}

}
