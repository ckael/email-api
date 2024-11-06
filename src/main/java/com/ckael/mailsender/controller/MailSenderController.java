package com.ckael.mailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ckael.mailsender.model.Email;
import com.ckael.mailsender.service.MailServiceImpl;

@RestController
@RequestMapping("/mailAPI")
public class MailSenderController {
	
	@Autowired
	MailServiceImpl service;
	
	@PostMapping("/send")
	public ResponseEntity<Email> send(@RequestBody Email e)
	{
		service.sendMail(e);
		
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	

}
