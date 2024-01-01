package org.dnyanyog.controller;

import org.dnyanyog.dto.AuthenticationServiceRequest;
import org.dnyanyog.dto.AuthenticationServiceResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationServiceController {

	@Autowired
	AuthenticationService authentication;

	@PostMapping(path = "/api/v1/user/login", consumes = { "application/json", "application/xml" }, produces = {"application/json", "application/xml" })
	public AuthenticationServiceResponse loginUser(@RequestBody AuthenticationServiceRequest authenticationServiceRequest) {
		return authentication.login(authenticationServiceRequest);

	}

	@PostMapping(path = "/api/v1/user/add", consumes = { "application/json", "application/xml" }, produces = {"application/json", "application/xml" })
	public AuthenticationServiceResponse userService(@RequestBody AuthenticationServiceRequest userRequest) {
		return authentication.addUser(userRequest);
	}

	@DeleteMapping(path = "/api/v1/user/delete/{userId}", consumes = { "application/json","application/xml" }, produces = { "application/json", "application/xml" })
	public AuthenticationServiceResponse deleteUser(@PathVariable Long userId) {
		return authentication.deleteUser(userId);

	}

	@GetMapping(path = "/api/v1/user/search/{userId}")
	public AuthenticationServiceResponse getSingleUser(@PathVariable Long userId) {
		return authentication.getSingleUser(userId);

	}

	@PostMapping(path = "/auth/v1/user/update/{userID}")
	public AuthenticationServiceResponse getSingleUser(@PathVariable Long userID, @RequestBody Users request) {
		return authentication.updateUser(userID, request);

	}

}
