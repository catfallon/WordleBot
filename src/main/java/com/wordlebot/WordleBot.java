package com.wordlebot;

import java.util.ArrayList;
import java.util.Set;

public class WordleBot {

    public static void analyzeGuesses(ArrayList<String> answers) {
        
        ArrayList<Character> lettersArrList = WordleGame.createCharArray();
        ArrayList<Letter> letters = new ArrayList<Letter>();
        //Set<Letter> letters = new Set<Letter>();

        for (int i = 0; i < lettersArrList.size(); i++) {
            letters.add(new Letter(lettersArrList.get(i)));
        }
        for (int j = 0; j < answers.size(); j++) {
            String word = answers.get(j);
            for (int k = 0; k < word.length(); k++) {
                char ch = word.charAt(k);
                Letter l = letters.get(letters.indexOf(ch));
                //TODO: this isnt working I think I need to make a function 
                //that searches an ArrayList of letters and returns that letter
                //or maybe im too married to arraylists in this project
                //there must be some library that does that already

            }
        }

    }

    public static void main(String[] args) {
        ArrayList<String> answers = WordleGame.getAnswers("answers.txt");

    }
}
