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
        Median med = new Median();
        long number = scan.nextInt();
        // MinPQ<Double> min = new MinPQ<Double>();
        // MaxPQ<Double> max = new MaxPQ<Double>();
        // double median = 0.0;
        for (long i = 0; i < number; i++) {
            double input = scan.nextDouble();
            med.insert(input);
            med.dynamicMedian();
            // if (input > median) {
            //     min.insert(input);
            // } else if (input < median) {
            //     max.insert(input);
            // } else {
            //     min.insert(input);
            // }
            // if (min.size() - max.size() > 1) {
            //     max.insert(min.delMin());
            // }
            // if (max.size() - min.size() > 1) {
            //     min.insert(max.delMax());
            // }
            // if (Math.abs(min.size() - max.size()) == 1) {
            //     if (min.size() > max.size()) {
            //         median = min.min();
            //         System.out.println(median);
            //     } else {
            //         median = max.max();
            //         System.out.println(median);
            //     }
            // }
            // if (min.size() - max.size() == 0) {
            //     double mini = min.delMin();
            //     min.insert(mini);
            //     double maxi = max.delMax();
            //     max.insert(maxi);
            //     median = (mini + maxi) / 2.0;
            //     System.out.println(median);
        }
    }
}

class Median {
    MinPQ<Double> min;
    MaxPQ<Double> max;
    double median;
    Median() {
        min = new MinPQ<Double>();
        max = new MaxPQ<Double>();
        median = 0.0;
    }
    public void dynamicMedian() {
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
    public void insert(double input) {
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
    }
}
