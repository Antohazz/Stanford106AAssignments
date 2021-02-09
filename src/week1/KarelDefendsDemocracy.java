package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {

		cleanBallot();
		
	}
	
	private void doCleaning() {
		turnLeft();
		pickEmAll();
		pickEmAll();
		move();
		turnRight();
	}
	
	private void pickEmAll() {
		while (frontIsClear()) {
			move();
		}
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
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
		
}
