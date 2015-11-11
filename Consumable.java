public class Consumable extends Loot {

	private Effect effect;
	
	public Consumable(String n, Effect e) {
		super(n);
		effect = e;
	}

	public Effect getEffect() {
		return effect;
	}
	
	public String checkType() {
		return "Consumable";
	}
	
}
