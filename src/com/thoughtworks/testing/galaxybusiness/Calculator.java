package com.thoughtworks.testing.galaxybusiness;

import com.thoughtworks.testing.galaxybusiness.exception.CalculateErrorException;
import com.thoughtworks.testing.galaxybusiness.exception.SymbolNotFoundException;
import com.thoughtworks.testing.galaxybusiness.input.InputStore;
import com.thoughtworks.testing.galaxybusiness.log.Logger;


public class Calculator {

	public static float calculateByWords(String statement, InputStore store) throws CalculateErrorException{
		float output = -1f;
		statement = transform(statement, store);
		output = calculateBySymbols(statement);
		return output;
	}
	
	/**
	 * The method calculate the value represented by input statement 
	 * that is supposed to be a sequence of symbols
	 * @param statement a sequence of symbols
	 * @return
	 */
	/*
	 * 
	 * */
	public static float calculateBySymbols(String statement){
		int size = statement.length();
		float total = 0f;
		
		//set current max to the smallest symbol
		Symbol current_max = Symbol.orderedValues(true).get(0);
		for(int i=size-1; i>=0; i--){
			Symbol symbol = Symbol.valueOf(statement.substring(i,i+1));
			if(symbol.getValue() >= current_max.getValue()){
				total = total + symbol.getValue();
				current_max = symbol;
			}else{
				total = total - symbol.getValue();
			}
		}
		return total;
	}
	
	private static String transform(String statement, InputStore store) throws CalculateErrorException{
		/*for(String name : store.getAllWords()){
			try {
				System.out.println(name+":"+store.getSymbol(name).name());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SymbolNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		String[] words = statement.split(" ");
		StringBuffer sb = new StringBuffer();
		for(String word : words){
			if(!word.trim().equals("")){
				try {
					sb.append(store.getSymbol(word).name());
				} catch (IllegalArgumentException e) {
					Logger.log(e);
					throw new CalculateErrorException("Unable to calculate with input:"+statement, e);
				} catch (SymbolNotFoundException e) {
					Logger.log(e);
					throw new CalculateErrorException("Unable to calculate with input:"+statement, e);
				}
			}
		}
		String output = sb.toString();
		return output;
	}
}
