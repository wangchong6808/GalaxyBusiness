package com.thoughtworks.testing.galaxybusiness.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.testing.galaxybusiness.Symbol;
import com.thoughtworks.testing.galaxybusiness.exception.GoodsNotFoundException;
import com.thoughtworks.testing.galaxybusiness.exception.SymbolNotFoundException;

public class InputStore {

	private Map<String, Symbol> word_symbol_map = new HashMap<String, Symbol>();
	private Map<String, Float> goods_price_map = new HashMap<String, Float>();
	private Map<String, String> questions_map = new HashMap<String, String>();
	private List<String> questions = new ArrayList<String>();
	
	public Symbol getSymbol(String word) throws IllegalArgumentException, SymbolNotFoundException {
		if(word==null || word.trim().equals("")){
			throw new IllegalArgumentException("The input parameter 'word' is null or empty value!");
		}
		if(word_symbol_map!=null && word_symbol_map.containsKey(word)){
			return word_symbol_map.get(word);
		}
		throw new SymbolNotFoundException("There is no symbol found matching with word: "+word);
	}
	
	public float getPrice(String goodsName) throws IllegalArgumentException, GoodsNotFoundException{
		if(goodsName==null || goodsName.trim().equals("")){
			throw new IllegalArgumentException("goods name is null or empty value!");
		}
		if(goods_price_map!=null && goods_price_map.containsKey(goodsName)){
			return goods_price_map.get(goodsName).floatValue();
		}
		throw new GoodsNotFoundException("There is no goods found with goods name: "+goodsName);
	}
	
	public List<String> getAllWords(){
		List<String> words = new ArrayList<String>();
		words.addAll(word_symbol_map.keySet());
		return words;
	}
	
	public List<String> getAllQuestions(){
		List<String> list = new ArrayList<String>();
		list.addAll(questions_map.keySet());
		return list;
	}
	
	protected void AddWordSymbol(String word, Symbol symbol){
		word_symbol_map.put(word, symbol);
	}
	
	protected void AddGoodsPrice(String goodsName, float price){
		goods_price_map.put(goodsName, Float.valueOf(price));
	}
	
	protected void AddQuestions(String origQuestion, String formattedQuestion){
		questions_map.put(origQuestion, formattedQuestion);
	}

	protected void setQuestions(List<String> questions) {
		this.questions.clear();
		this.questions.addAll(questions);
	}
	
}
