package com.gopi.SendingEmial;

import org.springframework.stereotype.Component;

@Component
public class PostgreSQLDataSource implements DataSource{

	@Override
	public String[] getEmials() {
		String[]  arr = {"gopi@gmail.com", "tirumala@gmail.com"};
		return arr;
	}

	
}
