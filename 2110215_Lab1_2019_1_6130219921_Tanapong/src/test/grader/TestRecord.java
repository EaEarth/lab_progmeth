package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Record;

class TestRecord {

	private Record t;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new Record("TestMenu", 10);
	}
	
	@Test
	void testConstructor() {
		t = new Record("Kimchi", 25);
		assertEquals("Kimchi", t.getFoodName());
		assertEquals(25, t.getSoldPrice());
	}
	
	@Test
	void testToString() {
		assertEquals("Menu : TestMenu sold in 10 THB" , t.toString());
	}

}
