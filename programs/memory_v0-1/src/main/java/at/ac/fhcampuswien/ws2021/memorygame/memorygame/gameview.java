package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.event.AWTEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;

public class gameview extends Application{ // implements EventHandler<MouseEvent>{

    EventHandler handler;
    private Card [] cards;
    private AnchorPane arr[];

    private int size, spaceX, spaceY;

    public void findImageToChange(double mouseX, double mouseY) throws FileNotFoundException {
        for(int i = 0; i < cards.length; i++){
            int[] pixel = cards[i].getPixel();
            //0 -> x1; 1 -> y1; 2 -> x2; 3 -> y2
            if(pixel[0] < mouseX && mouseX < pixel[2] && pixel[1] < mouseY && mouseY < pixel[3] && !cards[i].isPictureShown()){
                cards[i].setPictureShown(true);
                arr[i].getChildren().remove(0);
                arr[i].getChildren().add(setImage(i));
                break;
            }
            else if(pixel[0] < mouseX && mouseX < pixel[2] && pixel[1] < mouseY && mouseY < pixel[3] && cards[i].isPictureShown()){
                cards[i].setPictureShown(false);
                arr[i].getChildren().remove(0);
                arr[i].getChildren().add(setImage(i));
                break;
            }
        }
        System.out.println("0");
    }

    private ImageView setImage(int i) throws FileNotFoundException {
        String path;
        if(cards[i].isPictureShown()){
            path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/image1.png";
        }
        else {
            path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/cover.jpg";
        }
        File directory = new File(path);
        Image image = new Image(new FileInputStream(directory.getAbsoluteFile()));
        ImageView imageView = new ImageView(image);
        int x = spaceX + cards[i].getPosition()[0] * (size + spaceX);
        int y = spaceY + cards[i].getPosition()[1] * (size + spaceY);
        imageView.setX(x);
        imageView.setY(y);
        cards[i].setPixel(x, y, x+size, y+size);
        imageView.setFitWidth(size);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    @Override
    public void start(Stage stage) throws IOException{
        stage.setTitle("Mem(ory) game :<)");
        int window_height = 500;
        int window_length = 800;

        EventHandler<MouseEvent> eventHandler = new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                eventController evC = new eventController();
                double[] feedback = evC.controller(mouseEvent.getSceneX(), mouseEvent.getSceneY());
                try {
                    findImageToChange(feedback[0], feedback[1]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
        //!!! change methode that is can also handle e.g 80 cards
        //current problem: algorithm cases empty objects which leads in gameview to an error(1)

        cards = cardInitialisation.cardGeneration(50);
        StackPane root = new StackPane();

        arr = new AnchorPane[cards.length];

        size = 40;
        spaceX = (window_length - (size * cards[0].getNumberOfCardsXY()[0]))/(cards[0].getNumberOfCardsXY()[0] + 1);
        spaceY = (window_height - (size * cards[0].getNumberOfCardsXY()[1]))/(cards[0].getNumberOfCardsXY()[1] + 3);

        for(int i = 0; i < cards.length; i++){
            AnchorPane holder = new AnchorPane(); //each "holder" should contain one playing card
            arr[i] = holder;

            holder.resize(size,size);
            if(cards[i].getPictureId() != -1) {
                holder.getChildren().add(setImage(i));
            }
            root.getChildren().add(holder);
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
