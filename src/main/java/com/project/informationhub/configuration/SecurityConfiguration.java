package com.project.informationhub.configuration;

import com.project.informationhub.handler.LoginUrlAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("customUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    // .csrf().disable -> it allows to delete/update/add data. Most likely needs to be deleted
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/user/signup", "/user/username", "/user/email", "/user/signin").permitAll()
                .antMatchers("/user/{userId}/**").access("@userSecurity.hasUserId(authentication, #userId)")
                .and()
                .formLogin()
                // commented line below does redirect to user/id of the authenticated user.
                // uncomment if you want this functionality on the backend
                //.successHandler(loginUrlAuthenticationSuccessHandler())
                .and()
                .logout();
    }

    @Bean
    public AuthenticationSuccessHandler loginUrlAuthenticationSuccessHandler(){
        return new LoginUrlAuthenticationSuccessHandler();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}