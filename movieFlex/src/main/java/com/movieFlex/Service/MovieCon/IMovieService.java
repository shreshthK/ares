package com.movieFlex.Service.MovieCon;

import java.util.List;

import com.movieFlex.Model.Pojos.Movie;

public interface IMovieService {

	public List<Movie> findAllMoviesByYear();

	public List<Movie> findAllMoviesByRatings();

	public List<Movie> findAllMoviesByVotes();

	public List<Movie> topRatedMovies();

	public List<Movie> topRatedSeries();
	

}
