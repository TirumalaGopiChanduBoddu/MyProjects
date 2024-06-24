package com.gopi.confg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	//From spring security 6 we dont need to provide this explictly to the AM 
	//spring scurity 6 when we decalre like this -- > this will automatically uses this userDetailsService and it will call its loadUseyByName() method 
	@Autowired
	private UserDetailsService userDetailsService;
	
	
/*
	//http Basic authentication  -- it will not throw a login page for the authentication 
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
		.authorizeHttpRequests((authorize) -> {
			authorize.anyRequest().authenticated();
		}).httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}
*/
	
	
	//Roles based authentication
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
		.authorizeHttpRequests((authorize) -> {
//			authorize.requestMatchers(HttpMethod.POST , "/student/**").hasRole("ADMIN");
//			authorize.requestMatchers(HttpMethod.PUT , "/student/**").hasRole("ADMIN");
//			authorize.requestMatchers(HttpMethod.GET , "/student/**").hasAnyRole("ADMIN", "USER");
			authorize.anyRequest().authenticated();
		}).httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	//Spring security will call this AM 
	//authenticate() method present in this will can DAO Authentication provider 
	//authenticate() of AP will call loadByUserName() of CustomUserDetailsService class
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager(); 
	}
	
}
