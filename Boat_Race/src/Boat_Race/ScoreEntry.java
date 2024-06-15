package Boat_Race;

public class ScoreEntry {
	private int score;
	private String playerName;
	
	public ScoreEntry(int score, String playerName) {
		this.score = score;
		this.playerName = playerName;
		
	}
	
	public int getScore() {
		return score;
	}
	
	public String getPlayerName() {
		return playerName;
	}

}
