import java.util.Scanner;
/**
 * Class for solution.
 * @author tezasrivishnu.
 */
class Percolation {
    /**
     * initializing array size.
     */
    private int array_size;
    /**
     * initializing open nodes size.
     */
    private int openNsize;
    /**
     * initializing array grid.
     */
    private int[][] grid;
    /**
     * initializing array parent.
     */
    private int[] parent;
    /**
     * initializing size.
     */
    private int[] size;
    // int start;
    // int end;
    /**
     * Constructs the object.
     * declaring the attributes here.
     * @param      count  The size
     */
    Percolation(final int count) {
        array_size = count;
        openNsize = 0;
        // start = count*count;
        // end = start + 1;
        grid = new int[array_size][array_size];
        parent = new int[array_size * array_size];
        size = new int[array_size * array_size];
        // for (int i = 0; i < array_size; i++) {
        //  for (int j = 0; j < array_size; j++) {
        //      grid[i][j] = 0;
        //  }
        // }
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
        openNsize += 1;
        // if(row == 1) {
        //  union(index(row-1, col-1), start);
        // }
        // if(row == array_size) {
        //  union(index(row-1, col-1), end);
        // }
        if (row - 2 > -1 && isOpen(row - 1, col)) {
            union(index(row - 1, col - 1)
                ,index(row - 2, col - 1));
        }
        if (row < array_size && isOpen(row + 1, col)) {
            union(index(row - 1, col - 1)
                ,index(row, col - 1));
        }
        if (col - 2 > -1 && isOpen(row, col - 1)) {
            union(index(row - 1, col - 1)
                ,index(row - 1, col - 2));
        }
        if (col < array_size && isOpen(row, col + 1)) {
            union(index(row - 1, col - 1)
                ,index(row - 1, col));
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
        return openNsize;
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
     * @param      p     is the input parameter.
     * @param      q     The quarter
     */
    public void union(final int p, final int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
    /**
     * Searches for the first match.
     *
     * @param      p (int)     the input parameter.
     *
     * @return     the root of the element.
     */
    public int find(final int p) {
        int a = p;
        while (a != parent[a]) {
            a = parent[a];
        }
        return a;
    }
    /**
     * ckecking for the percolation.
     *
     * @return     true or false.
     */
    public boolean valididate() {
        // for (int j = 0; j < (array_size*array_size); j++) {
        //  System.out.println(Arrays.toString(grid[j]));
        // }
        if (openNsize > 0) {
            for (int i = (array_size - 1)
                         * array_size; i < array_size
                    * array_size; i++) {
                for (int j = 0; j < array_size; j++) {
                    if (find(i) == find(j)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main program for Percolation.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Percolation objper = new Percolation(number);
        while (sc.hasNext()) {
            int one = sc.nextInt();
            int two = sc.nextInt();
            //System.out.println(one+" "+two);
            objper.open(one, two);
        }
        System.out.println(objper.valididate());
    }
}