package com.gopi.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.stereotype.Service;

import com.gopi.entity.User;
import com.gopi.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmialId ) throws UsernameNotFoundException {
		User user = userRepository.findByUserNameOrEmailId(usernameOrEmialId, usernameOrEmialId).get();
		//Converting the set of rloes into set of Granted authorities 
		
		Set<GrantedAuthority> authorities =  user.getRoles().stream().
				map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		
		return new org.springframework.security.core.userdetails.User(usernameOrEmialId, user.getPassword(), authorities);
		
	}

}
