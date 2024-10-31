
/**
 * 
 */
package com.wordlebot;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 
 */
public class WordleGame {
	
	/*
	 * Returns an arraylist of strings from a file
	 * 
	 * @param fileName the name of the file to retrieve strings from
	 * @return an arraylist of each line of the file
	 */
	public static ArrayList<String> getAnswers(String fileName) {
		ArrayList<String> answers = new ArrayList<String>();
		try {
			File answersFile = new File(fileName);
			Scanner myScanner = new Scanner(answersFile);
			while (myScanner.hasNextLine()) {
				answers.add(myScanner.nextLine());
			}
			System.out.println(answers);
			myScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, please use a file called answers.txt");
		}
		return answers;
	}
	
	/*
	 * Takes an arraylist of Strings and returns one randomly
	 * 
	 * @param answerList an arraylist of strings
	 * @return String a randomly selected string
	 */
	public static String pickAnswer(ArrayList<String> answerList) {
		Random rand = new Random();
		int randIndex = rand.nextInt(answerList.size());
		return answerList.get(randIndex);
	}
	
	public static ArrayList<Character> createCharArray() {
		ArrayList<Character> arrLi = new ArrayList<Character>();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < alphabet.length; i++) {
			arrLi.add(alphabet[i]);
		}
		return arrLi;
	}

	
	public static ArrayList<Integer> checkMultiples(char ch, String guess) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < guess.length(); i++) {
			if (ch == guess.charAt(i)) {
				arr.add(i);
			}
		}
		return arr;
	}
	
	/*
	 * A method that checks against the edge case where a guess contains multiple of the same letter
	 * @param ch the character to check if it's in answer multiple times
	 * @param the String to check if the ch is in twice
	 * @param arr an array of the letters in the answer
	 */
	public static void checkYellows(String guess, String answer, ArrayList<Color> result) {
		for (int i = 0; i < guess.length(); i++) {
			ArrayList<Integer> indicesInGuess = checkMultiples(guess.charAt(i), guess);
			ArrayList<Integer> indicesInAnswer = checkMultiples(guess.charAt(i), answer);
			while ((indicesInGuess.size() > 0) && (indicesInAnswer.size() > 0)) {
				if (answer.indexOf(guess.charAt(i)) >= 0) { //if character of guess is in answer
					if (result.get(indicesInGuess.get(0)) != Color.GREEN) {
						result.set(indicesInGuess.get(0), Color.YELLOW);
					}
				}
				indicesInGuess.remove(0);
				indicesInAnswer.remove(0);
			}
		}
	}
	
	/*
	 * A method that checks if any character in a guess matches the position of the character in answer
	 * @param answer the String that is being checked against
	 * @param guess the String a user has guessed
	 * @param result the resulting representation of how answer and guess compare
	 */
	public static void checkGreens(String guess, String answer, ArrayList<Color> result) {
		for (int i = 0; i < guess.length(); i++) {
			if (answer.charAt(i) == guess.charAt(i)) {
				result.set(i, Color.GREEN);
			}
		}
	}
	
	/*
	 * Compares String guess to String answer and returns an ArrayList of colors to signal comparison
	 * 
	 * @param guess the String the user entered as their guess
	 * @param answer the String the user is trying to figure out
	 * @return an ArrayList where each color indicates info about the guess as compared to the answer
	 */
	public static ArrayList<Color> checkGuess(String guess, String answer) {
		ArrayList<Color> result = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		checkGreens(guess, answer, result);
		checkYellows(guess, answer, result);
		return result;
	}
	
	public static void printWinMessage(int guessCount) {
		System.out.print("Congratulations! You got the word in " 
				+ guessCount);
		if (guessCount == 1) {
			System.out.print(" guess!");
		} else {
			System.out.print(" guesses!");
		}
		System.out.println();
	}
	
	public static Boolean checkResult(ArrayList<Color> result, int guessCount) {
		Boolean stillPlaying = true;
		int correctCount = 0;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) == Color.GREEN) {
				correctCount++;
			}
		}
		if (correctCount == result.size()) {
			stillPlaying = false;
			printWinMessage(guessCount);
			
		}
		return stillPlaying;
	}
	
	
	/**
	 * planning okay basically i could tie the positions to its options or tie the 
	 * characters to like some sort of option if that makes sense
	 * @param args
	 */
	public static void play() {
		Scanner in = new Scanner(System.in);
		ArrayList<String> answerList = getAnswers("answers.txt");
		String answer = pickAnswer(answerList);
		//ArrayList<Character> charsLeft = createCharArray();
		//have a class for gray, yellow, and green?
		//System.out.println("Answer is " + answer); //TODO: debugging; delete
		int guessCount = 0;
		Boolean stillPlaying = true;
		while (stillPlaying && (guessCount < 6)) {
			System.out.print("Enter guess: ");
			String guess = in.next();
			//TODO: probably check if the guess is valid
			//TODO: could make a thing where it forces you to play hard mode and/or displays what
			//letters you have left
			guessCount++;
			guess = guess.trim().toLowerCase();
			System.out.println("Guess is " + guess); //TODO: debugging; delete
			
			ArrayList<Color> result = checkGuess(guess, answer);
			
			System.out.println(result);
			System.out.println();
			stillPlaying = checkResult(result, guessCount);

		}
		if ((guessCount == 6) && stillPlaying) {
			System.out.println("Brutal!\nYou have lost.\n");
		}
		in.close();
	}
	

}
