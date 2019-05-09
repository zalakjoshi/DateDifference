import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ioof.datediff.DateDifference;

public class DateDifferenceTest {

	// Success Case
	@Test
	public void successCase_validDate_Test() {
		DateDifference diff = new DateDifference();
		String output = diff.showTotalDays("01 01 2001", "10 01 2001");
		assertEquals("01 01 2001,    10 01 2001,  9 Days", output);
	}

	// Success Case
	@Test
	public void successCase_leapYrDate_Test() {
		DateDifference diff = new DateDifference();
		String output = diff.showTotalDays("29 02 2008", "08 08 2008");
		assertEquals("29 02 2008,    08 08 2008,  161 Days", output);
	}

	// Error case contain Letters
	@Test
	public void errorCase_containsLetter_Test() {
		DateDifference diff = new DateDifference();
		String output = diff.showTotalDays("ZZ 12 1990", "10 10 1990");
		assertEquals("Invalid Date", output);
	}

	// Error case invalid format
	@Test
	public void errorCase_invalidFormat_Test() {
		DateDifference diff = new DateDifference();
		String output = diff.showTotalDays("20:10:2000", "10 10 2001");
		assertEquals("Invalid Date", output);
	}

	// Error case date before 01 01 1900
	@Test
	public void errorCase_beforeDate_Test() {
		DateDifference diff = new DateDifference();
		String output = diff.showTotalDays("01 01 1800", "10 10 2001");
		assertEquals("Invalid Date", output);
	}

	// Error case date after 31 12 2010
	@Test
	public void errorCase_laterDate_Test() {
		DateDifference diff = new DateDifference();
		String output = diff.showTotalDays("20 10 2000", "10 10 2011");
		assertEquals("Invalid Date", output);
	}

	// Error case date after 31 12 2010
	@Test
	public void errorCase_invalidDate_Test() {
		DateDifference diff = new DateDifference();
		String output = diff.showTotalDays("33 01 2001", "10 10 2001");
		assertEquals("Invalid Date", output);
	}
}
