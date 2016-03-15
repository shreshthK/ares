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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name="Movie.findByMovieTitle",query="SELECT m FROM Movie m WHERE m.title = :mTitle"),
		@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m WHERE m.deleted=\"false\""),
		@NamedQuery(name="Movie.topRatedMovies", query="SELECT m from Movie WHERE m.type like \"mov%\" and m.deleted=\"false\""),
		@NamedQuery(name="Movie.topRatedSeries", query="SELECT m from Movie WHERE m.type like \"ser%\" and m.deleted=\"false\"")
})
public class Movie {
	
	@Id
	@GeneratedValue(generator="uuid2")
	 @GenericGenerator(strategy="uuid2", name = "uuid2")
	@JsonIgnore
	 private String movieId;
	
	@Column(nullable=false, unique=true)
	 private String title;
	
	@Column(nullable=false)
	 private int year;
	
	@Column(nullable=false)
	 private String rated;
	
	@Column(nullable=false)
	 private String released;
	
	@Column(nullable=false)
	 private String runtime;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable=false)
	 private List<Genre> genre;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable=false)
	 private List<Writers> writer;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable=false)
	 private List<Directors> director;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable=false)
	 private List<Actors> actor;
	
	@Column(nullable=false)
	 private String plot;
	
	@Column(nullable=false)
	 private String language;
	
	@Column(nullable=false)
	 private String country;
	
	@Column(nullable=false)
	 private String awards;
	
	@Column(nullable=false)
	 private String poster;
	
	@Column(nullable=false)
	 private int metascore;
	
	@Column(nullable=false)
	 private float imdbRating;
	
	@Column(nullable=false)
	 private int imdbVotes;
	
	@Column(nullable=false)
	 private String imdbID;
	
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public List<Writers> getWriter() {
		return writer;
	}

	public void setWriter(List<Writers> writer) {
		this.writer = writer;
	}

	public List<Directors> getDirector() {
		return director;
	}

	public void setDirector(List<Directors> director) {
		this.director = director;
	}

	public List<Actors> getActor() {
		return actor;
	}

	public void setActor(List<Actors> actor) {
		this.actor = actor;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Column(nullable=false)
	 private String type;
	
	@Column(nullable=false)
	 private boolean  deleted;
	
	@PrePersist
	void preInsert() {
	   deleted = false;
	}
	
}
