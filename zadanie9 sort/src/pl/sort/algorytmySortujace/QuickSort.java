package pl.sort.algorytmySortujace;

import pl.sort.Sort;

public class QuickSort implements Sort {

	public int[] sort(int[] a) {

		int[] arraySort = a;
		int x = 0;
		int y = 4999;

		quickSort(arraySort, x, y);

		return arraySort;
	}

	private static void quickSort(int tablica[], int x, int y) {

		int i, j, v, temp;

		i = x;
		j = y;
		v = tablica[(x + y) / 2];
		do {
			while (tablica[i] < v)
				i++;
			while (v < tablica[j])
				j--;
			if (i <= j) {
				temp = tablica[i];
				tablica[i] = tablica[j];
				tablica[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		if (x < j)
			quickSort(tablica, x, j);
		if (i < y)
			quickSort(tablica, i, y);
	}
}
