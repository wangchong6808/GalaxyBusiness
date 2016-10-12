package com.thoughtworks.testing.galaxybusiness;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thoughtworks.testing.galaxybusiness.exception.SymbolNotFoundException;
import com.thoughtworks.testing.galaxybusiness.exception.SyntaxIllegalException;
import com.thoughtworks.testing.galaxybusiness.input.InputParser;
import com.thoughtworks.testing.galaxybusiness.input.InputStore;

public class IntelligentCalculator {

	public static void main(String[] args) throws Exception {
		
		test3();
	}
	public static void test3(){
		Pattern p = Pattern.compile(".* +is +[1-9][0-9]* +Credits$");
		String glob = "glob glob Silver is 12342    Credits";
		Matcher m = p.matcher(glob);
		System.out.println(m.matches());
		System.out.println(glob.replaceAll(" +is +[1-9][0-9]* +Credits$", ""));
	}
	public static void test2() throws FileNotFoundException, IOException, SyntaxIllegalException{
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
	}
	
	public static void test1(){
		Exception e = new SymbolNotFoundException("aaa");
		System.out.println(e.getMessage());
		e = new IllegalArgumentException("vvv");
		System.out.println(e.getMessage());
		String[] ss = "aa vv cc  dd".split(" +?");
		System.out.println(ss.length);
		for(String s : ss){
			System.out.println(s);
		}
		Pattern p = Pattern.compile(" +is +[XYZ]$");
		Matcher m = p.matcher("pish is   Y");
		
		boolean b = m.matches();
		System.out.println(b);
		String string = "pish is   Y";
		String regex = " +is +[XYZ]$";
		System.out.println(string.matches(regex));
		String s = string.replaceAll(regex, "");
		System.out.println(s);
		
		p = Pattern.compile(".* +is +  Credits$");
		Symbol[] syb = Symbol.values();
		Arrays.sort(syb);
		for(Symbol sb : Symbol.values()){
			System.out.println(sb.toString()+sb.getValue());
		}
		List<Symbol> symbols = Symbol.orderedValues(true);
		StringBuffer sb = new StringBuffer();
		symbols.forEach((symb) -> sb.append(symb.name()));
		System.out.println(sb);
	}

}
