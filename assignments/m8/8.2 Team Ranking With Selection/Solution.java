import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for team information.
 * @author tezasrivishnu.
 */
class TeamInformation {
//implements Comparable<TeamInformation> {
    /**
     * declaring String variable teamname.
     */
    private String teamname;
    /**
     * declaring int variable teamwins.
     */
    private int teamwins;
    /**
     * declaring int variable teamloses.
     */
    private int teamloses;
    /**
     * declaring int variable teamdraws.
     */
    private int teamdraws;
    /**
     * Constructs the object.
     *
     * @param      name   string type
     * @param      wins   int type
     * @param      loses  int type
     * @param      draws  int type
     */
    TeamInformation(final String name, final int wins,
                    final int loses, final int draws) {
        this.teamname = name;
        this.teamwins = wins;
        this.teamloses = loses;
        this.teamdraws = draws;
    }
    /**
     * Gets the team name.
     * complexity O(1)
     * because we are just returing the name.
     * @return     string team name
     */
    public String getTeamName() {
        return this.teamname;
    }
    /**
     * Gets the no. of team wins.
     * complexity O(1)
     * because we are just returing the no of wins.
     * @return     int
     */
    public int getTeamWins() {
        return this.teamwins;
    }
    /**
     * Gets the no of team loses.
     * complexity O(1)
     * because we are just returing the no of loses.
     * @return     int
     */
    public int getTeamLoses() {
        return this.teamloses;
    }
    /**
     * Gets the no of draws.
     * complexity O(1)
     * because we are just returing the no of draws.
     * @return     int
     */
    public int getTeamDraws() {
        return this.teamdraws;
    }
    /**
     * compare two teaminformation objects
     * respective of their individual parameters.
     * complexity O(1)
     * because just comparing the two element parameters
     * @param      that  teaminformation object
     *
     * @return     boolean
     */
    public boolean less(final TeamInformation that) {
        if (this.teamwins > that.teamwins) {
            return true;
        }
        if (this.teamwins == that.teamwins) {
            if (this.teamloses < that.teamloses) {
                return true;
            }
        }
        if (this.teamwins == that.teamwins) {
            if (this.teamloses == that.teamloses) {
                if (this.teamdraws > that.teamdraws) {
                    return true;
                }
            }
        }
        return false;
    }
}
/**
 * Class for leader board.
 */
class LeaderBoard {
    /**
     * declaring array of teaminformation class objects.
     */
    private TeamInformation[] teaminformation;
    /**
     * declaring inr variable size.
     */
    private int size;
    /**
     * declaring sorting class object sort.
     */
    private Sorting sort;
    /**
     * Constructs the object.
     */
    LeaderBoard() {
        sort = new Sorting();
        teaminformation = new TeamInformation[2 + 2 + 2 + 2 + 2];
        size = 0;
    }
    /**
     * adding a object to the teaminformation array.
     * complexity O(1)
     * because we are just adding a element.
     * @param      teamdata  teaminformation object
     */
    public void add(final TeamInformation teamdata) {
        teaminformation[size] = teamdata;
        size += 1;
    }
    /**
     * size of teaminformation array.
     * complexity O(1)
     * because we are returning the size.
     * @return     int size
     */
    public int size() {
        return size;
    }
    /**
     * sorting the array according the parameters.
     */
    public void teamRanking() {
        teaminformation = Arrays.copyOf(teaminformation, size);
        teaminformation = sort.teamSorting(teaminformation);
    }
    /**
     * Returns a string representation
     * of the array objects in form of team names.
     * complexity O(N)
     * beacuse we are iterating throughout the array.
     * @return     String
     */
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
/**
 * Class for sorting.
 */
class Sorting {
    /**
     * Constructs the object.
     */
    Sorting() {

    }
    /**
     * sorting of the teaminformation array using insertion sort.
     * complexity O(N^2/4)
     * because we are using two lopps, one for and anpther while loop.
     * @param      team  teaminformation objects array.
     *
     * @return     teaminformation objects array.
     */
    public TeamInformation[] teamSorting(final TeamInformation[] team) {
        TeamInformation[] teams = team;
        for (int i = 1; i < teams.length; i++) {
            TeamInformation key = teams[i];
            int j = i - 1;
            while (j >= 0 && key.less(teams[j])) {
                teams[j + 1] = teams[j];
                j = j - 1;

            }
            teams[j + 1] = key;
        }
        return teams;
    }
}
/**
 * class Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main program.
     * complexity O(N)
     * because we are taking the input using for loop
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LeaderBoard board = new LeaderBoard();
        while (scan.hasNext()) {
            String[] teams = scan.nextLine().split(",");
            board.add(new TeamInformation(teams[0],
                                          Integer.parseInt(teams[1]),
                                          Integer.parseInt(teams[2]),
                                          Integer.parseInt(teams[2 + 1])));
        }
        board.teamRanking();
        System.out.println(board.toString());
    }
}
