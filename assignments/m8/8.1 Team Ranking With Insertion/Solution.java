import java.util.Scanner;
import java.util.Arrays;
class TeamInformation {
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
	public int compareTo(TeamInformation this, TeamInformation that) {
		return 0;
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
		sort.teamSorting(teaminformation);
	}
	public String toString() {
		String str = "";
		int i = 0;
		for (i = 0; i<size-1; i++) {
			str += teaminformation[i].getTeamName() + ",";
		}
		str += teaminformation[i].getTeamName();
		return str;
	}
}
class Sorting {
	Sorting() {

	}
	public void teamSorting(TeamInformation[] team) {

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