package scores;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestHighScore1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre prenom :");
		String str = sc.nextLine();
		System.out.println(" Bienvenue " + str);
		List<String> values = new ArrayList<String>(); 
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("scoreSamples.txt")))
		{
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				values.add(sCurrentLine);
			}
			
			Random rnd = new Random();
			int rndValue = rnd.nextInt(values.size());

			values.get(rndValue);
		
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
