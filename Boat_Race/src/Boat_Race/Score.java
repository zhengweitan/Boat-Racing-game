package Boat_Race;

import java.io.*;
import java.util.*;

// Score class to store and manage top scores
public class Score {
    private List<ScoreEntry> topScores;
    private static final int MAX_SCORES = 5;

    public Score() {
        topScores = new ArrayList<>();
        readScores();
    }

    /*
     * Method to read scores from the 'TopScore.txt' file
     * Throw an error message if the text file is not readable
     */
    private void readScores() {
        try {
            FileReader fileReader = new FileReader("TopScore.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    int score = Integer.parseInt(parts[0]);
                    String playerName = parts[1];
                    topScores.add(new ScoreEntry(score, playerName));
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading from TopScore.txt");
        }
    }

    // Method to update the top scores with a player's score and name
    public void updateScores(int score, String playerName) {
    	ScoreEntry newEntry = new ScoreEntry(score, playerName);

        // Check if the score qualifies for the top 5
        if (topScores.size() < MAX_SCORES || score < topScores.get(MAX_SCORES - 1).getScore()) {
            topScores.add(newEntry);
            topScores.sort(Comparator.comparingInt(ScoreEntry::getScore));

            if (topScores.size() > MAX_SCORES) {
                topScores.remove(MAX_SCORES);
            }

            writeScores();
        }

    }

    /*
     *  Method to write scores to the 'TopScore.txt' file
     *  Throw an error message if scores is unable to write in text file
     */
    private void writeScores() {
        try {
            FileWriter fileWriter = new FileWriter("TopScore.txt");
            fileWriter.write("\n--- Top 5 Scores ---\n");
            for (ScoreEntry scoreEntry : topScores) {
                fileWriter.write(scoreEntry.getScore() +
                		 " " + scoreEntry.getPlayerName() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to TopScore.txt");
        }
    }

    // Method to display the top scores
    public void displayScores() {
        System.out.println("\n--- Top 5 Scores ---");
        int count = 1;
        for (ScoreEntry scoreEntry : topScores) {
            System.out.println(count + ". " + scoreEntry.getPlayerName() + " - " + scoreEntry.getScore() + " turns");
            count++;
        }
    }
}