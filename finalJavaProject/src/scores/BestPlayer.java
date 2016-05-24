package scores;

/**
 * 
 */
public class BestPlayer implements Comparable<BestPlayer>{
	private String player;
	private int score;
	
	public BestPlayer(String player, int score){
		this.player = player;
		this.score = score;
	}
	
	@Override
	public int compareTo(BestPlayer p){
		if (this.score == p.getScore()){
			return 0;
		} else if (this.score < p.getScore()) {
			return -1;
		} else {
			return 1;
		}
	}

	public int getScore(){
		return this.score;
	}

	public String getPlayer(){
		return this.player;
	}
	
	
}