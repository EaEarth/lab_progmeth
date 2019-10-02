package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Store;
import logic.Menu;

class TestStore {
	private Store store;
	private Menu menu;
	
	@BeforeEach
	void setUp() throws Exception {
		store = new Store("ABC");
		menu = new Menu("Rice", 5);
	}
	
	@Test
	void testConstructor() {
		assertEquals("ABC", store.getName());
		assertEquals(0, store.getTotalSales());
		
	}
	
	@Test
	void testAddMenu() {
		assertEquals(0, store.getMenus().size());
		
		store.addMenu(menu);
		
		assertEquals(1, store.getMenus().size());
		assertTrue(store.getMenus().contains(menu));
	}
	
	@Test
	void testSell() {
		int oldBalance = store.getTotalSales();
		int recordsSize = store.getRecords().size();
			
		store.addMenu(menu);
		
		//general price
		store.sell(menu, false);
		assertEquals(oldBalance + menu.getPrice(), store.getTotalSales());
		assertEquals(recordsSize+1, store.getRecords().size());
		
		oldBalance = store.getTotalSales();
		recordsSize = store.getRecords().size();
		
		//special price
		store.sell(menu, true);
		assertEquals(oldBalance + menu.getSpecialPrice(), store.getTotalSales());
		assertEquals(recordsSize+1, store.getRecords().size());
		
	}
}
