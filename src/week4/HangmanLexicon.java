package week4;
/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import acmx.export.java.util.ArrayList;
import acm.program.*;
import acm.graphics.*;
import java.io.*;



public class HangmanLexicon extends ConsoleProgram {
	
	private ArrayList dict;
	

	
	public void openFile() throws FileNotFoundException {
		
		BufferedReader rd = new BufferedReader(new FileReader("src\\week4\\HangmanLexicon.txt"));
		
		dict = new ArrayList();

		try {
			while(true) {
				String line = rd.readLine();
				if (line == null) {
					break;}
				dict.add(line);
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return dict.size();
	}


/** Returns the word at the specified index. */
	public String getWord(int index) {

		return (String) dict.get(index);
		
		//		switch (index) {
//			case 0: return "BUOY";
//			case 1: return "COMPUTER";
//			case 2: return "CONNOISSEUR";
//			case 3: return "DEHYDRATE";
//			case 4: return "FUZZY";
//			case 5: return "HUBBUB";
//			case 6: return "KEYHOLE";
//			case 7: return "QUAGMIRE";
//			case 8: return "SLITHER";
//			case 9: return "ZIRCON";
//			default: throw new ErrorException("getWord: Illegal index");
//		}
	}
}
