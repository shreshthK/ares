package com.movieFlex.Model.Pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class RatingAndComments {
	
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Getter @Setter private String rcId;
	
	@ManyToMany
	@Column(nullable=false)
	@Getter @Setter private List<User> user;
	
	@ManyToMany
	@Column(nullable=false)
	@Getter @Setter private List<Movie> movie;  // make sure this correct mapping
	
	@Getter @Setter private int rating;
	
	@Getter @Setter private String comments;
	
	

}
