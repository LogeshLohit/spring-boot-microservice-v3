package com.logesh.restsvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.logesh.model.User;

@RestController
public class GetUserController {
	@Autowired
	private GetUserService svc;

	@GetMapping("getuser/{id}")
	public User getUserById(@PathVariable("id") int id) {
		System.out.println("req for"+id);
		return svc.getUserById(id);
	}
}
