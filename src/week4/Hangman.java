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
import java.io.FileNotFoundException;


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
    	try {
			setupDict();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	gameSequence();
    	
	}
    
    private void gameSequence() {
    	setupGame();
    	canvas.testG(word); //test
    	runGame();
    }
    
    private void setupDict() throws FileNotFoundException {
    	Dict = new HangmanLexicon();
    	Dict.openFile();
    }
   
    
    private void setupGame() {
    	canvas.reset();
    	gameOver = false;
    	xword = "";
    	guessNum = 8;
    	int rNum = rgen.nextInt(0, (Dict.getWordCount() - 1));
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
        		canvas.noteIncorrectGuess(inpCharUp, guessNum);
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
    	print("\n");
    	println("You haven't guessed the word "+ word);
    	println("I'm sorry, you have to share the fate of Selma Jezkova");
    	playAgain();
    }
    
    
    private void gameGoodEnd() {
    	print("\n");
    	println("Yes, the word is " + xword);
    	println("You can live a little bit longer");
    	playAgain();
    }    	
    private void playAgain() {
    	print("\n\n");
    	String yn = readLine("Play again? y/n ");
    	if (yn.equals("")) {
    		playAgain();
    	}
    	else if (yn.charAt(0) == 'y' || yn.charAt(0) == 'Y') {
    		gameSequence();
    	}else if (yn.charAt(0) == 'n' || yn.charAt(0) == 'N') {
    		println("Rest in peace");
    	}
    	else {
    		playAgain();
    	}
    }

}
