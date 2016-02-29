package com.movieFlex.Model.Pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class User {
	
	 public User(String userName, String firstName, String lastName,
			String email, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	 @GeneratedValue(generator="uuid2")
	 @GenericGenerator(strategy="uuid2", name = "uuid2")
	@Setter private String userId;
	 @Id
	@Getter @Setter private String userName;
	 
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@Getter @Setter private String email;
	@Getter @Setter private String password;
	

}
