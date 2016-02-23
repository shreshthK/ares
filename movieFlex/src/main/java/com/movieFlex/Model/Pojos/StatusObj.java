package com.movieFlex.Model.Pojos;

/**
 * A simple object that is used to return the status of a operation. 
 *
 */
public class StatusObj {
	public String failure;
	public boolean result;
	public StatusObj() {
	}
	public StatusObj(String failure, boolean result) {
		this.failure = failure;
		this.result = result;
	}
	public String getFailure() {
		return failure;
	}
	public void setFailure(String failure) {
		this.failure = failure;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}

}
