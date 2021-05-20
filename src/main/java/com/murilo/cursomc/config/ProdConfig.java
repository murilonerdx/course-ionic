package com.murilo.cursomc.config;

import com.murilo.cursomc.service.EmailService;
import com.murilo.cursomc.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("prod")
public class ProdConfig  {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}