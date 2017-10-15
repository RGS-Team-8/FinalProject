package com.codingSchool.webApp;

import com.codingSchool.webApp.Security.LoginAuthenticationProvider;
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
//                .and().formLogin().defaultSuccessUrl("/")
//                .loginPage("/login").and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

//        http.authorizeRequests()
//                .antMatchers("/admin/**").access("hasRole('ROLE_USER')")
//                .and()
//                .formLogin().loginPage("/login").failureUrl("/")
//                .usernameParameter("username").passwordParameter("password")
//                .and()
//                .logout().logoutSuccessUrl("/login")
//                .and()
//                .csrf();


    http.authorizeRequests()
        .antMatchers("/admin/**").hasAuthority("ADMIN")
        .anyRequest().fullyAuthenticated()
        .and().csrf().disable()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .usernameParameter("email")
        .passwordParameter("password")
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService()); //Credentials from UserDetails Service
        auth.authenticationProvider(loginAuthenticationProvider); //Credentials from repository
        //auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN"); //Hardcoded Credentials
    }

}
