package week4;
/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */


import acm.graphics.*;

import acm.program.*;
import acm.util.*;

import java.awt.*;


public class Hangman extends ConsoleProgram {
	
	private HangmanCanvas canvas;
	private RandomGenerator rgen = RandomGenerator.getInstance(); 
	private HangmanLexicon Dict;
	private boolean gameOver;
	private int guessNum;
	private char inpChar;
	private String word;
	private String xword;
	private String inp;
    
    public void init() {
    	canvas = new HangmanCanvas();
    	add(canvas);
    	}

    public void run() {
    	setFont("arial-bold-18");
    	setupDict();
    	gameSequence();
    	
	}
    
    private void gameSequence() {
    	setupGame();
    	canvas.shoW(word); //test
    	runGame();
    }
    
    private void setupDict() {
    	Dict = new HangmanLexicon();
    }
    
    private void setupGame() {
    	canvas.reset();
    	gameOver = false;
    	xword = "";
    	guessNum = 8;
    	int rNum = rgen.nextInt(0, Dict.getWordCount() - 1);
    	word = Dict.getWord(rNum);
    	
    	for (int i = 0; i < word.length(); i++) {
    		xword = xword + "-";
    	}
    	
    	println("Welcome to Hangman");
    }
    
    private void runGame() {
    	while (!gameOver) {
    	println("Word: " + xword);
    	canvas.displayWord(xword);
    	userInput();
    	checkInput();
    	checkGameOver();
    	}
    }
    
    private void userInput() {
    	inp = readLine("Pick one letter: ");
    	if (inp.length() != 1) {
    		userInput();
    		}
    	inpChar = inp.charAt(0);
    	if (inpChar < 'A' || inpChar > 'z') {
    		userInput();
    	}
    }
    
    private void checkInput() {
    	char inpCharUp = Character.toUpperCase(inpChar);
    	char inpCharLow = Character.toLowerCase(inpChar);
   	    	
    	if (xword.indexOf(inpCharUp) == -1) {
    		if (word.indexOf(inpCharUp) != -1 || word.indexOf(inpCharLow) != -1) {
    			for (int i = 0; i < word.length(); i++) {
    				if (word.charAt(i) == inpCharUp || word.charAt(i) == inpCharLow){
    					xword = xword.substring(0, i) + word.charAt(i) + xword.substring(i+1);
    				}
    			}
        	}else {
        		guessNum -= 1;
            	println("There are no "+ inpCharUp +"'s in this word");
            	if (guessNum > 0) {
            		println("You have "+ guessNum +" attempts left");
            	}
            }
    	}
       	
    }
    
    private void checkGameOver() {
    			if (xword.indexOf('-') != -1 && guessNum == 0){
    				gameOver = true;
    				gameBadEnd();
    			} else if (xword.indexOf('-') == -1) {
    				canvas.displayWord(word);
    				gameOver = true;
    				gameGoodEnd();
    		}
    	
    }

    
    private void gameBadEnd() {
    	println("");
    	println("You haven't guessed the word "+ word);
    	println("I'm sorry, you have to share the fate of Selma Jezkova");
    	playAgain();
    }
    
    
    private void gameGoodEnd() {
    	println("");
    	println("Yes, the word is " + xword);
    	println("You can live a little bit longer");
    	playAgain();
    }    	
    private void playAgain() {
    	println("");
    	println("");
    	String yn = readLine("Press any key to play again? y/n ");
    	if (yn.charAt(0) == 'y') {
    		gameSequence();
    	}else if (yn.charAt(0) == 'n') {
    		println("Rest in peace");
    	}else {
    		playAgain();
    	}
    }

}