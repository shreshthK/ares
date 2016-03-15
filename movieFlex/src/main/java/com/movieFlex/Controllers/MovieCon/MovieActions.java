package com.movieFlex.Controllers.MovieCon;

import java.util.List;

import com.movieFlex.Exception.MovieAlreadyExistsException;
import com.movieFlex.Exception.MovieNotFoundException;
import com.movieFlex.Model.Pojos.Comment;
import com.movieFlex.Model.Pojos.Movie;

public interface MovieActions {
	
	/**
	 * a function to get a list of all movies. The function accepts filters 
	 * /all/paginate?p=0
	 * /category/paginate?p=0
	 * /title/paginate?p=0
	 * /year/paginate?p=0
	 * /genre/paginate?p=0
	 * returns a list of movie snippet Object 
	 * url: /{filter}/paginate?p=0
	 */
	public List<Movie> getList(String filterType,int p);
	
	/**
	 * Rate a movie, accepts movie uuid, rating and the username
	 * it returns the new ratings 
	 * url: /{emailId}/ratings
	 */
	public int submitMovieFlexRatings(String emailId,String uuid,int rate);
	
	/**
	 * Get the rating of a movie. It accepts the UUID of the movie.
	 * Returns the ratings of the movie
	 * url: /get/ratings  
	 */
	public int getMovieFlexRatings(String uuid);
	
	/**
	 * Create a new move. 
	 * It accepts all the details of the move and creates a new movie. It returns the movie details
	 * url: /create 
	 * @throws MovieAlreadyExistsException 
	 */
	public Movie createMovieFlexEntry(Movie m) throws MovieAlreadyExistsException;
	
	/**
	 * Delete a movie
	 * It deletes a movie. Accepts the uuid of the movie and the security token 
	 * It returns the status object after deleting the movie
	 * url: /delete  
	 * @throws MovieNotFoundException 
	 */
	public void deleteMovieFlexEntry(String uuid) throws MovieNotFoundException;
	
	/**
	 * Edit a movie 
	 * It edits the details of a existing movie. It accepts the MovieDetails object and returns the same
	 * url: /edit 
	 * @throws MovieNotFoundException 
	 */
	public Movie editMovieFlexEntry(Movie m) throws MovieNotFoundException;
	
	/**
	 * Add comments to the movie
	 * It accepts the comment object and returns a list of the newley appended comments 
	 */
	public List<Comment> addMovieComemnts(Comment comment);
	
	/**
	 * Get movie comments
	 * IT returns a list of movie comments. It is paginated by defaule 
	 */
	public List<Comment> getMovieCommetns(String uuid);
	
	public List<Movie> sortMoviesByRating();
	
	public List<Movie> sortMoviesByYear();
	
	public List<Movie> sortMoviesByVotes();
	
	public List<Movie> topRatedMovies();
	
	public List<Movie> topRatedSeries();

}
