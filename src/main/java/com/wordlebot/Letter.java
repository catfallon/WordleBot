package com.wordlebot;
/*
 * A class that keeps count of many different letters and how many times 
 * the letter appears in each possible position in wordle
 */
public class Letter {
    public char letter;
    int[] counts;

    public Letter(char letter) {
        this.letter = letter;
        for (int i = 0; i < 5; i++) {
            counts[i] = 0;
        }
    }
//TODO: Finish all the other functions for Letter class
}
