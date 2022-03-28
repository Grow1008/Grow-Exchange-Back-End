package com.grow.exchange.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_role")
	private String userRole;
	@Column(name = "admin_id")
	private String adminId;
	@Column(name = "user_password")
	private String userPassword;
	@Column(name = "user_coin")
	private int userCoin;
	@Column(name = "created_on")
	private String createdOn;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "is_logged_in")
	private boolean isLoggedIn;
	@Column(name = "phone_no")
	private String mobileNo;
	

	public UserEntity(Long id, String userId, String userName, String userRole, String adminId, String userPassword,
			int userCoin, String createdOn, boolean isActive, boolean isLoggedIn, String mobile) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.adminId = adminId;
		this.userPassword = userPassword;
		this.userCoin = userCoin;
		this.createdOn = createdOn;
		this.isActive = isActive;
		this.isLoggedIn = isLoggedIn;
		this.mobileNo = mobile;
	}
	public UserEntity() {
		
	}
	
	public String getMobile() {
		return mobileNo;
	}
	public void setMobile(String mobile) {
		this.mobileNo = mobile;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserCoin() {
		return userCoin;
	}
	public void setUserCoin(int userCoin) {
		this.userCoin = userCoin;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userId, userPassword);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(userId, other.userId) && Objects.equals(userPassword, other.userPassword);
	}
	
	
	
	
	
}
