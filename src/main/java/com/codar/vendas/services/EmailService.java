package com.codar.vendas.services;

import org.springframework.mail.SimpleMailMessage;

import com.codar.vendas.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);
}
