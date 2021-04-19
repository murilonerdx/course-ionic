package com.murilo.cursomc.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO {
    @NotEmpty
    @Email(message="Email invalido")
    private String email;
    public EmailDTO(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
