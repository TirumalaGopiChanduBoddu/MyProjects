package com.gopi.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
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
	public UserDetailsService userDetailsService() {
		UserDetails niraj = User.builder().username("niraj").password(passwordEncoder().encode("niraj")).roles("ADMIN").build();
		UserDetails gopi = User.builder().username("gopi").password(passwordEncoder().encode("gopi")).roles("USER").build();
		return new InMemoryUserDetailsManager(niraj , gopi);
		
	}
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
