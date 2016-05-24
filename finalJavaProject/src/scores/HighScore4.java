package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * manages high scores and the high score web server
 */
public class HighScore4 {
        
        
        /** 
         * retrieves High Scores from the web server 
         * @return an array containing high scores
         */
        public List<String> getScores() {
                
                List<String> scores = new ArrayList<String>();
                //String scores[] = new String[10];
                
            URL url;
                try {
                        url = new URL("https://thingspeak.com/channels/111310/feed.csv");
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String inputLine;
                int i = -1;
                while (((inputLine = in.readLine()) != null)) {
                        if (i >= 0) { // we don't want the first line
                                scores.add(inputLine);        
                        }
                        i++;
                }
                in.close();
                } catch (MalformedURLException e1) {
                        System.out.println("Malformed URL : "+e1.getMessage());
                } catch (IOException e2) {
                        System.out.println("I/O error : "+e2.getMessage());
                }
        
                return scores;
        }
        
        /**
        * Retrieves scores and extract the 10 best
        * @param a list of read scores
        * @return an array of BestPlayer containing the top10  
        */
        public BestPlayer[] tenBestScores(List<String> readScores) {
                ArrayList<BestPlayer> allBest = new ArrayList<BestPlayer>();
                int nb = 0;
                for (String s : readScores){ // pour chaque ligne de scores
                        String[] parsed = s.split(",");
                        if (parsed.length == 4){ // if there is a score
                                BestPlayer bp = new BestPlayer(parsed[3], Integer.parseInt(parsed[2]));
                                allBest.add(bp);
                        } // on ne prend pas les lignes ne contenant pas de score.
                }
                Collections.sort(allBest, Collections.reverseOrder());
                // get the 10 best
                if (allBest.size() < 10){
                        nb = allBest.size();
                } else {
                        nb = 10;
                }
                BestPlayer[] res = new BestPlayer[nb];
                for (int i = 0; i < nb; i++){
                        res[i] = allBest.get(i);
                }
                return res;
        }
        
        /**
         * Send a new high score to the server. 
         * @param player Send the Player high score to the server.
         */
        public static void sendScore(BestPlayer player) throws IOException{
                String name = player.getPlayer();
                int score = player.getScore();
                
                
                URL getURL = new URL("https://api.thingspeak.com/update?api_key=KT52V0MMF3DG3NDA&field1=" + score + "&field2=" + name);
                getURL.openStream();
        }
        

        
}
