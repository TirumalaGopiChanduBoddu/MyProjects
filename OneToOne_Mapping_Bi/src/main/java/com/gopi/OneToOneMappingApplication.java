package com.gopi;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gopi.entity.Address;
import com.gopi.entity.Order;
import com.gopi.entity.repository.AddressRepository;
import com.gopi.entity.repository.OrderRepository;


@SpringBootApplication
public class OneToOneMappingApplication implements CommandLineRunner{

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		saveOrder() ;
	}

	public void saveOrder() {
		Address address = new Address();
		address.setStreet("456 MG Road");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPinCode("560001");

		Order order = new Order();
		order.setOrderTrackingNumber("ORD123456");
		order.setTotalQuantity("5"); 
		order.setTotalPrice(BigDecimal.valueOf(9999.99));
		order.setStatus("Shipped");
		
		
		address.setOrder(order);
		addressRepository.save(address);
		
	}
}
