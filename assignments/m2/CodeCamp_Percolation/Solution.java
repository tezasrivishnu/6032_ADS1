// public class Solution {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
/**
 * Class for solution.
 * @author tezasrivishnu.
 */
class Solution {
	private int array_size;
	private int open_size;
	private int[][] grid;
	private int[] parent;
	private int[] size;
	/**
	 * Constructs the object.
	 * declaring the attributes here.
	 * @param      count  The size
	 */
	Solution(final int count) {
		array_size = count;
		open_size = 0;
		grid = new int[array_size][array_size];
		parent = new int[array_size * array_size];
		size = new int[array_size * array_size];
		for (int i = 0; i < array_size; i++) {
			for (int j = 0; j < array_size; j++) {
				grid[i][j] = 0;
			}
		}
		for (int i = 0; i < array_size * array_size; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	/**
	 * opening a connection between two points.
	 * @param      row   The row
	 * @param      col   The col
	 */
	public void open(final int row, final int col) {
		grid[row - 1][col - 1] = 1;
		open_size += 1;
		if (row-2>-1 && isOpen(row - 1, col)) {
			union(index(row - 1, col - 1) , index(row - 2, col - 1));
		}
		if (row < array_size && isOpen(row + 1, col)) {
			union(index(row - 1, col - 1) , index(row, col - 1));
		}
		if (col-2>-1 && isOpen(row, col - 1)) {
			union(index(row - 1, col - 1) , index(row - 1, col - 2));
		}
		if (col < array_size && isOpen(row, col + 1)) {
			union(index(row - 1, col - 1) , index(row - 1, col));
		}
	}
	/**
	 * checks if the route betwwen two nodes is open or not. 
	 * @param      row   The row
	 * @param      col   The col
	 *
	 * @return     True if open, False otherwise.
	 */
	public boolean isOpen(final int row, final int col) {
		if (grid[row - 1][col - 1] == 1) {
			return true;
		}
		return false;
	}
	/**
	 * gives us the no. og open sites in the matrixx.
	 *
	 * @return     int value.
	 */
	public int numberOfOpenSites() {
		return open_size;
	}
	/**
	 * gives the index of the element in the union array from the
	 * 2d array.
	 *
	 * @param      i     is the input value.
	 * @param      j     secong inpu parameter.
	 *
	 * @return     index of the element.
	 */
	public int index(final int i, final int j) {
		return (i * array_size) + j;
	}
	/**
	 * { function_description }
	 *
	 * @param      p     { parameter_description }
	 * @param      q     The quarter
	 */
	public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
	/**
	 * Searches for the first match.
	 *
	 * @param      p     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int find(final int p) {
		int a = p;
		while (a != parent[a])
			a = parent[a];
		return a;
	}
	public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
	/**
	 * ckecking for the percolation.
	 *
	 * @return     true or false.
	 */
	public boolean valididate() {
		for (int i = (array_size - 1) * array_size; i < array_size * array_size; i++) {
			for (int j = 0; j < array_size * array_size; j++) {
				if (connected(i,j)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * main program for solution.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		Solution sol = new Solution(number);
		while (sc.hasNext()) {
			int one = sc.nextInt();
			int two = sc.nextInt();
			sol.open(one, two);
		}
		System.out.println(sol.valididate());
	}
}