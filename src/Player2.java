import java.util.Scanner;

public class Player2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Playerprogram[] p = new Playerprogram[4];
        for (int i = 0; i < 4; i++) {
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            int c = in.nextInt();
            in.nextLine();
            int d = in.nextInt();
            in.nextLine();
            int e = in.nextInt();
            in.nextLine();

            p[i] = new Playerprogram(a, b, c, d, e);

        }
        int target = in.nextInt();
        in.nextLine();

        double[] result = findAverageScoreOfPlayers(p, target);

        for (int i = 0; i < result.length; i++) {
            if (result[i] <= 80.0) {
                System.out.println("Grade A Player");
            } else if (result[i] <= 79.0 && result[i] >= 50.0) {
                System.out.println("Grade B Player");
            } else {
                System.out.println("Grade C Player");
            }
        }

    }

    public static double[] findAverageScoreOfPlayers(Playerprogram[] p, int target) {
        int count = 0;


        for (int i = 0; i < p.length; i++) {
            if (p[i].getNoOfMatchesPlayed() >= target) {
                count++;
            }
        }
        double avgrunrate = 0.0;
        double[] runrate = new double[count];
        for (int i = 0; i < p.length; i++) {
            avgrunrate = p[i].getTotalRunsScored() / p[i].getNoOfMatchesPlayed();
            runrate[i] = avgrunrate;
        }
        return runrate;
    }



}



class Playerprogram{
    private int playerId;
    private String playerName;
    private int iccRank;
    private int noOfMatchesPlayed;
    private int totalRunsScored;

    public Playerprogram(int playerId,String playerName,int iccRank,int noOfMatchesPlayed,int totalRunsScored){
        this.playerId=playerId;
        this.playerName=playerName;
        this.iccRank=iccRank;
        this.noOfMatchesPlayed=noOfMatchesPlayed;
        this.totalRunsScored=totalRunsScored;
    }

    public int getPlayerId(){
        return playerId;
    }
    public String getPlayerName(){
        return playerName;
    }
    public int getIccRank(){
        return iccRank;
    }
    public int getNoOfMatchesPlayed(){
        return noOfMatchesPlayed;
    }
    public int getTotalRunsScored(){
        return totalRunsScored;
    }
}
