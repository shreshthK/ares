package com.movieFlex.Model.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries ({
		@NamedQuery(name="User.findByUserName", query="SELECT u FROM User u WHERE u.userName = :puserName"),
		@NamedQuery(name="User.deleteUser", query="Update User u SET u.deleted=true WHERE u.userName=:puserName")
})
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
	 @Id
	 @GeneratedValue(generator="uuid2")
	 @GenericGenerator(strategy="uuid2", name = "uuid2")
	 private String userId;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(unique=true, nullable=false)
	 private String userName;
	 
	 @Column(unique=true, nullable=false)
	 private String firstName;
	 
	 @Column(unique=true, nullable=false)
	 private String lastName;
	 
	 public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Column(unique=true, nullable=false)
	 private String email;
	 
	 @Column(nullable=false)
	 private String password;
	 
	 @Column(nullable=false)
	 private boolean  deleted;
	
	@PrePersist
	void preInsert() {
	   deleted = false;
	}
	

}
