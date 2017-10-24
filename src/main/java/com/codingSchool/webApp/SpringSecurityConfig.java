package com.codingSchool.webApp;

import com.codingSchool.webApp.Security.LoginAuthenticationProvider;
import com.codingSchool.webApp.Security.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Autowired
    private SuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/admin/**").hasAuthority("ADMIN")
        .antMatchers("/user/**").hasAuthority("USER")
        .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
        .anyRequest().fullyAuthenticated()
    .and().csrf().disable()
        .formLogin().successHandler(successHandler)
        .loginPage("/login") //to url tou LoginPage
        .permitAll()
        .usernameParameter("email")
        .passwordParameter("password")
    .and()
        .logout()
        .logoutUrl("/logout") //to url tou Logout
        .logoutSuccessUrl("/login") //redirect sti selida tou Login
        .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService()); //Credentials from UserDetails Service
        auth.authenticationProvider(loginAuthenticationProvider); //Credentials from repository
        //auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN"); //Hardcoded Credentials
    }

}
