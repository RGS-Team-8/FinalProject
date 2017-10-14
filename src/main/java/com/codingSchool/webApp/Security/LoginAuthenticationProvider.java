package com.codingSchool.webApp.Security;

import com.codingSchool.webApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        userService.login(username, password);

        Authentication auth = null;

       // Authenticate the user based on your custom logic

        if (role != null)
        {
            Collection<GrantedAuthority> grantedAuths = new SimpleGrantedAuthority(role.trim());
            ApplicationUser appUser = new ApplicationUser(userName,password, true, true, true, true,grantedAuths,"TestEmail");
            auth = new UsernamePasswordAuthenticationToken(appUser, password, grantedAuths);
            return auth;
        }
        else
        {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(username, password);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
