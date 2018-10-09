import java.util.Scanner;
import java.lang.Math;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method for the program.
     * complexity O(n) as we are taking n inputs.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        long number = scan.nextInt();
        MinPQ min = new MinPQ();
        MaxPQ max = new MaxPQ();
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
class MinPQ {
    private double[] pq;
    private int n;
    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MinPQ(int initCapacity) {
        pq = new double[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue.
     */
    public MinPQ() {
        this(1);
    }
    public int size() {
        return n;
    }
    private void resize(int capacity) {
        assert capacity > n;
        double[] temp = new double[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    public void insert(double x) {
        if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
    }
    public double delMin() {
        double min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = 0;
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return min;
    }
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    private boolean greater(double i, double j) {
        return i > j;
    }

    private void exch(int i, int j) {
        double swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    public double min() {
        return pq[1];
    }
}
class MaxPQ {
    private double[] pq;
    private int n;
    public MaxPQ(int initCapacity) {
        pq = new double[initCapacity + 1];
        n = 0;
    }
    public MaxPQ() {
        this(1);
    }
    public double size() {
        return n;
    }
    private void resize(int capacity) {
        double[] temp = new double[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    public void insert(double x) {
        if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
    }
    public double delMax() {
        double max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = 0;
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return max;
    }
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    private boolean less(double i, double j) {
        return i < j;
    }

    private void exch(int i, int j) {
        double swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    public double max() {
        return pq[1];
    }
}