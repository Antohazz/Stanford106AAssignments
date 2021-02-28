package week4;

import acm.program.ConsoleProgram;

public class RemoveDoubledLetters extends ConsoleProgram{
	
	public void run() {
		
		String str = "Aabbotthieeferrtuallee";
		println(str);
		String str2 = "";
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(i == 0 || ch != str.charAt(i-1) && Character.toUpperCase(ch) != str.charAt(i-1))  {
				str2 += ch;
			}
		
		}
		
		println(str2);
	}

}
