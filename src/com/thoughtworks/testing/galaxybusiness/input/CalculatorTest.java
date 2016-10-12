package com.thoughtworks.testing.galaxybusiness.input;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.testing.galaxybusiness.Calculator;
import com.thoughtworks.testing.galaxybusiness.Symbol;
import com.thoughtworks.testing.galaxybusiness.exception.CalculateErrorException;

public class CalculatorTest {
	
	private InputStore store;

	@Before
	public void setUp() throws Exception {
		store = new InputStore();
		store.AddWordSymbol("glob", Symbol.I);
		store.AddWordSymbol("prok", Symbol.V);
		store.AddWordSymbol("pish", Symbol.X);
		store.AddWordSymbol("tegj", Symbol.L);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testCalculateByWords() throws CalculateErrorException {
		assertEquals(42f, Calculator.calculateByWords("pish tegj glob glob", store), 0.5f);
	}

	@Test
	public void testCalculateBySymbols() {
		assertEquals(1944f, Calculator.calculateBySymbols("MCMXLIV"),0.5f);
		assertEquals(2006f, Calculator.calculateBySymbols("MMVI"),0.5f);
		assertEquals(1903f, Calculator.calculateBySymbols("MCMIII"),0.5f);
	}

}
