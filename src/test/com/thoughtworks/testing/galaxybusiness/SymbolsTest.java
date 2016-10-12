package test.com.thoughtworks.testing.galaxybusiness;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.testing.galaxybusiness.Symbol;

public class SymbolsTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("SymbolsTest start");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("I", Symbol.I.toString());
		assertEquals(1000, Symbol.M.getValue());
	}

}
