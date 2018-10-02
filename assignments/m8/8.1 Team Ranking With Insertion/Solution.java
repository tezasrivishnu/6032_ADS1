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
}
class TeamSorting {
	TeamInformation[] teaminformation;
	int size;
	TeamSorting() {
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
		for (int i = 0; i < size; i++) {
			int max = i;
			for (int j = i + 1; j < size; j++) {
				if (teaminformation[j].getTeamWins() > teaminformation[i].getTeamWins()) {
					max = j;
					break;
				}
				else if (teaminformation[j].getTeamWins() == teaminformation[i].getTeamWins()) {
					if (teaminformation[j].getTeamLoses() < teaminformation[i].getTeamLoses()) {
						max = j;
						break;
					}
				}
				else if (teaminformation[j].getTeamWins() == teaminformation[i].getTeamWins()) {
					if (teaminformation[j].getTeamLoses() == teaminformation[i].getTeamLoses()) {
						if (teaminformation[j].getTeamDraws() > teaminformation[i].getTeamDraws()) {
							max = j;
							break;
						}
					}
				}
			}
			TeamInformation temp = teaminformation[max];
			teaminformation[max] = teaminformation[i];
			teaminformation[i] = temp;
		}
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
public final class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TeamSorting sorting = new TeamSorting();
		while (scan.hasNext()) {
			String[] teams = scan.nextLine().split(",");
			sorting.add(new TeamInformation(teams[0],
			                                Integer.parseInt(teams[1]),
			                                Integer.parseInt(teams[2]),
			                                Integer.parseInt(teams[3])));
		}
		sorting.teamRanking();
		System.out.println(sorting.toString());
	}
}