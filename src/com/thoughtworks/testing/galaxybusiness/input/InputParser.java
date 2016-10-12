package com.thoughtworks.testing.galaxybusiness.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.thoughtworks.testing.galaxybusiness.Regex;
import com.thoughtworks.testing.galaxybusiness.Symbol;
import com.thoughtworks.testing.galaxybusiness.exception.SyntaxIllegalException;
import com.thoughtworks.testing.galaxybusiness.input.syntax.SyntaxAnalyzerFacade;
import com.thoughtworks.testing.galaxybusiness.input.syntax.SyntaxType;
import com.thoughtworks.testing.galaxybusiness.log.Logger;

public class InputParser {
	
	private List<String> questions = new ArrayList<String>();
	private Map<String, SyntaxType> statements = new HashMap<String, SyntaxType>(); 
	private InputStore store = new InputStore();
	
	public InputStore parse(File file) throws FileNotFoundException, IOException, SyntaxIllegalException  {
		load(file);
		translateWordsIntoSymbols();
		calculateGoodsPrice();
		return store;
	}
	
	private void load(File file) throws FileNotFoundException, IOException, SyntaxIllegalException {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line = reader.readLine();
			Logger.log("  ");
			Logger.log("------------------- input data start -----------------------------");
			while(line!=null && !line.trim().equals("")){
				Logger.log(line);
				prePorcess(line.trim());
				line = reader.readLine();
			}
			Logger.log("------------------- input data end -------------------------------");
		}
	}
	
	private void prePorcess(String line) throws SyntaxIllegalException {
		SyntaxType type = SyntaxAnalyzerFacade.analyze(line);
		if(type == SyntaxType.UNKNOWN){
			throw new SyntaxIllegalException("Illegal input : "+line);
		}
		if(type == SyntaxType.QUESTION){
			questions.add(line);
		}
		statements.put(line, type);
	}
	
	/**
	 * Translate words into symbols and put result into InputStore
	 */
	private void translateWordsIntoSymbols(){
		statements.forEach((statement, syntax) -> {
			if(syntax==SyntaxType.WORD_SYMBOL_RELATION){
				String word = statement.replaceAll(Regex.WORD_SYMBOL_REGEX_PARTIAL, "");
				String symbol_name = statement.substring(statement.length()-1);
				Symbol symbol = Symbol.valueOf(symbol_name);
				store.AddWordSymbol(word.trim(), symbol);
			}
		});
	}
	
	private void calculateGoodsPrice(){
		statements.forEach((statement, syntax) -> {
			if(syntax==SyntaxType.GOODS_PRICING){
				
			}
		});
	}
	
}
