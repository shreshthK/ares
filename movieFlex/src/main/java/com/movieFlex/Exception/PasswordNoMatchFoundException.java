package com.movieFlex.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_ACCEPTABLE, reason="No Password Match Found")
	public class PasswordNoMatchFoundException extends Exception {
}
