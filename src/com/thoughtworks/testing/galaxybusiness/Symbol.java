package com.thoughtworks.testing.galaxybusiness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Symbol {

	I(1),V(5),X(10),L(50),C(100),D(500),M(1000);
	
	private int value;
	
	private Symbol(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public static List<Symbol> orderedValues(boolean asc){
		int order = asc ? 1 : -1;
		List<Symbol> list = new ArrayList<Symbol>();
		Symbol[] symbol = values();
		for(Symbol sb : symbol){
			list.add(sb);
		}
		Collections.sort(list, (symbol1, symbol2) -> {
			return (symbol1.getValue()-symbol2.getValue())*order;
		});
		return list;
		
	}
}
