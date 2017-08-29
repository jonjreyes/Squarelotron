package squarelotron;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {

	Squarelotron s_3;
	Squarelotron s_4;
	Squarelotron s_5;
	Squarelotron s_array_3;
	Squarelotron s_array_4;
	Squarelotron s_array_5;

	@Before
	public void setUp() throws Exception  {
		s_3 = new Squarelotron(3);
		s_4 = new Squarelotron(4);
		s_5 = new Squarelotron(5);
		int[] temp_3 = {1,2,3,4,5,6,7,8,9};
		int[] temp_4 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int[] temp_5 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		s_array_3 = new Squarelotron(temp_3);
		s_array_4 = new Squarelotron(temp_4);
		s_array_5 = new Squarelotron(temp_5);
	}

	//Testing that made Squarelotrons match the required format
	@Test
	public void testSquarelotron() {
		assertEquals(3, s_3.size);
		int[][] test_3 = {{1,2,3},{4,5,6},{7,8,9}};
		assertArrayEquals(test_3,s_3.squarelotron);
		assertArrayEquals(test_3,s_array_3.squarelotron);
		int[][] test_4 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		assertArrayEquals(test_4,s_4.squarelotron);
		assertArrayEquals(test_4,s_array_4.squarelotron);
		int[][] test_5 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		assertArrayEquals(test_5,s_5.squarelotron);
		assertArrayEquals(test_5,s_array_5.squarelotron);
	}


	@Test
	public void testUpsideDownFlip() {
		//3 by 3, flipping outer ring
		Squarelotron temp_3 = s_3.upsideDownFlip(1);
		int[][] test_3 = {{7,8,9},{4,5,6},{1,2,3}};
		assertArrayEquals(test_3,temp_3.squarelotron);
		// 4 by 4, flip inner ring
		int[][] test_4 = {{1,2,3,4},{5,10,11,8},{9,6,7,12},{13,14,15,16}};
		Squarelotron temp_4 = s_4.upsideDownFlip(2);
		assertArrayEquals(test_4,temp_4.squarelotron);
		// 4 by 4, flip outer ring
		int[][] test_4_1 = {{13,14,15,16},{9,6,7,12},{5,10,11,8},{1,2,3,4}};
		Squarelotron temp_4_1 = s_4.upsideDownFlip(1);
		assertArrayEquals(test_4_1,temp_4_1.squarelotron);
		// 5 by 5, flip the outer ring
		int[][] test_5 = {{21,22,23,24,25},{16,7,8,9,20},{11,12,13,14,15},{6,17,18,19,10},{1,2,3,4,5}};
		Squarelotron temp_5 = s_5.upsideDownFlip(1);
		assertArrayEquals(test_5,temp_5.squarelotron);
		// 5 by 5, flip the center
		int[][] test_5_1 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		Squarelotron temp_5_1 = s_5.upsideDownFlip(3);
		assertArrayEquals(test_5_1,temp_5_1.squarelotron);

	}

	@Test
	public void testMainDiagonalFlip() {
		//3 by 3 case
		Squarelotron temp_3 = s_3.mainDiagonalFlip(1);
		int[][] test_3 = {{1,4,7},{2,5,8},{3,6,9}};
		assertArrayEquals(test_3,temp_3.squarelotron);

		// 4 by 4, main diagonal flip of the outer ring
		int[][] test_4 = {{1,5,9,13},{2,6,7,14},{3,10,11,15},{4,8,12,16}};
		Squarelotron temp_4 = s_4.mainDiagonalFlip(1);
		assertArrayEquals(test_4,temp_4.squarelotron);
		// 4 by 4, but main diagonal flip of inner ring
		int[][] test_4_1 = {{1,2,3,4},{5,6,10,8},{9,7,11,12},{13,14,15,16}};
		Squarelotron temp_4_1 = s_4.mainDiagonalFlip(2);
		assertArrayEquals(test_4_1,temp_4_1.squarelotron);

		// 5 by 5, flip the outer ring
		int[][] test_5 = {{1,6,11,16,21},{2,7,8,9,22},{3,12,13,14,23},{4,17,18,19,24},{5,10,15,20,25}};
		Squarelotron temp_5 = s_5.mainDiagonalFlip(1);
		assertArrayEquals(test_5,temp_5.squarelotron);
		// 5 by 5, flip the middle ring
		int[][] test_5_1 = {{1,2,3,4,5},{6,7,12,17,10},{11,8,13,18,15},{16,9,14,19,20},{21,22,23,24,25}};
		Squarelotron temp_5_1 = s_5.mainDiagonalFlip(2);
		assertArrayEquals(test_5_1,temp_5_1.squarelotron);
		// 5 by 5, flip the center
		int[][] test_5_2 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		Squarelotron temp_5_2 = s_5.mainDiagonalFlip(3);
		assertArrayEquals(test_5_2,temp_5_2.squarelotron);
	}

	@Test
	public void testRotateRight() {
		//test 3x3 case
		int[][] test_3 = {{1,2,3},{4,5,6},{7,8,9}}; 
		int[][] test_3_1 = {{7,4,1},{8,5,2},{9,6,3}}; 
		int[][] test_3_2 = {{9,8,7},{6,5,4},{3,2,1}}; 
		int[][] test_3_3 = {{3,6,9},{2,5,8},{1,4,7}};
		// rotate 0 degrees and 720 degrees
		// should stay the same
		s_3.rotateRight(0);
		assertArrayEquals(test_3,s_3.squarelotron);
		s_3.rotateRight(8);
		assertArrayEquals(test_3,s_3.squarelotron);
		// rotate to the right 90 degrees
		s_3.rotateRight(1);
		assertArrayEquals(test_3_1,s_3.squarelotron);
		// rotate to the left 90 degrees
		// back to original
		s_3.rotateRight(-1);
		assertArrayEquals(test_3,s_3.squarelotron);
		// rotate to the right 180 degrees
		s_3.rotateRight(2);
		assertArrayEquals(test_3_2,s_3.squarelotron);
		// rotate to the left 180 degrees
		// back to original
		s_3.rotateRight(-2);
		assertArrayEquals(test_3,s_3.squarelotron);
		// rotate to the right 270 degrees
		s_3.rotateRight(3);
		assertArrayEquals(test_3_3,s_3.squarelotron);
		// rotate to the left 270 degrees
		// back to original
		s_3.rotateRight(-3);
		assertArrayEquals(test_3,s_3.squarelotron);

		// test 4x4 case
		int[][] test_4 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}; 
		int[][] test_4_1 = {{13,9,5,1},{14,10,6,2},{15,11,7,3},{16,12,8,4}};
		int[][] test_4_2 = {{16,15,14,13},{12,11,10,9},{8,7,6,5},{4,3,2,1}};
		int[][] test_4_3 = {{4,8,12,16},{3,7,11,15},{2,6,10,14},{1,5,9,13}};
		// rotate 0 degrees and 720 degrees
		// should stay the same
		s_4.rotateRight(0);
		assertArrayEquals(test_4,s_4.squarelotron);
		s_4.rotateRight(8);
		assertArrayEquals(test_4,s_4.squarelotron);
		// rotate to the right 90 degrees
		s_4.rotateRight(1);
		assertArrayEquals(test_4_1,s_4.squarelotron);
		// rotate to the left 90 degrees
		// back to original
		s_4.rotateRight(-1);
		assertArrayEquals(test_4,s_4.squarelotron);
		// rotate to the right 180 degrees
		s_4.rotateRight(2);
		assertArrayEquals(test_4_2,s_4.squarelotron);
		// rotate to the left 180 degrees
		// back to original
		s_4.rotateRight(-2);
		assertArrayEquals(test_4,s_4.squarelotron);
		// rotate to the right 270 degrees
		s_4.rotateRight(3);
		assertArrayEquals(test_4_3,s_4.squarelotron);
		// rotate to the left 270 degrees
		// back to original
		s_4.rotateRight(-3);
		assertArrayEquals(test_4,s_4.squarelotron);
	}

}
