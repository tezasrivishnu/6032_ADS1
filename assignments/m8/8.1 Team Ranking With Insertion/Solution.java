import java.util.Scanner;
import java.util.Arrays;
class TeamInformation {
//implements Comparable<TeamInformation> {
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
			return 1;
		} else {
			if (this.teamloses < that.teamloses) {
				return 1;
			} else {
				if (this.teamdraws > that.teamdraws) {
					return 1;
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
			for (int j = i + 1; j < team.length; j++) {
				int count = team[j].compareTo(team[max]);
				if (count == 1) {
					max = j;
				}
			}
			team = swapping(max, i, team);
		}
		return team;
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