package com.murilo.cursomc.service;

import com.murilo.cursomc.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    public static UserSS authenticatedUser() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch(Exception e) {
            return null;
        }
    }


}
