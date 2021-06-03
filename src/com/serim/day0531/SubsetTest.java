package com.serim.day0531;

public class SubsetTest {

	static int K = 5;
	static int[] visited;

	public static void main(String[] args) {
		visited = new int[K];
		subset(0);
	}

	private static void subset(int start) {
		for (int i = start; i < K; i++) {
			if (visited[i] == 1) {// 뽑았던 숫자면 지나가
				continue;
			}
			visited[i] = 1;
			for(int v = 0;v<K;v++){
				System.out.print(visited[v]+" ");
			}System.out.println();
			subset(i + 1);
			visited[i] = 0;
		}
		System.out.println("");

	}

}
