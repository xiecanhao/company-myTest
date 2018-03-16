package mytest;

import java.util.Arrays;

public class SortTest {
	public static int quickSort(int[] aa, int start, int end) {
		int base = aa[end];
		while (start < end) {
			while (start < end && aa[start] <= base) {
				start++;
			}
			if (start < end) {
				int temp = aa[start];
				aa[start] = aa[end];
				aa[end] = temp;
			}
			while (start < end && aa[end] >= base) {
				end--;
			}
			if (start < end) {
				int temp = aa[start];
				aa[start] = aa[end];
				aa[end] = temp;
			}
		}
		return start;
	}

	public static void quickSort2(int[] aa, int start, int end) {
		if (start > end)
			return;
		else {
			int parinit = quickSort(aa, start, end);
			quickSort2(aa, start, parinit - 1);
			quickSort2(aa, parinit + 1, end);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		quickSort2(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
