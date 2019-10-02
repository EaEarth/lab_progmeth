package test.grader;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Hero;

class HeroTest {

	@Test
	void testHero() {

		// Normal Case
		Hero hero = new Hero("OneFiveHero", 1, 5);
		assertEquals("OneFiveHero", hero.getName());
		assertEquals(1, hero.getPower());
		assertEquals(5, hero.getHp());

		// Inappropriate parameter value
		hero = new Hero("NegativeHero", -2, 0);
		assertEquals(0, hero.getPower());
		assertEquals(1, hero.getHp());

	}

	@Test
	void testTakeDamage() {

		Hero hero = new Hero("OneFiveHero", 1, 5);

		// Normal case
		assertEquals(2, hero.takeDamage(2));
		assertEquals(3, hero.getHp());

		// Negative damage
		assertEquals(0, hero.takeDamage(-2));
		assertEquals(3, hero.getHp());

		// Overkill
		assertEquals(5, hero.takeDamage(5));
		assertEquals(0, hero.getHp());
		
	}

	@Test
	void testDoDamage() {
		
		Hero target = new Hero("Target", 1, 5);
		Hero attacker = new Hero("Attacker", 3, 5);
		
		// Normal case
		assertEquals(3, attacker.doDamage(target));
		assertEquals(2, target.getHp());

		// Overkill
		assertEquals(3, attacker.doDamage(target));
		assertEquals(0, target.getHp());
		
	}

	@Test
	void testIsDefeated() {
		
		Hero dummy = new Hero("Dummy", 1, 3);
		
		// Normal case
		assertFalse(dummy.isDefeated());
		dummy.takeDamage(2);		
		assertFalse(dummy.isDefeated());
		dummy.takeDamage(2);		
		assertTrue(dummy.isDefeated());

	}

	@Test
	void testPrintStat() {
		Hero dummy = new Hero("Dummy", 20, 35);
		assertEquals("[atk:20 hp:35]", dummy.printStat());
	}

}
