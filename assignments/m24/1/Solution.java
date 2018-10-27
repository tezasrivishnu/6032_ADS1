import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SeparateChainingHashST<Integer, Student> finding
		 = new SeparateChainingHashST<Integer, Student>();
		String input = scan.nextLine();
		for(int i = 0; i< Integer.parseInt(input); i++) {
			String[] tokens = scan.nextLine().split(",");
			finding.put(Integer.parseInt(tokens[0]),
				new Student(tokens[1], Double.parseDouble(tokens[2])));
		}
		String get = scan.nextLine();
		for(int i = 0; i< Integer.parseInt(get); i++) {
			String[] items = scan.nextLine().split(" ");
			Student stu = finding.get(Integer.parseInt(items[1]));
			if(Integer.parseInt(items[2]) == 1 && stu != null) {
				System.out.println(stu.getName());
			} else if (Integer.parseInt(items[2]) == 2 && stu != null){
				System.out.println(stu.getMarks());
			} else {
				System.out.println("Student doesn't exists...");
			}
		}

	}
}
class Student {
	String studentname;
	double studentmarks;
	Student(String name, double marks) {
		this.studentname = name;
		this.studentmarks = marks;
	}
	public String getName() {
		return this.studentname;
	}
	public double getMarks() {
		return this.studentmarks;
	}
}
