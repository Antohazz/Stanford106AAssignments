package week4;

import acm.program.ConsoleProgram;
import acmx.export.java.util.ArrayList;
import java.util.*;

public class NameCounts extends ConsoleProgram {
	
	private ArrayList names = new ArrayList();
	
	public void run() {
		
		
		
		while (true) {
			String line = readLine("Enter name: ");
			if (line.length() == 0) {
				printNames(names);
				break;
			}
			
			addsToArr(line);
			
											
		}
		
		
	}//run
	
	private void addsToArr(String line) {
		if (!names.contains(line)){
			names.add(line);
		}
	}
	
	private void printNames(ArrayList names) {
		
		println("Uniqe list contains:");
		
		for (int i = 0; i < names.size(); i++) {
			println(names.get(i));
		}
		
		
	}
	
}//class
