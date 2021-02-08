package week1;
/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;



public class StoneMasonKarel extends SuperKarel {

	public void run() {
		while(frontIsClear()) {
			fixColumn();
			climbDown();
			moveToNextColumn();
			}
		fixColumn();
		climbDown();
	}
	
	private void fixColumn() {
		turnLeft();
			
			while(frontIsClear()) {
					if (!beepersPresent()) {
					putBeeper();
					}
				move();
			}
			
			if (!beepersPresent()) {
				putBeeper();
			}
	}
	
	private void climbDown() {
		turnAround();
			while(frontIsClear()) {
				move();
				}
			turnLeft();
	}
	
	private void moveToNextColumn() {
		for (int i=0; i<4; i++) {
			move();
			}
	}

}
