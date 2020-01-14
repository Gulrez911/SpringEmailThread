package com.gul.thread;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailThreading extends Thread {

	@Autowired
	JavaMailSender mailSender;
	String sentTo;
	String message;
	String text;
	String subject;

	public EmailThreading(JavaMailSender mailSender, String sentTo, String message, String text, String subject) {
		super();
		this.mailSender = mailSender;
		this.sentTo = sentTo;
		this.message = message;
		this.text = text;
		this.subject = subject;
	}

	@Override
	public void run() {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setCc("gulfarooqui1@gmail.com");
			helper.setFrom("gulfarooqui1@gmail.com");
			helper.setBcc(sentTo);
			helper.setSubject(subject);

			helper.setText(text, true);
			mailSender.send(message);
			System.out.println("Mail Sent Successfully");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread Called");
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
