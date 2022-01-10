package dbaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dbaccess.dto.User;
import dbaccess.dto.UserDao;

@RestController
public class UserResource {
	
	@Autowired
	private UserDao ud;
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		
		return ud.findall();
	}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		
		return ud.findOne(id);
	}
	@PostMapping("/users")
	public void createUser(@RequestBody User u)
	{
		ud.save(u);
	}

}
