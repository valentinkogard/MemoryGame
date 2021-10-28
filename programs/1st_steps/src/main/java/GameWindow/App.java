package GameWindow;

import java.util.Scanner;

public class App {

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
                    cardArray[counter] = new Card(j,i,0);
                    counter++;
                }
            }
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
        a.boardSetup(numberOfCards);
        //test
    }
}
