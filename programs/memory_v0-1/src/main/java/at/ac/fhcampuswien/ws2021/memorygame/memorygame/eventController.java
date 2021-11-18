package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class eventController {
    /*
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    */
    public double[] controller(double mouseX, double mouseY){
        System.out.println(mouseX + " | " + mouseY);
        return new double[]{mouseX,mouseY};
    }
}