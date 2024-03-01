package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Dev.Dice;
import Dev.DiceFace;

public class TestDice {

	@Test
	public void testRandom() {
		
		//Given
		int[] result = new int[100];
		
		//When
		for (int i = 0; i < result.length ; i++) {
			result[i] = (int)(Math.random()*6+1);
		}
		
		//Then
		assertEquals(Arrays.stream(result).min().getAsInt(), 1);

	}
	

	
}
