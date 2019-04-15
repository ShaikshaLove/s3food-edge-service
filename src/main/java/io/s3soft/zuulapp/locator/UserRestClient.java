package io.s3soft.zuulapp.locator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.s3soft.zuulapp.util.User;

@Component
public class UserRestClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User getUserByUserName(String username) {
		User user=restTemplate.getForObject("https://s3food-users.herokuapp.com/users/"+username.toLowerCase(),User.class);
		System.out.println("From user rest client "+user);
		return user;
		
	}

}
