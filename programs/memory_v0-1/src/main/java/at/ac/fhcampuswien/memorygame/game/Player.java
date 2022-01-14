package at.ac.fhcampuswien.memorygame.game;

public class Player {
    private String playerName;
    private int playerId;
    private int playerPoints;
    private boolean inTurn;

    private static int playerCounter = 0;
    private static int triesOfPlayer = 0;

    public Player(String playerName) {
        this.playerId = playerCounter;
        this.playerName = playerName;
        this.playerPoints = 0;

        if(playerCounter == 0) this.inTurn = true;
        else this.inTurn = false;

        playerCounter++;
    }

    //get-Methods
    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getNumOfPlayers(){
        return playerCounter;
    }

    public int getPlayerPoints(){
        return playerPoints;
    }

    public boolean getInTurn(){
        return this.inTurn;
    }

    public int getTriesOfPlayer(){
        return triesOfPlayer;
    }

    //set-Methods
    public void incPlayerPoints(){
        this.playerPoints++;
        System.out.println(this.playerName + " has now " + this.playerPoints + " Point(s)");
    }

    public void setInTurn(boolean inTurn) {
        this.inTurn = inTurn;
    }

    public void incTriesOfPlayer(){
        triesOfPlayer++;
    }

    public void resetTriesOfPlayer(){
        triesOfPlayer = 0;
    }

    // method to get player names and points for the game header
    public String getHeader(){
        return " Player " + (this.playerId + 1) + " : " + this.getPlayerName() + "\t " + this.getPlayerPoints() + " Point(s) ";
    }

    public void resetPlayerCounter(){
        playerCounter = 0;
    }
}
