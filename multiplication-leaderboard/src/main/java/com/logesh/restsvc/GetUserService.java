package com.logesh.restsvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.logesh.model.User;

@Service
public class GetUserService {
	private final String URL = "http://localhost";
	private final String PORT = "8082";
	@Autowired
	private RestTemplate template;

	public User getUserById(int id) {
		User user = template.getForObject(URL + ":" + PORT + "/getUserById/" + id, User.class);
		System.out.println("Found user : " + user);
		return user;
	}

}
