package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {	
		
		httpSecurity.formLogin().loginPage("/login").permitAll();
		
		httpSecurity.csrf().disable().authorizeRequests();
		
		/*
		 .and().authorizeRequests()
        .antMatchers("/index").permitAll()
		.antMatchers("/games/", "/stories/", "/games/**", "/stories/**").hasAnyRole("administrator", "superAdministrator")
		.antMatchers("/topics/**").hasRole("superAdministrator")
		.anyRequest().authenticated().and().httpBasic().and().logout().invalidateHttpSession(true)
		.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout").permitAll().and().exceptionHandling()
		.accessDeniedHandler(accessDeniedHandler)
		 */
	}
}
