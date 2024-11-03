package com.wordlebot;

import java.util.ArrayList;

public class WordleBot {

    /*
     * A method that iterates through an ArrayList of Letters to
     * find one that has the given character
     * @param ch the character that represents the Letter to be found
     * @param letters the ArrayList of Letters to search through
     * @return Letter the letter associated with the given character
     */
    public static Letter findLetter(char ch, ArrayList<Letter> letters) {
        Letter le = new Letter('1')
        for (int i = 0; i < letters.size(); i++) {
            if (letters.get(i).getChar() == ch) {
                le = letters.get(i);
            }
        }
        return le;
    }


    public static void analyzeGuesses(ArrayList<String> answers) {
        
        ArrayList<Character> lettersArrList = WordleGame.createCharArray();
        ArrayList<Letter> letters = new ArrayList<Letter>();

        for (int i = 0; i < lettersArrList.size(); i++) {
            letters.add(new Letter(lettersArrList.get(i)));
        }
        ArrayList<Letter> maxes = new ArrayList<Letter>(5); 
        //should store the letter that appears most in each position
        for (int j = 0; j < answers.size(); j++) {
            String word = answers.get(j);
            for (int k = 0; k < word.length(); k++) {
                char ch = word.charAt(k);
                
                Letter l = findLetter(ch, letters);
                l.incrementCount(k);
                if (l.getCountFromIndex(k) > maxes.get(k).getCountFromIndex(k)) {
                    maxes.set(k, l); 
                }

            }
        }

    }

    public static void main(String[] args) {
        ArrayList<String> answers = WordleGame.getAnswers("answers.txt");

    }
}
