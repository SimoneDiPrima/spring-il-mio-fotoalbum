package org.foto.italy.demo.security;

import org.foto.italy.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConf {


	@Bean
	public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()	
		.requestMatchers("/*/admin/", "/*/admin/**").hasAuthority("Admin")
		.requestMatchers("/**").permitAll()
	.and().formLogin()
	.and().logout()
;
		
		return http.build();
	}
	
	
	@Bean
	public UserDetailsService getUserDetailsService() {
		
		return new UserService();
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(getUserDetailsService());
		provider.setPasswordEncoder(getPasswordEncoder());
		
		return provider;
	}

}
