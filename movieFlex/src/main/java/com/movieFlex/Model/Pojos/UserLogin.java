package com.movieFlex.Model.Pojos;

import lombok.Getter;
import lombok.Setter;

public class UserLogin {
	@Getter @Setter private String userName;
	@Getter @Setter private String password;
	public UserLogin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}
