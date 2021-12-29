package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class intermidiatePage extends Application {
    Button button;
    public static void main(String[] args) {
            launch(args);


    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Intermediate Page");
        button=new Button();
        button.setText("click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 1600, 900);
        stage.setScene(scene);
        stage.show();

    }
}
