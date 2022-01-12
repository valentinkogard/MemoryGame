package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env;

import java.util.Objects;

public class GameSettings {
    private String playerOne;
    private String playerTwo;
    private int numOfCards;
    private String theme;

    public GameSettings(){}

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public int getNumOfCards() {
        return numOfCards;
    }

    public void setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        if (Objects.equals(theme, "Katzen")){
            this.theme = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/theme1/image";
        }else {
            this.theme = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/theme2/image";
        }
    }
}
