package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * manages high scores.
 */
public class HighScore2 {

	

	
	/** 
	 * retrieves High Scores from web server 
	 * @return an array containing high scores
	 */
	public List<String> getScores() {
		
		List<String> scores = new ArrayList<>();
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
	*
	*/

	public BestPlayer[] tenBestScores(List<String> readScores) {
		
		
		
		BestPlayer[] allBest = new BestPlayer[10];
		int nb = 0;
		for (String s : readScores){
			String[] parse = s.split(",");
			if (s.length() == 4){
				BestPlayer bp = new BestPlayer(parse[2], Integer.parseInt(parse[3]));
				nb ++;
				allBest[nb-1] = bp;
			} // on ne prend pas les lignes ne contenant pas de score.
		}
		return allBest;
	}
	
	

}
