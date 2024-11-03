package com.wordlebot;
/*
 * A class that keeps count of many different letters and how many times 
 * the letter appears in each possible position in wordle
 * 
 * int[] counts stores the amount of times the letter appears in that position in the wordle word
 * for example, if the letter appears in the first position of a wordle word 50 times,
 * then count[0] = 50
 */
public class Letter {
    public char letter;
    int[] counts; //stores the amount of times the letter appears in that position in the wordle word

    public Letter(char letter) {
        this.letter = letter;
        for (int i = 0; i < 5; i++) {
            this.counts[i] = 0;
        }
    }

    /** 
     * Returns the character the Letter is associated with
     * @return char
     */
    public char getChar() {
        return this.letter;
    }

    /** 
     * sets the character the Letter is associated with
     * @param letter new char to be associated with the letter
     */
    public void setChar(char letter) {
        this.letter = letter;
    }

    /** 
     * returns each count associated with the Letter
     * @return int[] the array of all countes for the letter's positions
     */
    public int[] getCounts() {
        return this.counts;
    }

    /** 
     * sets the arraylist of counts associated with the letter
     * @param counts
     */
    public void setCounts(int[] counts) {
        this.counts = counts;
    }

    /** 
     * returns the count associated with the given position.
     * The index should be the position or tile in which to find the count
     * @param index which count to return
     * @return int the count 
     */
    public int getCountFromIndex(int index) {
        return this.counts[index];
    }

    /** 
     * sets the count in counts to a new given int
     * @param index which index of count to set
     * @param count what to set the new count to
     */
    public void setCountFromIndex(int index, int count) {
        this.counts[index] = count;
    }

    /*
     * Increases the count found with index by 1
     * @param index the index of the count to increment
     */
    public void incrementCount(int index) {
        this.counts[index] = this.counts[index] + 1;
    }
}
