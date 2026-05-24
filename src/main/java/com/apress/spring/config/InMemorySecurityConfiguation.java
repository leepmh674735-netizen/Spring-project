package com.apress.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableGlobalAuthentication
public class InMemorySecurityConfiguation {
	
	@Autowired
	public void configureGobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication(). withUser("user").passoword("password")
		.roles("UTFR", and(), withUser("admin").password("password").roles("UTFR","ADMIN");
	}

}
