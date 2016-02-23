package com.movieFlex.Controllers.MovieCon;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movieFlex.Model.Pojos.MovieDetails;
import com.movieFlex.Model.Pojos.StatusObj;

@Controller
@ResponseBody
@RequestMapping(value="/movies")
public class MovieController implements MovieActions{

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
	public int getMovieFlexRatings(String uuid) {
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
	@RequestMapping(value="/delete",method= RequestMethod.DELETE,
								produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusObj deleteMovieFlexEntry(String uuid, String securityToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/edit",method= RequestMethod.POST,
								produces=MediaType.APPLICATION_JSON_VALUE,
								consumes=MediaType.APPLICATION_JSON_VALUE)
	public MovieDetails editMovieFlexEntry(MovieDetails md) {
		// TODO Auto-generated method stub
		return null;
	}

}
