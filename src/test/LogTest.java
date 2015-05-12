package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Log;

public class LogTest {
	Log log = new Log(50, "TestBericht", "TestType", true);
	Log log2 = new Log(50, "TestBericht", "TestType", false);
	
	@Test
	public void testToString() {
		assertEquals("45+5: TestBericht\n", log.toString());
		assertEquals("50: TestBericht\n", log2.toString());
	}
	
	@Test
	public void testgetMinuutTrue() {
		assertTrue(log.getMinuut() == 50);
	}
	
	@Test
	public void testgetMinuutFalse() {
		assertFalse(log.getMinuut() == 40);
	}
	
	@Test
	public void testgetBerichtTrue() {
		assertTrue(log.getBericht().equals("TestBericht"));
	}
	
	@Test
	public void testgetBerichtFalse() {
		assertFalse(log.getBericht().equals("TestBericht2"));
	}
	
	@Test
	public void testgetTypeTrue() {
		assertTrue(log.getType().equals("TestType"));
	}

	@Test
	public void testgetTypeFalse() {
		assertFalse(log.getType().equals("TestType2"));
	}
}
