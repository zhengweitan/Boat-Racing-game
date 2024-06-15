package Boat_Race;

public class River {
	private Tile[] track;
	
	public River(int length) {   //Give river the length 
		track = new Tile[length];   
		
		for(int i = 0; i <length; i++) {
			track[i] = new Tile('_');
		}
	}
	
	public void addTrap(int index, int strength) {   //Add trap
		track[index] = new Traps('#',strength);
	}
	
	public void addCurrent(int index, int strength) {  //Add current 
		track[index] = new Current('C',strength);
		
	}
	
	
	public Tile getTile(int index) {  //Method to get the tiles at specific index
		return track[index];
	}
	
	public void displayRiver() {
		 for (Tile tile : track) {
		        if (tile instanceof Current) {
		        	Current current = (Current) tile;
		            System.out.print( "C" + current.getStrength() + " ");
		        } else if (tile instanceof Traps) {
		        	Traps trap = (Traps) tile;
		            System.out.print("#" + trap.getStrength() + " ");
		        } else {
		            System.out.print(tile.getSymbol() + " ");
		        }
		    }
		    System.out.println();
	
	}
}
