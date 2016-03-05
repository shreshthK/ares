package com.movieFlex.Dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.movieFlex.Exception.MovieAlreadyExistsException;
import com.movieFlex.Exception.MovieNotFoundException;
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
	public Movie addTitle(Movie m) throws MovieAlreadyExistsException {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByMovieTitle", Movie.class);
    	query.setParameter("mTitle", m.getTitle());
    	List<Movie> movies =  query.getResultList();
    	
    	if(movies.size() >0){
    		throw new MovieAlreadyExistsException();	
    		
    	} else {
    		em.persist(m);
    	}
    				
    	return m;
	}
	
	@Override
	public Movie editTitle(Movie m) throws MovieNotFoundException {
		
		Movie existing = em.find(Movie.class, m.getMovieId());
		
	    if(existing != null){
	    	
	    	existing.setTitle(m.getTitle());
	    	existing.setYear(m.getYear());
	    	existing.setRated(m.getRated());
	    	existing.setReleased(m.getReleased());
	    	existing.setRuntime(m.getRuntime());
	    	existing.setPlot(m.getPlot()); 
	    	existing.setLanguage(m.getLanguage());
	    	existing.setCountry(m.getCountry());
	    	existing.setAwards(m.getAwards());
	    	existing.setPoster(m.getPoster());
	    	existing.setMetascore(m.getMetascore());
	    	existing.setImdbRating(m.getImdbRating());
	    	existing.setImdbVotes(m.getImdbVotes());
	    	existing.setImdbID(m.getImdbID());
	    	existing.setType(m.getType());
	    	existing.setDeleted(false);
			
	    	List<Genre> genres = existing.getGenre();
			for(Genre genre : genres ){
				genre.setDeleted(false);
				em.merge(genre);
			}
			List<Writers> writers = existing.getWriter();
			for (Writers writer : writers) {
				writer.setDeleted(false);
				em.merge(writer);
			}
			
			List<Directors> directors = existing.getDirector();
			for(Directors director : directors){	
				director.setDeleted(false);
				em.merge(director);
			}
			
			List<Actors> actors = existing.getActor();
			for(Actors actor: actors){
				actor.setDeleted(false);
				em.merge(actor);
			}
			
	    	em.merge(existing);
	    }else{
	    	throw new MovieNotFoundException();
	    }
	    
		return m;
	}

	@Override
	public void deleteTitle(String movieId) throws MovieNotFoundException {
		Movie existing = em.find(Movie.class, movieId);
		
		if(existing!=null){
			List<Genre> genres = existing.getGenre();
			for(Genre genre : genres ){
				genre.setDeleted(true);
				em.merge(genre);
			}
			List<Writers> writers = existing.getWriter();
			for (Writers writer : writers) {
				writer.setDeleted(true);
				em.merge(writer);
			}
			
			List<Directors> directors = existing.getDirector();
			for(Directors director : directors){	
				director.setDeleted(true);
				em.merge(director);
			}
			
			List<Actors> actors = existing.getActor();
			for(Actors actor: actors){
				actor.setDeleted(true);
				em.merge(actor);
			}
			
			existing.setDeleted(true);
			
			em.merge(existing);
		}else{
			throw new MovieNotFoundException();
		}
	}
}