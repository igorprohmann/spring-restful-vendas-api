package com.codar.vendas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codar.vendas.services.EmailService;
import com.codar.vendas.services.SmtpEmailService;

@Configuration
public class MailConfig {

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
