import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
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
        SeparateChainingHashST<Integer, Student> finding
            = new SeparateChainingHashST<Integer, Student>();
        String input = scan.nextLine();
        for (int i = 0; i < Integer.parseInt(input); i++) {
            String[] tokens = scan.nextLine().split(",");
            finding.put(Integer.parseInt(tokens[0]),
                        new Student(tokens[1],
                            Double.parseDouble(tokens[2])));
        }
        String get = scan.nextLine();
        for (int i = 0; i < Integer.parseInt(get); i++) {
            String[] items = scan.nextLine().split(" ");
            Student stu = finding.get(Integer.parseInt(items[1]));
            if (Integer.parseInt(items[2]) == 1 && stu != null) {
                System.out.println(stu.getName());
            } else if (Integer.parseInt(items[2])
                == 2 && stu != null) {
                System.out.println(stu.getMarks());
            } else {
                System.out.println("Student doesn't exists...");
            }
        }

    }
}
/**
 * Class for student.
 */
class Student {
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
    Student(final String name, final double marks) {
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
}
