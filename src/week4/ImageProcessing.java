package week4;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class ImageProcessing extends GraphicsProgram {

	public void run() {
	GImage image = new GImage("Vermeer.jpg");
	
	int array[][] = image.getPixelArray();
	int height = array.length;
	int width = array[0].length;
	int flip[][] = new int[height][width];	
	
	for (int k = 0; k < height; k++) {
		int j = width - 1;
		for (int i = 0; i < width; i++) {
			flip[k][j] = array[k][i];
			j--;
		}
	}
	
	GImage flipped = new GImage(flip);
	flipped.scale(0.4);
	add(flipped);
	
	}
}
