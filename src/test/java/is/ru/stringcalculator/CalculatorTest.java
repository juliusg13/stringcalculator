package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
	public void testMultipleNumbers(){
	    	assertEquals(6, Calculator.add("1,2,3"));
	}
	
	@Test
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testNewDel2() {
		assertEquals(3, Calculator.add("//;1;2"));
	}
	@Test
	public void testNewDel() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	@Test
	public void testNegative() {
		try{
			Calculator.add("-1,2");
		}
		catch(RuntimeException ex) {
			assertEquals("Negatives are not allowed: -1", ex.getMessage());
		}
	}

	@Test
	public void testNegative2() {
		try{
			Calculator.add("2,-4,3,-5");
		}
		catch(RuntimeException ex) {
			assertEquals("Negatives are not allowed: -4,-5", ex.getMessage());
		}
	}
	@Test 
	public void testover1000() {
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testForAnySizeDelim() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	@Test
	public void testForMultipeDelim() {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}
	@Test
	public void testForMultipleAnySizeDelim() {
		assertEquals(6, Calculator.add("//[**][%%%%]\n1**2%%%%3"));
	}
	@Test
	public void testforMultipleAnySizeDelim() {
		assertEquals(10, Calculator.add("//[#$%][###][&&&][%]\n1#$%1###2&&&3%3"));
	}

}
