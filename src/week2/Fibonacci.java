package week2;

import acm.program.*;

public class Fibonacci extends ConsoleProgram {

	private static final int MAX_VALUE = 10000;

	
	public void run() {

		println("Ladies and Gentlemen,");
		println("The Fibonacci Sequence!");
		
		int one = 0;
		int two = 1;
		int thr = one + two;
		
		while (true){

			if (one <= 	MAX_VALUE)
				println(one);
			if (two <= MAX_VALUE)
				println(two);
			if (thr <= MAX_VALUE)
				println(thr);
			else break;
			
			one = two + thr;
			two = thr + one;
			thr = one + two;
		}
		
		
//		int fib0 = 0;
//		
//		for (int fib1 = 1; fib1 < MAX_VALUE; fib1 += fib0 ) {
//			println(fib0);
//			println(fib1);
//			fib0 += fib1; 
//		}
//		if (fib0 < MAX_VALUE) {
//			println(fib0);
//		}
	}
	
	
}
