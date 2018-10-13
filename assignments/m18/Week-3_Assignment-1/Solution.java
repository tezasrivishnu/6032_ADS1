import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MinPQ<Stock> minstock = new MinPQ<Stock>();
		MaxPQ<Stock> maxstock = new MaxPQ<Stock>();
		Stock stock = new Stock();
		String number = scan.nextLine();
		int input = Integer.parseInt(number);
		int counter = 0;
		int index = input;
		Stock[] max = new Stock[5];
		Stock[] min = new Stock[5];
		for (int i = 0; i < input * 6; i++) {
			counter++;
			String[] tokens = scan.nextLine().split(",");
			if (counter % input != 0) {
				
				minstock.insert(new Stock((tokens[0]),
				                          Float.parseFloat(tokens[1])));
				maxstock.insert(new Stock((tokens[0]),
				                          Float.parseFloat(tokens[1])));
			} else {
				for (int j = 0; j<5; i++) {
					max[j] = maxstock.max();
					maxstock.delMax();
					min[j] = minstock.min();
					minstock.delMin();
				}
				System.out.println(stock.toString(max));
				System.out.println();
				System.out.println(stock.toString(min));
				System.out.println();
				counter = 0;
				index = 0;
				minstock.makeNull();
				maxstock.makeNull();
			}
		}
	}
}

class Stock implements Comparable<Stock>{
	String stockname;
	float stockfrequency;
	Stock() {}
	Stock(String name, float freq) {
		this.stockname = name;
		this.stockfrequency = freq;
	}
	public String getName() {
		return this.stockname;
	}
	public float getFrequency() {
		return this.stockfrequency;
	}
	public int compareTo(Stock that) {
		if(this.getFrequency() - that.getFrequency() > 0){
			return 1;
		} else if (this.getFrequency() - that.getFrequency() < 0){
			return -1;
		}
		return 0;
	}
	public String toString(Stock[] array) {
		int i = 0;
		String str = "";
		for (i = 0; i < 4; i++) {
			str += array[i].getName() + " " + array[i].getFrequency() + "\n";
		}
		str += array[i].getName() + " " + array[i].getFrequency();
		return str;
	}
}