package us.mschmaud.runningsim.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Score {
	
	private static ArrayList<String> scores = new ArrayList<>();
	private static String highScoreDate = "";	// Allows us to check if a score was ever set, avoids nullPointerException
	private static int highScore = 0;
	private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy (HH:mm:ss)");
	
	public static void addScore(int score) {
		Date d1 = new Date();
		String date1 = dateFormat.format(d1);
		scores.add(date1 + ": " + score + " coins");
		if (score >= highScore) {
			Date date = new Date();
			highScoreDate = dateFormat.format(date);
			highScore = score;
		}
	}
	
	public static String getHighScore() {
		return highScoreDate + ": " + highScore + " coins";
	}
	
	public static String lastTime() {	// Handles quitting without ever playing the game and getting a score
		return highScoreDate;
	}
	
	public static ArrayList<String> getScores() {
		return scores;
	}
}
