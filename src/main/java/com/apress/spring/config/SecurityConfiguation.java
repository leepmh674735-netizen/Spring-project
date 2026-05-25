package com.apress.spring.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguation extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**").autheniticated()
		.and()
		.logout().permitAll()
		.and()
		.csrf().disable();
	}
	
	@Configuration
	static protected class LoginController extends WebMvcConfiguerAdapter {
		
		@Override
		public void addViewControllers(ViewControlllerRegistry redistry) {
			registry.addViewController("/login").setViewName("login");
		}		
	}
}
