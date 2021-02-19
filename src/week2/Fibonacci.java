package week2;

import acm.program.*;

public class Fibonacci extends ConsoleProgram {

	private static final int MAX_VALUE = 10000;

	public void run() {

		println("Lady and Gentlemens,");
		println("The Fibonacci Sequence!");
		
		int fib0 = 0;
		
		for (int fib1 = 1; fib1 < MAX_VALUE; fib1 += fib0 ) {
			println(fib0);
			println(fib1);
			fib0 += fib1; 
		}
		if (fib0 < MAX_VALUE) {
			println(fib0);
		}
	}
}
