package week3;

import acm.program.ConsoleProgram;

public class DeleteCharactersFromString extends ConsoleProgram {
	
	public void run() {
		
		println(removeAllOccurrences("tThis is a test,t tveryt bigt tttest", 't'));
		
	}
	
	public String removeAllOccurrences(String str, char ch) {
		int n = str.indexOf(ch);
		while(n != -1) {
			str = str.substring(0, n) + str.substring(n + 1);
			n = str.indexOf(ch);
		}
		return str;
	}
}
