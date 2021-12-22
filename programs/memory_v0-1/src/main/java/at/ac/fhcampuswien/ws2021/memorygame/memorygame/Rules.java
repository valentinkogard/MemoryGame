package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Rules {

    public boolean isMoveAllowed(Card[] cards){
        int counter = 0;
        for(int i = 0; i < cards.length; i++){
            if(cards[i].isPictureShown()){
                counter++;
            }
        }
        if(counter >= 2){
            return false;
        }
        return true;
    }

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

    public boolean playerWon(Player p){
        if(p.getPlayerPoints() > Gameview.cards.length/2){
            return true;
        }
        return false;
    }

    public int getPlayerInTurn(List<Player> players){
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getInTurn()) return i;
        }
        return -1;
    }

    public void setPlayerInTurn(List<Player> players){
        players.get(0).incTriesOfPlayer();       //not pretty well coded...
        if(players.get(0).getTriesOfPlayer() >= 2){
            players.get(0).resetTriesOfPlayer();
            int currentlyInTurn = getPlayerInTurn(players);

            if(currentlyInTurn + 1 >= players.size()) players.get(0).setInTurn(true);
            else players.get(currentlyInTurn + 1).setInTurn(true);

            players.get(currentlyInTurn).setInTurn(false);
        }
    }

    public boolean twoCardsUncovered(Card[] cards, AnchorPane[] arr) throws FileNotFoundException {
        int counter = 0;
        boolean isMatch = false;
        List<Integer> uncoveredCards = new ArrayList<Integer>();
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
