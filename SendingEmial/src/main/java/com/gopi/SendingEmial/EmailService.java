package com.gopi.SendingEmial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	DataSource dataSource;
	
	@Autowired
	EmailService(@Qualifier("mySqlDataSource") DataSource dtaDataSource){
		this.dataSource=dtaDataSource;
	}
	
	public void sendEmail() {
		String[] arr = dataSource.getEmials();
		for(String str : arr) {
			System.out.println(str);
		}
	}
}
