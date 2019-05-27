package com.jp.poc.email.service.impl;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jp.poc.email.model.EmailVO;
import com.jp.poc.email.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	@Override
	public String sendEmail(EmailVO emailVO) {
		String successMessage;
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(emailVO.getFromEmail());
		message.setTo(emailVO.getToEmail());

		StringWriter stringWriter = getEmailSubjectTemplateString(emailVO);
		message.setSubject(stringWriter.toString());

		StringWriter messageWriter = getEmailBodyTemplateString(emailVO);
		message.setText(messageWriter.toString());
		try {
			mailSender.send(message);
			successMessage ="SUCCESS";
		} catch (MailException e) {
			e.printStackTrace();
			successMessage ="FAILURE";
		}
		return successMessage;
	}

	private StringWriter getEmailSubjectTemplateString(EmailVO emailVO) {
		Template template = velocityEngine.getTemplate("./templates/" + emailVO.getTemplateName() + "_SUBJECT.vm");

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("firstName", emailVO.getFirstName());
		velocityContext.put("lastName", emailVO.getLastName());

		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		return stringWriter;
	}

	private StringWriter getEmailBodyTemplateString(EmailVO emailVO) {
		Template template = velocityEngine.getTemplate("./templates/" + emailVO.getTemplateName() + "_BODY.vm");

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("firstName", emailVO.getFirstName());
		velocityContext.put("lastName", emailVO.getLastName());
		velocityContext.put("location", "Chennai");

		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		return stringWriter;
	}

}
