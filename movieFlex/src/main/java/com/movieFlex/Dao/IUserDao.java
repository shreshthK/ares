package com.movieFlex.Dao;

import com.movieFlex.Exception.UserNotFoundException;
import com.movieFlex.Model.Pojos.User;

public interface IUserDao {
	
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public int deleteUser(String userName) throws UserNotFoundException;
	
	public User findByUserName(String userName);

}
