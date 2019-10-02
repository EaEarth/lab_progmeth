package logic;

public class Robot extends Hero {

	public Robot(String name) {
		super(name, 2, 10);
	}
	
	public int doDamage(Hero target) {
		if(target instanceof Tank) {
			return ((Tank) target).takePiercingDamage(power);
		}else {
			return target.takeDamage(power);
		}
	}
}
