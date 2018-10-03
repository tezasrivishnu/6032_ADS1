import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Merge merge = new Merge();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			merge.sort(tokens);
			System.out.println(merge.toString(tokens));
			System.out.println();
		}
	}
}
class Merge {
	Insertion insertion;
	Comparable[] aux;
	Merge() {
		insertion  = new Insertion();
	}
	public void sort(Comparable[] a) {
		aux = a.clone();
		sort(aux, a, 0, a.length - 1);
		assert isSorted(a);
	}
	public void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				aux[k] = a[j++];
			} else if (j > hi) {
				aux[k] = a[i++];
			} else if (insertion.less(a[j], a[i])) {
				aux[k] = a[j++];
			} else {
				aux[k] = a[i++];
			}
		}
		assert isSorted(aux, lo, hi);
	}
	private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		int cutoff = 7;
		// if (hi <= lo) {
		// 	return;
		// }
		if (hi <= lo + cutoff) {
			insertion.sorting(a, lo, hi);
			System.out.println("Insertion sort method invoked...");
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid + 1, hi);
		if (!insertion.less(a[mid + 1], a[mid])) {
			for (int i = lo; i <= hi; i++) {
				aux[i] = a[i];
			}
			System.out.println("Array is already sorted. So, skipped the call to merge...");
			return;
		}
		merge(a, aux, lo, mid, hi);
	}
	public String toString(Comparable[] input) {
		int i = 0;
		String str = "[";
		for (i = 0; i < input.length - 1; i++) {
			str += input[i] + ",";
		}
		str += input[i] + "]";
		return str;
	}
	public boolean isSorted(final Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}
	public boolean isSorted(final Comparable[] a,
	                        final int lo, final int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			if (insertion.less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
class Insertion {
	public void sorting(Comparable[] team, int lo, int hi) {
		// int[] teams = team;
		// for (int i = lo; i < hi; i++) {
		// 	int key = teams[i];
		// 	int j = i - 1;
		// 	while (j >= 0 && less(key, teams[j])) {
		// 		teams[j + 1] = teams[j];
		// 		j = j - 1;

		// 	}
		// 	teams[j + 1] = key;
		// }
		// return teams;
		// for (int i = lo; i <= hi; i++)
		// Comparable[] sort = team;
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(team[j], team[j - 1]); j--)
				exch(team, j, j - 1);
	}
	private void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	public boolean less(final Comparable one, final Comparable two) {
		return one.compareTo(two) < 0;
	}
}