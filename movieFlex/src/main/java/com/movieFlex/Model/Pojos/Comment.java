package com.movieFlex.Model.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@NamedQueries(
		@NamedQuery(name="Comment.findByMovie",query="SELECT c FROM Comment c WHERE c.movieId = :cMovieId")
		)
public class Comment {

	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", unique = true)
	@JsonIgnore
	private String commentUuid;
	private String userEmail;
	@Column(columnDefinition="VARCHAR(500)")
	private String comment;
	private String movieId;
	public Comment() {
	}
	public String getCommentUuid() {
		return commentUuid;
	}
	public void setCommentUuid(String commentUuid) {
		this.commentUuid = commentUuid;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
}
