import java.util.Scanner;
import java.lang.*;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long number = scan.nextInt();
		MinPQ<Double> min = new MinPQ<Double>();
		MaxPQ<Double> max = new MaxPQ<Double>();
		double median = 0.0;
		for (long i = 0; i < number; i++) {
			double input = scan.nextDouble();
			if (input > median) {
				min.insert(input);
			} else if (input < median) {
				max.insert(input);
			} else {
				min.insert(input);
			}
			if (min.size() - max.size() > 1) {
				max.insert(min.delMin());
			}
			if (max.size() - min.size() > 1) {
				min.insert(max.delMax());
			}
			if (Math.abs(min.size() - max.size()) == 1) {
				if (min.size() > max.size()) {
					median = min.min();
					System.out.println(median);
				} else {
					median = max.max();
					System.out.println(median);
				}
			} 
			if (min.size() - max.size() == 0) {
				double mini = min.delMin();
				min.insert(mini);
				double maxi = max.delMax();
				max.insert(maxi);
				median = (mini + maxi) / 2.0;
				System.out.println(median);
			}
		}
	}
}
// class MinPQ {
// 	private int[] pq;
//     private int n;
//     /**
//      * Initializes an empty priority queue with the given initial capacity.
//      *
//      * @param  initCapacity the initial capacity of this priority queue
//      */
//     public MinPQ(int initCapacity) {
//         pq = new int[initCapacity + 1];
//         n = 0;
//     } 
//     /**
//      * Initializes an empty priority queue.
//      */
//     public MinPQ() {
//         this(1);
//     }
//     public int size() {
//         return n;
//     }
//     private void resize(int capacity) {
//         assert capacity > n;
//         int[] temp = new int[capacity];
//         for (int i = 1; i <= n; i++) {
//             temp[i] = pq[i];
//         }
//         pq = temp;
//     }
//     public void insert(int x) {
//         if (n == pq.length - 1) resize(2 * pq.length);
//         pq[++n] = x;
//         swim(n);
//     }
//     public int delMin() {
//         int min = pq[1];
//         exch(1, n--);
//         sink(1);
//         pq[n+1] = 0;
//         if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
//         return min;
//     }
//     private void swim(int k) {
//         while (k > 1 && greater(k/2, k)) {
//             exch(k, k/2);
//             k = k/2;
//         }
//     }
//     private void sink(int k) {
//         while (2*k <= n) {
//             int j = 2*k;
//             if (j < n && greater(j, j+1)) j++;
//             if (!greater(k, j)) break;
//             exch(k, j);
//             k = j;
//         }
//     }
//     private boolean greater(int i, int j) {
//         return i>j;
//     }

//     private void exch(int i, int j) {
//         int swap = pq[i];
//         pq[i] = pq[j];
//         pq[j] = swap;
//     }
// }
// class MaxPQ {
// 	private int[] pq;
//     private int n; 
//     public MaxPQ(int initCapacity) {
//         pq = new int[initCapacity + 1];
//         n = 0;
//     }
//     public MaxPQ() {
//         this(1);
//     }
//     public int size() {
//         return n;
//     }
//     private void resize(int capacity) {
//         int[] temp = new int[capacity];
//         for (int i = 1; i <= n; i++) {
//             temp[i] = pq[i];
//         }
//         pq = temp;
//     }
//     public void insert(int x) {
//         if (n == pq.length - 1) resize(2 * pq.length);
//         pq[++n] = x;
//         swim(n);
//     }
//      public int delMax() {
//         int max = pq[1];
//         exch(1, n--);
//         sink(1);
//         pq[n+1] = 0;
//         if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
//         return max;
//     }
//     private void swim(int k) {
//         while (k > 1 && less(k/2, k)) {
//             exch(k, k/2);
//             k = k/2;
//         }
//     }
//     private void sink(int k) {
//         while (2*k <= n) {
//             int j = 2*k;
//             if (j < n && less(j, j+1)) j++;
//             if (!less(k, j)) break;
//             exch(k, j);
//             k = j;
//         }
//     }
//     private boolean less(int i, int j) {
//         return i<j;
//     }

//     private void exch(int i, int j) {
//         int swap = pq[i];
//         pq[i] = pq[j];
//         pq[j] = swap;
//     }
// }