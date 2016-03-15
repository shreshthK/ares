package com.movieFlex.Comparators.MovieCon;

import java.util.Comparator;

import com.movieFlex.Model.Pojos.Movie;

public class ComparatorSortByVotes implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1.getImdbVotes()> o2.getImdbVotes()){
			return 1;
		}
		else if(o1.getImdbVotes()< o2.getImdbVotes()){
		return -1;
		}
		else{
			return 0;
		}
	}

}
