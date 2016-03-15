package com.movieFlex.Model.Pojos;


public class UserLogin {
	 private String userName;
	 public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	public UserLogin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}
