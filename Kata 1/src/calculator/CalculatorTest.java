package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		// fail("Not yet implemented");
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testForSingleNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testForTwoNumberReturnSum() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}

	@Test
	public void testNewLineCharacter() {
		assertEquals(6, Calculator.add("1,2\n3"));
	}

	@Test
	public void testAnyDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testRegexExpression() {

		assertEquals(3, Calculator.add("//.\n1.2"));
	}

	@Test()
	public void testRaiseExceptionOnNegativeNumber() {

		try {
			Calculator.add("-1,-2,-3");

		} catch (Exception e) {

			assertEquals("Negatives not allowed:-1", e.getMessage());
			System.out.println(e.getMessage());

		}

	}
	
//	@Test
//	public void testAddMethodEvokesCounter() {
//		assertEquals(8, Calculator.counter);
//	}
	
	@Test
	public void testNumbergreterThan1000Ignore() {
		assertEquals(1,Calculator.add("1,1001"));
	}

}
