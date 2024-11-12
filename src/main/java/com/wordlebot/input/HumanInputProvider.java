package com.wordlebot.input;

import java.util.Scanner;

public class HumanInputProvider implements InputProvider {
    private Scanner scn = new Scanner(System.in);

    public HumanInputProvider() {
        this.scn = new Scanner(System.in);
    }

    
    public String getHardModeInput() {
        System.out.println("Would you like to play hard mode? Y/N");
        return scn.nextLine();
    }

    @Override
    public String getInput() {
        System.out.print("Enter a guess: ");
        return scn.nextLine();
    }

    public void close() {
        scn.close();
    }
}
