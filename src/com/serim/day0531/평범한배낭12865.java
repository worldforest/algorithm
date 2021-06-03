package com.serim.day0531;

import java.util.Scanner;

public class 평범한배낭12865 {
	static int N, K;
	static int[][] bag;
	static boolean[] visited;
	static int temp = 0, answer = 0, ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		bag = new int[N][2];
		for (int n = 0; n < N; n++) {
			bag[n][0] = sc.nextInt();// W 무게
			bag[n][1] = sc.nextInt();// V 가치
		}
		visited = new boolean[N];
		// subset(0);
		powerset(N);
//		System.out.println(">>" + answer);
		System.out.println(answer);

	}

	private static void powerset(int start) {
		for (int i = 0; i < 1 << start; i++) {
			for (int j = 0; j < start; j++) {
				if ((i & 1 << j) != 0) {
					temp += bag[j][0];
//					System.out.println(j + " " + "temp : " + temp);
					// if(temp>K){
					// break;
					// }
					if (temp <= K) {
						visited[j] = true;
						ans += bag[j][1];
					} else {
						visited = new boolean[N];
						temp = 0;
						ans = 0;
						break;
					}
//					System.out.println("j : " + j + " ans : " + ans);
					// System.out.print(bag[j][0] + " " + bag[j][1] + " ");
				}
			}
//			System.out.println();
			answer = answer > ans ? answer : ans;
		}
	}

	private static void subset(int start) {
		// if ((temp + bag[start][0]) >= K || start == N) {
		// return;
		// }
		if ((temp + bag[start][0]) <= K || start == N - 1) {
			int ans = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					ans += bag[i][1];
				}
			}
			answer = ans > answer ? ans : answer;

			return;
		}
		visited[start] = false;
		subset(start + 1);
		visited[start] = true;
		temp += bag[start][0];
		subset(start + 1);
		// for (int i = start; i < N; i++) {
		// if (visited[i]) {
		// continue;
		// }
		// if ((temp + bag[start][0]) >= K) {
		// continue;
		// }
		// visited[i] = true;
		// temp += bag[i][0];
		// System.out.println(temp);
		// subset(i + 1);
		// visited[i] = false;
		// subset(i + 1);
		// temp -= bag[i][0];
		// }
	}
}
/*
 * 4 7 6 13 4 8 3 6 5 12
 */