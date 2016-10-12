package test.com.thoughtworks.testing.galaxybusiness.input.syntax;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.testing.galaxybusiness.input.syntax.SyntaxAnalyzerFacade;
import com.thoughtworks.testing.galaxybusiness.input.syntax.SyntaxType;

public class SyntaxAnalyzerFacadeTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("SyntaxMathcerFacade start");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testanalyze() {
		
		assertEquals(SyntaxType.WORD_SYMBOL_RELATION, SyntaxAnalyzerFacade.analyze("glob is I"));
		assertEquals(SyntaxType.WORD_SYMBOL_RELATION, SyntaxAnalyzerFacade.analyze("XYI is I"));
		assertEquals(SyntaxType.UNKNOWN, SyntaxAnalyzerFacade.analyze("XYI is I "));
		assertEquals(SyntaxType.UNKNOWN, SyntaxAnalyzerFacade.analyze("X1 YI is I "));
		
		assertEquals(SyntaxType.GOODS_PRICING, SyntaxAnalyzerFacade.analyze("glob glob Silver is 34 Credits"));
		assertEquals(SyntaxType.GOODS_PRICING, SyntaxAnalyzerFacade.analyze("glob glob Gold Silver is  34 Credits"));
		assertEquals(SyntaxType.UNKNOWN, SyntaxAnalyzerFacade.analyze("glob glob Gold Silver is  34 Points"));
		assertEquals(SyntaxType.UNKNOWN, SyntaxAnalyzerFacade.analyze(" is  34 Points"));
		
		assertEquals(SyntaxType.QUESTION, SyntaxAnalyzerFacade.analyze("glob glob Silver is 34 Credits?"));
		assertEquals(SyntaxType.QUESTION, SyntaxAnalyzerFacade.analyze("glob glob Gold Silver is  34 Credits?"));
		assertEquals(SyntaxType.UNKNOWN, SyntaxAnalyzerFacade.analyze("glob glob Gold Silver is  34 Points"));
		assertEquals(SyntaxType.UNKNOWN, SyntaxAnalyzerFacade.analyze(" is  34 Points"));
	}

}
