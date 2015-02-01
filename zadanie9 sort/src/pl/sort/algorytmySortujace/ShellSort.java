package pl.sort.algorytmySortujace;

import pl.sort.Sort;

public class ShellSort implements Sort {

	public int[] sort(int[] array) {
		int h = 1;
		while (h < array.length)
			h = 3 * h + 1;
		while (h > 0) {
			h = h / 3;
			for (int k = 0; k < h; k++) {
				for (int i = h + k; i < array.length; i += h) {
					int key = array[i];
					int j = i - h;
					while (j >= 0 && array[j] > key) {
						array[j + h] = array[j];
						j -= h;
					}
					array[j + h] = key;
					// -> invariant: array[0,h,2*h..j] is sorted
				}
			}
			// ->invariant: each h-sub-array is sorted
		}
		return array;
	};
}
