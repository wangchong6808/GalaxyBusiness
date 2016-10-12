package com.thoughtworks.testing.galaxybusiness.exception;

public class GoodsNotFoundException extends Exception {

	private static final long serialVersionUID = -8113849836001186104L;

	public GoodsNotFoundException(){
		super();
	}
	
	public GoodsNotFoundException(String message){
		super(message);
	}
}
