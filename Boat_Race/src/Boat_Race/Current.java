package Boat_Race;

public class Current extends Tile{
	private int strength;

	
	public Current(char symbol,int strength) {
		super(symbol);
		this.strength = strength;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
}
