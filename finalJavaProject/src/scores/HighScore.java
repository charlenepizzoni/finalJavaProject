package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * manages high scores.
 */
public class HighScore {

	/** 
	 * retrives High Scores from web server 
	 * @return an array containing high scores
	 */
	public String[] getScores() {
		String scores[] = new String[10];
		
	    URL url;
		try {
			url = new URL("https://thingspeak.com/channels/111310/feed.csv");
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        String inputLine;
	        int i = -1;
	        while (((inputLine = in.readLine()) != null) && (i < 10)) {
	        	if (i >= 0) { // we don't want the first line
	        		scores[i] = inputLine;
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
}
