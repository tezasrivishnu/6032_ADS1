import java.util.Scanner;
/**
 * Class for josephus.
 * @author tezasrivishnu
 */
class Josephus {
    /**
     * Constructs the object.
     */
    Josephus() {

    }
    /**
     * printing the order od the persons with the spaces.
     *
     * @param      m     no of persons.
     * @param      n     spaces.
     */
    public void antiQuity(final int m, final int n) {
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < m; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty() && queue.peekFirst() != null) {
            for (int i = 0; i < n - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
        System.out.print(queue.dequeue());
        System.out.println();
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main class for the program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Josephus josephus = new Josephus();
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        while (scan.hasNext()) {
            int persons = scan.nextInt();
            int spaces = scan.nextInt();
            josephus.antiQuity(persons, spaces);
        }
    }
}