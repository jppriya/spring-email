package com.jp.poc.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.poc.email.model.EmailVO;
import com.jp.poc.email.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@RequestMapping("/status")
	public String getStatus() {
		return "SUCCESS";
	}

	@PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendEmail(@RequestBody EmailVO emailVO) {
		
		return emailService.sendEmail(emailVO);
	}
}
