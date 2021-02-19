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
	
    RandomGenerator rgen = RandomGenerator.getInstance(); 
    HangmanLexicon Dict;
    boolean gameOver;
    int guessNum;
    char inpChar;
    String word;
    String xword = "";
    String inp;

    public void run() {
    	
    	setupDict();
    	setupGame();
    	println(word);
    	runGame();
    	
	}
    
    private void setupDict() {
    	Dict = new HangmanLexicon();
    }
    
    private void setupGame() {
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
            	println("You have "+ guessNum +" guesses left");
        	}
    	}
       	
    }
    
    private void checkGameOver() {
    			if (xword.indexOf('-') != -1 && guessNum == 0){
    				gameOver = true;
    				gameBadEnd();
    			}else if (xword.indexOf('-') == -1) {
    				gameOver = true;
    				gameGoodEnd();
    		}
    	
    }

    
    private void gameBadEnd() {
    	println("You haven't guessed the word "+ word);
    	println("You're DEAD!");
    }
    
    
    private void gameGoodEnd() {
    	println("Yes, the word is " + xword);
    	println("You can live a little bit longer");
    }    	

}
