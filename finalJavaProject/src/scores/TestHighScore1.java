package scores;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestHighScore1 {

	public static void main(String[] args) {
		
		// Part current score
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre prenom :");
		String str = sc.nextLine();
		
		List<String> values = new ArrayList<String>(); 
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("scoreSamples.txt")))
		{
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				values.add(sCurrentLine);
			}
			
			Random rnd = new Random();
			int rndValue = rnd.nextInt(values.size());

			String score = values.get(rndValue);
			System.out.println( str+ " a fait un score de "+ score);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		// Part high scores
		HighScore highScore = new HighScore();
		String scores[];
		int i = 0;
		
		scores = highScore.getScores();
		System.out.println("\nPrevious high scores are :");
		while ((i < 10) && (scores[i] != null)){
			System.out.println(scores[i]);
			i++;
		}
		
	}
}
