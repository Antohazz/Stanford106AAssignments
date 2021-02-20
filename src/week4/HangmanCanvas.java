package week4;
/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;



public class HangmanCanvas extends GCanvas {


	private GLabel xword;
	
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		removeAll();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		int w = getWidth();
		int h = getHeight();
		

		
		if (xword != null) {
			remove(xword);
		}
		
		xword = new GLabel(word, w/6 , h-h/6);
		xword.setFont("arial-bold-26");
		add(xword);		
		
		
	}

		public void shoW (String word) {
			int w = getWidth();
			int h = getHeight();
			
			GRect body = new GRect (w/2, h/3, w/20, h/4);
			body.setFilled(true);
			add(body);
			
			GLabel answer = new GLabel(word, w/6 , h-h/8);
			add(answer);
		
		}
/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */

	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
