package com.thoughtworks.testing.galaxybusiness.exception;

public class CalculateErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8860283071074845944L;

	public CalculateErrorException(){
		super();
	}
	
	public CalculateErrorException(String message){
		super(message);
	}
	
	public CalculateErrorException(String message, Throwable e){
		super(message, e);
	}
}
