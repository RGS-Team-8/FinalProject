package com.codingSchool.webApp.Security;

import com.codingSchool.webApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication ) throws AuthenticationException {
//        String email = authentication.getName().trim();
//        String password = authentication.getCredentials().toString().trim();
//        User user;
//        try {
//            user =  userService.login(email, password);
//        } catch (javax.naming.AuthenticationException e) {
//            e.printStackTrace();
//        }
//        return new UsernamePasswordAuthenticationToken(email, password);

        String email = authentication.getName();
        String password = (String) authentication.getCredentials();
        try {
            userService.loadUserByEmail(email);
        } catch (javax.naming.AuthenticationException e) {
            e.printStackTrace();
        }
        return new UsernamePasswordAuthenticationToken(email, password);
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
