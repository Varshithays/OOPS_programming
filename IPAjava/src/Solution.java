import java.util.*;

class MyClas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player[] p = new Player[4];

        // Input for 4 players
        for (int i = 0; i < 4; i++) {
            int a = in.nextInt(); in.nextLine(); // Player ID
            String b = in.nextLine(); // Player name
            int c = in.nextInt(); in.nextLine(); // Runs
            String d = in.nextLine(); // Player type
            String e = in.nextLine(); // Match type
            p[i] = new Player(a, b, c, d, e);
        }

        String playerType = in.nextLine(); // Player type to search
        String matchType = in.nextLine(); // Match type to search

        // Finding player with lowest runs for given playerType
        int run = findPlayerWithLowestRuns(p, playerType);
        if (run == Integer.MAX_VALUE) {
            System.out.println("No such player");
        } else {
            System.out.println(run);
        }

        // Finding players by match type
        Player[] ids = findPlayerByMatchType(p, matchType);
        if (ids == null) {
            System.out.println("No Player with given match Type");
        } else {
            for (int i = ids.length - 1; i >= 0; i--) {
                System.out.println(ids[i].getPlayerId());
            }
        }
    }

    // Method to find player with the lowest runs of the given playerType
    public static int findPlayerWithLowestRuns(Player[] pl, String playerType) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < pl.length; i++) {
            if (pl[i].getPlayerType().equalsIgnoreCase(playerType)) {
                if (pl[i].getRuns() < min) {
                    min = pl[i].getRuns();
                }
            }
        }
        return min;
    }

    // Method to find players by match type
    public static Player[] findPlayerByMatchType(Player[] pl, String matchType) {
        Player[] res = new Player[0]; // Empty array for matching players

        // Find all players with the given match type
        for (int i = 0; i < pl.length; i++) {
            if (pl[i].getMatchType().equalsIgnoreCase(matchType)) {
                res = Arrays.copyOf(res, res.length + 1);
                res[res.length - 1] = pl[i]; // Add matching player
            }
        }

        // If no matching players found, return null
        return res.length > 0 ? res : null;
    }
}

// Player class definition
class Player {
    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    // Constructor
    public Player(int playerId, String playerName, int runs, String playerType, String matchType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.playerType = playerType;
        this.matchType = matchType;
    }

    // Getter and setter methods
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }
}
