package week4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;
import acmx.export.java.util.ArrayList;

public class WordCount extends ConsoleProgram {
	
	//private String text = "";
	private BufferedReader rd;
	private int strCounter;
	private int words;
	private int chars;
	
	public void run() {

		openFile();
		readAndCount();
		resOut();
		
	}

	private void openFile() {
		try {
			rd = new BufferedReader(new FileReader("src\\week4\\lear.txt"));
		} catch (FileNotFoundException e) {
			println("src\\week4\\lear.txt not found");
			e.printStackTrace();
		}
	}
		
	private void readAndCount() {	
		try {
			while(true) {
				String line = rd.readLine();
				if (line == null) {
					break;}
				//text += line;
				//println(line);
				chars += line.length();
				words += countWords(line);
				strCounter++;

			}
			rd.close();

		} catch (IOException e) {
			println("I/O Error");
		}
	}	
	
	private int countWords(String line) {		
		//StringTokenizer myTok = new StringTokenizer(line);
		//int wordsNum = myTok.countTokens();
		int wordCounter = 0;
		boolean isWord = false;
		
		for (int i = 0; i <line.length(); i++) {
		
			char ch = line.charAt(i);
			
			if (Character.isLetterOrDigit(ch) && !isWord) {
			isWord = true;
			wordCounter++;
			}
			
			if (!Character.isLetterOrDigit(ch)) {
			isWord = false;
			
			}				
		
		}
		return wordCounter;
}
		
	private void resOut() {
		println("File: lear.txt");
		println("Lines: " + strCounter);
		println("Words: " + words);
		println("Chars: "+ chars);
	}
}
	

