package com.wordlebot;

import com.wordlebot.input.HumanInputProvider;

public class WordleUser {
//TODO: make class
//TODO: could implement hard mode

public static void main(String[] args) {
    HumanInputProvider in = new HumanInputProvider();
    boolean lost = WordleGame.play(in);
    if (lost) {
        System.out.println("Better luck next time!");
    }
    in.close();
}
}