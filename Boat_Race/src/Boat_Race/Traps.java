package Boat_Race;

public class Traps extends Tile{
	private int strength;
	

	public Traps(char symbol,int strength) {
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