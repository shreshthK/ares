package com.movieFlex.Controllers.MovieCon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movieFlex.Dao.MovieDaoActions;
import com.movieFlex.Exception.MovieAlreadyExistsException;
import com.movieFlex.Exception.MovieNotFoundException;
import com.movieFlex.Model.Pojos.Comment;
import com.movieFlex.Model.Pojos.Movie;
import com.movieFlex.Service.MovieCon.IMovieService;

@Controller
@ResponseBody
@RequestMapping(value="/movies")
public class MovieController implements MovieActions{

	@Autowired
	MovieDaoActions mActions;
	
	@Autowired
	IMovieService service;
	@RequestMapping(value="/hello-eng",method= RequestMethod.GET,
						produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> sayHello(ModelMap map)
	{
				List<String> userList = new ArrayList<String>();
				userList.add("Four");
				userList.add("Five");
				userList.add("Six");
				return userList;
	}
	
	@Override
	@RequestMapping(value="/{filter}/paginate?p=0",method= RequestMethod.GET,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getList(@PathVariable("filter") String filterType,@RequestParam(value = "p") int p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/{emailId}/{uuid}/ratings/{rate}",method= RequestMethod.POST,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public int submitMovieFlexRatings(@PathVariable("emailId") String emailId,
						@PathVariable("uuid") String uuid,@PathVariable("rate") int rate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@RequestMapping(value="/{uuid}",method= RequestMethod.GET,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public int getMovieFlexRatings(@PathVariable("uuid") String uuid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@RequestMapping(value="/create",method= RequestMethod.POST,
								produces=MediaType.APPLICATION_JSON_VALUE,
								consumes=MediaType.APPLICATION_JSON_VALUE)
	public Movie createMovieFlexEntry(@RequestBody Movie m) throws MovieAlreadyExistsException {
		return mActions.addTitle(m);
	}

	@Override
	@RequestMapping(value="/delete/{uuid}",method= RequestMethod.DELETE,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteMovieFlexEntry(@PathVariable("uuid")String movieId) throws MovieNotFoundException {
		mActions.deleteTitle(movieId);
	}

	@Override
	@RequestMapping(value="/edit",method= RequestMethod.PUT,
								produces=MediaType.APPLICATION_JSON_VALUE,
								consumes=MediaType.APPLICATION_JSON_VALUE)
	public Movie editMovieFlexEntry(@RequestBody Movie m) throws MovieNotFoundException {
		return mActions.editTitle(m);
	}

	@Override
	@RequestMapping(value="/add-comment",method= RequestMethod.POST,
								produces=MediaType.APPLICATION_JSON_VALUE,
								consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Comment> addMovieComemnts(@RequestBody Comment comment) {
		return mActions.addComment(comment);
	}

	@RequestMapping(value="/get-comments/{movieId}",method= RequestMethod.GET,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Comment> getMovieCommetns(@PathVariable("movieId") String movieId) {
		return mActions.getComments(movieId);
	}
	
	@RequestMapping(value="/sort/ratings", method= RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> sortMoviesByRating(){
		return service.findAllMoviesByRatings();
		
	}
	
	@RequestMapping(value="/sort/year", method= RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> sortMoviesByYear(){
		return service.findAllMoviesByYear();
	}
	
	@RequestMapping(value="/sort/votes", method= RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> sortMoviesByVotes(){
		return service.findAllMoviesByVotes();
	}
	@RequestMapping(value="/toprated/movies", method= RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> topRatedMovies(){
		return service.topRatedMovies();
		
	}
	@RequestMapping(value="/toprated/series", method= RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> topRatedSeries(){
		return service.topRatedSeries();
		
	}
}
