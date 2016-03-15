package com.movieFlex.Controllers.UserCon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieFlex.Exception.UserAlreadyExistsException;
import com.movieFlex.Exception.UserNotFoundException;
import com.movieFlex.Model.Pojos.User;
import com.movieFlex.Model.Pojos.UserLogin;
import com.movieFlex.Service.UserCon.IUserService;

@RestController
@RequestMapping(value="/users")
public class UserController implements UserActions {
	
	@Autowired
	
	private IUserService service;

	@RequestMapping(value="/hello-eng",method= RequestMethod.GET,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> sayHello(ModelMap map)
	{
		List<String> userList = new ArrayList<String>();
		userList.add("One");
		userList.add("Two");
		userList.add("Three");
		return userList;
	}

	@Override
	@RequestMapping(value="/list",method= RequestMethod.GET,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/find",method= RequestMethod.POST,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUser(UserLogin ur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/create",method= RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User ur) throws UserAlreadyExistsException {
		return service.signUp(ur);
	}

	@Override
	@RequestMapping(value="/delete/{userName}",method= RequestMethod.DELETE,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable("userName") String userName) {
	}

	@Override
	@RequestMapping(value="/update/{email}",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,
	produces=MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@PathVariable("userName") String userName, User user) throws UserNotFoundException {
		return service.updateUser(userName, user);
	}


	

}
