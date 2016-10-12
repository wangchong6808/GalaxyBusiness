package com.thoughtworks.testing.galaxybusiness;

import java.util.List;

public class Regex {

	public static final String WORD_SYMBOL_REGEX_PARTIAL;
	public static final String WORD_SYMBOL_REGEX_FULL;
	public static final String PRICING_REGEX_PARTIAL=" +is +[1-9][0-9]* +Credits$";
	public static final String PRICING_REGEX_FULL = ".*"+PRICING_REGEX_PARTIAL;
	
	static {
		List<Symbol> symbols = Symbol.orderedValues(true);
		StringBuffer sb = new StringBuffer(" +is +[");
		symbols.forEach((symb) -> sb.append(symb.name()));
		String regex = sb.append("]$").toString();
		WORD_SYMBOL_REGEX_PARTIAL = regex;
		WORD_SYMBOL_REGEX_FULL = ".*"+regex;
	}
	
}
