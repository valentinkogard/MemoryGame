package at.ac.fhcampuswien.memorygame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardInitialisation {
    List<Integer> list = new ArrayList<>();
    private static Card[] cardReference;

    /**
     * since each card occurs twice, a list with n, n, n+1, n+1, n+2, n+2, ...
     * @param numberOfCards
     */
    private void fillList(int numberOfCards){
        Random random = new Random();
        int randomIndex = -1;
        for(int i = 0; i < numberOfCards/2; i++){
            do{
                randomIndex = random.nextInt(20);
            }while(list.contains(randomIndex));
            for (int j = 0; j < 2; j++) {
                list.add(randomIndex);
            }
        }
    }

    /**
     * randomly selects a number from the list (from the method fillList),
     * adds it to the respective object and eliminates it from the list
     * @return
     */
    private int chooseRandCardId(){
        Random rand = new Random();
        int randId;
        if(!list.isEmpty()) {
            int randomIndex = rand.nextInt(list.size());
            randId = list.get(randomIndex);
            System.out.print(randId + ", ");
            list.remove(randomIndex);
        }
        else{
            randId = -1;
        }
        return randId;
    }

    /**
     * takes an int parameter and checks if it is an even number (otherwise error(1))
     *
     * Calculates how many cards should be placed in the x- or y- direction
     * based on the aspect ratio and returns the finished object array.
     * @param numberOfCards
     */
    private void boardSetup(int numberOfCards){
        if(numberOfCards % 2 == 0){
            //show the cards in a 16:9 format (the standard format of a screen)
            float[] proportion = {16, 9};
            int y = (int) Math.ceil(Math.sqrt((proportion[1] / proportion[0]) * numberOfCards));
            int x = (int) Math.ceil(numberOfCards / y);
            int cardsToCreate = x * y;
            if(cardsToCreate < numberOfCards){
                y += 1;
                cardsToCreate = cardsToCreate + x;
            }
            //80 -> x: 52   y: 28
            Card[] cardArray = new Card[cardsToCreate];
            int counter = 0;
            for(int i = 0; i < y; i++){
                for(int j = 0; j < x; j++){
                    cardArray[counter] = new Card(j,i,chooseRandCardId());
                    if(cardArray[counter].getPictureId() == -1){
                        cardArray[counter].setCardShown(false);
                    }
                    counter++;
                }
            }
            cardReference = cardArray;
        }
        else {
            System.out.println("Card number is an odd number");
            System.exit(1);
            //use a Logger in further versions
        }
    }

    /**
     * is responsible for the creation of the Card objects
     * @param numberOfCards
     * @return
     */
    public static Card[] cardGeneration(int numberOfCards){
        CardInitialisation a = new CardInitialisation();

        System.out.println("Number of cards created: " + numberOfCards);

        a.fillList(numberOfCards);
        a.boardSetup(numberOfCards);
        System.out.println("Done");
        return cardReference;
    }
}
