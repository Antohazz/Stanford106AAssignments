
package week2;


import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class RandomCircles extends GraphicsProgram {

	public void run () {
			for (int i = 0; i<10; i++) {
				int radius= rgen.nextInt(5, 50);
				int x = rgen.nextInt(0, (getWidth()-2*radius));
				int y = rgen.nextInt(0, (getHeight()-2*radius));
				GOval myCircle = new GOval(x,y,radius*2,radius*2);
				myCircle.setFilled(true);
				myCircle.setColor(rgen.nextColor());
// white circle not seen
				add(myCircle);
			}
	}
RandomGenerator rgen = RandomGenerator.getInstance();
}