package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.*;

class BattleTest {

	@Test
	void testBattle() {
		
		Tank human = new Tank("John Connor", 3, 10, 5);
		Robot terminator = new Robot("T800");
		Battle battle = new Battle(human, terminator);
		
		battle.doBattleStep();
		assertEquals(8, human.getHp());
		assertEquals(7, terminator.getHp());
		assertFalse(battle.isEnd());

		battle.doBattleStep();
		assertEquals(6, human.getHp());
		assertEquals(4, terminator.getHp());
		assertFalse(battle.isEnd());
		
		battle.doBattleStep();
		assertEquals(4, human.getHp());
		assertEquals(1, terminator.getHp());
		assertFalse(battle.isEnd());
		
		battle.doBattleStep();
		assertEquals(2, human.getHp());
		assertEquals(0, terminator.getHp());
		assertTrue(battle.isEnd());
		
	}

}
