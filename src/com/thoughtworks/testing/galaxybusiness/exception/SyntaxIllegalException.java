package com.thoughtworks.testing.galaxybusiness.exception;

/**
 * This exception indicate illegal syntax found with supplied input
 * @author chongwa
 *
 */
public class SyntaxIllegalException extends Exception {

	private static final long serialVersionUID = -8674281894215871977L;
	
	public SyntaxIllegalException(){
		
	}
	
	public SyntaxIllegalException(String message){
		super(message);
	}

}
