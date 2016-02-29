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
import com.movieFlex.Model.Pojos.Comment;
import com.movieFlex.Model.Pojos.MovieDetails;
import com.movieFlex.Model.Pojos.StatusObj;

@Controller
@ResponseBody
@RequestMapping(value="/movies")
public class MovieController implements MovieActions{

	@Autowired
	MovieDaoActions mActions;
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
	public List<MovieDetails> getList(@PathVariable("filter") String filterType,@RequestParam(value = "p") int p) {
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
	@RequestMapping(value="/create",method= RequestMethod.GET,
								produces=MediaType.APPLICATION_JSON_VALUE,
								consumes=MediaType.APPLICATION_JSON_VALUE)
	public StatusObj createMovieFlexEntry(@RequestBody MovieDetails md) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/delete/{uuid}",method= RequestMethod.DELETE,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusObj deleteMovieFlexEntry(@PathVariable("uuid")String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/edit",method= RequestMethod.POST,
								produces=MediaType.APPLICATION_JSON_VALUE,
								consumes=MediaType.APPLICATION_JSON_VALUE)
	public MovieDetails editMovieFlexEntry(@RequestBody MovieDetails md) {
		// TODO Auto-generated method stub
		return null;
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

}
