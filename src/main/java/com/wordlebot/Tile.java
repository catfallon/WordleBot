package com.wordlebot;

import java.util.ArrayList;

/*
 * A class that is meant to represent each letter position in the Wordle word.
 * Each tile corresponds to a certain letter of the five-letter word,
 * for 5 total tiles.
 */

public class Tile {
    public int number;
	public ArrayList<Character> possibilities;
	public ArrayList<Character> eliminated;
	
	public Tile(int position) {
		this.number = position;
        this.possibilities = WordleGame.createCharArray();
        this.eliminated = new ArrayList<Character>();
	}
    
    /** 
     * @return int
     */
    public int getNumber() {
        return this.number;
    }

    
    /** 
     * @param num
     */
    public void setNumber(int num) {
        this.number = num;
    }

    
    /** 
     * @return ArrayList<Character>
     */
    public ArrayList<Character> getPossibilities() {
        return this.possibilities;
    }

    
    /** 
     * @param newPossibilities
     */
    public void setPossibilities (ArrayList<Character> newPossibilities) {
        this.possibilities = newPossibilities;
    }

    public ArrayList<Character> getEliminated() {
        return this.eliminated;
    }

    public void setEliminated (ArrayList<Character> newEliminated) {
        this.possibilities = newEliminated;
    }

    public void eliminate(char ch) {
        this.eliminated.add(ch);
        this.possibilities.remove(ch);
    }
    //TODO: finish all other functions for this class or
    //get rid of it if unneeded
	
	
	
}
