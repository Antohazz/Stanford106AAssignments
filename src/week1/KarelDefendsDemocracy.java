package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {

		cleanBallot();
	}
	
	private void cleanBallot() {
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				doCleaning();
				move();
			}else{
				move();
				cleanBallot();
			}
			
		}

	}
	
	private void doCleaning() {
		turnLeft();
		pickBallots();
		pickBallots();
		turnRight();
	}
	
	private void pickBallots() {
		while (frontIsClear()) {
			move();
		}
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
	}
	
	
		
}
