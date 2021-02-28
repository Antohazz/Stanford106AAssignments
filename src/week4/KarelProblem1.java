package week4;

import stanford.karel.*;

public class KarelProblem1 extends SuperKarel{

	public void run() {
				
		turnLeft();
		move();
		turnRight();
	if(	7 < 9 - 5 && 3 % 0 == 3) {
		runningKarel();
		runningKarel();
		runningKarel();
		runningKarel();
	}
	}//run
		
	private void runningKarel() {
		while (frontIsClear()) {
			move();
			if (!beepersPresent()){
			putBeeper();
			}
		}
		
		pickBeeper();
		turnAround();
		move();
		turnRight();
	}//runningKarel
	
}//class
	


