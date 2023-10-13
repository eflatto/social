package com.fiu.social.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fiu.social.entities.User;
import com.fiu.social.repositories.UserRepository;

@RestController
@RequestMapping(path="/social/users")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
//	
//	# Use the 'curl' command to send a POST request to a local web server.
//	# Specify the URL as 'http://localhost:8080/social/users/add'.
//	# Include data in the request body using the '-d' flag.
//	# Send 'name=First' and 'email=someemail@someemailprovider.com' as form data.
//	curl http://localhost:8080/demo/add -d name=First -d email=someemail@someemailprovider.com

	@PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewUser (@RequestBody User user) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	    User newUser = new User();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(user.getPassword());
	    userRepo.save(newUser);
	    return "Saved";
	  }
	
	
	@GetMapping(path="/all")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userRepo.findAll();
	 }
	
	//Show helloworld at /hello
	 @GetMapping("/hello")
	    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	      return "Hello, "+name;
	 }
	
	
}
