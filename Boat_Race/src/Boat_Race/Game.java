package Boat_Race;

import java.util.*;
import java.io.*;

public class Game {
	private Player[]players;    //Array to store player
	private Boat[]boats;    //Array to store boat
	private River river;    
	private Random random;   //generate random number 
	private Score score;

	
	public Game() {
		players = new Player[2];  //2 elements in this array --> 2
		boats = new Boat[2];   //2 boats 
		random = new Random();


		initializeRiver();   //Call method to initialize the river below 
		score = new Score();
	}
	
	
	// Set river
	private void initializeRiver() {
		river = new River(100);  
		
		Set<Integer> duplicatedIndexes = new HashSet<>();
	
		//Add trap
		for(int i=0; i <10; i++) {    //Add 10 trap
			int index = random.nextInt(100);
			duplicatedIndexes.add(index);
			int strength = random.nextInt(10) + 1; 
			river.addTrap(index, strength);
		}
		
		//Add current
		for (int i=0; i<10; i++) {   //Add 10 current 
			int index;
			do{
				index = random.nextInt(100);
			} while (duplicatedIndexes.contains(index));   //Give a new index if already used
			 int strength = random.nextInt(10) + 1; 
			river.addCurrent(index, strength);
		}
		
	}
	
	//Create a dice 
	private int Dice() {
		return random.nextInt(6) + 1;
	}
	
	
	
	//Enter player name and store them 
	public void play() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter player 1 name: ");
		String name1 = input.next();
		players[0] = new Player(name1);
		
		System.out.print("Enter player 2 name: ");
		String name2 = input.next();
		players[1] = new Player(name2);
		
		boats[0]= new Boat(99);
		boats[1] = new Boat(99);
		
		input.nextLine();   //press enter
		
		int currentPlayerIndex = 0;
		
		//Display the river 
		System.out.println("\nRIVER DISPLAY: ");
		river.displayRiver();
		System.out.println("\n--GAME STARTS--");
		
		
		
		//Game 
		while(true) {
			Player currentPlayer = players[currentPlayerIndex];
			Boat currentBoat = boats[currentPlayerIndex];
			
			
			System.out.println(currentPlayer.getName() + "'s turns.\nPress enter to roll the dice");
			input.nextLine();
			

			int currentPosition = currentBoat.getPosition();
			Tile tile = river.getTile(currentPosition);

			
			currentPlayer.incrementTurn();	 
			
			
			int steps = Dice();
			System.out.println("Player: " + currentPlayer.getName());
			System.out.println("Rolled: " + steps);
			currentBoat.move(steps);
			
			
		    //Hitting traps or Current 
			if (tile instanceof Traps) { // Check if trap object is present
				Traps trap = (Traps) tile;
		        System.out.println("##Opps, " + currentPlayer.getName() + " hits a trap.\nMove backwards " + trap.getStrength() + " steps");
		        currentBoat.move(-trap.getStrength());
		    } else if (tile instanceof Current) { // Check if current object is present
		    	Current current = (Current) tile;
		        System.out.println("Yay! " + currentPlayer.getName() + " mets a current.\nMove forward " + current.getStrength() + "steps");
		        currentBoat.move(current.getStrength());
		    }
			
			System.out.println("Position: " + currentBoat.getPosition());
			System.out.println("Total turns: " + currentPlayer.getTurn() + "\n");
			
			
			/*While player's boat have exceeded 100th position, the palyer will be the winner.
			 *Player's turn will be store in the text file if his/her turn is lesser than players
			 *in top 5 list.
			 */ 
			if (currentPosition >= 99) {
				System.out.println(currentPlayer.getName() + " arrive at the Goal!" );
				System.out.println(currentPlayer.getName() + " is the Winner!\nGAME OVER 😁" );
				
				score.updateScores(currentPlayer.getTurn(),currentPlayer.getName());
				score.displayScores();
				break;
			}
			
			currentPlayerIndex = (currentPlayerIndex + 1) % 2;
			
		}

		input.close();

	}
	

}
