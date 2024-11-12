package com.wordlebot.input;

public class BotInputProvider implements InputProvider {
    private String input;

    public BotInputProvider(String input) {
        this.input = input;
    }
    
    public void setInput(String input) {
        this.input = input;
    }
    
    @Override
    public String getHardModeInput() {
        return this.input;
    }

    @Override
    public String getInput() {
        return this.input;
    }


    // may be inefficient but needed to be able to put a close method in the HumanInputProvider class
    public void close() {    }
}
