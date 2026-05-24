package com.apress.spring.config;

import java.sql.ResultSet;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@EnableGlobalAuthentication
public class JdbcSecurutyConfiguration extends GlobalAuthenticationConfigurAdapter {

	@Bean
	public UserDetailService userDetailsService(JdbcTemplate jdbcTemplate) {
		RowMapper<User> userRowMapper = (ResultSet rs, int i) -> 
		new User(
				rs.getString("ACCOUNT_NAME"),
				rs.getString("PASSWORD"),
				rs.getBoolean("ENABLED"),
				rs.getBoolean("ENABLED"),
				rs.getBoolean("ENABLED"),
				rs.getBoolean("ENABLED"),
				AuthorityUtiles.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
		return username -> 
		jdbcTemplate.queryForObject("SELECT * form ACCOUNT where ACCOUNT_NAME = ?",
				userRowMapper, username);
		
	}
	
	@Autowired
	private UserDetailsService userDetilsService;
	
	@Override
	public void init(AutenticationManagerBuider auth) throws Exception {
		auth.userDetailsService(this.userDetiailsService);
	
	}
	
}
