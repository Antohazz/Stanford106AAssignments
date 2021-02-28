package week4;

import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;



public class Frog extends GraphicsProgram{
	
	public static final int SQSIZE = 75;
	public static final int NCOLS = 7;
	public static final int NROWS = 3;
	private GRect square;
	private int mx;
	private int my;
	private int fcx;
	private int fcy;
	
	private GImage frog = new GImage("frog.gif");;
	
	public void init() {
		int w = getWidth();
		int h = getHeight();
		
		
		
		for(int i = 0; i <= w; i += SQSIZE) {
			for(int j = 0; j <= h-SQSIZE; j+=SQSIZE) {
				square = new GRect (i,j,SQSIZE,SQSIZE);
				add(square);
			}
		}
		
		add(frog, SQSIZE*4+2, SQSIZE*5+2);
		 
		addMouseListeners();
						
	}
	
	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		fcx = (int)(frog.getX() + frog.getWidth()/2);
		fcy = (int)(frog.getY() + frog.getHeight()/2);
		if (Math.abs(mx - fcx) <= Math.abs(my - fcy)) {
		
		moveY();

		
		}else {
		
		
		if (mx < frog.getX()) {
			frog.move(-SQSIZE, 0);
		}else
		{
			frog.move(SQSIZE, 0);
		}
	}
	}
	
	private void moveY() {
		if (my <= frog.getY()) {
			frog.move(0, -SQSIZE);
		}else {
			frog.move(0, SQSIZE);
		}
	}
	
	private void moveX() {
		if (my <= frog.getY()) {
			frog.move(0, -SQSIZE);
		}else {
			frog.move(0, SQSIZE);
		}
	}
	
	
}