package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gameview extends Application{ // implements EventHandler<MouseEvent>{

    //EventHandler handler;
    public static Card[] cards;
    public static AnchorPane[] arr;
    public static List<Player> gamePlayer = new ArrayList<Player>();;

    public static int size, spaceX, spaceY;

    public static int gameheaderSize = 50;

    public void findImageToChange(double mouseX, double mouseY) throws FileNotFoundException {
        for(int i = 0; i < cards.length; i++){
            int[] pixel = cards[i].getPixel();
            //0 -> x1; 1 -> y1; 2 -> x2; 3 -> y2
            if(pixel[0] < mouseX && mouseX < pixel[2] && pixel[1] < mouseY && mouseY < pixel[3] && cards[i].isCardShown()){
                //cards[i].setPictureShown(!cards[i].isPictureShown());
                cards[i].setPictureShown(true);
                ImageController.removeChildren(i, arr);
                arr[i] = ImageController.setImage(i, arr[i]);
                System.out.println("Children of " + i + ": "+ arr[i].getChildren().size());
                break;
            }
        }
        System.out.println("0");
    }

    @Override
    public void start(Stage stage) throws IOException{
        int numberOfPlayer = 2;
        for(int i = 0; i < numberOfPlayer; i++){
            gamePlayer.add(new Player("Player" + i));
        }
        Player p1 = new Player("Hello");


        stage.setTitle("Mem(ory) game :<)");
        int window_height = 500;
        int window_length = 800;

        EventHandler<MouseEvent> eventHandler = new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                EventController evC = new EventController();
                double[] feedback = evC.controller(mouseEvent.getSceneX(), mouseEvent.getSceneY());
                try {
                    Rules r = new Rules();
                    if(r.isMoveAllowed(cards)){
                        findImageToChange(feedback[0], feedback[1]);
                    }
                    else {
                        if(r.twoCardsUncovered(cards, arr)){
                            //p1.incPlayerPoints();
                            gamePlayer.get(0).incPlayerPoints();
                            System.out.println("Bravo...");
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
        //!!! change methode that is can also handle e.g 80 cards
        //current problem: algorithm cases empty objects which leads in gameview to an error(1)

        cards = CardInitialisation.cardGeneration(30);
        StackPane root = new StackPane();

        arr = new AnchorPane[cards.length];


        size = 40;
        spaceX = (window_length - (size * cards[0].getNumberOfCardsXY()[0]))/(cards[0].getNumberOfCardsXY()[0] + 1);
        spaceY = (window_height - gameheaderSize - (size * cards[0].getNumberOfCardsXY()[1]))/(cards[0].getNumberOfCardsXY()[1] + 3);
        //spaceY = (window_height - (size * cards[0].getNumberOfCardsXY()[1]))/(cards[0].getNumberOfCardsXY()[1] + 3);

        //create gameheader
        HBox header = new HBox();
        Label label = new Label("Hello World");
        header.setVisible(true);
        //header.getChildren().add(label);
        root.getChildren().add(header);


        for(int i = 0; i < cards.length; i++){
            AnchorPane holder = new AnchorPane(); //each "holder" should contain one playing card
            arr[i] = holder;

            holder.resize(size,size);
            if(cards[i].getPictureId() != -1) {
                arr[i] = ImageController.setImage(i, arr[i]);
            }
            root.getChildren().add(arr[i]);
        }

        root.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        stage.setScene(new Scene(root, window_length, window_height));
        //stage.setResizable(false);
        //window_length = (int) stage.getX();
        //window_height = (int) stage.getY();
        stage.show();
        stage.setResizable(false);

    }

    public static void main(String[] args) {

        launch(args);
    }
}
