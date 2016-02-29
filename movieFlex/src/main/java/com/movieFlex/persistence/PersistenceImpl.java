package com.movieFlex.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieFlex.Dao.MovieDaoActions;
import com.movieFlex.Model.Pojos.Comment;

@Service
public class PersistenceImpl implements PersistenceActions {

	@Autowired
	MovieDaoActions mActions;
	
	@Override
	public List<Comment> getComments(String movieId) {
		return mActions.getComments(movieId);
	}

	@Override
	public List<Comment> addComment(Comment comment) {
		return mActions.addComment(comment);
	}

}
