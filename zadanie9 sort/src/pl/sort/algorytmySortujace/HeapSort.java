package pl.sort.algorytmySortujace;

import pl.sort.Sort;

public class HeapSort implements Sort {

	public static int heapSize;

	public int[] sort(int[] a) {

		buildMaxHeap(a);

		for (int i = a.length - 1; i >= 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			heapSize = heapSize - 1;
			maxHeapifi(a, 0);
		}
		return a;
	}

	public static void maxHeapifi(int[] a, int i) {
		int l = left(i);
		int r = right(i);
		int largestElementIndex = -1;
		if (l < heapSize && a[l] > a[i]) {
			largestElementIndex = l;
		} else {
			largestElementIndex = i;
		}

		if (r < heapSize && a[r] > a[largestElementIndex]) {
			largestElementIndex = r;
		}
		if (largestElementIndex != i) {
			int temp = a[i];
			a[i] = a[largestElementIndex];
			a[largestElementIndex] = temp;

			maxHeapifi(a, largestElementIndex);
		}
	}

	public static void buildMaxHeap(int[] a) {
		heapSize = a.length;
		for (int i = a.length / 2; i >= 0; i--) {
			maxHeapifi(a, i);
		}
	}

	public static int right(int i) {
		return 2 * i + 2;
	}

	public static int left(int i) {
		return 2 * i + 1;
	}
}
