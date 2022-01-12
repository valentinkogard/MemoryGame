package at.ac.fhcampuswien.ws2021.memorygame.memorygame.game;

import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Rules {

    /**
     * Ensures that a maximum of two cards are face up at the same time
     * @param cards
     * @return true if less than two cards are face up
     */
    public boolean isMoveAllowed(Card[] cards){
        int counter = 0;
        for (Card card : cards) {
            if (card.isPictureShown()) {
                counter++;
            }
        }
        return counter < 2;
    }

    /**
     * compares to cards if they are both visible (face up) and have the same Card-ID
     * @param cards - array of all cards
     * @param arr - an AnchorPane (Style)
     * @param uncoveredCards - List of face up cards
     * @return true if same Card-ID and both uncovered
     */
    public boolean isMatch(Card[] cards, AnchorPane[] arr, List<Integer> uncoveredCards){

        if(cards[uncoveredCards.get(0)].equals(cards[uncoveredCards.get(1)]) &&
        cards[uncoveredCards.get(0)].isCardShown() && cards[uncoveredCards.get(1)].isCardShown()){
            cards[uncoveredCards.get(0)].setCardShown(false);
            arr[uncoveredCards.get(0)].setVisible(false);
            cards[uncoveredCards.get(1)].setCardShown(false);
            arr[uncoveredCards.get(1)].setVisible(false);
            return true;
        }
        return false;
    }

    /**
     *
     * @param p - Player for whom it is to be checked whether he has won
     * @return true if player has won the game
     */
    public boolean playerWon(Player p){
        return p.getPlayerPoints() > (Gameview.cards.length / 2) / p.getNumOfPlayers();
    }

    /**
     * is used to find out which player's turn it is at the moment
     * @param players - all Players
     * @return player currently in turn
     */
    public int getPlayerInTurn(List<Player> players){
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getInTurn()) return i;
        }
        return -1;
    }

    /**
     * is used to define the next player whose turn it is to play |
     * if there are n players (with i < n) -> next player is n+1 |
     * if i=n -> next player i = 0
     * @param players - List of all Players
     */
    public void setPlayerInTurn(List<Player> players){
        int currentlyInTurn = getPlayerInTurn(players);

        players.get(currentlyInTurn).setInTurn(false);

        if(currentlyInTurn + 1 >= players.size()) players.get(0).setInTurn(true);
        else players.get(currentlyInTurn + 1).setInTurn(true);
    }

    /**
     * is used to identify the printed cards and
     * then check whether they are the same (have the same card ID).
     * @param cards
     * @param arr
     * @return boolean if two cards match
     * @throws FileNotFoundException
     */
    public boolean twoCardsUncovered(Card[] cards, AnchorPane[] arr) throws FileNotFoundException {
        int counter = 0;
        boolean isMatch;
        List<Integer> uncoveredCards = new ArrayList<>();
        for(int i = 0; i < cards.length; i++){
            if(cards[i].isPictureShown()){
                counter++;
                uncoveredCards.add(i);
            }
        }
        if(counter >= 2) {
            isMatch = isMatch(cards, arr, uncoveredCards);
            for (int i = 0; i < cards.length; i++) {
                if(cards[i].getPictureId() != -1 && cards[i].isPictureShown()) {
                    cards[i].setPictureShown(false);
                    ImageController.removeChildren(i, arr);
                    arr[i] = ImageController.setImage(i, arr[i]);
                }
            }
            return isMatch;
        }
        return false;
    }


}
