import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	private Solution() {

	}
	/**
	 * main method for the program.
	 * complexity is O()
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		CheckWords word = new CheckWords();
		int first = scan.nextInt();
		int second = scan.nextInt();
		String firstarr[] = new String[first];
		String secondarr[] = new String[second];
		for (int i = 0; i < first; i++) {
			firstarr[i] = scan.next();
		}
		for (int i = 0; i < second; i++) {
			secondarr[i] = scan.next();
		}
		if (word.words(firstarr, secondarr)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
/**
 * Class for check words.
 */
class CheckWords {
	/**
	 * initialising the seperate chaining class object.
	 */
	private SeparateChainingHashST<String, Integer> hashone;
	/**
	 * initialising the seperate chaining class object.
	 */
	private SeparateChainingHashST<String, Integer> hashtwo;
	/**
	 * Constructs the object.
	 */
	CheckWords() {
		hashone = new SeparateChainingHashST
		<String, Integer>();
		hashtwo = new SeparateChainingHashST
		<String, Integer>();
	}
	/**
	 * checking if rason note words are present in.
	 * magsine note or note.
	 * complexity 
	 * @param      firstarr   The firstarr
	 * @param      secondarr  The secondarr
	 *
	 * @return     the boolean value. true or false
	 */
	public boolean words(final String[] firstarr,
		final String[] secondarr) {
		for (String one : firstarr) {
			if (hashone.contains(one)) {
				int count = hashone.get(one);
				count++;
				hashone.put(one, count);
			} else {
				hashone.put(one, 1);
			}
		}
		for (String two : secondarr) {
			if (hashtwo.contains(two)) {
				int count = hashtwo.get(two);
				count++;
				hashtwo.put(two, count);
			} else {
				hashtwo.put(two, 1);
			}
		}
		for (String check : hashtwo.keys()) {
			Integer onevalue = hashone.get(check);
			Integer twovalue = hashtwo.get(check);
			if (twovalue == null || onevalue == null) {
				return false;
			} else if (onevalue < twovalue) {
				return false;
			}
		}
		return true;
		// 	int count = 0;
		// 	System.out.println(two);
		// 	System.out.println(!hash.contains(two));
		// 	if (!hash.contains(two)) {
		// 		return "NO";
		// 	} else {
		// 		count++;
		// 		if(count > hash.get(two)) {
		// 			return "NO";
		// 		}
		// 	}
		// }
		// return "YES";

	}
}
