package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Tank;

class TankTest {

	@Test
	void testTakeDamage() {
		
		Tank hammer = new Tank("HammerTank", 50, 100, 10);
		
		// Normal case
		assertEquals(20, hammer.takeDamage(30));
		assertEquals(80, hammer.getHp());
		
		// Negative case
		assertEquals(0, hammer.takeDamage(-30));
		assertEquals(80, hammer.getHp());
		
		// Overkill case
		assertEquals(9000, hammer.takeDamage(9010));
		assertEquals(0, hammer.getHp());
		
	}

	@Test
	void testPrintStat() {
		
		Tank siege = new Tank("SiegeTank", 50, 100, 10);
		assertEquals("[atk:50 hp:100 armor:10]",siege.printStat());
		
	}

	@Test
	void testTank() {

		// Normal Case
		Tank rhino = new Tank("RhinoTank", 50, 100, 5);
		assertEquals("RhinoTank", rhino.getName());
		assertEquals(50, rhino.getPower());
		assertEquals(100, rhino.getHp());
		assertEquals(5, rhino.getArmor());

		// Negative case
		Tank grizzly = new Tank("GrizzlyTank", -50, -100, -5);
		assertEquals("GrizzlyTank", grizzly.getName());
		assertEquals(0, grizzly.getPower());
		assertEquals(1, grizzly.getHp());
		assertEquals(1, grizzly.getArmor());

	}

	@Test
	void testTakePiercingDamage() {
		
		Tank tsunami = new Tank("TsunamiTank", 50, 100, 10);
		
		// Normal case
		assertEquals(40, tsunami.takePiercingDamage(40));
		assertEquals(60, tsunami.getHp());
		
		// Negative case
		assertEquals(0, tsunami.takePiercingDamage(-40));
		assertEquals(60, tsunami.getHp());
		
		// Overkill case
		assertEquals(70, tsunami.takePiercingDamage(70));
		assertEquals(0, tsunami.getHp());
	}

}
