package com.serim.day0531;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Compare {
	private static class Point implements Comparable<Point> {
		private int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Point o) {
			int res = this.y - o.y;
			return res;
		}

		// @Override
		// public int compareTo(Point o) {
		// if (this.y > o.y) {
		// return 1;
		// } else if (this.x == o.x) {
		// return 1;
		// }
		// // return this.y - o.y;
		// return -1;
		// }

	}

	private static class Point2 implements Comparator<Point2> {

		int y, x;

		public Point2(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compare(Point2 o1, Point2 o2) {
			return Integer.compare(o1.hashCode(), o2.hashCode());
		}

	}

	public static void main(String[] args) {
		List<Point> pList = new ArrayList<>();
		pList.add(new Point(2, 1));
		Collections.sort(pList);
		
		
		
//		Point2 p2 = new Point2(4, 3);

	}
}
