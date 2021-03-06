package scores;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Test class HighScores and its functions.
 */
public class TestHighScore3 {

	/**
	 * retrieves a name and a score and display high scores.
	 */
	public static void main(String[] args) {
		
		HighScore3 highscore = new HighScore3();
		BestPlayer3[] bestPlayers = highscore.tenBestScores(highscore.getScores());
		int j = 1;
		for (BestPlayer3 p : bestPlayers)
			{
				System.out.println("numero" + j + ": " + p.getPlayer());	
				j++;
			}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre prenom :");
		String nom = sc.nextLine();
		sc.close();
		int score = getRandomScore();
		System.out.println("Username: " + nom + ", Score: " + score);
				
		
		for (BestPlayer3 player : bestPlayers) {
			if (player != null && player.getScore() < score) {
				try {
					HighScore3.sendScore(new BestPlayer3(nom, score));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				break;
			}
		}
	
	}
	
	/**
	 * retrieves a score randomly from scoreSamples.txt
	 * 
	 * @return a random score
	 */
	public static int getRandomScore()
	{ ArrayList<String> values = new ArrayList<String>();
		int res=0;
		try (BufferedReader br = new BufferedReader(new FileReader("scoreSamples.txt")))
		{
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				values.add(sCurrentLine);
			}
			
			Random rnd = new Random();
			int rndValue = rnd.nextInt(values.size());

			String score = values.get(rndValue);
			res = Integer.parseInt(score);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return res;
	}
}
