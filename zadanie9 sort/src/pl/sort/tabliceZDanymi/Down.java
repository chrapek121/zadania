package pl.sort.tabliceZDanymi;

import pl.sort.ListGenerator;

public class Down implements ListGenerator {

	private static int[] generatedList;

	public int[] generator() {
		if (generatedList == null) {
			generatedList = make();
		}

		return generatedList;
	}

	private int[] make() {
		int[] down = new int[5000];

		for (int i = 0; i < down.length; i++) {
			down[i] = 4999 - i;
		}

		int[] generatedList = down;
		return generatedList;
	}
}
