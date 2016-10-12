package test.com.thoughtworks.testing.galaxybusiness;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.thoughtworks.testing.galaxybusiness.input.CalculatorTest;

import test.com.thoughtworks.testing.galaxybusiness.input.syntax.SyntaxAnalyzerFacadeTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	SymbolsTest.class,
	SyntaxAnalyzerFacadeTest.class,
	CalculatorTest.class})
public class AllTests {

	@BeforeClass 
    public static void setUpClass() {
        System.out.println("TestSuite start.");
    }

    @AfterClass public static void tearDownClass() { 
        System.out.println("Test end.");
    }
}
