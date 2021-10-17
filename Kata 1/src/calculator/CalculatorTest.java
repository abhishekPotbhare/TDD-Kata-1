package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() throws Exception {
		// fail("Not yet implemented");
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testForSingleNumber() throws Exception {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testForTwoNumberReturnSum() throws Exception {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers() throws Exception {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}

	@Test
	public void testNewLineCharacter() throws Exception {
		assertEquals(6, Calculator.add("1,2\n3"));
	}

	@Test
	public void testAnyDelimiter() throws Exception {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testRegexExpression() throws Exception {

		assertEquals(3, Calculator.add("//.\n1.2"));
	}

	@Test
	public void testRaiseExceptionOnNegativeNumber() {

		try {
			Calculator.add("-1,-2,-3");

		} catch (Exception e) {

			assertEquals("Negatives not allowed:-1", e.getMessage());
			System.out.println(e.getMessage());

		}

	}
	
	@Test
	public void testAddMethodEvokesCounter() {
		assertEquals(9, Calculator.counter);
	}
	
	@Test
	public void testNumbergreterThan1000Ignore() throws Exception {
		assertEquals(1,Calculator.add("1,1001"));
	}
	


}
