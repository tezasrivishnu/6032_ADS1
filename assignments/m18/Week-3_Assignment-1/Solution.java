import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MinPQ<Stock> minstock = new MinPQ<Stock>();
		MaxPQ<Stock> maxstock = new MaxPQ<Stock>();
		Stock stock = new Stock();
		String number = scan.nextLine();
		int input = Integer.parseInt(number);
		System.out.println(input);
		int counter = 0;
		int index = 0;
		Stock[] max = new Stock[input];
		Stock[] min = new Stock[input];
		for (int i = 0; i < input * 6; i++) {
			
			String[] tokens = scan.nextLine().split(",");
			if (counter == 0 || counter % input != 0) {
				counter++;
				minstock.insert(new Stock((tokens[0]),
				                          Float.parseFloat(tokens[1])));
				maxstock.insert(new Stock((tokens[0]),
				                          Float.parseFloat(tokens[1])));
				min[index] = minstock.delMin();
				max[index] = maxstock.delMax();
				index++;
			} else {
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

class Stock {
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