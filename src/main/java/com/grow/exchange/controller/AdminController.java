package com.grow.exchange.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grow.exchange.entity.CoinTransactionLog;
import com.grow.exchange.entity.UserEntity;
import com.grow.exchange.request.UserRequest;
import com.grow.exchange.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/AddRedeemCoin")
	    public ResponseEntity AddRedeemCoin( @RequestBody CoinTransactionLog trnlog) {
		if(trnlog.getUserId().isEmpty() || trnlog.getUserId() == null ) {
			        Map<String, Object> map = new HashMap<String, Object>();
		            map.put("timestamp", new Date());
		            map.put("status", HttpStatus.BAD_REQUEST);
		            map.put("message","user Id can not be empty");
		            return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		}
		else {
			String rst=adminService.AddRedeemCoin(trnlog);
			if(rst.equals("User Not Found")) {
				 Map<String, Object> map = new HashMap<String, Object>();
		            map.put("timestamp", new Date());
		            map.put("status", HttpStatus.NOT_FOUND);
		            map.put("message", rst);
		            return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
			}
			else {
				 Map<String, Object> map = new HashMap<String, Object>();
		            map.put("timestamp", new Date());
		            map.put("status", HttpStatus.OK);
		            map.put("message", rst);
		            return new ResponseEntity<Object>(map,HttpStatus.OK);
			}
		      
		}
	}
		
// Add Edit User Service
		@CrossOrigin(origins = "*", allowedHeaders = "*")
		@PostMapping("/addEditUser")
		public UserEntity addEditUser(@RequestBody UserEntity requser) {
			
			return adminService.addEditUser(requser);
		}
//		end
	        
		
            
    

	    
	 


}
