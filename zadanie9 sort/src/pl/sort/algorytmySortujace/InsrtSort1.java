package pl.sort.algorytmySortujace;

import pl.sort.Sort;

public class InsrtSort1 implements Sort {

	public int[] sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j;

			for (j = i - 1; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
		return a;
	}

}
