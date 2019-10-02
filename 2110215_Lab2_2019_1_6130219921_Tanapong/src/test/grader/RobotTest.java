package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.*;

class RobotTest {
	
	@Test
	void testDoDamage() {
		
		Robot t800 = new Robot("T-800");
		
		// Target normal Hero
		Hero dummyHero = new Hero("Dummy",2,10);
		assertEquals(2, t800.doDamage(dummyHero));		
		assertEquals(8, dummyHero.getHp());
		
		//Target Tank
		Tank dummyTank = new Tank("Dummy",2,10,3);
		assertEquals(2, t800.doDamage(dummyTank));		
		assertEquals(8, dummyTank.getHp());
		
	}

	@Test
	void testRobot() {

		Robot robocop = new Robot("Robocop");
		
		assertEquals("Robocop", robocop.getName());
		assertEquals(2, robocop.getPower());
		assertEquals(10, robocop.getHp());
		
	}

}
