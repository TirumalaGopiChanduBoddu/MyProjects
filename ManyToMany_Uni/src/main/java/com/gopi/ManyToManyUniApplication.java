package com.gopi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gopi.entity.Role;
import com.gopi.entity.User;
import com.gopi.repository.UserRepository;

@SpringBootApplication
public class ManyToManyUniApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ManyToManyUniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		saveUser();
		
	}

	public void saveUser() {
		User user = new User();
		user.setFirstName("Gpi");
		user.setEmail("Gopi.gmaul.com");
		user.setLastName("Chandu");
		user.setPassword("Password");
		
		
		Role admin = new Role();
		admin.setName("ADMIN_ROlE");
		Role customer = new Role();
		customer.setName("CUSTOMER_ROLE");
		
		user.getRoles().add(customer);
		user.getRoles().add(admin);
		
		userRepository.save(user);
		
		
	}
}
