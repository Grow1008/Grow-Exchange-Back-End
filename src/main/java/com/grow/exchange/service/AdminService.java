package com.grow.exchange.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.grow.exchange.entity.CoinTransactionLog;
import com.grow.exchange.entity.UserEntity;
import com.grow.exchange.repository.CoinTransRepository;
import com.grow.exchange.repository.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	CoinTransRepository coinTransRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public String AddRedeemCoin(@RequestBody CoinTransactionLog cointrns) {
		
		
		
		UserEntity user=userRepo.findUserByUserId(cointrns.getUserId());
		if(user!=null) {
			UserEntity admin=userRepo.findUserByUserId(user.getAdminId());			
			String currentDate;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			   LocalDateTime now = LocalDateTime.now();
			   currentDate=dtf.format(now);
			user.setUserCoin(cointrns.getUpdatedCoin());
			userRepo.save(user);
			cointrns.setTrnsDate(currentDate);
			coinTransRepo.save(cointrns);
			if(admin!=null) {
			
			// add transaction details for admin 
				CoinTransactionLog adminCoinTrn = new CoinTransactionLog();
				adminCoinTrn.setPreCoin(admin.getUserCoin());
				adminCoinTrn.setEventName(Integer.parseInt(cointrns.getReqCoin())>=0?"Redeem":"Add");
				adminCoinTrn.setReqCoin(Integer.parseInt(cointrns.getReqCoin())>=0?cointrns.getReqCoin().replace("+","-"):cointrns.getReqCoin().replace("-","+"));
				adminCoinTrn.setUserId(admin.getUserId());
				adminCoinTrn.setTrnsDate(currentDate);
			
			int prvCoin=Integer.parseInt(admin.getUserCoin());
			int reqcoin=Integer.parseInt(adminCoinTrn.getReqCoin());
			int updatedCoin=prvCoin+reqcoin;
			admin.setUserCoin(String.valueOf(updatedCoin));
			adminCoinTrn.setUpdatedCoin(String.valueOf(updatedCoin));
			userRepo.save(admin);
			
			coinTransRepo.save(adminCoinTrn);
			// end
			}
			return "User Coin Updated Sucessfully";
		}
		else {
			return "User Not Found";
		}
		
	}
	
	public UserEntity addEditUser(@RequestBody UserEntity requser) {
		String currentDate;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   currentDate=dtf.format(now);
		
		if(requser.getId()==null) {
			// case of add user
			requser.setCreatedOn(currentDate);
			UserEntity us= userRepo.save(requser);
			us.setUserPassword(null);
			return us;
		}
		else {
			// case of edit/delete
//			UserEntity user=userRepo.findUserByUserId(requser.getUserId());
			UserEntity user=userRepo.findUserById(requser.getId());
			user.setUserId(requser.getUserId());
			user.setUserName(requser.getUserName());
			user.setUserPassword(requser.getUserPassword());
			user.setMobile(requser.getMobile());
			user.setActive(requser.isActive());
			UserEntity us=userRepo.save(user);
			us.setUserPassword(null);
			return us;
		}
//	
//	if(user!=null) {
//		
//	}
//	else {
//		return null;
//	}
	}

}
