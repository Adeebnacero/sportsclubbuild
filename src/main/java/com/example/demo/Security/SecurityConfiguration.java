package com.example.demo.Security;

/**
 * Created by Adeebo on 2017/09/04.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        protected void configure(AuthenticationManagerBuilder amb) throws Exception {
            amb.inMemoryAuthentication()
                    .withUser("user")
                    .password("password")
                    .roles("USER");

        }

        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/Controller/**")
                    //.permitAll()
                    //.antMatchers("/assetController/**")
                    .hasRole("USER")
                    .and().csrf().disable().headers().frameOptions().disable();
        }
}