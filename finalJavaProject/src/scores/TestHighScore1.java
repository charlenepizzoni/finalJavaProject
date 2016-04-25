package scores;

public class TestHighScore1 {

	public static void main(String[] args) {
		HighScore hg = new HighScore();
		
		for(String score : hg.getScores()) {
			System.out.println(score);
		}

	}

}
