package com.wordlebot.input;

public interface InputProvider {
    String getHardModeInput();
    String getInput();
    void close();
}
