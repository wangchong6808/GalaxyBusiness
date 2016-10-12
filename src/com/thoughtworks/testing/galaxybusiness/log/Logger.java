package com.thoughtworks.testing.galaxybusiness.log;

public class Logger {

	public static void log(String message){
		System.out.println(message);
	}
	
	public static void log(String message, Throwable e){
		System.out.println(message);
		e.printStackTrace();
	}
	
	public static void log(Throwable e){
		e.printStackTrace();
	}
}
