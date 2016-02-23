package com.movieFlex.Controllers.MovieCon;

import java.util.List;

import com.movieFlex.Model.Pojos.MovieDetails;
import com.movieFlex.Model.Pojos.StatusObj;

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
	public List<MovieDetails> getList(String filterType,int p);
	
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
	 * It accepts all the details of the move and creates a new movie. It returns the status object
	 * url: /create 
	 */
	public StatusObj createMovieFlexEntry(MovieDetails md);
	
	/**
	 * Delete a movie
	 * It deletes a movie. Accepts the uuid of the movie and the security token 
	 * It returns the status object after deleting the movie
	 * url: /delete  
	 */
	public StatusObj deleteMovieFlexEntry(String uuid, String securityToken);
	
	/**
	 * Edit a movie 
	 * It edits the details of a existing movie. It accepts the MovieDetails object and returns the same
	 * url: /edit 
	 */
	public MovieDetails editMovieFlexEntry(MovieDetails md);
	
	

}
