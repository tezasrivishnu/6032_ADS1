import java.util.Scanner;
class Josephus {
    Josephus() {

    }
    public void Antiquity(int m, int n) {
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < m; i++)
            queue.enqueue(i);

        while (!queue.isEmpty()) {
            for (int i = 0; i < n - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }
}
public class Solution {
    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        while(scan.hasNext()) {
            int persons = scan.nextInt();
            int spaces = scan.nextInt();
            josephus.Antiquity(persons, spaces);
        }
    }
}