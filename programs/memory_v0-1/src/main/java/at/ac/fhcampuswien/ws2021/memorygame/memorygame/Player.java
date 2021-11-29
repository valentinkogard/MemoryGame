package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

public class Player {
    private String playerName;
    private int playerId;
    private int playerPoints;

    private static int playerCounter = 0;

    public Player(String playerName) {
        this.playerId = playerCounter;
        this.playerName = playerName;
        this.playerPoints = 0;
        playerCounter++;

    }

    //get-Methods
    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getPlayerPoints(){
        return playerPoints;
    }

    //set-Methods
    public void incPlayerPoints(){
        this.playerPoints++;
        System.out.println(this.playerName + " has now " + this.playerPoints + " Point(s)");
    }
}
