package com.movieFlex.Model.Pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
@NamedQueries(
		@NamedQuery(name="Ratings.getByMovieId",query="SELECT r FROM Ratings r WHERE r.movieId = :rMovieId")
		)
public class Ratings {

	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", unique = true)
	@JsonIgnore
	private String ratingId;
	private List<User> usersRated;
	private int ratings;
	private String movieId;
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public Ratings() {
	}
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	
	public List<User> getUsersRated() {
		return usersRated;
	}
	public void setUsersRated(List<User> usersRated) {
		this.usersRated = usersRated;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	
}
