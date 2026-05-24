package com.apress.spring.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourSecurityConfiguration {
	
	@Override
	protected void configure(HttpSecurirty http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/").permitAll()
		    .antMatchers("/api/**").authenticated()
		    .and()
		    .formLogin().loginPage("/login").permitAll()
		    .and()
		    .logout().permitAll();
		
	}

}
