package com.wordlebot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
	void testCheckGreensAll() {
		ArrayList<Color> correct = new ArrayList<Color>();
		for (int i = 0; i < 5; i++) {
			correct.add(Color.GREEN);
		}
		ArrayList<Color> result = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		WordleGame.checkGreens("lunar", "lunar", result);
		assertEquals(result, correct);
	}
	
	@Test
	void testCheckGreensThree() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GREEN);
		ArrayList<Color> result = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		WordleGame.checkGreens("loner", "lunar", result);
		assertEquals(result, correct);
	}
	
	@Test
	void testCheckMultiples3() {
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.add(0);
		correct.add(2);
		correct.add(3);
		ArrayList<Integer> test = WordleGame.checkMultiples('s', "sassy");
		assertEquals(correct, test);
	}
	
	@Test
	void testCheckMultiples0() {
		ArrayList<Integer> correct = new ArrayList<Integer>();
		ArrayList<Integer> test = WordleGame.checkMultiples('e', "sassy");
		assertEquals(correct, test);
	}
	
	@Test
	void testCheckMultiples1() {
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.add(1);
		ArrayList<Integer> test = WordleGame.checkMultiples('a', "sassy");
		assertEquals(correct, test);
	}
	
	@Test
	void testCheckMultiples5() {
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.add(0);
		correct.add(1);
		correct.add(2);
		correct.add(3);
		correct.add(4);
		ArrayList<Integer> test = WordleGame.checkMultiples('p', "ppppp");
		assertEquals(correct, test);
	}
	
	@Test
	void testCheckYellows() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.YELLOW);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.YELLOW);
		correct.add(Color.GRAY);
		ArrayList<Color> test = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		WordleGame.checkYellows("stare", "spork", test);
		assertEquals(correct, test);
	}
	
	@Test
	void testCheckYellows0() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		ArrayList<Color> test = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		WordleGame.checkYellows("beach", "spork", test);
		assertEquals(correct, test);
	}
	
	@Test
	void testCheckYellows5() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.YELLOW);
		correct.add(Color.YELLOW);
		correct.add(Color.YELLOW);
		correct.add(Color.YELLOW);
		correct.add(Color.YELLOW);
		ArrayList<Color> test = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		WordleGame.checkYellows("mater", "tamer", test);
		assertEquals(correct, test);
	}
	
	//TODO: make this one with greens already in both arraylists
	@Test
	void testCheckYellowsWithGreens() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.GREEN);
		correct.add(Color.YELLOW);
		ArrayList<Color> test = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		test.set(0, Color.GREEN);
		test.set(3, Color.GREEN);
		WordleGame.checkYellows("sharp", "spork", test);
		assertEquals(correct, test);
	}
	
	@Test
	void testCheckGuess() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.YELLOW);
		ArrayList<Color> test = WordleGame.checkGuess("minor", "mirth");
		assertEquals(correct, test);
	}
	
	@Test
	void testCheckGuessMultiples() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.YELLOW);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		ArrayList<Color> test = WordleGame.checkGuess("mommy", "minor");
		assertEquals(correct, test);
	}

	@Test
	void testCheckGuessMultiplesInOrder() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.YELLOW);
		correct.add(Color.YELLOW);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.YELLOW);
		ArrayList<Color> test = WordleGame.checkGuess("omnim", "mommy"); //its not an actual word but its ok
		assertEquals(test, correct);
	}
	
	@Test
	void testCheckGuessMultiplesInDiffOrder() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.YELLOW);
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.YELLOW);
		ArrayList<Color> test = WordleGame.checkGuess("mymim", "mommy"); //its not an actual word but its ok
		assertEquals(test, correct);
	}
	
	@Test
	void testCheckGuessMultiples1() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		ArrayList<Color> test = WordleGame.checkGuess("scoob", "scrap");
		assertEquals(test, correct);
	}
	
	@Test
	void testCheckGuessStareJerky() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.YELLOW);
		correct.add(Color.YELLOW);
		ArrayList<Color> test = WordleGame.checkGuess("stare", "jerky");
		assertEquals(test, correct);
	}
}
