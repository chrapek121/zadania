package pl.sort.algorytmySortujace;

import pl.sort.Sort;

public class SelectSort implements Sort {

	public int[] sort(int[] a) {
		int i, j, minIndex, tmp;
		int n = a.length;
		for (i = 0; i < n - 1; i++) {
			minIndex = i;
			for (j = i + 1; j < n; j++)
				if (a[j] < a[minIndex])
					minIndex = j;
			if (minIndex != i) {
				tmp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = tmp;
			}
		}
		return a;
	}
}
