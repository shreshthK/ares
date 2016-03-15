package com.movieFlex.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movieFlex.Exception.PasswordNoMatchFoundException;
import com.movieFlex.Exception.UserNotFoundException;
import com.movieFlex.Model.Pojos.User;
import com.movieFlex.Model.Pojos.UserLogin;

@Repository
public class UserDaoImpl implements IUserDao{

	@PersistenceContext
	private EntityManager em;
	
	private int count;
	
	
	@Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		return em.merge(user);
		 
	}

	@Override
	public int deleteUser(String userName) throws UserNotFoundException {
				Query query = em.createNamedQuery("User.findByuserName");
		    	query.setParameter("puserName", userName);
		    	count = query.executeUpdate();
		    	return count;
	}

	@Override
	public User findByUserName(String userName) {
		TypedQuery<User> query = em.createNamedQuery("User.findByuserName", User.class);
    	query.setParameter("puserName", userName);
    	List<User> users = query.getResultList();
    	if(users != null && users.size() == 1) {
    		return users.get(0);
    	}
    	else {
    		return null;
    	}
	}

}
