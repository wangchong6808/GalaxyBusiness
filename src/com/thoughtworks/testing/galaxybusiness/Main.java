package com.thoughtworks.testing.galaxybusiness;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.thoughtworks.testing.galaxybusiness.exception.SymbolNotFoundException;
import com.thoughtworks.testing.galaxybusiness.exception.SyntaxIllegalException;
import com.thoughtworks.testing.galaxybusiness.input.InputParser;
import com.thoughtworks.testing.galaxybusiness.input.InputStore;
import com.thoughtworks.testing.galaxybusiness.log.Logger;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, SyntaxIllegalException {
		Logger.log("*****************************************************************");
		Logger.log("************************  Program start  ************************");
		InputStore store = new InputParser().parse(new File("input1.txt"));
		for(String word : store.getAllWords()){
			try {
				System.out.println(word+":"+store.getSymbol(word).toString());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SymbolNotFoundException e) {
				e.printStackTrace();
			}
		}
		Logger.log("************************  Program end  **************************");
		Logger.log("*****************************************************************");
		
	}

}
