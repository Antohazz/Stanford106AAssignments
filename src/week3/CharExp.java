package week3;


import acm.program.ConsoleProgram;

public class CharExp extends ConsoleProgram {

	public void run() {
		while(true){
			String string = readLine("type smth: ");
			char ch = string.charAt(0);
			println(ch);
			println(toLowCase(ch));
		}
		
	}
	
	private char toLowCase (char ch) {
		if (ch >= 'A' && ch <= 'Z') {
			int y = ch - ('A'+'a');
			ch = (char) y;
			return ch;
		}
		return ch;
	}
	
}
