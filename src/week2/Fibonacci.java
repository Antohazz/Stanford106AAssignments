package week2;

import acm.program.*;

public class Fibonacci extends ConsoleProgram {

	private static final int MAX_VALUE = 10000;
	
	public void run() {

		println("Lady and Gentlemens,");
		println("The Fibonacci Sequence!");
		
		int fib = 1;
		println("0");
		println("1");
		do {println(fib);
			fib+=fib;
			if (fib > MAX_VALUE) {
					break;
			}
		}
		while (fib < MAX_VALUE);
	}
}
