package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.AuthenticationServiceRequest;
import org.dnyanyog.dto.AuthenticationServiceResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.AuthnticationServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	@Autowired
	AuthnticationServiceRepository repo;

	public AuthenticationServiceResponse login(AuthenticationServiceRequest authenticationServiceRequest) {

		AuthenticationServiceResponse response = new AuthenticationServiceResponse();
		List<Users> liCustomer = repo.findByUsernameAndPassword(authenticationServiceRequest.getUsername(),
				authenticationServiceRequest.getPassword());

		if (liCustomer.size() == 1) {
			response.setStatus("Success");
			response.setMessage("User Found!");
		} else {
			response.setStatus("Fail");
			response.setMessage("User Not Found");
		}

		return response;

	}

	public AuthenticationServiceResponse addUser(AuthenticationServiceRequest authenticationServiceRequest) {

		AuthenticationServiceResponse userResponse = new AuthenticationServiceResponse();

		Users tableData = new Users();

		tableData.setUsername(authenticationServiceRequest.getUsername());
		tableData.setPassword(authenticationServiceRequest.getPassword());
		tableData.setAge(authenticationServiceRequest.getAge());
		tableData.setEmail(authenticationServiceRequest.getEmail());

		tableData = repo.save(tableData);
		userResponse.setStatus("Success");
		userResponse.setMessage("Product Add Successfully");
		userResponse.setId(tableData.getId());

		return userResponse;

	}

	public AuthenticationServiceResponse deleteUser(Long userId) {

		AuthenticationServiceResponse response = new AuthenticationServiceResponse();

		Optional<Users> liCustomer = repo.findById(userId);

		if (liCustomer.isPresent()) {
			repo.deleteById(userId);
			response.setStatus("Success");
			response.setMessage("User Delete Successfully");
		} else {
			response.setStatus("Fail");
			response.setMessage("User Not Found");
		}

		return response;

	}

	public AuthenticationServiceResponse getSingleUser(Long userId) {

		AuthenticationServiceResponse userResponse = new AuthenticationServiceResponse();
		Optional<Users> receivedData = repo.findById(userId);
		if (receivedData.isEmpty()) {
			userResponse.setStatus("Fail");
			userResponse.setMessage("User Not Found");
		} else {
			Users user = receivedData.get();
			userResponse.setStatus("Success");
			userResponse.setMessage("User Found");
			userResponse.setUsername(user.getUsername());
			userResponse.setPassword(user.getPassword());
			userResponse.setId(user.getId());
			userResponse.setEamil(user.getEmail());
			userResponse.setAge(user.getAge());
		}

		return userResponse;
	}

	public AuthenticationServiceResponse updateUser(Long userId, Users request) {
		AuthenticationServiceResponse userResponse = new AuthenticationServiceResponse();
		Optional<Users> receivedData = repo.findById(userId);
		if (receivedData.isPresent()) {

			Users user = receivedData.get();

			user.setUsername(request.getUsername());
			user.setPassword(request.getPassword());
			user.setEmail(request.getEmail());
			user.setAge(request.getAge());

			user = repo.save(user);

			userResponse.setStatus("Success");
			userResponse.setMessage("User Updated");
		} else {
			userResponse.setStatus("Fail");
			userResponse.setMessage("User Not Found");

		}
		return userResponse;
	}

}
