package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.WindowSize;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SinglePlayerIntermidiatePage {

    public static int[] windowSize;

    Button button;

    public Scene multiPlayerIntInit() throws Exception {
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();
        //stage.setTitle("Intermediate Page");

        button=new Button();
        button.setText("Start Memory");

        VBox vbox = new VBox();

        ChoiceBox<Integer> numOfCards = new ChoiceBox<>();
        ChoiceBox<String> themeOfCards= new ChoiceBox<>();
        TextField playerOneName = new TextField();
        Label playerOneNameLabel= new Label("Player Name");
        Label numOfCardsLabel= new Label("Number of Cards");
        Label themeOfCardsLabel= new Label("Theme");

        HBox hboxPlayerNameLabels= new HBox();
        hboxPlayerNameLabels.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNameLabels.setPadding(new Insets(75,0,0,0));
        hboxPlayerNameLabels.getChildren().addAll(playerOneNameLabel);

        HBox hboxPlayerNames= new HBox();
        hboxPlayerNames.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNames.setPadding(new Insets(0,0,0,0));
        hboxPlayerNames.getChildren().addAll(playerOneName);
        playerOneName.setOnKeyReleased(keyEvent -> setPlayerOneName(playerOneName));


        HBox hboxnumOfCardsLabel= new HBox();
        hboxnumOfCardsLabel.setAlignment(Pos.TOP_CENTER);
        hboxnumOfCardsLabel.setPadding(new Insets(75,0,0,0));
        hboxnumOfCardsLabel.getChildren().addAll(numOfCardsLabel);

        HBox hboxnumOfCards= new HBox();
        hboxnumOfCards.setAlignment(Pos.TOP_CENTER);
        hboxnumOfCards.setPadding(new Insets(0,0,0,0));
        hboxnumOfCards.getChildren().addAll(numOfCards);
        numOfCards.getItems().addAll(10,11,12,13,14,15,16,1,7,18,19,20);
        numOfCards.setValue(10);
        numOfCards.setOnAction(actionEvent -> getNumOfCards(numOfCards));

        HBox hboxThemeOfCardsLabel= new HBox();
        hboxThemeOfCardsLabel.setAlignment(Pos.TOP_CENTER);
        hboxThemeOfCardsLabel.setPadding(new Insets(75,0,0,0));
        hboxThemeOfCardsLabel.getChildren().addAll(themeOfCardsLabel);

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
        //stage.setScene(scene);
        //stage.show();

        return scene;


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

}