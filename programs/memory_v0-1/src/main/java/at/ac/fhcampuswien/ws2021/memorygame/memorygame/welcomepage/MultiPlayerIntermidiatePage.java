package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.GameSettings;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.WindowSize;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MultiPlayerIntermidiatePage {

    public static int[] windowSize;

    private Button button;

    private GameSettings settings;

    public Object[] multiPlayerIntInit() throws Exception {
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();

        settings = new GameSettings();

        String[] currentPlayers = new String[2];
        //stage.setTitle("Intermediate Page");

        button = new Button();
        button.setText("Start Memory");
        button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button.setFont(new Font(20));
        button.setMinWidth(200);

        VBox vbox = new VBox();

        ChoiceBox<String> numOfCards = new ChoiceBox<>();
        ChoiceBox<String> themeOfCards = new ChoiceBox<>();
        TextField playerOneName = new TextField();
        TextField playerTwoName = new TextField();
        Label playerOneNameLabel = new Label("Player One");
        Label playerTwoNameLabel = new Label("Player Two");
        Label numOfCardsLabel = new Label("Number of Cards");
        Label themeOfCardsLabel = new Label("Theme");

        HBox hboxPlayerNameLabels = new HBox();
        hboxPlayerNameLabels.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNameLabels.setPadding(new Insets(75, 0, 0, 0));
        hboxPlayerNameLabels.getChildren().addAll(playerOneNameLabel, playerTwoNameLabel);
        hboxPlayerNameLabels.setMargin(playerOneNameLabel, new Insets(0, 200, 0, 100));
        playerOneNameLabel.setStyle("-fx-text-fill: darkslateblue;");
        playerOneNameLabel.setFont(new Font(20));
        playerOneNameLabel.setMinWidth(200);
        playerTwoNameLabel.setStyle("-fx-text-fill: darkslateblue;");
        playerTwoNameLabel.setFont(new Font(20));
        playerTwoNameLabel.setMinWidth(200);

        HBox hboxPlayerNames = new HBox();
        hboxPlayerNames.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNames.setPadding(new Insets(0, 0, 0, 0));
        hboxPlayerNames.getChildren().addAll(playerOneName, playerTwoName);
        hboxPlayerNames.setMargin(playerOneName, new Insets(0, 150, 0, 0));
        playerOneName.setOnKeyReleased(keyEvent -> setPlayerOneName(playerOneName));
        playerTwoName.setOnKeyReleased(keyEvent -> setPlayerTwoName(playerTwoName));
        playerOneName.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        playerOneName.setFont(new Font(20));
        playerOneName.setMinWidth(200);
        playerTwoName.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        playerTwoName.setFont(new Font(20));
        playerTwoName.setMinWidth(200);

        HBox hboxnumOfCardsLabel = new HBox();
        hboxnumOfCardsLabel.setAlignment(Pos.TOP_CENTER);
        hboxnumOfCardsLabel.setPadding(new Insets(75, 0, 0, 50));
        hboxnumOfCardsLabel.getChildren().addAll(numOfCardsLabel);
        numOfCardsLabel.setStyle("-fx-text-fill: darkslateblue;");
        numOfCardsLabel.setFont(new Font(20));
        numOfCardsLabel.setMinWidth(200);

        HBox hboxnumOfCards = new HBox();
        hboxnumOfCards.setAlignment(Pos.TOP_CENTER);
        hboxnumOfCards.setPadding(new Insets(0, 0, 0, 0));
        hboxnumOfCards.getChildren().addAll(numOfCards);
        numOfCards.getItems().addAll("Easy", "Medium", "Hard", "Extreme");
        numOfCards.setValue("Select Difficulty");
        numOfCards.setOnAction(actionEvent -> getNumOfCards(numOfCards));


        HBox hboxThemeOfCardsLabel = new HBox();
        hboxThemeOfCardsLabel.setAlignment(Pos.TOP_CENTER);
        hboxThemeOfCardsLabel.setPadding(new Insets(75, 0, 0, 135));
        hboxThemeOfCardsLabel.getChildren().addAll(themeOfCardsLabel);
        themeOfCardsLabel.setStyle("-fx-text-fill: darkslateblue;");
        themeOfCardsLabel.setFont(new Font(20));
        themeOfCardsLabel.setMinWidth(200);

        HBox hboxThemeOfCards = new HBox();
        hboxThemeOfCards.setAlignment(Pos.TOP_CENTER);
        hboxThemeOfCards.setPadding(new Insets(0, 0, 0, 0));
        hboxThemeOfCards.getChildren().addAll(themeOfCards);
        themeOfCards.getItems().addAll("Sehenswürdigkeiten", "Katzen");
        themeOfCards.setValue("Select Theme");
        themeOfCards.setOnAction(actionEvent -> getThemeOfCards(themeOfCards));

        HBox hboxButton = new HBox();
        hboxButton.setAlignment(Pos.TOP_CENTER);
        hboxButton.setPadding(new Insets(75, 0, 0, 0));
        hboxButton.getChildren().addAll(button);


        vbox.getChildren().addAll(hboxPlayerNameLabels, hboxPlayerNames, hboxnumOfCardsLabel, hboxnumOfCards, hboxThemeOfCardsLabel, hboxThemeOfCards, hboxButton);
        Scene scene = new Scene(vbox, windowSize[0], windowSize[1]);
        String pathToBg = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background2.jpg";
        File directoryToBg = new File(pathToBg);

        BackgroundImage myBI = new BackgroundImage(new Image(new FileInputStream(directoryToBg.getAbsoluteFile()), windowSize[0], windowSize[1], false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        vbox.setBackground(new Background(myBI));
        //stage.setScene(scene);
        //stage.show();

        return new Object[]{scene, button, settings};
    }

    private void getNumOfCards(ChoiceBox<String> level) {
        if ("easy".equals(level.getValue())) {
            settings.setNumOfCards(12);
        } else if ("medium".equals(level.getValue())) {
            settings.setNumOfCards(15);
        } else if ("hard".equals(level.getValue())) {
            settings.setNumOfCards(16);
        } else if ("extreme".equals(level.getValue())) {
            settings.setNumOfCards(20);
        }
    }

    private void getThemeOfCards(ChoiceBox<String> themeOfCards) {
        settings.setTheme(themeOfCards.getValue());
    }

    private void setPlayerOneName(TextField playerOneName) {
        settings.setPlayerOne(playerOneName.getText());
    }

    private void setPlayerTwoName(TextField playerTwoName) {
        settings.setPlayerTwo(playerTwoName.getText());
    }

    public Background PageBack(String path) throws FileNotFoundException {

        File directory1 = new File(path);
        javafx.scene.image.Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

        BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bi);
        return bg;
    }
}
