import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nthnumber = scan.nextInt();
		int mpairs = scan.nextInt();
		int mcounter = 0;
		MinPQ<TaxiCab> pq = new MinPQ<TaxiCab>();
		for (int i = 0; i <= 400; i++) {
			pq.insert(new TaxiCab(i, i));
		}
		int tempsum = 0;
		while (pq.isEmpty()) {
			TaxiCab s = pq.delMin();
			if(tempsum == s.sum) {
				mcounter++;
				if(mcounter == mpairs){
					System.out.println(s.sum);
					break;
				}
			}
			tempsum = s.sum;
			if (s.j < 400){
				pq.insert(new TaxiCab(s.i, s.j + 1));
			}
		}
	}
}
class TaxiCab {
	int sum;
	int i;
	int j;

	public TaxiCab(int i, int j) {
		this.sum = i * i * i + j * j * j;
		this.i = i;
		this.j = j;
	}
}
