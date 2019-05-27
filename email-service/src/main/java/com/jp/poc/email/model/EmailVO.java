package com.jp.poc.email.model;

public class EmailVO {
	
	private String fromEmail;

	private String[] toEmail;
	
	private String firstName;
	
	private String lastName;
	
	private String[] ccEmail;
	
	private String emailBody;
	
	private String subject;
	
	private String templateName;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String[] getToEmail() {
		return toEmail;
	}

	public void setToEmail(String[] toEmail) {
		this.toEmail = toEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String[] getCcEmail() {
		return ccEmail;
	}

	public void setCcEmail(String[] ccEmail) {
		this.ccEmail = ccEmail;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	
}
