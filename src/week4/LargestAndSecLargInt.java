package week4;

import acm.program.ConsoleProgram;
import acmx.export.java.util.ArrayList;


public class LargestAndSecLargInt extends ConsoleProgram{
	
	public void run() {

		int x1 = 0;
		int x2 = 0;
		while (true) {
		int x = readInt("?");
		if (x == 0) {
			println(x1);
			println(x2);
			break;
		}
		
		if(x > x1) {
		x2 = x1;
		x1 = x;
		}else if (x > x2) {
			x2 = x;
		}
		
		}
				
	}//run
	


}//class
