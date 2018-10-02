import java.util.Scanner;
import java.util.Arrays;
class TeamInformation implements Comparable<TeamInformation> {
	String teamname;
	int teamwins;
	int teamloses;
	int teamdraws;
	TeamInformation(String name, int wins, int loses, int draws) {
		this.teamname = name;
		this.teamwins = wins;
		this.teamloses = loses;
		this.teamdraws = draws;
	}
	public String getTeamName() {
		return this.teamname;
	}
	public int getTeamWins() {
		return this.teamwins;
	}
	public int getTeamLoses() {
		return this.teamloses;
	}
	public int getTeamDraws() {
		return this.teamdraws;
	}
	public int compareTo(TeamInformation that) {
		if (this.teamwins > that.teamwins) {
			return 0;
		}
		if (this.teamwins == that.teamwins) {
			if (this.teamloses < that.teamloses) {
				return 1;
			}
		}
		if (this.teamwins == that.teamwins) {
			if (this.teamloses == that.teamloses) {
				if (this.teamdraws > that.teamdraws) {
					return 2;
				}
			}
		}
		return -1;
	}
}
class LeaderBoard {
	TeamInformation[] teaminformation;
	int size;
	Sorting sort;
	LeaderBoard() {
		sort = new Sorting();
		teaminformation = new TeamInformation[10];
		size = 0;
	}
	public void add(TeamInformation teamdata) {
		teaminformation[size] = teamdata;
		size += 1;
	}
	public int size() {
		return size;
	}
	public void teamRanking() {
		teaminformation = Arrays.copyOf(teaminformation, size);
		teaminformation = sort.teamSorting(teaminformation);
	}
	public String toString() {
		String str = "";
		int i = 0;
		for (i = 0; i < size - 1; i++) {
			str += teaminformation[i].getTeamName() + ",";
		}
		str += teaminformation[i].getTeamName();
		return str;
	}
}
class Sorting {
	Sorting() {

	}
	public TeamInformation[] teamSorting(TeamInformation[] team) {
		for (int i = 0; i < team.length; i++) {
			int max = i;
			for (int j = 0; j < team.length; j++) {
				int count = team[i].compareTo(team[max]);
				if (count >= 0) {
					max = j;
				}
			}
			team = swapping(max, i, team);
		}
		return team;

		// for (int i = 0; i < size; i++) {
		// 	int max = i;
		// 	for (int j = i + 1; j < size; j++) {
		// 		//max = sorting(i, j);
		// 		if (teaminformation[j].getTeamWins() > teaminformation[max].getTeamWins()) {
		// 			max = j;
		// 		}
		// 		if (teaminformation[j].getTeamWins() == teaminformation[max].getTeamWins()) {
		// 			if (teaminformation[j].getTeamLoses() < teaminformation[max].getTeamLoses()) {
		// 				max = j;
		// 			}
		// 		}
		// 		if (teaminformation[j].getTeamWins() == teaminformation[max].getTeamWins()) {
		// 			if (teaminformation[j].getTeamLoses() == teaminformation[max].getTeamLoses()) {
		// 				if (teaminformation[j].getTeamDraws() > teaminformation[max].getTeamDraws()) {
		// 					max = j;
		// 				}
		// 			}
		// 		}
		// 	}
		// 	TeamInformation temp = teaminformation[max];
		// 	teaminformation[max] = teaminformation[i];
		// 	teaminformation[i] = temp;
		// }
	}
	public TeamInformation[] swapping(int max, int index, TeamInformation[] info) {
		TeamInformation[] swap = info;
		TeamInformation temp = swap[max];
		swap[max] = swap[index];
		swap[index] = temp;
		return swap;
	}
}
public final class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LeaderBoard board = new LeaderBoard();
		while (scan.hasNext()) {
			String[] teams = scan.nextLine().split(",");
			board.add(new TeamInformation(teams[0],
			                              Integer.parseInt(teams[1]),
			                              Integer.parseInt(teams[2]),
			                              Integer.parseInt(teams[3])));
		}
		board.teamRanking();
		System.out.println(board.toString());
	}
}