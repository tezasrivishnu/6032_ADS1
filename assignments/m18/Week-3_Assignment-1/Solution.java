import java.util.Scanner;
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
        MinPQ<Stock> minstock = new MinPQ<Stock>();
        MaxPQ<Stock> maxstock = new MaxPQ<Stock>();
        Stock stock = new Stock();
        String number = scan.nextLine();
        int input = Integer.parseInt(number);
        int counter = 0;
        int index = input;
        Stock[] max = new Stock[2 + 2 + 1];
        Stock[] min = new Stock[2 + 2 + 1];
        for (int i = 0; i < input * (2 + 2 + 2); i++) {
            counter++;
            String[] tokens = scan.nextLine().split(",");
            if (counter % input != 0) {

                minstock.insert(new Stock((tokens[0]),
                                          Float.parseFloat(tokens[1])));
                maxstock.insert(new Stock((tokens[0]),
                                          Float.parseFloat(tokens[1])));
            } else {
                for (int j = 0; j < 2 + 2 + 1; i++) {
                    max[j] = maxstock.max();
                    maxstock.delMax();
                    min[j] = minstock.min();
                    minstock.delMin();
                }
                System.out.println(stock.toString(max));
                System.out.println();
                System.out.println(stock.toString(min));
                System.out.println();
                counter = 0;
                index = 0;
                minstock.makeNull();
                maxstock.makeNull();
            }
        }
    }
}
/**
 * Class for stock.
 */
class Stock implements Comparable <Stock> {
    /**
     * initializing the string variable stockname.
     */
    private String stockname;
    /**
     * initializing the float variable stockfrequency.
     */
    private float stockfrequency;
    /**
     * Constructs the object.
     */
    Stock() {

    }
    /**
     * Constructs the object.
     *
     * @param      name  The name
     * @param      freq  The frequency
     */
    Stock(final String name, final float freq) {
        this.stockname = name;
        this.stockfrequency = freq;
    }
    /**
     * Gets the stock name.
     * complexxity O(1) as we are just returning the name.
     * @return     The name.
     */
    public String getName() {
        return this.stockname;
    }
    /**
     * Gets the stock name.
     * complexxity O(1) as we are just returning the freuency.
     * @return     The frequency.
     */
    public float getFrequency() {
        return this.stockfrequency;
    }
    /**
     * comparing two stock objects frequencies.
     * complexxity O(1)
     * @param      that  The that
     *
     * @return     int value.
     */
    public int compareTo(final Stock that) {
        if (this.getFrequency() - that.getFrequency() > 0) {
            return 1;
        } else if (this.getFrequency() - that.getFrequency() < 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the arrays.
     * complexity O(n) as we iterating over the full array.
     * @param      array  The array
     *
     * @return     String representation of the object.
     */
    public String toString(final Stock[] array) {
        int i = 0;
        String str = "";
        for (i = 0; i < 2 + 2; i++) {
            str += array[i].getName()
                   + " " + array[i].getFrequency() + "\n";
        }
        str += array[i].getName() + " " + array[i].getFrequency();
        return str;
    }
}