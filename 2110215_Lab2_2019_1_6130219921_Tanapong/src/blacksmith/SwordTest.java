package blacksmith;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SwordTest {
	Sword normal,negative,zero;
	// TODO Create Sword for each test case for more convenient
	@BeforeEach
	void setUp() throws Exception {
		normal = new Sword(50,5);
		negative = new Sword(-10,-5);
		zero = new Sword(0,0);
	}

	// TODO Test Sword constructor
	@Test
	void testSword() {
		assertEquals(50, normal.getAttack());
		assertEquals(5, normal.getDurability());
		assertEquals(1, zero.getAttack());
		assertEquals(1, zero.getDurability());
	}

	// TODO Test Sword constructor with negative attack
	@Test
	void testSwordNegativeAttack() {
		assertEquals(1, negative.getAttack());
	}

	// TODO Test Sword constructor with negative durability
	@Test
	void testSwordNegativeDurability() {
		assertEquals(1, negative.getDurability());
	}

	// TODO Test upgrade()
	@Test
	void testUpgrade() {
		normal.upgrade(50);
		negative.upgrade(0);
		assertEquals(100,normal.getAttack());
		assertEquals(6,normal.getDurability());
		assertEquals(1,negative.getAttack());
		assertEquals(2,negative.getDurability());
	}

	// TODO Test upgrade() with negative value
	@Test
	void testUpgradeNegative() {
		normal.upgrade(-5);
		negative.upgrade(-1);
		assertEquals(50,normal.getAttack());
		assertEquals(6,normal.getDurability());
		assertEquals(1,negative.getAttack());
		assertEquals(2,negative.getDurability());
	}

	// TODO Test doParry()
	@Test
	void testDoParry() {
		assertEquals(34,normal.doParry(84));
		assertEquals(4,normal.getDurability());
		assertEquals(50,normal.getAttack());
		assertEquals(83,negative.doParry(84));
		assertEquals(0,negative.getDurability());
		assertEquals(1,negative.getAttack());
		assertEquals(51,negative.doParry(51));
	}

	// TODO Test doParry() with non positive attack
	@Test
	void testDoParryNonPositiveAttack() {
		assertEquals(0,normal.doParry(-5));
		assertEquals(4,normal.getDurability());
		assertEquals(50,normal.getAttack());
		assertEquals(0,negative.doParry(0));
		assertEquals(0,negative.getDurability());
		assertEquals(1,negative.getAttack());
	}

	// TODO Test doParry() with attack <= Sword's attack ( fully parried )
	@Test
	void testDoParryFullyParried() {
		assertEquals(0,normal.doParry(49));
		assertEquals(4,normal.getDurability());
		assertEquals(50,normal.getAttack());
	}

	// TODO Test isBroken()
	@Test
	void testIsBroken() {
		negative.doParry(0);
		assertTrue(negative.isBroken());
		assertFalse(normal.isBroken());
		negative.doParry(0);
		assertTrue(negative.isBroken());
	}

}
