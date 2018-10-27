import java.util.Scanner;
import java.util.Arrays;
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
     * complexity O()
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BST<Student, Double> finding
            = new BST<Student, Double>();
        String input = scan.nextLine();
        for (int i = 0; i < Integer.parseInt(input); i++) {
            String[] tokens = scan.nextLine().split(",");
            finding.put(
                new Student(tokens[0],
                            tokens[1],
                            Double.parseDouble(tokens[2])),
                Double.parseDouble(tokens[2]));
        }
        String get = scan.nextLine();
        for (int i = 0; i < Integer.parseInt(get); i++) {
            String[] items = scan.nextLine().split(" ");
            switch (items[0]) {
            case "BE":
                for (Student stu : finding.keys()) {
                    if ((stu != null) && (stu.getMarks()
                                          >= Double.parseDouble(items[1])
                                          && stu.getMarks() <= Double.parseDouble(items[2])
                                         )) {
                        System.out.println(stu.getName());
                    }
                }
                break;
            case "LE":
                for (Student stu : finding.keys()) {
                    if (stu.getMarks() <= Double.parseDouble(items[1])
                       ) {
                        System.out.println(stu.getName());
                    }
                }
                break;
            case "GE":
                for (Student stu : finding.keys()) {
                    if (stu.getMarks() >= Double.parseDouble(items[1])
                       ) {
                        System.out.println(stu.getName());
                    }
                }
                break;
            }
        }
    }
}
/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * initializing the student roll variable.
     */
    private String studentroll;
    /**
     * initializing the student name variable.
     */
    private String studentname;
    /**
     * initializing the student marks variable.
     */
    private double studentmarks;
    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      marks  The marks
     */
    Student(final String roll, final String name, final double marks) {
        this.studentroll = roll;
        this.studentname = name;
        this.studentmarks = marks;
    }
    /**
     * Gets the name of the student.
     * complexity O(1) as we are just retuning the
     * student name.
     * @return     The name.
     */
    public String getName() {
        return this.studentname;
    }
    /**
     * Gets the name of the student.
     * complexity O(1) as we are just retuning the
     * student marks.
     * @return     The name.
     */
    public double getMarks() {
        return this.studentmarks;
    }
    public int compareTo(final Student that) {
        if (this.getMarks() < that.getMarks()) {
            return -1;
        } else if (this.getMarks() > that.getMarks()) {
            return 1;
        }
        return 0;
    }
}
