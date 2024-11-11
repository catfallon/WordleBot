package com.wordlebot;

import com.wordlebot.input.HumanInputProvider;

public class WordleUser {
//TODO: make class
//TODO: could implement hard mode

public static void main(String[] args) {
    HumanInputProvider in = new HumanInputProvider();
    WordleGame.play(in);

    in.close();
}
}