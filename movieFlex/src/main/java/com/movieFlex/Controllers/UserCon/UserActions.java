package com.movieFlex.Controllers.UserCon;

import java.util.List;

import com.movieFlex.Model.Pojos.User;
import com.movieFlex.Model.Pojos.UserRegistration;

public interface UserActions {

	/**
	 * Get Users 
	 * Accepts the security packet
	 * return a list of users. 
	 *  /list
	 *  
	 */
	public List<User> getAllUsers();
	
	/**
	 * Get a specific user 
	 * given the email of the user we must be able to get a user from the database. It is conceptually 
	 * equal to the Login Function.
	 */
	public User getUser(UserRegistration ur);
	
	/**
	 * Create a user 
	 * this accepts a object of type userRegistration, it then creates a user object and a login object.
	 * It returns the user object if successful  
	 */
	public User createUser(UserRegistration ur);
	
	/**
	 * Delete a user
	 * This function needs to delete a user, it accepts the users email
	 * it return the User object if successful 
	 */
	public User deleteUser(String userEmail);
}
