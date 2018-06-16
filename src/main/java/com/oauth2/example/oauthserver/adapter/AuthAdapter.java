package com.oauth2.example.oauthserver.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class AuthAdapter   extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
	  return authenticationManager();
	}
	
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}

}
