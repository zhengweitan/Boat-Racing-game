package Boat_Race;

public class Boat {
	private int position;    //store boat position
	private int boundary;     //store boundary of the river 
	
	public Boat(int boundary) {
		this.position = 1;
		this.boundary = boundary;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void move(int steps) {
		position += steps;   //position = position + steps
		if (position <1) {    //if position is less than 0, it will = to 0
			position =1;
		}
		else if (position >= boundary) {  //if position is more than 100, it will equal to 100
			position = boundary;
		}
		
	}
	
	
	@Override
	public String toString() {
		return String.format("Boat position: ", position);
	}

}
