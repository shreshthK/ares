package com.movieFlex.Service.UserCon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieFlex.Dao.IUserDao;
import com.movieFlex.Exception.PasswordNoMatchFoundException;
import com.movieFlex.Exception.UserAlreadyExistsException;
import com.movieFlex.Exception.UserNotFoundException;
import com.movieFlex.Model.Pojos.User;
import com.movieFlex.Model.Pojos.UserLogin;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao dao;
	
	@Override
	public User signUp(User user) throws UserAlreadyExistsException {
		User existing =  dao.findByUserName(user.getUserName());
		if(existing == null) {
			return dao.createUser(user);
		}
		else {
			throw new UserAlreadyExistsException();
		}
	}

	@Override
	public User login(UserLogin ul) throws PasswordNoMatchFoundException, UserNotFoundException {
		User existing= dao.findByUserName(ul.getUserName());
		if(existing!=null){
			if((existing.getPassword()).equalsIgnoreCase(ul.getPassword())){
				return existing;
			}
			else{
				 throw new PasswordNoMatchFoundException();
			}
		}
		else {
			throw new UserNotFoundException();
		}
	}

	@Override
	public User updateUser(String userName, User user) throws UserNotFoundException {
		User existing =  dao.findByUserName(userName);
		if(existing == null) {
			throw new UserNotFoundException();
		}
		else {
			return dao.updateUser(user);
		}
	}

	@Override
	public void deleteUser(String userName) throws UserNotFoundException {
		if(userName!=null)
		{
			User existing=dao.findByUserName(userName);
			if(existing!=null){	
				int count=dao.deleteUser(userName);
			}
		else{
			throw new UserNotFoundException();
		}
	}
	else{
		throw new NullPointerException();
	}
	}

}
