package com.movieFlex.Service.MovieCon;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieFlex.Comparators.MovieCon.ComparatorSortByRatings;
import com.movieFlex.Comparators.MovieCon.ComparatorSortByVotes;
import com.movieFlex.Comparators.MovieCon.ComparatorSortByYear;
import com.movieFlex.Dao.MovieDaoActions;
import com.movieFlex.Model.Pojos.Movie;

@Service
@Transactional
public class MovieServiceImpl implements IMovieService{

	@Autowired
	MovieDaoActions mActions;
	@Override
	public List<Movie> findAllMoviesByYear() {
		List<Movie> mv=mActions.findAllMovies();
		Collections.sort(mv,new ComparatorSortByYear());
		return mv;
	}

	@Override
	public List<Movie> findAllMoviesByRatings() {
		List<Movie> mv=mActions.findAllMovies();
		Collections.sort(mv,new ComparatorSortByRatings());
		return mv;
	}

	@Override
	public List<Movie> findAllMoviesByVotes() {
		List<Movie> mv=mActions.findAllMovies();
		Collections.sort(mv,new ComparatorSortByVotes());
		return mv;
	}

	@Override
	public List<Movie> topRatedMovies() {
		List<Movie> mv=mActions.findTopRatedMovies();
		Collections.sort(mv,new ComparatorSortByRatings());
		return mv;
	}

	@Override
	public List<Movie> topRatedSeries() {
		List<Movie> mv=mActions.findTopRatedSeries();
		Collections.sort(mv,new ComparatorSortByRatings());
		return mv; 
	}

}
