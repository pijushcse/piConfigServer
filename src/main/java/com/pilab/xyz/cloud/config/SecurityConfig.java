package com.pilab.xyz.cloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
				.authorizeRequests()
				.antMatchers("/phx-config-rest/prod/master").hasRole("PROD")
			.and()
				.authorizeRequests()
					.antMatchers("/phx-config-rest/dev/master").hasRole("DEV")
						.anyRequest()
							.denyAll()
			.and()
				.csrf()
					.disable();
	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
			inMemoryAuthentication()
			.withUser("devuser")
			.password("dev")
			.roles("DEV") ;
		
		auth.
			 inMemoryAuthentication()
			.withUser("produser")
			.password("prod")
			.roles("PROD") ;		
	}
}
