package com.movieFlex.Model.Pojos;

public class User {

	private int id;
	private String userNameFirst;
	private String userNameLast;
	private String userEmail;
	public int getId() {
		return id;
	}
	public User() {// for JPA
	}
	public User(String userNameFirst, String userNameLast, String userEmail) {
		super();
		this.userNameFirst = userNameFirst;
		this.userNameLast = userNameLast;
		this.userEmail = userEmail;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserNameFirst() {
		return userNameFirst;
	}
	public void setUserNameFirst(String userNameFirst) {
		this.userNameFirst = userNameFirst;
	}
	public String getUserNameLast() {
		return userNameLast;
	}
	public void setUserNameLast(String userNameLast) {
		this.userNameLast = userNameLast;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
