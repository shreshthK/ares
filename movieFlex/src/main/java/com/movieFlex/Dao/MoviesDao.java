package com.movieFlex.Dao;


import java.util.List;

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
import com.movieFlex.Model.Pojos.Ratings;
import com.movieFlex.Model.Pojos.User;
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

	@Override
	public List<Movie> findAllMovies() {
		TypedQuery<Movie> query = em.createQuery("Movie.findAll", Movie.class);
		List<Movie>mv=query.getResultList();
		return mv;
	}


	@Override
	public List<Movie> findTopRatedMovies() {
		TypedQuery<Movie> query = em.createQuery("Movie.topRatedMovies", Movie.class);
		List<Movie>mv=query.getResultList();
		return mv;
	}

	@Override
	public List<Movie> findTopRatedSeries() {
		TypedQuery<Movie> query = em.createQuery("Movie.topRatedSeries", Movie.class);
		List<Movie>mv=query.getResultList();
		return mv;
	}

	@Override
	public Integer addRatings(String movieUuid, User user, Integer rating) {
		TypedQuery<Ratings> tq = em.createNamedQuery("Ratings.getByMovieId", Ratings.class);
		tq.setParameter("rRatingId", movieUuid);
		List<Ratings> ratings = tq.getResultList();
		
		Ratings r = ratings.get(0);
		List<User> u = r.getUsersRated();
		if(u.contains(user))
			return ratings.get(0).getRatings();
		
		r.setRatings((r.getRatings()+rating)/2);
		List<User> newU = r.getUsersRated();
		newU.add(user);
		r.setUsersRated( newU );
		return ratings.get(0).getRatings();
	}

	@Override
	public Integer getRatings(String movieUuid) {
		TypedQuery<Ratings> tq = em.createNamedQuery("Ratings.getByMovieId", Ratings.class);
		tq.setParameter("rRatingId", movieUuid);
		List<Ratings> ratings = tq.getResultList();
		return ratings.get(0).getRatings();
	}

	@Override
	public User getUserFromId(String emailId) {
		TypedQuery< User> tx = em.createNamedQuery("User.findByEmail", User.class);
		tx.setParameter("uEmail", emailId);
		List<User> qList = tx.getResultList();
		return qList.get(0);
	}
}