package com.movieFlex.persistence;

import java.util.List;

import com.movieFlex.Model.Pojos.Comment;

public interface PersistenceActions {

	/**
	 * Get a list of comments from the underlying DAO layer
	 */
	public List<Comment> getComments(String movieId);
	
	/**
	 * Persist a comment object, returns a fresh list of comments
	 */
	public List<Comment> addComment(Comment comment);
}
