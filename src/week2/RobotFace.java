package week2;

import acm.program.GraphicsProgram;

import java.awt.Color;

import acm.graphics.*;

public class RobotFace extends GraphicsProgram {

	private static final int HEAD_WIDTH = 200;
	private static final int HEAD_HEIGHT = 300;
	private static final int EYE_RADIUS = 20;
	private static final int MOUTH_WIDTH = 150;
	private static final int MOUTH_HEIGHT = 50;
	private static double xMid;
	private static double yMid;
	private static double posX;
	private static double posY;
	
	public void run() {
		xMid = getWidth() / 2;
		yMid = getHeight() / 2;
		drawHead();
		drawMouth();
		drawEye1();
		drawEye2();
	}	
	
	private void drawHead() {
		posX = xMid - HEAD_WIDTH / 2;
		posY = yMid - HEAD_HEIGHT / 2;
	
		GRect RHead = new GRect (posX, posY, HEAD_WIDTH, HEAD_HEIGHT);
		RHead.setColor(Color.gray);
		RHead.setFilled(true);
		add(RHead);
	}
		
	private void drawMouth() {
		posX = xMid - MOUTH_WIDTH / 2;
		posY = yMid + MOUTH_HEIGHT * 1.5;
	
		GRect RMouth = new GRect (posX, posY, MOUTH_WIDTH, MOUTH_HEIGHT);
		RMouth.setColor(Color.white);
		RMouth.setFilled(true);
		add(RMouth);
		
	}
	private void drawEye1() {
		posX += EYE_RADIUS;
		posY = yMid - HEAD_HEIGHT / 2 + 3*EYE_RADIUS;
		GOval REye1 = new GOval (posX, posY, EYE_RADIUS, EYE_RADIUS);
		REye1.setColor(Color.yellow);
		REye1.setFilled(true);
		add(REye1);
	}
	private void drawEye2() {
		posX = HEAD_WIDTH / 2 + xMid - 3.5*EYE_RADIUS;
		posY = yMid - HEAD_HEIGHT / 2 + 3*EYE_RADIUS;
		GOval REye2 = new GOval (posX, posY, EYE_RADIUS, EYE_RADIUS);
		REye2.setColor(Color.yellow);
		REye2.setFilled(true);
		add(REye2);
	}
		
	
}
