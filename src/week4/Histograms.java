package week4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import acm.program.ConsoleProgram;
import acmx.export.java.io.FileReader;


public class Histograms extends ConsoleProgram {
	
	private BufferedReader rd;
	private String[] scoreArr = new String[11];
	
	public void run() {
		
		//init array
		for (int i =0; i < scoreArr.length; i++) {
			scoreArr[i] = "";
		}//for
		
		//open file
		try {
			rd = new BufferedReader(new FileReader("src\\week4\\MidtermScores.txt"));
		} catch (FileNotFoundException e) {
			println("file not found");
			e.printStackTrace();
		}//try
		
		//read from file
		while (true) {
	
			try {
				String line = rd.readLine();
				if(line == null) {break;}
				putInArray(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}//while
		
		outPut();
						
	}//run
		
	
	private void putInArray(String line) {
		
		// Checks for range and digits only
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
	
						int scoreInt = Integer.parseInt(line);
		
						if (scoreInt >= 0 && scoreInt <= 100) {
								int j = scoreInt / 10;
								scoreArr[j] += "*";
						}
		 	}
		}
		
	}//putInArray
	
	private void outPut() {
		int i = 0;
		String pos;
		
		while (i <= 10) {
			
			if (i == 0) {
				pos = "00-09: ";
			}else if (i == 10) {
				pos = "  100: ";
			} else {
			pos = (10 * i) + "-" + (10 * i + 9)+": ";
			}
			
		
		println(pos+scoreArr[i]);
		i++;
		}
	}//outPut
	
	
}//class
