package com.project.anpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.anpr.request.UserCreatationRequest;
import com.project.anpr.service.UserService;

@RestController
@RequestMapping(value="/api/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> saveUser(@RequestBody UserCreatationRequest creatationRequest){
		userService.saveUser(creatationRequest);
		return new ResponseEntity<Object>("User Created",HttpStatus.CREATED);
		
		
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> saveUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return new ResponseEntity<Object>("User Deleted",HttpStatus.CREATED);
		
	}

}
