package com.codingSchool.webApp.Security;

import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication ) throws AuthenticationException {

        String email = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userService.loadUserByEmailAndPassword(email, password);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (user.isTypeofuser().equals("ADMIN")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        }
        else if (user.isTypeofuser().equals("USER")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        }

        Authentication auth = new UsernamePasswordAuthenticationToken(email, password, grantedAuthorities);
        System.out.println(user.getFirstname());
        return auth;
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
