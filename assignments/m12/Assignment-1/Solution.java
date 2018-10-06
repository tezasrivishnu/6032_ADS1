import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * main function for the program.
	 * complexity O(n) as we are taking input n times.
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int students = scan.nextInt();
		int vacancies = scan.nextInt();
		int unreserved = scan.nextInt();
		int bcreserved = scan.nextInt();
		int screserved = scan.nextInt();
		int streserved = scan.nextInt();
		int n = 0;
		Information info = new Information(students);
		Insertion insert = new Insertion(unreserved, bcreserved,
		                                 screserved, streserved, vacancies);
		while (n < students) {
			String[] array = scan.next().split(",");
			info.add(new Students(array[0], array[1],
			                      Integer.parseInt(array[2]),
			                      Integer.parseInt(array[3]),
			                      Integer.parseInt(array[4]),
			                      Integer.parseInt(array[5]), array[6]));
			n += 1;
		}
		info.sort();
	}
}
class Students {
	String studentname;
	String datebirth;
	int subject1;
	int subject2;
	int subject3;
	int totalmarks;
	String category;
	Students() {

	}
	Students(String name, String dob, int sub1,
	         int sub2, int sub3, int total, String reservation) {
		this.studentname = name;
		this.datebirth = dob;
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
		this.totalmarks = total;
		this.category = reservation;
	}
	public String getName() {
		return studentname;
	}
	public String getDOB() {
		return datebirth;
	}
	public int getSub1() {
		return subject1;
	}
	public int getSub2() {
		return subject2;
	}
	public int getSub3() {
		return subject3;
	}
	public int getTotal() {
		return totalmarks;
	}
	public String getCategory() {
		return category;
	}
	public int compareTo(Students two) {
		if ((this.getTotal() == two.getTotal())
		        && (this.getSub3() == two.getSub3())
		        && (this.getSub2() == two.getSub2())) {
			String[] thisdob = this.getDOB().split("-");
			String[] twodob = two.getDOB().split("-");
			if (Integer.parseInt(thisdob[2])
			        < Integer.parseInt(twodob[2])) {
				return -1;
			} else {
				return 1;
			}
		} else if ((this.getTotal() == two.getTotal())
		           && (this.getSub3() == two.getSub3())) {
			return this.getSub2() - this.getSub3();
		} else if (((this.getTotal() == two.getTotal()))) {
			return this.getSub2() - this.getSub2();
		} else {
			return this.getTotal() - two.getTotal();
		}
	}
}
class Information {
	Students[] students;
	int size;
	Insertion merge;
	Information(int n) {
		students = new Students[n];
		size = 0;
		merge = new Insertion();
	}
	public void add(Students student) {
		students[size] = student;
		size += 1;
	}
	public void sort() {
		merge.sort(students);
		//System.out.println(merge.show(students));
	}

	// public String toString(Students[] a) {

	// }

}
class Insertion {
	Insertion() {}
	static int open;
	static int bc;
	static int sc;
	static int st;
	static int vacancies;
	Insertion(int one, int two, int three, int four, int vacancy) {
		open = one;
		bc = two;
		sc = three;
		st = four;
		//stem.out.println(vacancy);
		vacancies = vacancy;
	}
	public static int getOpen() {
		return open;
	}public static int getBC() {
		return bc;
	}public static int getSC() {
		return sc;
	}public static int getST() {
		return st;
	}public static int getSTVacancy() {
		return vacancies;
	}
	public void sort(Students[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
		System.out.println(show(a));
		System.out.println();
		System.out.print(toppers(a));
	}
	private boolean less(Students v, Students w) {
		return v.compareTo(w) > 0;
	}
	private static void exch(Students[] a, int i, int j) {
		Students swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	public String show(Students[] a) {
		String str = "";
		int i = 0;
		for (i = 0; i < a.length - 1; i++) {
			str += a[i].getName() + "," +
			       a[i].getTotal() + "," + a[i].getCategory()
			       + "\n";
		}
		str += a[i].getName() + "," +
		       a[i].getTotal() + ","
		       + a[i].getCategory();
		return str;
	}
	public static String toppers(Students[] a) {
		String str = "";
		int i = 0;
		int vacan = 0;
		int op = 0;
		int bc1 = 0;
		int sc1 = 0;
		int st1 = 0;
		for (i = 0; i < a.length - 1; i++) {
			int j = i + 1;
			while (vacan < Insertion.getSTVacancy()) {
				if (a[i].getCategory().equals("OPEN") && op < Insertion.getOpen()
				        && a[i].getTotal() > a[j].getTotal()) {
					str += a[i].getName() + "," +
					       a[i].getTotal() + "," + a[i].getCategory()
					       + "\n";
					op += 1;
					vacan += 1;
				}
				if (a[i].getCategory().equals("BC") && bc1 < Insertion.getBC()
				        && a[i].getTotal() > a[j].getTotal()) {
					str += a[i].getName() + "," +
					       a[i].getTotal() + "," + a[i].getCategory()
					       + "\n";
					bc1 += 1;
					vacan += 1;
				} if (a[i].getCategory().equals("SC") && sc1 < Insertion.getSC()
				        && a[i].getTotal() > a[j].getTotal()) {
					str += a[i].getName() + "," +
					       a[i].getTotal() + "," + a[i].getCategory()
					       + "\n";
					sc1 += 1;
					vacan += 1;
				} if (a[i].getCategory().equals("ST") && st1 < Insertion.getST()
				        && a[i].getTotal() > a[j].getTotal()) {
					str += a[i].getName() + "," +
					       a[i].getTotal() + "," + a[i].getCategory()
					       + "\n";
					st1 += 1;
					vacan += 1;
				}
			}
		}
		System.out.println(str);
		return str;
	}
}
// class Merge {
// 	public void sort(Students[] a) {
// 		Students[] aux = new Students[a.length];
// 		sort(a, aux, 0, a.length - 1);
// 	}
// 	private void sort(Students[] a, Students[] aux, int lo, int hi) {
// 		if (hi <= lo){
// 			return;
// 		}
// 		int mid = lo + (hi - lo) / 2;
// 		sort(a, aux, lo, mid);
// 		sort(a, aux, mid + 1, hi);
// 		merge(a, aux, lo, mid, hi);
// 	}
// 	private void merge(Students[] a, Students[] aux,
// 	                          int lo, int mid, int hi) {
// 		for (int k = lo; k <= hi; k++) {
// 			aux[k] = a[k];
// 		}
// 		int i = lo, j = mid + 1;
// 		for (int k = lo; k <= hi; k++) {
// 			if (i > mid) {
// 				a[k] = aux[j++];
// 			} else if (j > hi) {
// 				a[k] = aux[i++];
// 			} else if (less(aux[j], aux[i])) {
// 				a[k] = aux[j++];
// 			} else    {
// 				a[k] = aux[i++];
// 			}
// 		}
// 	}
// 	private static boolean less(Students v, Students w) {
// 		return v.compareTo(w) < 0;
// 	}
// }