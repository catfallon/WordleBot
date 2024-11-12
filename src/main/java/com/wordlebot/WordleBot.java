package com.wordlebot;

import java.util.ArrayList;

public class WordleBot {

    /*
     * A method that iterates through an ArrayList of Letters to
     * find one that has the given character
     * If the letter is not found, the method just returns a new Letter representing the char 1
     * 
     * @param ch the character that represents the Letter to be found
     * @param letters the ArrayList of Letters to search through
     * @return Letter the letter associated with the given character
     */
    
    public static Letter findLetter(char ch, ArrayList<Letter> letters) {
        Letter le = new Letter('1');
        int index = (((Character.getNumericValue(ch) - 10) / (Character.getNumericValue('z') - 10)) * letters.size()); 
        //finds approximately where the letter should be given that the ArrayList is
        //evenly ditributed amongst the alphabet
        while ((le.getChar() == '1') && (index < letters.size()) && (index >= 0)) {
            char leChar = letters.get(index).getChar();
            if (leChar == ch) {
                le = letters.get(index);
            }
            else if (leChar < ch) {
                index++;
            }
            else { //if leChar > ch
                index--;
            }
        }
        return le;
    }

    public static ArrayList<Letter> createCharArrayList() {
        ArrayList<Character> lettersArrList = WordleGame.createCharArray();
        ArrayList<Letter> letters = new ArrayList<Letter>();
        for (int i = 0; i < lettersArrList.size(); i++) {
            letters.add(new Letter(lettersArrList.get(i)));
        }
        return letters;
    }

    public static void analyzeGuesses(ArrayList<String> answers) {
        
        ArrayList<Letter> letters = createCharArrayList();
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
        WordleGame game = new WordleGame();
        //ALWAYS NEED TO SET INPUT BEFORE GETTING INPUT DO NOT FORGET
        System.out.println("a: " + Character.getNumericValue('a')
        + "\nb: " + Character.getNumericValue('b')
        + "\nz: " + Character.getNumericValue('z'));

        System.out.println("\n\na: " + Character.valueOf('a')
        + "\nb: " + Character.valueOf('b')
        + "\nz: " + Character.valueOf('z'));
    }
}
