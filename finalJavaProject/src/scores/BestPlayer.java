package scores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */
public class BestPlayer implements comparable{
	private String player;
	private int score;
	
	public BestPlayer(String player, int score){
		this.player = player;
		this.score = score;
	}
	
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

	public String getName(){
		return this.name;
	}
	
	
}