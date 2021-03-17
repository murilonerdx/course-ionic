package com.murilo.cursomc.service;

import com.murilo.cursomc.model.pedido.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {
    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationEmail(Pedido obj);

    void sendOrderConfirmationHtmlEmail(Pedido obj);

    void sendHtmlEmail(MimeMessage msg);
}
