package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

public class Player {
    private String playerName;
    private int playerId;

    private int playerCounter = 0;

    public Player(String playerName) {
        this.playerId = playerCounter;
        playerCounter++;
        this.playerName = playerName;
    }

    //get-Methods
    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }
}
