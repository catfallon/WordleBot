package com.wordlebot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class WordleTest 
{
    /**
     * Rigorous Test :-)
     */
	//TODO: delete this method
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
	public void testCheckGreensAll() {
		ArrayList<Color> correct = new ArrayList<Color>();
		for (int i = 0; i < 5; i++) {
			correct.add(Color.GREEN);
		}
		ArrayList<Color> result = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		WordleGame.checkGreens("lunar", "lunar", result);
		assertEquals(result, correct);
	}
	
	@Test
	public void testCheckGreensThree() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GREEN);
		ArrayList<Color> test = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		WordleGame.checkGreens("loner", "lunar", test);
		assertEquals(correct, test);
	}
	
	@Test
	public void testCheckMultiples3() {
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.add(0);
		correct.add(2);
		correct.add(3);
		ArrayList<Integer> test = WordleGame.checkMultiples('s', "sassy");
		assertEquals(correct, test);
	}
	
	@Test
	public void testCheckMultiples0() {
		ArrayList<Integer> correct = new ArrayList<Integer>();
		ArrayList<Integer> test = WordleGame.checkMultiples('e', "sassy");
		assertEquals(correct, test);
	}
	
	@Test
	public void testCheckMultiples1() {
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.add(1);
		ArrayList<Integer> test = WordleGame.checkMultiples('a', "sassy");
		assertEquals(correct, test);
	}
	
	@Test
	public void testCheckMultiples5() {
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
	public void testCheckYellows() {
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
	public void testCheckYellows0() {
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
	public void testCheckYellows5() {
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
	
	@Test
	public void testCheckYellowsWithGreens() {
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
	public void testCheckYellowsWithGreensInBoth() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GREEN);
		correct.add(Color.GREEN);
		ArrayList<Color> test = new ArrayList<Color>(Collections.nCopies(5, Color.GRAY));
		test.set(0, Color.GREEN);
		test.set(1, Color.GREEN);
		test.set(3, Color.GREEN);
		test.set(4, Color.GREEN);
		WordleGame.checkYellows("parer", "paler", test);
		assertEquals(correct, test);
	}
	
	@Test
	public void testCheckGuess() {
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
	public void testCheckGuessMultiples() {
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
	public void testCheckGuessMultiplesInOrder() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.YELLOW);
		correct.add(Color.YELLOW);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.YELLOW);
		ArrayList<Color> test = WordleGame.checkGuess("omnim", "mommy"); //its not an actual word but its ok
		assertEquals(correct, test);
	}
	
	@Test
	public void testCheckGuessMultiplesInDiffOrder() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.YELLOW);
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.YELLOW);
		ArrayList<Color> test = WordleGame.checkGuess("mymim", "mommy"); //its not an actual word but its ok
		assertEquals(correct, test);
	}
	
	@Test
	public void testCheckGuessMultiples1() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		ArrayList<Color> test = WordleGame.checkGuess("scoob", "scrap");
		assertEquals(correct, test);
	}
	
	/*
	 * Made this test because I thought running the program one time
	 * produced a wrong result but it works fine with this test
	 * Should probably investigate if something else messed things up
	 * but I also easily could have gotten confused and it actually works fine
	 */
	@Test
	public void testCheckGuessStareJerky() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.GRAY);
		correct.add(Color.YELLOW);
		correct.add(Color.YELLOW);
		ArrayList<Color> test = WordleGame.checkGuess("stare", "jerky");
		assertEquals(correct, test);
	}

	//TODO: this fails
	@Test
	public void testCheckGuessParer() {
		ArrayList<Color> correct = new ArrayList<Color>();
		correct.add(Color.GREEN);
		correct.add(Color.GREEN);
		correct.add(Color.GRAY);
		correct.add(Color.GREEN);
		correct.add(Color.GREEN);
		ArrayList<Color> test = WordleGame.checkGuess("parer", "paler");
		assertEquals(correct, test);
	}

	@Test
	public void testFindLetter() {
		Letter correct = new Letter('s');
		ArrayList<Letter> letters = WordleBot.createCharArrayList(); //test depends on this working correctly, maybe change that
		Letter test = WordleBot.findLetter('s', letters);
		assertEquals(correct.getChar(), test.getChar());
		//TODO: I probably need to write like an equals method for Letter
	}

	//TODO: fix, only doing literal equals, not actual equals
	@Test
	public void testFindLetter2() {
		Letter correct = new Letter('s');
		ArrayList<Letter> letters = WordleBot.createCharArrayList(); //test depends on this working correctly, maybe change that
		Letter test = WordleBot.findLetter('s', letters);
		assertEquals(correct, test);
	}
}
