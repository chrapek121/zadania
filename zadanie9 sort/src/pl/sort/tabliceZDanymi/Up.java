package pl.sort.tabliceZDanymi;

import pl.sort.ListGenerator;

public class Up implements ListGenerator {

	public int[] generator() {
		int[] u = new int[5000];

		for (int i = 0; i < u.length; i++) {
			u[i] = i;
		}

		return u;
	}
}
