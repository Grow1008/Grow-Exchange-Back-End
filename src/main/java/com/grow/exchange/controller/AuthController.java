package com.grow.exchange.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grow.exchange.entity.UserEntity;
import com.grow.exchange.request.UserRequest;
import com.grow.exchange.service.LoginService;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	
	@Autowired
	private LoginService loginService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/login")
	    public UserEntity loginUser( @RequestBody UserRequest user) {
	        
	        return loginService.getloginUser(user);
	    
	 

}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	 @PostMapping("/logout")
	    public ResponseEntity logoutUser( @RequestBody UserRequest user) {
	        
	       String rst = loginService.logoutUser(user);
//	        return ResponseEntity
//            .status(HttpStatus.OK)                 
//            .body(rst);
	       Map<String, Object> map = new HashMap<String, Object>();
	            map.put("timestamp", new Date());
	            map.put("status", HttpStatus.OK);
	            map.put("message", rst);

	            return new ResponseEntity<Object>(map,HttpStatus.OK);
	    
	 

}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
		@GetMapping("/all_users")
		public List<UserEntity> getAllUsers(){
			return loginService.getallusers();
		
}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/get_users")
	public List<UserEntity> getAllUsersByAdminId(@RequestBody UserRequest admin){
		
		if(admin.getUserId().isEmpty() || admin.getUserId() == null ) {
	        Map<String, Object> map = new HashMap<String, Object>();
            map.put("timestamp", new Date());
            map.put("status", HttpStatus.BAD_REQUEST);
            map.put("message","user Id can not be empty");
            return (List<UserEntity>) new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
}
//		if(admin.getUserId()==null || admin.getUserId().) {
//		if(admin.getUserId() != null && !admin.getUserId().trim().isEmpty()) {
			return loginService.getusersbyAdminId(admin.getUserId());
//		}
//		else {
//			 Map<String, Object> map = new HashMap<String, Object>();
//	            map.put("timestamp", new Date());
//	            map.put("status", HttpStatus.OK);
//	            map.put("message", "User Id Cannot be Empty or Null");
//
//	            return new ResponseEntity<Object>(map,HttpStatus.OK);
////		return loginService.getusersbyAdminId(admin.getUserId());
//		}
	
}
}
