package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

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

public class MultiPlayerIntermidiatePage {

    public static int[] windowSize;

    Button button;

    public Object[] multiPlayerIntInit() throws Exception {
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();
        //stage.setTitle("Intermediate Page");

        button=new Button();
        button.setText("Start Memory");
        button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button.setFont(new Font(20));
        button.setMinWidth(200);

        VBox vbox = new VBox();

        ChoiceBox<Integer> numOfCards = new ChoiceBox<>();
        ChoiceBox<String> themeOfCards= new ChoiceBox<>();
        TextField playerOneName = new TextField();
        TextField playerTwoName = new TextField();
        Label playerOneNameLabel= new Label("Player One");
        Label playerTwoNameLabel= new Label("Player Two");
        Label numOfCardsLabel= new Label("Number of Cards");
        Label themeOfCardsLabel= new Label("Theme");

        HBox hboxPlayerNameLabels= new HBox();
        hboxPlayerNameLabels.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNameLabels.setPadding(new Insets(75,0,0,0));
        hboxPlayerNameLabels.getChildren().addAll(playerOneNameLabel, playerTwoNameLabel);
        hboxPlayerNameLabels.setMargin(playerOneNameLabel, new Insets(0,200,0,100));
        playerOneNameLabel.setStyle("-fx-text-fill: darkslateblue;");
        playerOneNameLabel.setFont(new Font(20));
        playerOneNameLabel.setMinWidth(200);
        playerTwoNameLabel.setStyle("-fx-text-fill: darkslateblue;");
        playerTwoNameLabel.setFont(new Font(20));
        playerTwoNameLabel.setMinWidth(200);

        HBox hboxPlayerNames= new HBox();
        hboxPlayerNames.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNames.setPadding(new Insets(0,0,0,0));
        hboxPlayerNames.getChildren().addAll(playerOneName, playerTwoName);
        hboxPlayerNames.setMargin(playerOneName, new Insets(0,150,0,0));
        playerOneName.setOnKeyReleased(keyEvent -> setPlayerOneName(playerOneName));
        playerTwoName.setOnKeyReleased(keyEvent -> setPlayerTwoName(playerTwoName));
        playerOneName.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        playerOneName.setFont(new Font(20));
        playerOneName.setMinWidth(200);
        playerTwoName.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        playerTwoName.setFont(new Font(20));
        playerTwoName.setMinWidth(200);

        HBox hboxnumOfCardsLabel= new HBox();
        hboxnumOfCardsLabel.setAlignment(Pos.TOP_CENTER);
        hboxnumOfCardsLabel.setPadding(new Insets(75,0,0,50));
        hboxnumOfCardsLabel.getChildren().addAll(numOfCardsLabel);
        numOfCardsLabel.setStyle("-fx-text-fill: darkslateblue;");
        numOfCardsLabel.setFont(new Font(20));
        numOfCardsLabel.setMinWidth(200);

        HBox hboxnumOfCards= new HBox();
        hboxnumOfCards.setAlignment(Pos.TOP_CENTER);
        hboxnumOfCards.setPadding(new Insets(0,0,0,0));
        hboxnumOfCards.getChildren().addAll(numOfCards);
        numOfCards.getItems().addAll(10,11,12,13,14,15,16,1,7,18,19,20);
        numOfCards.setValue(10);
        numOfCards.setOnAction(actionEvent -> getNumOfCards(numOfCards));


        HBox hboxThemeOfCardsLabel= new HBox();
        hboxThemeOfCardsLabel.setAlignment(Pos.TOP_CENTER);
        hboxThemeOfCardsLabel.setPadding(new Insets(75,0,0,135));
        hboxThemeOfCardsLabel.getChildren().addAll(themeOfCardsLabel);
        themeOfCardsLabel.setStyle("-fx-text-fill: darkslateblue;");
        themeOfCardsLabel.setFont(new Font(20));
        themeOfCardsLabel.setMinWidth(200);

        HBox hboxThemeOfCards= new HBox();
        hboxThemeOfCards.setAlignment(Pos.TOP_CENTER);
        hboxThemeOfCards.setPadding(new Insets(0,0,0,0));
        hboxThemeOfCards.getChildren().addAll(themeOfCards);
        themeOfCards.getItems().addAll("Sehenswürdigkeiten", "Katzen");
        themeOfCards.setValue("Sehenswürdigkeiten");
        themeOfCards.setOnAction(actionEvent -> getThemeOfCards(themeOfCards));

        HBox hboxButton= new HBox();
        hboxButton.setAlignment(Pos.TOP_CENTER);
        hboxButton.setPadding(new Insets(75,0,0,0));
        hboxButton.getChildren().addAll(button);



        vbox.getChildren().addAll(hboxPlayerNameLabels,hboxPlayerNames, hboxnumOfCardsLabel, hboxnumOfCards, hboxThemeOfCardsLabel, hboxThemeOfCards,hboxButton);
        Scene scene = new Scene(vbox, windowSize[0], windowSize[1]);
        String pathToBg = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background2.jpg";
        File directoryToBg = new File(pathToBg);

        BackgroundImage myBI = new BackgroundImage(new Image(new FileInputStream(directoryToBg.getAbsoluteFile()), windowSize[0], windowSize[1], false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        vbox.setBackground(new Background(myBI));
        //stage.setScene(scene);
        //stage.show();

        return new Object[] {scene, button};


    }
    private void getNumOfCards (ChoiceBox<Integer> numOfCards){
        int cardAmmount = numOfCards.getValue();
        System.out.println(cardAmmount);
    }
    private void getThemeOfCards (ChoiceBox<String> themeOfCards){
        String theme= themeOfCards.getValue();
        System.out.println(theme);
    }
    private void setPlayerOneName (TextField playerOneName){
        String playerOne= playerOneName.getText();
        System.out.println(playerOne);
    }
    private void setPlayerTwoName (TextField playerTwoName){
        String playerTwo= playerTwoName.getText();
        System.out.println(playerTwo);
    }
    public Background PageBack (String path) throws FileNotFoundException {

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
