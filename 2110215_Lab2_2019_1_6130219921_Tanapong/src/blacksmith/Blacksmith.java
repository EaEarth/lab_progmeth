package blacksmith;
import logic.Hero;

public class Blacksmith extends Hero{
	private Sword sword;
	private int skillLevel;
	
	public Blacksmith() {
		super("DefaultBlacksmith",1,1);
		this.skillLevel = 1;
		sword = new Sword(1,1);
	}
	
	public Blacksmith(String name, int hp, int skillLevel) {
		super(name,1,hp);
		this.skillLevel = skillLevel;
		sword = new Sword(1,1);
	}
	
	public int doDamage(Hero target) {
		int tempt ;
		tempt = target.takeDamage(sword.getAttack());
		upgradeSword();
		return tempt;
	}
	
	public void upgradeSword() {
		sword.upgrade(skillLevel);
	}
	
	public String printStat() {
		return "[hp: "+this.getHp()+" lvl:"+skillLevel+"]";
	}
}
