package Boat_Race;

public class Player {
	//attribute
	private String name;  //Store player name 
	private int turn;  //Store player score
		
	//constructor
	public Player(String name) { 
		this.name = name;  //initialize player with a name & set score to 0
		this.turn = 0;
			
		}
		
	//setter getter
	public String getName() {
		return name;  
	}
		
	public int getTurn() {
		return turn;
	}
		
		
	//other methods
	public void incrementTurn () {
		turn++;    //Increase the score 
	}	

}
