package logic;

public class Battle {
	private Hero[] fighter = new Hero[2];
	
	public Battle(Hero a,Hero b) {
		fighter[0] = a;
		fighter[1] = b;
	}
	
	public void start() {
		System.out.println("==== Here Come A New Challenger ====");
		// TODO Show opening phrase -> Show challengers -> Repeat doBattleStep() -> Show result
		System.out.println("== " +fighter[0].name+fighter[0].printStat() + " VS " + fighter[1].name+fighter[1].printStat() + " ==\n");
		while(!isEnd()) {
			doBattleStep();
		}
		showResult();
	}

	public void doBattleStep() {
		// TODO FILL ME
		// First fighter Attack
		System.out.println(fighter[0].name + " do " + fighter[0].doDamage(fighter[1]) + " damage to " + fighter[1].name);
		System.out.println(fighter[1].name + " has " + fighter[1].hp + " HP left\n");
		// Second fighter Attack
		System.out.println(fighter[1].name + " do " + fighter[1].doDamage(fighter[0]) + " damage to " +fighter[0].name);
		System.out.println(fighter[0].name + " has " + fighter[0].hp + " HP left\n");
		if(fighter[0].isDefeated()) {
			System.out.println(fighter[0].name + " is knocked out\n");
		}
		if(fighter[1].isDefeated()) {
			System.out.println(fighter[1].name + " is knocked out\n");
		}
	}
	
	public boolean isEnd() {
		if(fighter[0].isDefeated() || fighter[1].isDefeated()) {
			return true;
		}else {
			return false;
		}
	}
	// TODO Fill me
	public void showResult() {
		if(fighter[0].isDefeated() && fighter[1].isDefeated()) {
			System.out.println("== DRAW ==");
		}
		else if(fighter[0].isDefeated()) {
			System.out.println("== " + fighter[1].name + " WIN ==");
		}
		else if(fighter[1].isDefeated()) {
			System.out.println("== " + fighter[0].name + " WIN ==");
		}
	}
}
