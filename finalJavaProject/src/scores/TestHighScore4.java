 
 package scores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * tests the class HighScores and its functions.
 */
public class TestHighScore4 {

        /**
         * retrieves high scores from thingspeak, print the 10 best and add yours if you are in the top10
         * @param args
         */
        public static void main(String args[]){
                System.out.println("\nPlease, enter your name :");
                Scanner sc = new Scanner(System.in);
                String name = sc.nextLine();
                
                HighScore4 highScore = new HighScore4();
                BestPlayer[] bestPlayers;
                String str;

                do{
                        System.out.println("Previous best scores are :");
                        bestPlayers = highScore.tenBestScores(highScore.getScores());
                        int j = 1;
                        for (BestPlayer p : bestPlayers) {
                                if (p != null){        
                                        System.out.println("numero" + j + ": " + p.getPlayer());        
                                        j++;
                                }
                        }
                        System.out.println("\nDo you want to start a new game? (y/n)");
                        str = sc.nextLine();
                        if (str.equals("y")){
                                BestPlayer bp= new BestPlayer(name, TestHighScore4.getRandomScore());
                                for (BestPlayer player : bestPlayers) {
                                        if (player != null && player.getScore() <= bp.getScore()) {
                                                try {
                                                        HighScore4.sendScore(new BestPlayer(bp.getPlayer(), bp.getScore()));
                                                } catch (IOException e) {
                                                        e.printStackTrace();
                                                }
                                                break;
                                        }
                                }
                        }
                } while(str.equals("y"));
                sc.close();
                System.out.println("Thank you ! Have a good day !");
        }
        
        
        /**
         * retrieves a score randomly from scoreSamples file
         * @return a random score
         */
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

