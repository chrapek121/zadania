package pl.sort.algorytmySortujace;

import pl.sort.Sort;

public class InsrtSort2 implements Sort {

	public int[] sort(int[] a) {
		int i, j, newValue;
		for (i = 1; i < a.length; i++) {
			newValue = a[i];
			j = i;
			while (j > 0 && a[j - 1] > newValue) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = newValue;
		}
		return a;
	}
}
