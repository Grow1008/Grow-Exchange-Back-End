package com.grow.exchange.request;

import java.util.Objects;

public class UserRequest {

	private String userId;
	private String userPassword;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserRequest(String userId, String userPassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
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
		UserRequest other = (UserRequest) obj;
		return Objects.equals(userId, other.userId) && Objects.equals(userPassword, other.userPassword);
	}
	
	
}
