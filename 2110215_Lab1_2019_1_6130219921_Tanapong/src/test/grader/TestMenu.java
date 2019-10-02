package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Menu;

class TestMenu {

	private Menu m;

	@Test
	void testConstructor() {
		m = new Menu("testName", 100);
		assertEquals("testName", m.getName());
		assertEquals(100, m.getPrice());
		assertEquals(110, m.getSpecialPrice());

	}
	
	@Test 
	void testToString(){
		m = new Menu("testName", 100);
		assertEquals("testName Price : 100 (special 110)", m.toString());
	}
	
	@Test
	void testSetPrice() {
		m = new Menu("testName", 100);
		assertEquals(100, m.getPrice());
		m.setPrice(150);
		assertEquals(150, m.getPrice());
	}
	//Add more test e.g. setPrice()
}
