package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * manages high scores.
 */
public class HighScore3 {

	

	
	/** 
	 * retrieves High Scores from web server 
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
	
	

}