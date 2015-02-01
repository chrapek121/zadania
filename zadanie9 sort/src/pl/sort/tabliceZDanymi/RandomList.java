package pl.sort.tabliceZDanymi;

import java.util.Random;

import pl.sort.ListGenerator;

public class RandomList implements ListGenerator {

	public int[] generator() {

		int[] rand = new int[5000];
		Random generator = new Random();

		for (int i = 0; i < rand.length; i++) {
			rand[i] = generator.nextInt(5000);
		}

		return rand;
	}
}
