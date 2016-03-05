package com.movieFlex.Model.Pojos;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@NamedQueries(
		@NamedQuery(name="Movie.findByMovieTitle",query="SELECT m FROM Movie m WHERE m.title = :mTitle")
		)
public class Movie {
	
	@Id
	@GeneratedValue(generator="uuid2")
	 @GenericGenerator(strategy="uuid2", name = "uuid2")
	@Getter @Setter private String movieId;
	
	@Column(nullable=false, unique=true)
	@Getter @Setter private String title;
	
	@Column(nullable=false)
	@Getter @Setter private int year;
	
	@Column(nullable=false)
	@Getter @Setter private String rated;
	
	@Column(nullable=false)
	@Getter @Setter private String released;
	
	@Column(nullable=false)
	@Getter @Setter private String runtime;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable=false)
	@Getter @Setter private List<Genre> genre;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable=false)
	@Getter @Setter private List<Writers> writer;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable=false)
	@Getter @Setter private List<Directors> director;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable=false)
	@Getter @Setter private List<Actors> actor;
	
	@Column(nullable=false)
	@Getter @Setter private String plot;
	
	@Column(nullable=false)
	@Getter @Setter private String language;
	
	@Column(nullable=false)
	@Getter @Setter private String country;
	
	@Column(nullable=false)
	@Getter @Setter private String awards;
	
	@Column(nullable=false)
	@Getter @Setter private String poster;
	
	@Column(nullable=false)
	@Getter @Setter private int metascore;
	
	@Column(nullable=false)
	@Getter @Setter private float imdbRating;
	
	@Column(nullable=false)
	@Getter @Setter private int imdbVotes;
	
	@Column(nullable=false)
	@Getter @Setter private String imdbID;
	
	@Column(nullable=false)
	@Getter @Setter private String type;
	
	@Column(nullable=false)
	@Getter @Setter private boolean  deleted;
	
	@PrePersist
	void preInsert() {
	   deleted = false;
	}
	
}
