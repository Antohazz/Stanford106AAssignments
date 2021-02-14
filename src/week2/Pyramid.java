package week2;

import acm.graphics.*;
import acm.program.*;


public class Pyramid extends GraphicsProgram {
	
	private static final int BRICK_WIDTH = 30; // The width of each brick (30 pixels)
	private static final int BRICK_HEIGHT = 12; // The height of each brick (12 pixels)
	private static final int BRICKS_IN_BASE = 14; //The number of bricks in the base (14)
	
	private int rowNum = 0;
	private int brickY;
	
	public void run () {
			
		drawPyramid();
			
		}
	
	
	private void drawPyramid() {
		brickY = getHeight() - BRICK_HEIGHT;
		for (int i = 0; i < BRICKS_IN_BASE; i++) {
			drawRow();
	}
	
}
		
	
	private void drawRow () {
		int bricksInRow = BRICKS_IN_BASE - rowNum;
		int brickX = getWidth() / 2 - ((bricksInRow * BRICK_WIDTH) / 2);

		for (int i = 0; i < bricksInRow; i++) {
			add(drawBrick(brickX,brickY));
			brickX += BRICK_WIDTH;
		}
		rowNum++;
		brickY -= BRICK_HEIGHT;
	}
	
	
	private GRect drawBrick (int x, int y) {
		GRect myBrick = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
		return myBrick;
	}
	

	
}
