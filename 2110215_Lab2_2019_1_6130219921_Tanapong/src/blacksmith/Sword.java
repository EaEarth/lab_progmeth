package blacksmith;

public class Sword {

	private int attack;
	private int durability;
	
	public Sword(int attack, int durability) {
		this.attack = attack < 1 ? 1 : attack;
		this.durability = durability < 1 ? 1 : durability;
	}
	
	public void upgrade(int val) {
		if(val < 0) {
			val = 0;
		}
		this.attack += val;
		this.durability++;
	}
	
	public int doParry(int attack) {
		if(isBroken()) {
			return attack;
		}
		attack = attack < 1 ? 1 : attack;
		this.durability--;
		int damage = attack -= this.attack;
		if(damage<0) {
			damage = 0;
		}
		return damage;
	}
	
	public boolean isBroken() {
		return this.durability <= 0;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDurability() {
		return durability;
	}
}
