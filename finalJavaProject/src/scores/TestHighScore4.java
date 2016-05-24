package scores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestHighScore4 {

	public static void main(String args[]){
		System.out.println("\nPlease, enter your name :");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		sc.close();
		
		HighScore4 highScore = new HighScore4();
		BestPlayer[] bestPlayers = highScore.tenBestScores(highScore.getScores());
		String str;
		boolean wantsToPlay = true;
		do{
			
			System.out.println("Previous best scores are :");
			int j = 1;
			for (BestPlayer p : bestPlayers) {
					System.out.println("numero" + j + ": " + p.getPlayer());	
					j++;
			}
			System.out.println("\nDo you want to start a new game? (y/n");
			Scanner scanner = new Scanner(System.in);
			str = sc.nextLine();
			sc.close();
			wantsToPlay = (str == "y");
			if (wantsToPlay){
				BestPlayer bp= new BestPlayer(name, TestHighScore4.getRandomScore());
				//TO DO
			}
		} while(wantsToPlay);
	}
	
	 public static int getRandomScore() { 
		 ArrayList<String> values = new ArrayList<String>();
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
