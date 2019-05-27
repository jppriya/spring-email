package com.jp.poc.email.service;

import com.jp.poc.email.model.EmailVO;

public interface EmailService {

	String sendEmail(EmailVO emailVO);
	
	

}
