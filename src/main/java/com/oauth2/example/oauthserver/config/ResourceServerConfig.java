package com.oauth2.example.oauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@Configuration
@Order(-30)
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Override
	protected void configure(HttpSecurity httpSecurity)throws Exception{
		httpSecurity.requestMatchers().antMatchers("/login","/oauth/authorize")
		.and()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.permitAll();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder)throws Exception{
		authManagerBuilder.parentAuthenticationManager(authenticationManager)
		.inMemoryAuthentication()
		.withUser("arunabindu")
		.password("bindu")
		.roles("USER");
		//User.withDefaultPasswordEncoder().username("test").password("test").roles("ADMIN").build(); 
	}
	


  @SuppressWarnings("deprecation")
  @Bean
  public static NoOpPasswordEncoder passwordEncoder() {
   return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
}
	

}
