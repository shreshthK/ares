package com.movieFlex.Comparators.MovieCon;

import java.util.Comparator;

import com.movieFlex.Model.Pojos.Movie;

public class ComparatorSortByYear implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1.getYear()> o2.getYear()){
			return 1;
		}
		else if(o1.getYear()< o2.getYear()){
		return -1;
		}
		else{
			return 0;
		}
	}

}
