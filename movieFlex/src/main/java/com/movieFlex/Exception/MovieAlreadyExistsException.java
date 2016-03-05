package com.movieFlex.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Movie already exists")
public class MovieAlreadyExistsException extends Exception{
	private static final long serialVersionUID = 4024354626549014224L;
}
