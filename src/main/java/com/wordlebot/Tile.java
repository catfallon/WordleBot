package com.wordlebot;

import java.util.Set;

public class Tile {
    public int number;
	public Set<Character> possibilities;
	public Set<Character> eliminated;
	
	public Tile(int position) {
		number = position;
	}
	
	
	
}
