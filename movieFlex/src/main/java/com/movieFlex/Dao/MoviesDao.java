package com.movieFlex.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.movieFlex.Model.Pojos.Comment;


@Repository
@Transactional
public class MoviesDao implements MovieDaoActions{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Comment> getComments(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findByMovie", Comment.class);
    	query.setParameter("cMovieId", movieId);
    	List<Comment> quList =  query.getResultList();
    	return quList;
	}

	@Override
	public List<Comment> addComment(Comment comment) {
		em.persist(comment);
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findByMovie", Comment.class);
    	query.setParameter("cMovieId", comment.getMovieId());
    	List<Comment> quList =  query.getResultList();
    	return quList;
	}

}
