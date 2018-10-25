import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	public static void main(String[] args) {
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
class CheckWords {
	SeparateChainingHashST<String, Integer> hashone;
	SeparateChainingHashST<String, Integer> hashtwo;
	CheckWords() {
		hashone = new SeparateChainingHashST<String, Integer>();
		hashtwo = new SeparateChainingHashST<String, Integer>();
	}
	public boolean words(String[] firstarr, String[] secondarr) {
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
