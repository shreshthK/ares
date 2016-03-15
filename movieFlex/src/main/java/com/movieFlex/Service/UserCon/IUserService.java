package com.movieFlex.Service.UserCon;

import com.movieFlex.Exception.PasswordNoMatchFoundException;
import com.movieFlex.Exception.UserAlreadyExistsException;
import com.movieFlex.Exception.UserNotFoundException;
import com.movieFlex.Model.Pojos.User;
import com.movieFlex.Model.Pojos.UserLogin;

public interface IUserService {

	public User signUp(User user) throws UserAlreadyExistsException;
	
	public User login(UserLogin ul) throws PasswordNoMatchFoundException, UserNotFoundException;
	
	public User updateUser(String userName, User user) throws UserNotFoundException;
	
	public void deleteUser(String userName) throws UserNotFoundException;
	
}
