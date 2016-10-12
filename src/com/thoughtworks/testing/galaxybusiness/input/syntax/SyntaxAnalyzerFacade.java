package com.thoughtworks.testing.galaxybusiness.input.syntax;

import com.thoughtworks.testing.galaxybusiness.Regex;

public class SyntaxAnalyzerFacade {

	private static final ISyntaxAnalyzer WORD_SYMBOL_MATCHER = (s) ->{
		if(s != null && s.matches(Regex.WORD_SYMBOL_REGEX_FULL)){
			String word = s.replaceAll(Regex.WORD_SYMBOL_REGEX_PARTIAL, "");
			if(word.length()>0 && word.indexOf(" ")==-1){
				return true;
			}
		}
		return false;
	};
	
	private static final ISyntaxAnalyzer GOODS_PRICE_MATCHER = (s) ->{
		if(s != null && s.matches(Regex.PRICING_REGEX_FULL)){
			String goods_price = s.replaceAll(Regex.PRICING_REGEX_PARTIAL, "");
			if(goods_price.length()>0 && goods_price.indexOf(" ")==-1){
				return true;
			}
		}
		return false;
	};
	
	private static final ISyntaxAnalyzer QUESTION_MATCHER = (s) ->{
		if(s.endsWith("?")){
			return true;
		}
		return false;
	};
	
	public static SyntaxType analyze(String s){
		SyntaxType type = SyntaxType.UNKNOWN;
		if(WORD_SYMBOL_MATCHER.analyze(s)){
			type = SyntaxType.WORD_SYMBOL_RELATION;
		} else if(GOODS_PRICE_MATCHER.analyze(s)){
			type = SyntaxType.GOODS_PRICING;
		} else if(QUESTION_MATCHER.analyze(s)){
			type = SyntaxType.QUESTION;
		}
		return type;
	}
	
	
	
}
