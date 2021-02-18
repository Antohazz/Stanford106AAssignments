package week3;

import acm.program.ConsoleProgram;

public class AddCommasToNumberStrings extends ConsoleProgram {
	
	public void run() {

		while(true) {
		String digits = readLine("Enter a numeric string: ");
		if (digits.length() == 0) {
			break;
		}
		
		println(addCommasToNumericString(digits));
	 }
	}
	
	private String addCommasToNumericString(String digits) {
		int x = digits.length() % 3;
		if (x == 0) {
			x = 3;
		}
		
		String sepDigits = digits.substring(0, x);
		
		for (int i = 0; i < digits.length()-x; i+=3) {
			sepDigits = sepDigits + "," + digits.substring(x, x + 3);
		}
				
		return sepDigits;
		
	}
	
	
}
