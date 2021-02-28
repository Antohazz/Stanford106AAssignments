package week4;

import acm.program.ConsoleProgram;
import acmx.export.java.util.ArrayList;
import java.util.*;
import java.util.*; 
public class NameCounts extends ConsoleProgram {
	
private HashMap<String, Integer> names = new HashMap<String, Integer>();

	public void run() {
		println(5.0 / 4 - 4 / 5 );
		while (true) {
			String line = readLine("Enter name: ");
			if (line.length() == 0) {
				printNames(names);
				break;
			}
			
			if (names.containsKey(line)) {
				int x = names.get(line);
				x++;
				names.put(line, x);
			}else {
				names.put(line, 1);
			}
			
			
		}//while
				
	}//run
	
	
	private void printNames(HashMap<String, Integer> names) {
		Iterator <String> iter = names.keySet().iterator();
		while (iter.hasNext()) {
			String k = iter.next();
			Integer number = (Integer) names.get(k);
			println("Name "+ k +": "+ number);

		}
	}
	
}//class
