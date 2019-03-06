package com.sefamertkaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sefamertkaya.yazilimsozluk.LoginController;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	public void registerMail(String mail, String key) {

		// mail g�ndercek kod
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("javaspringegitim@gmail.com");
		email.setTo(mail);
		email.setSubject("Parola De�i�tir.");
		email.setText(
				"Parolan�z� de�i�tirmek i�in a�a��daki linke t�klay�n. \n\n" + LoginController.url + "/pss/" + key);

		mailSender.send(email);
	}

}
