package com.movieFlex.Comparators.MovieCon;

import java.util.Comparator;

import com.movieFlex.Model.Pojos.Movie;

public class ComparatorSortByRatings implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1.getImdbRating()> o2.getImdbRating()){
			return 1;
		}
		else if(o1.getImdbRating()< o2.getImdbRating()){
		return -1;
		}
		else{
			return 0;
		}
	}

}
