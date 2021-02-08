package week1;
/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	
	public void run() {
		doAllSteps();
	}
	
	private void doAllSteps() {
		fillRow();
		while (leftIsClear()) {
			goToEvenRow();
			fillRow();
				if (rightIsClear()) {
						goToOddRow();
						fillRow();
				} else {
					turnAround();
				}

		}
	}
	
	private void fillRow() {
		putBeeper();
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
	}
	
	private void goToEvenRow() {
		turnLeft();
		move();
		turnLeft();
	}
	
	private void goToOddRow() {
		turnRight();
		move();
		turnRight();
	}
}
	
/*	public void run() {
		putFillMoveUp();
	}

	
	private void putFillMoveUp() {
		putBeeper();
		fillRow();
		moveUpRow();
	}
	
	private void fillRow() {
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
		
	}
	
	private void moveUpRow() {
		if (facingEast()) {
			turnLeft();
				if (frontIsClear()) {
					move();
					turnLeft();
					putFillMoveUp();
				}
		}
		else {
			turnRight();
			if (frontIsClear()) {
				move();
				turnRight();
				putFillMoveUp();
			}
		}
	}
		
}
*/	

