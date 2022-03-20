package com.grow.exchange.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.grow.exchange.entity.UserEntity;
import com.grow.exchange.repository.UserRepository;
import com.grow.exchange.request.UserRequest;


@Service
public class LoginService {

	
	@Autowired
	   private UserRepository userRepository;
		
		 public UserEntity getloginUser( @RequestBody UserRequest user) {
		List<UserEntity> users = userRepository.findAll();
		
	    for (UserEntity other : users) {
//	        if (other.equals(user)) {
	    	if(other.isActive() && other.getUserId().equals(user.getUserId()) && other.getUserPassword().equals(user.getUserPassword())) {
	            other.setLoggedIn(true);
	            userRepository.save(other);
	            other.setUserPassword(null);	            
	            return other;
	        }
//	        else {
//	        	return null;
//	        }
	    }
	    return null;
		 }
		 
		 public List<UserEntity> getallusers(){
			 
			 List <UserEntity> users=userRepository.findAll();
			 for (UserEntity other : users) {
				 other.setUserPassword(null);
			 }
			 return users;
		 }
		 
		 public String logoutUser(@RequestBody UserRequest user) {
			 UserEntity users=userRepository.findUserByUserId(user.getUserId());
			 if(users!=null) {
				 if(users.isLoggedIn()) {
			 users.setLoggedIn(false);
			 userRepository.save(users);
			 return "user has been logout succesfully";
				 }
				 else {
					 return "user not logged in ";
				 }
			 }
			 else {
				 return "user not found.";
			 }
		 }
		 public List<UserEntity> getusersbyAdminId(String adminId){
			List< UserEntity> users= userRepository.findUsersByAdminId(adminId);
			for (UserEntity other : users) {
				 other.setUserPassword(null);
			 }
			return users;
//			if(users.isEmpty()){
//				return null;
//			}
//			else {
//				return users;
//			}
		 }
		 
}
