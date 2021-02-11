/*
* File: Checkerboard.java
* -----------------------
* This program draws a checkerboard.
*/

package week2;

/*
* This class draws a checkerboard on the graphics window.
* The size of the checkerboard is specified by the
* constants NROWS and NCOLUMNS, and the checkboard fills
* the vertical space available.
*/
import acm.graphics.*;
import acm.program.*;
import acm.program.GraphicsProgram;

public class Checkerboard extends GraphicsProgram {

	private static final int NROWS = 8;
	private static final int NCOLUMNS = 8;

	public void run() {
		
		int rectHight = getHeight() / NROWS;

		for (int i = 0; i < NCOLUMNS; i++) {
			for (int j = 0; j < NROWS; j++) {
				int x = rectHight*i;
				int y = rectHight*j;
				GRect myRect = new GRect (x,y,rectHight,rectHight);
				if ((j+i) % 2 == 0) {
					myRect.setFilled(true);
				}else{myRect.setFilled(false);}
				
				add(myRect);
			}
	
		}
	}
}