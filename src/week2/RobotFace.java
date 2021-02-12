package week2;


import acm.program.GraphicsProgram;

import java.awt.Color;

import acm.graphics.*;

public class RobotFace extends GraphicsProgram {

	private static final int HEAD_WIDTH = 200;
	private static final int HEAD_HEIGHT = 300;
	private static final int EYE_RADIUS = 20;
	private static final int MOUTH_WIDTH = 100;
	private static final int MOUTH_HEIGHT = 30;
	
	int canvWidth = getWidth();
	int canvHeight = getHeight();
	int midX;
	int midY;
	
	public void run () {
		midX = getWidth() / 2;
		midY = getHeight() / 2;
		drawRobot(midX, midY);
		
	}

	private void drawRobot(double x, double y) {
		
		drawHead(x,y);
		drawMouth(x,y);
		drawEyes(x,y);
	}
	private void drawHead (double x, double y) {
		int X = midX - HEAD_WIDTH /2;
		int Y = midY - HEAD_HEIGHT / 2;
		
		GRect RHead = new GRect (X, Y, HEAD_WIDTH, HEAD_HEIGHT);
		RHead.setColor(Color.gray);
		RHead.setFilled(true);
		add(RHead);

	}
	private void drawMouth (double x, double y) {
		int X = midX - HEAD_WIDTH / 4;
		int Y = midY + HEAD_HEIGHT / 4;
		GRect RMouth = new GRect (X, Y, MOUTH_WIDTH, MOUTH_HEIGHT);
		RMouth.setColor(Color.white);
		RMouth.setFilled(true);
		add(RMouth);

	}
	private void drawEyes (double x, double y) {
		int X = midX - HEAD_WIDTH / 4;
		int Y = midY - HEAD_HEIGHT / 4;
		GOval REye = new GOval (X, Y, 2*EYE_RADIUS, 2*EYE_RADIUS);
		REye.setColor(Color.yellow);
		REye.setFilled(true);
		add(REye);
		X = midX + HEAD_WIDTH / 4 - 2*EYE_RADIUS;
		GOval REye2 = new GOval (X, Y, 2*EYE_RADIUS, 2*EYE_RADIUS);
		REye2.setColor(Color.yellow);
		REye2.setFilled(true);
		add(REye2);

	}

	
/*	//version 1
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
		posX = xMid - 3*EYE_RADIUS;
		posY = yMid - HEAD_HEIGHT / 2 + 3*EYE_RADIUS;
		GOval REye1 = new GOval (posX, posY, 2*EYE_RADIUS, 2*EYE_RADIUS);
		REye1.setColor(Color.yellow);
		REye1.setFilled(true);
		add(REye1);
	}
	private void drawEye2() {
		posX = xMid + EYE_RADIUS;
		posY = yMid - HEAD_HEIGHT / 2 + 3*EYE_RADIUS;
		GOval REye2 = new GOval (posX, posY, 2*EYE_RADIUS, 2*EYE_RADIUS);
		REye2.setColor(Color.yellow);
		REye2.setFilled(true);
		add(REye2);
	}
		*/
	
}
