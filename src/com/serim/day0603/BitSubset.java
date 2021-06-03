package com.serim.day0603;

public class BitSubset {

	public static void main(String[] args) {
		int n = 3;
		int[] arr = { 1, 2, 3 };
		for (int i = 0; i < 1 << n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) != 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
