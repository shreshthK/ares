package com.movieFlex.Controllers.UserCon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.movieFlex.Model.Pojos.User;
import com.movieFlex.Model.Pojos.UserRegistration;
import com.movieFlex.util.OrderedPair;

@Controller
@ResponseBody
@RequestMapping(value="/users")
public class UserController implements UserActions {

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
	public User getUser(UserRegistration ur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/create",method= RequestMethod.POST,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public User createUser(UserRegistration ur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/delete",method= RequestMethod.DELETE,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public User deleteUser(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
