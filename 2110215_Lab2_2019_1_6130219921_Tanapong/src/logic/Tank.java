package logic;


public class Tank extends Hero {
	private int armor;
	
	public Tank(String name, int power, int hp, int armor) {
		super(name,power,hp);
		if(armor<1) {
			this.armor = 1;
		}else {
			this.armor = armor;
		}
	}
	
	public int takeDamage(int damage) {
		if(damage < armor) {
			damage = 0;
		}else {
			damage -= armor;
		}
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
	
	public int takePiercingDamage(int damage) {
		return super.takeDamage(damage);
	}
	
	public String printStat() {
		return  "[atk:"+power+" hp:"+hp+" armor:"+armor+"]";
	}

	public int getArmor() {
		return armor;
	}

}
