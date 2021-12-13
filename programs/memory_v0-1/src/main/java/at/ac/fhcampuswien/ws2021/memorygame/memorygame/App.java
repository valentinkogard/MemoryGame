/*
https://www.youtube.com/watch?v=FLkOX4Eez6o

stage: is the whole window
scene: what happens

 */

package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App  {

    public static void main(String[] args) {
        System.out.println("Starting memory");
        //new gameview();
        gameview.launch();


    }


}