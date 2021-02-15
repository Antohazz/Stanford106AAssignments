package week2;
/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPopupMenu.Separator;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 800;
	public static final int APPLICATION_HEIGHT = 1200;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 120;
	private static final int PADDLE_HEIGHT = 20;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 120;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 8;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 16;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 20;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 140;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		
		setup();
		play();
		
	}
	
	private void setup() {
		createWallOfBricks();
		createPaddle();
		addMouseListeners();
	}
	
		
	private void createWallOfBricks() {
		int y = BRICK_Y_OFFSET;
		int r = 255;
		int g = 50;
		int b = 0;
	//	String cColor = "RED";
		for (int i = 0; i < NBRICK_ROWS; i++) {
			Color myColor = new Color(r, g, b);
			createRowOfBricks(y, myColor);
			y = y + BRICK_HEIGHT + BRICK_SEP;
			if (g <= 200) {
				g+=50;
			}else {
				if (b <= 200) {
			}
				r = 0;
				b+=50;
			}
		}
	}
	
	private void createRowOfBricks(int y, Color currentColor) {
		int x = BRICK_SEP/2;
		for (int i = 0; i < NBRICKS_PER_ROW; i++) {
		brick = new GRect (x,y, BRICK_WIDTH, BRICK_HEIGHT);
		x = x + BRICK_WIDTH + BRICK_SEP;
		brick.setFilled(true);
		brick.setColor(currentColor);
		add(brick);
		}
	}
	
	
	public void createPaddle() {
		int x = WIDTH / 2 - PADDLE_WIDTH / 2;
		paddleY = (HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		paddle = new GRect (x, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setColor(Color.black);
		add(paddle);
	}

	public void mouseMoved(MouseEvent e) {
        int x = e.getX() - PADDLE_WIDTH / 2;
        paddle.setLocation(x,paddleY);
        if (paddle.getX() <= 0) {
        	paddle.setLocation(0, paddleY);
        }
        if (paddle.getX() + PADDLE_WIDTH >= WIDTH) {
        	paddle.setLocation(WIDTH - PADDLE_WIDTH, paddleY);
        }
		
	}
	
	private void play() {
		createBall();
		while(!gameOver()) {
			
			
			
			
		}
	}

	
	private void createBall() {
		ball = new GOval(WIDTH / 2 - BALL_RADIUS, HEIGHT / 2 + BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		ball.setColor(Color.black);
		add(ball);
	}
	
	private boolean gameOver() {
		return (brick == null); 
	}
	
	private GRect paddle;
	private GRect brick;
	private GOval ball;
	private int paddleY;

	
}
