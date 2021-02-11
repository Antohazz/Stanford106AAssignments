package week1;
/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;



public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		deployCornerBeepers();
		deployRestOfBeepers();
		addCentralBeeperToNextRow();
		returnToRow1Corner();
		pickUpAllFromRow();
		goRowUp();
		findBeeper();
		returnBeeperDown();
	}
	

	private void deployCornerBeepers() {
		putBeeper();
		goToWall();
		putBeeper();
		turnAround();
		move();
	}	
		
	private void deployRestOfBeepers() {
		findBeeper();
		turnAround();
		move();
		if (noBeepersPresent()) {
			putBeeper();
			move();
		deployRestOfBeepers();
		}
		
	}
	
	private void addCentralBeeperToNextRow() {
		goRowUp();
		putBeeper();

}	

	private void returnToRow1Corner() {
		goToWall();
		turnLeft();
		move();
		turnLeft();
	}	
	
	private void pickUpAllFromRow() {
		while (frontIsClear()) {
			pickBeeper();
			move();
			}
		pickBeeper();
		}
	
	private void goRowUp() {
		turnLeft();
		if (frontIsClear()) {
		move();
		turnLeft();
		}
		else {
			turnAround();
			move();
			turnLeft();
		}
	}
	
	private void findBeeper() {
		while (noBeepersPresent()) {
			move();
		}
	}
	
	private void returnBeeperDown() {
		pickBeeper();
		turnLeft();
		move();
		putBeeper();
		turnRight();
		goToWall();
		turnAround();
	}
	
		
	private void goToWall() {
		while (frontIsClear()) {
			move();
		}
	}
	

}
