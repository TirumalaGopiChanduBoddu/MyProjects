package com.gopi.SendingEmial;

import org.springframework.stereotype.Component;

@Component
public class MySqlDataSource implements DataSource{

	@Override
	public String[] getEmials() {
		String[]  arr = {"hari@gmail.com", "mahesh@gmail.com"};
		return arr;
	}

	
}
