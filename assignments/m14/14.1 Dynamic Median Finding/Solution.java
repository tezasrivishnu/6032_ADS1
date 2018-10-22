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
        for (long i = 0; i < number; i++) {
            double input = scan.nextDouble();
            med.insert(input);
            System.out.println(med.dynamicMedian());
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
    public double dynamicMedian() {
        if (Math.abs(min.size() - max.size()) == 1) {
            if (min.size() > max.size()) {
                median = min.min();
                return median;
            } else {
                median = max.max();
                return median;
            }
        }
        if (min.size() - max.size() == 0) {
            double mini = min.delMin();
            min.insert(mini);
            double maxi = max.delMax();
            max.insert(maxi);
            median = (mini + maxi) / 2.0;
                return median;
        }
        return 0.0;
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
