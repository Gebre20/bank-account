package com.bap.bankaccount.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bap.bankaccount.entity.User;
import com.bap.bankaccount.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    
    UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<String> findById(@PathVariable Long id) {
		return new ResponseEntity<>(userService.getUser(id).getUsername(), HttpStatus.OK);
	}

    @PostMapping("/signup")
	public ResponseEntity<HttpStatus> createUser(@Valid @RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	// @PostMapping("/login")
	// public ResponseEntity<HttpStatus> loginUser(@Valid @RequestBody User user) {
	// 	userService.saveUser(user);
	// 	return new ResponseEntity<>(HttpStatus.CREATED);
	// }
}
