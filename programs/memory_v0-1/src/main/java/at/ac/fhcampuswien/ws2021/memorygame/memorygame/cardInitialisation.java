package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class cardInitialisation {
    List<Integer> list = new ArrayList<>();
    private static Card [] cardReference;

    private void fillList(int numberOfCards){
        for(int i = 0; i < numberOfCards/2; i++){
            for(int j = 0; j < 2; j++) {
                list.add(i);
            }
        }
    }

    private int chooseRandCardId(){
        Random rand = new Random();
        int randId;
        if(!list.isEmpty()) {
            int randomIndex = rand.nextInt(list.size());
            randId = list.get(randomIndex);
            list.remove(randomIndex);
        }
        else{
            randId = -1;
        }
        return randId;
    }

    private void boardSetup(int numberOfCards){
        if(numberOfCards % 2 == 0){
            //i'ld suggest to show the cards in a 16:9 format (the standard format of a screen)

            float[] proportion = {16, 9};
            int y = (int) Math.ceil(Math.sqrt((proportion[1] / proportion[0]) * numberOfCards));
            int x = (int) Math.ceil(numberOfCards / y);
            int cardsToCreate = x * y;
            if(cardsToCreate < numberOfCards){
                y += 1;
                cardsToCreate = cardsToCreate + x;
            }
            //80 -> x: 52   y: 28
            Card [] cardArray = new Card[cardsToCreate];
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

    public static Card[] cardGeneration(int numberOfCards){
        cardInitialisation a = new cardInitialisation();

        //Scanner scanner = new Scanner(System.in);
        //System.out.print("Number of Cards: ");
        //int numberOfCards = scanner.nextInt();
        System.out.println("Number of cards created: " + numberOfCards);

        a.fillList(numberOfCards);
        a.boardSetup(numberOfCards);
        System.out.println("Done");

        return cardReference;
    }
}
