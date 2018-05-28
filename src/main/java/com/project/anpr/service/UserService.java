package com.project.anpr.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.anpr.exception.AlreadyExitException;
import com.project.anpr.exception.NotFoundException;
import com.project.anpr.model.Login;
import com.project.anpr.model.User;
import com.project.anpr.repository.LoginRepository;
import com.project.anpr.repository.UserRepository;
import com.project.anpr.request.UserCreatationRequest;
import com.project.anpr.util.LoginStatus;
import com.project.anpr.util.LoginType;
import com.project.anpr.util.Status;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LoginRepository loginRepository;

	public User saveUser(UserCreatationRequest creatationRequest) {
		
		User u =userRepository.findUserByEmail(creatationRequest.getEmail());
		if(u!=null) {
			throw new AlreadyExitException("Email Already Exits");
		}
		
		User user=new User();
		user.setFirstName(creatationRequest.getFirstName());
		user.setLastName(creatationRequest.getLastName());
		user.setEmail(creatationRequest.getEmail());
		user.setCreatedDate(new Date());
		user.setGender(creatationRequest.getGender());
		user.setStatus(Status.ACTIVE);
		
		User savedUser=userRepository.save(user);
		if(savedUser!=null) {
			Login login =new Login();
			login.setEmail(savedUser.getEmail());
			login.setPassword(creatationRequest.getPassord());
			login.setUsername(creatationRequest.getUsername());
			login.setLoginType(LoginType.ADMIN);
			login.setStatus(Status.ACTIVE);
			login.setLoginStatus(LoginStatus.LOGOUT);
			login.setUser(savedUser);
			loginRepository.save(login);
		}
		
		return user;
	}

	public void deleteUser(Long userId) {
		
		User user =userRepository.findUserById(userId);
		if(user==null) {
			throw new NotFoundException("User not found");
			
		}
		Login login=loginRepository.findLoginByEmailAndStatusNot(user.getEmail(),Status.DELETE);
		if(login==null) {
			throw new NotFoundException("User not found");
		}
		user.setStatus(Status.DELETE);
		login.setStatus(Status.DELETE);
		userRepository.save(user);
		loginRepository.save(login);
		
	}

}
