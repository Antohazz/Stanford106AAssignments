package week4;
/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.Color;

import acm.graphics.*;



public class HangmanCanvas extends GCanvas {


	private GLabel xword;
	private GLabel lettersGuessed;
	private String letterrow = "";
	
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
		
		xword = new GLabel(word, w*0.2 , h-h*0.15);
		xword.setFont("arial-bold-26");
		add(xword);		
		
		
	}

		public void testG (String word) {
			int w = getWidth();
			int h = getHeight();
			

			GLabel answer = new GLabel(word, w*0.2 , h-0.5);
			add(answer);
		
		}
/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter, int guessNum) {
		/* You fill this in */
		int w = getWidth();
		int h = getHeight();
		
		if (letterrow.indexOf(letter) == -1) {
		letterrow += letter;
		if (lettersGuessed != null) {
			remove(lettersGuessed);
		}
		lettersGuessed = new GLabel(letterrow, w*0.2 , h-h*0.1);
		lettersGuessed.setFont("arial-bold-18");
		add(lettersGuessed);
		}
		
		switch (guessNum) {
		case 7:
			GRect pole = new GRect(w*0.2, h*0.1, w*0.03, h*0.6);
			pole.setFilled(true);
			add(pole);
			break;
		
		case 6:
			GRect beam = new GRect(w*0.2, h*0.1, w*0.4, h*0.015);
			beam.setFilled(true);
			add(beam);
			break;
		case 5: 
			GLine rope = new GLine(w*0.5, h*0.1, w*0.5, h*0.27);
			add(rope);
			GOval head = new GOval(w*0.5 - w*0.05*0.5, h*0.25, w*0.05, w*0.05);
			head.setFilled(true);
			add(head);
			break;
		case 4:
			GRect body = new GRect (w*0.5 - w*0.02*0.5, h*0.25, w*0.02, h*0.2);
			body.setFilled(true);
			add(body);
			break;
		case 3:
			GLine leftArm = new GLine (w*0.5, h*0.25, w*0.45, h*0.4);
			add(leftArm);
			break;
		case 2:
			GLine rightArm = new GLine (w*0.5, h*0.25, w*0.55, h*0.4);
			add(rightArm);
			break;
		case 1:
			GLine leftLeg = new GLine (w*0.49, h*0.4, w*0.49, h*0.6);
			add(leftLeg);
			break;
		case 0:
		GLine rightLeg = new GLine (w*0.51, h*0.4, w*0.51, h*0.6);
		add(rightLeg);
		GOval pool = new GOval(w*0.5 - w*0.1*0.5, h*0.67, w*0.1, w*0.05);
		add(pool);
		}


	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 300;
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
