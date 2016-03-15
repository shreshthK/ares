package com.movieFlex.Model.Pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class RatingAndComments {
	
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	 private String rcId;
	
	@ManyToMany
	@Column(nullable=false)
	 private List<User> user;
	
	@ManyToMany
	@Column(nullable=false)
	 private List<Movie> movie;  // make sure this correct mapping
	
	 private int rating;
	
	 private String comments;
	
	

}
