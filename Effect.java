
public class Effect {

	private int hmod;
	private int attackmod;
	private int apmod;
	private int duration; //Default 30 seconds
	
	public Effect(int h, int attack, int ap, int d) {
		hmod = h;
		attackmod = attack;
		apmod = ap;
		duration = d;
	}
	
	public int getHMod() {
		return hmod;
	}
	
	public int getAttackMod() {
		return attackmod;
	}
	
	public int getAPMod() {
		return apmod;
	}
	
	public int getDuration() {
		return duration;
	}
}
