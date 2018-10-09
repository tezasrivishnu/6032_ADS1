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
   * main function for the program.
   * complexity O(n) as we are taking input n times.
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
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
                                     screserved,
                                     streserved, vacancies);
    while (n < students) {
      String[] array = scan.next().split(",");
      info.add(new Students(array[0], array[1],
                            Integer.parseInt(array[2]),
                            Integer.parseInt(array[1 + 2]),
                            Integer.parseInt(array[2 + 2]),
                            Integer.parseInt(array[2 + 2 + 1]),
                            array[2 + 2 + 2]));
      n += 1;
    }
    info.sort();
  }
}
/**
 * Class for students.
 */
class Students {
  /**
   * declarig the string studentname.
   */
  private String studentname;
  /**
   * declarig the string datebirth.
   */
  private String datebirth;
  /**
   * declarig the int subject1.
   */
  private int subject1;
  /**
   * declarig the int subject2.
   */
  private int subject2;
  /**
   * declarig the int subject3.
   */
  private int subject3;
  /**
   * declarig the string total marks.
   */
  private int totalmarks;
  /**
   * declarig the string category.
   */
  private String category;
  /**
   * Constructs the object.
   */
  Students() {

  }
  /**
   * Constructs the object.
   * comlexity O(1)
   * @param      name         The name
   * @param      dob          The dob
   * @param      sub1         The sub 1 marks
   * @param      sub2         The sub 2 marks
   * @param      sub3         The sub 3 marks
   * @param      total        The total marks
   * @param      reservation  The reservation category
   */
  Students(final String name, final String dob,
           final int sub1,
           final int sub2, final int sub3,
           final int total, final String reservation) {
    this.studentname = name;
    this.datebirth = dob;
    this.subject1 = sub1;
    this.subject2 = sub2;
    this.subject3 = sub3;
    this.totalmarks = total;
    this.category = reservation;
  }
  /**
   * Gets the name.
   * complexity O(1)
   *
   * @return     The name.
   */
  public String getName() {
    return studentname;
  }
  /**
   * Gets the dob.
   * complexity O(1)
   * @return     The dob.
   */
  public String getDOB() {
    return datebirth;
  }
  /**
   * Gets the sub 1.
   * complexity O(1)
   * @return     The sub 1.
   */
  public int getSub1() {
    return subject1;
  }
  /**
   * Gets the sub 2.
   * complexity O(1)
   * @return     The sub 2.
   */
  public int getSub2() {
    return subject2;
  }
  /**
   * Gets the sub 3.
   * complexity O(1)
   * @return     The sub 3.
   */
  public int getSub3() {
    return subject3;
  }
  /**
   * Gets the total.
   * complexity O(1)
   * @return     total marks.
   */
  public int getTotal() {
    return totalmarks;
  }
  /**
   * Gets the category.
   *complexity O(1)
   * @return     The category.
   */
  public String getCategory() {
    return category;
  }
  int getAge() {
    int age = 0;
    final int year = 2018, days = 365, month = 30, ten = 10;
    String[] token = this.getDOB().split("-");
    age += (year - Integer.parseInt(token[2])) * days;
    age += (ten - Integer.parseInt(token[1])) * month;
    age += Integer.parseInt(token[0]);

    return age;
  }
  /**
   * comparing the objects.
   * complexity O(1)
   *
   * @param      two   Two
   *
   * @return     true or false.
   */
  public int compareTo(final Students two) {
    // if ((this.getTotal() == two.getTotal())
    //     && (this.getSub3() == two.getSub3())
    //     && (this.getSub2() == two.getSub2())) {
    //   String[] thisdob = this.getDOB().split("-");
    //   String[] twodob = two.getDOB().split("-");
    //   if (Integer.parseInt(thisdob[2])
    //       < Integer.parseInt(twodob[2])) {
    //     return -1;
    //   } else {
    //     return 1;
    //   }
    // } else if ((this.getTotal() == two.getTotal())
    //            && (this.getSub3() == two.getSub3())) {
    //   return this.getSub2() - this.getSub3();
    // } else if (((this.getTotal() == two.getTotal()))) {
    //   return this.getSub2() - this.getSub2();
    // } else {
    //   return this.getTotal() - two.getTotal();
    // // }
    if (this.getTotal() > two.getTotal()) {
      return 1;
    } else if (this.getTotal() < two.getTotal()) {
      return -1;
    } else {
      if (this.getSub3() > two.getSub3()) {
        return 1;
      } else if (this.getSub3() < two.getSub3()) {
        return -1;
      } else {
        if (this.getSub2() > two.getSub2()) {
          return 1;
        } else if (this.getSub2() < two.getSub2()) {
          return -1;
        } else {
          if (this.getAge() < two.getAge()) {
            return 1;
          } else {
            return -1;
          }
        }
      }
    }
  }
}
/**
 * Class for information.
 */
class Information {
  /**
   * declaring the students array.
   */
  private Students[] students;
  /**
   * declaring the int size.
   */
  private int size;
  /**
   * declarin the insertion class object.
   */
  private Insertion merge;
  /**
   * Constructs the object.
   * complexity O(1)
   * @param      n     { parameter_description }
   */
  Information(final int n) {
    students = new Students[n];
    size = 0;
    merge = new Insertion();
  }
  /**
   * adding a element in student array.
   * complexity O(1)
   *
   * @param      student  The student
   */
  public void add(final Students student) {
    students[size] = student;
    size += 1;
  }
  /**
   *we are callin the insertion sort.
   * comlexity O(1).
   */
  public void sort() {
    merge.sort(students);
    //System.out.println(merge.show(students));
  }

}
/**
 * Class for insertion.
 */
class Insertion {
  /**
   * Constructs the object.
   */
  Insertion() {

  }
  /**
   * declaring int open.
   */
  private static int open;
  /**
   * declaring int bc.
   */
  private static int bc;
  /**
   * declaring int sc.
   */
  private static int sc;
  /**
   * declaring int st.
   */
  private static int st;
  /**
   * declaring int vacancies.
   */
  private static int vacancies;
  boolean boo = true;
  /**
   * Constructs the object.
   *
   * @param      one      One
   * @param      two      Two
   * @param      three    Three
   * @param      four     Four
   * @param      vacancy  The vacancy
   */
  Insertion(final int one, final int two,
            final int three, final int four,
            final int vacancy) {
    open = one;
    bc = two;
    sc = three;
    st = four;
    //stem.out.println(vacancy);
    vacancies = vacancy;
  }
  /**
   * Gets the open.
   *
   * @return     The open.
   */
  public static int getOpen() {
    return open;
  }
  /**
   * Gets the bc.
   *
   * @return     The bc.
   */
  public static int getBC() {
    return bc;
  }
  /**
   * Gets the sc.
   *
   * @return     The sc.
   */
  public static int getSC() {
    return sc;
  }
  /**
   * Gets the st.
   *
   * @return     The st.
   */
  public static int getST() {
    return st;
  }
  /**
   * Gets the st vacancy.
   *
   * @return     The st vacancy.
   */
  public static int getSTVacancy() {
    return vacancies;
  }
  /**
   * insertion sort.
   * complexity O(N^2)
   *
   * @param      a     student array
   */
  public void sort(final Students[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j > 0 && less(a[j],
                                    a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
    System.out.println(show(a));
    System.out.println();
    toppers(a);
  }
  /**
   * comparing two objects.
   *
   * @param      v     student object
   * @param      w     student object
   *
   * @return     true or false.
   */
  private boolean less(final Students v,
                       final Students w) {
    return v.compareTo(w) > 0;
  }
  /**
   * swapping of elements.
   *
   * @param      a     student array.
   * @param      i     index.
   * @param      j     index.
   */
  private static void exch(final Students[] a,
                           final int i, final int j) {
    Students swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
  /**
   * string representation of elements.
   * complexity O(N)
   * @param      a     array
   *
   * @return     string
   */
  public String show(final Students[] a) {
    String str = "";
    int i = 0;
    for (i = 0; i < a.length - 1; i++) {
      str += a[i].getName() + ","
             + a[i].getTotal() + ","
             + a[i].getCategory()
             + "\n";
    }
    str += a[i].getName() + ","
           + a[i].getTotal() + ","
           + a[i].getCategory();
    return str;
  }
  /**
   * tring representation of toppers.
   * complexity O(N)
   * @param      a     student array.
   *
   * @return     string.
   */
  public void toppers(final Students[] a) {
    int total = getOpen() + getSC() + getST() + getBC();
    int noSC = getSC();
    int noBC = getBC();
    int noST = getST();
    int in = 0;
    Students[] toppers = new Students[total];
    for (int i = 0; i < getOpen(); i++) {
      toppers[in++] = a[i];
    }
    for (int k = getOpen(); k < a.length; k++) {
      if (a[k].getCategory().equals("BC") && noBC > 0) {
        toppers[in++] = a[k];
        noBC--;
      }
      if (a[k].getCategory().
          equals("SC") && noSC > 0) {
        toppers[in++] = a[k];
        noSC--;
      }
      if ((a[k].getCategory()).
          equals("ST") && noST > 0) {
        toppers[in++] = a[k];
        noST--;
      }
    }
    if (noBC > 0) {
      for (int k = getOpen(); k < a.length; k++) {
        if (a[k].getCategory().equals("Open") && noBC > 0) {
          if (!contains(toppers, a[k], in)) {
            toppers[in++] = a[k];
            noBC--;
          }
        }
      }
    }
    if (noSC > 0) {
      for (int k = getOpen(); k < a.length; k++) {
        if (a[k].getCategory().equals("Open") && noSC > 0) {
          if (!contains(toppers, a[k], in)) {
            toppers[in++] = a[k];
            noSC--;
          }
        }
      }
    }
    if (noST > 0) {
      for (int k = getOpen(); k < a.length; k++) {
        if (a[k].getCategory().equals("Open") && noST > 0) {
          if (!contains(toppers, a[k], in)) {
            toppers[in++] = a[k];
            noST--;
          }
        }
      }
    }
    while(boo) {
      boo = false;
      sort(toppers);
    }
    System.out.println(show(toppers));
  }
  public boolean contains(final Students[] arr, final Students val, int k) {
    for (int i = 0; i < k; i++) {
      if (val.equals(arr[i])) {
        return true;
      }
    }
    return false;
  }
}
