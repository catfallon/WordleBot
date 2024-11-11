package com.wordlebot.input;

import java.util.Scanner;

public class HumanInputProvider implements InputProvider {
    private Scanner scn = new Scanner(System.in);

    public HumanInputProvider() {
        this.scn = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        System.out.print("Enter input: ");
        return scn.nextLine();
    }

    public void close() {
        scn.close();
    }
}
