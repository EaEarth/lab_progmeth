package logic;

public class Hero {
	protected String name;
	protected int power;
	protected int hp;
	
	public Hero(String name , int power , int hp) {
		this.name = name;
		if( power < 0) {
			this.power = 0;
		}else {
			this.power = power;
		}
		if( hp<1 ) {
			this.hp = 1 ;
		}else {
			this.hp = hp;
		}
	}
	
	public int takeDamage(int damage) {
		if(damage <=0 ) {
			return 0;
		}else {
			if(damage >= hp) {
				hp = 0;
				return damage;
			}else {
				hp -= damage;
				return damage;
			}
		}
	}
	
	public int doDamage(Hero target) {
		return target.takeDamage(power);
	}
	
	public boolean isDefeated() {
		if (hp == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public String printStat() {
		return  "[atk:"+power+" hp:"+hp+"]";
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getHp() {
		return hp;
	}
	
}
