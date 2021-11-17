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
import java.io.IOException;

public class gameview extends Application{ // implements EventHandler<MouseEvent>{

    EventHandler handler;
    Button btn = new Button();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws IOException{
        stage.setTitle("Mem(ory) game :<)");
        int window_height = 500;
        int window_length = 700;

        EventHandler<MouseEvent> eventHandler = new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                eventController.controller(mouseEvent.getSceneX(), mouseEvent.getSceneY());
            }
        };

        Card[] cards = cardInitialisation.cardGeneration(50);

        StackPane root = new StackPane();
        AnchorPane holder = new AnchorPane(); //each "holder" should contain one playing card
        holder.resize(20,20);
        String path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/image1.png";
        File directory = new File(path);
        System.out.print(directory.getAbsoluteFile());
        Image image = new Image(new FileInputStream(directory.getAbsoluteFile()));
        ImageView imageView = new ImageView(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
        holder.getChildren().add(imageView);

        root.getChildren().add(holder);
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        stage.setScene(new Scene(root, window_length, window_height));
        stage.show();
        //stage.setResizable(false);

    }

}
