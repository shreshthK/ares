package com.movieFlex.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.movieFlex.Model.Pojos.Actors;
import com.movieFlex.Model.Pojos.Comment;
import com.movieFlex.Model.Pojos.Directors;
import com.movieFlex.Model.Pojos.Genre;
import com.movieFlex.Model.Pojos.Movie;
import com.movieFlex.Model.Pojos.Writers;

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

	@Override
	public Movie addTitle(Movie m) {
		
		/* List<Genre> genres = m.getGenre();
		for (Genre genre : genres) {
			Genre existing = genre.find(Genre.class, genre.getName());
			if(existing==null)
				em.persist(genre);
		} 
		
		List<Writers> writers = m.getWriter();
		for (Writers writer : writers) {
			em.persist(writer);
		}
		
		List<Directors> directors = m.getDirector();
		for(Directors director : directors){	
			em.persist(director);
		}
		
		List<Actors> actors = m.getActor();
		for(Actors actor: actors){
			em.persist(actor);
		} */
		
		em.persist(m);
		
		return m;
	}
	
	@Override
	public Movie editTitle(Movie m) {
		
		Movie movie = m;
		
		Movie existing = em.find(Movie.class, m.getMovieId());
		
	    if(existing != null){
			
	    	//Following code can be used when soft delete is implemented
			/*
			List<Genre> genres = movie.getGenre();
			for(Genre genre : genres )
				em.merge(genre);
			
			List<Writers> writers = movie.getWriter();
			for (Writers writer : writers) {
				em.merge(writer);
			}
			
			List<Directors> directors = movie.getDirector();
			for(Directors director : directors){	
				em.merge(director);
			}
			
			List<Actors> actors = movie.getActor();
			for(Actors actor: actors)
				em.merge(actor);*/
	 		
	    	em.merge(m);
	    }
	    
		return m;
	}

	@Override
	public void deleteTitle(String movieId) {
		Movie existing = em.find(Movie.class, movieId);
		
		//Following code can be used when soft delete is implemented
		/*List<Genre> genres = existing.getGenre();
		for(Genre genre : genres )
			em.remove(genre);
		
		List<Writers> writers = existing.getWriter();
		for (Writers writer : writers) {
			em.remove(writer);
		}
		
		List<Directors> directors = existing.getDirector();
		for(Directors director : directors){	
			em.remove(director);
		}
		
		List<Actors> actors = existing.getActor();
		for(Actors actor: actors)
			em.remove(actor);*/
			
		em.remove(existing);
	}

}
