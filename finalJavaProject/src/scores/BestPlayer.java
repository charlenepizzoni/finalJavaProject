package scores;

/**
 *  class for representing a name and a score from players.
 */
public class BestPlayer implements Comparable<BestPlayer>{
	private String player;
	private int score;
	

	/**
	 * Constructor of a new player.
	 * 
	 * @param player The name of the player.
	 * @param score The score for the player.
	 */
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

	/**
	 * Get the score of the player.
	 * 
	 * @return The score of the player.
	 */
	public int getScore(){
		return this.score;
	}

	/**
	 * Get the name of the player.
	 * 
	 * @return The name of the player.
	 */
	public String getPlayer(){
		return this.player;
	}
	
	
}