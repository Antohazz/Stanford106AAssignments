package week2;

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class DrawingLines extends GraphicsProgram {

	public void init() {
		addMouseListeners();
	}
	

	public void mousePressed(MouseEvent e) {
		myLine = new GLine (e.getX(), e.getY(), e.getX(), e.getY());
	}
	
	public void mouseDragged(MouseEvent e) {
		myLine.setEndPoint(e.getX(), e.getY());
		add(myLine);
	}
	
	private GLine myLine;	
}



	/* public void mousePressed(MouseEvent clickEvent) {
		if (firstClick) {
		pointOne = clickEvent.getPoint();
		firstClick = false;
		}else {
		pointTwo = clickEvent.getPoint();
		firstClick = true;
		GLine myLine = new GLine (pointOne.getX(), pointOne.getY(), pointTwo.getX(), pointTwo.getY());
		add(myLine);
		} 
		
		println (pointOne); //to console
		println (pointTwo); //to console
	}

	public void mouseDragged(MouseEvent e) {
		myLine = new GLine (e.getX(), e.getY(), e.getX(), e.getY());
		add(myLine);
	}
	
	private GLine myLine;
	private boolean firstClick = true;
	private Point pointOne, pointTwo;
	
*/
