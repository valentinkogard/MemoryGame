package GameWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    List<Integer> list = new ArrayList<>();
    public static Card [] cardReference;

    public void fillList(int numberOfCards){
        for(int i = 0; i < numberOfCards/2; i++){
            for(int j = 0; j < 2; j++) {
                list.add(i);
            }
        }
    }

    public int chooseRandCardId(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        int randId = list.get(randomIndex);
        list.remove(randomIndex);
        return randId;
    }

    public void boardSetup(int numberOfCards){
        if(numberOfCards % 2 == 0){
            //i'ld suggest to show the cards in a 16:9 format (the standard format of a screen)
            //e.g 50 cards -> 50/(16+9) * 16 = 32 ... width
            //             -> 50/(16+9) * 09 = 18 ... hight
            float[] proportion = {16, 9};
            int y = (int) Math.floor(Math.sqrt((proportion[1] / proportion[0]) * numberOfCards));
            int x = (int) Math.ceil(numberOfCards / y);
            //80 -> x: 52   y: 28
            Card [] cardArray = new Card[numberOfCards];
            int counter = 0;
            for(int i = 0; i < y; i++){
                for(int j = 0; j < x; j++){
                    cardArray[counter] = new Card(j,i,chooseRandCardId());
                    counter++;
                }
            }
            cardReference = cardArray;
        }
        else {
            System.out.println("Card number is an odd number");
            //use a Logger in further versions
        }
    }

    public static void main(String[] args) {
        App a = new App();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of Cards: ");
        int numberOfCards = scanner.nextInt();

        a.fillList(numberOfCards);
        a.boardSetup(numberOfCards);
        System.out.println("Done");
        //test
    }
}
