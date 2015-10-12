

public class Armor extends Loot {

	private int ap;
	
	public Armor(String name, int ap) {
		super(name);
		setAP(ap);
	}
	
	public String checkType() {
		return "Armor";
	}

	public int getAP() {
		return ap;
	}

	public void setAP(int ap) {
		this.ap = ap;
	}
	
	
}
