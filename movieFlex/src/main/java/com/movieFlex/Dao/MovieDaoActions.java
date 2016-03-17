package com.movieFlex.Dao;

import java.util.List;

import com.movieFlex.Exception.MovieAlreadyExistsException;
import com.movieFlex.Exception.MovieNotFoundException;
import com.movieFlex.Model.Pojos.Comment;
import com.movieFlex.Model.Pojos.Movie;
import com.movieFlex.Model.Pojos.User;

public interface MovieDaoActions {

	/**
	 * get a single movie by ID
	 */
	public User getUserFromId(String emailId);
	/**
	 * Get a list of comments from the underlying DAO layer
	 */
	public List<Comment> getComments(String movieId);
	
	/**
	 * Persist a comment object, returns a fresh list of comments
	 */
	public List<Comment> addComment(Comment comment);
	
	/**
	 * Persists a movie title and returns the persisted movie 
	 * @throws MovieAlreadyExistsException 
	 **/
	public Movie addTitle(Movie m) throws MovieAlreadyExistsException;
	
	public Movie editTitle(Movie m) throws MovieNotFoundException;

	public void deleteTitle(String movieId) throws MovieNotFoundException;

	public List<Movie> findTopRatedMovies();

	public List<Movie> findTopRatedSeries();

	public List<Movie> findAllMovies();
	
	/**
	 * Rating a title
	 */
	public Integer addRatings(String movieUuid, User user, Integer rating);
	
	/**
	 * Get a title ratings
	 */
	public Integer getRatings(String movieUuid);
}
