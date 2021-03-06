package at.ac.fhcampuswien.memorygame.welcomepage;

import at.ac.fhcampuswien.memorygame.welcomepage.env.GameSettings;
import at.ac.fhcampuswien.memorygame.welcomepage.env.Music;
import at.ac.fhcampuswien.memorygame.welcomepage.env.WindowSize;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileInputStream;

public class MultiPlayerIntermidiatePage {

    private static int[] windowSize;

    private GameSettings settings;

    public Object[] multiPlayerIntInit() throws Exception {
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();

        settings = new GameSettings();
        settings.setPlayerOne(null);
        settings.setPlayerTwo(null);

        //Creating and styling of the memory start button
        Button button = new Button();
        button.setText("Start Memory");
        button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button.setFont(new Font(20));
        button.setMinWidth(200);
        button.setCursor(Cursor.HAND);
        button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button.setOnMouseEntered(mouseEvent -> {
            button.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
        });

        button.setOnMouseExited(mouseEvent -> {
            button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        });

        //Creating and styling of the return to menue button
        Button exitButton = new Button();
        exitButton.setText("Back");
        exitButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        exitButton.setFont(new Font(15));
        exitButton.setMinWidth(80);
        exitButton.setCursor(Cursor.HAND);
        exitButton.setOnMouseEntered(mouseEvent -> {
            exitButton.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
        });

        exitButton.setOnMouseExited(mouseEvent -> {
            exitButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        });

        //Scene settings
        VBox vbox = new VBox();

        //Initialization of all graphical interactives
        ChoiceBox<String> numOfCards = new ChoiceBox<>();
        ChoiceBox<String> themeOfCards = new ChoiceBox<>();
        TextField playerOneName = new TextField();
        TextField playerTwoName = new TextField();
        Label playerOneNameLabel = new Label("Player One");
        Label playerTwoNameLabel = new Label("Player Two");
        Label numOfCardsLabel = new Label("Difficulty");
        Label themeOfCardsLabel = new Label("Theme");

        //Placing of the return to menue button
        HBox hboxButtonBack = new HBox();
        hboxButtonBack.setAlignment(Pos.TOP_RIGHT);
        hboxButtonBack.setPadding(new Insets(10, 50, 0, 0));
        hboxButtonBack.getChildren().addAll(exitButton);

        //Label placing and styling for player names
        HBox hboxPlayerNameLabels = new HBox();
        hboxPlayerNameLabels.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNameLabels.setPadding(new Insets(40, 0, 0, 0));
        hboxPlayerNameLabels.getChildren().addAll(playerOneNameLabel, playerTwoNameLabel);
        HBox.setMargin(playerOneNameLabel, new Insets(0, 200, 0, 100));
        playerOneNameLabel.setStyle("-fx-text-fill: darkslateblue;");
        playerOneNameLabel.setFont(new Font(20));
        playerOneNameLabel.setMinWidth(200);
        playerTwoNameLabel.setStyle("-fx-text-fill: darkslateblue;");
        playerTwoNameLabel.setFont(new Font(20));
        playerTwoNameLabel.setMinWidth(200);

        //Placing and styling of the player name inputs
        HBox hboxPlayerNames = new HBox();
        hboxPlayerNames.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNames.setPadding(new Insets(0, 0, 0, 0));
        hboxPlayerNames.getChildren().addAll(playerOneName, playerTwoName);
        HBox.setMargin(playerOneName, new Insets(0, 150, 0, 0));
        playerOneName.setOnKeyReleased(keyEvent -> setPlayerOneName(playerOneName));
        playerTwoName.setOnKeyReleased(keyEvent -> setPlayerTwoName(playerTwoName));
        playerOneName.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        playerOneName.setFont(new Font(20));
        playerOneName.setMinWidth(200);
        playerTwoName.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        playerTwoName.setFont(new Font(20));
        playerTwoName.setMinWidth(200);

        //Placing and styling of the difficulty selection label
        HBox hboxnumOfCardsLabel = new HBox();
        hboxnumOfCardsLabel.setAlignment(Pos.TOP_CENTER);
        hboxnumOfCardsLabel.setPadding(new Insets(75, 0, 0, 120));
        hboxnumOfCardsLabel.getChildren().addAll(numOfCardsLabel);
        numOfCardsLabel.setStyle("-fx-text-fill: darkslateblue;");
        numOfCardsLabel.setFont(new Font(20));
        numOfCardsLabel.setMinWidth(200);

        //Placing and styling of the difficulty selection
        HBox hboxnumOfCards = new HBox();
        hboxnumOfCards.setAlignment(Pos.TOP_CENTER);
        hboxnumOfCards.setPadding(new Insets(0, 0, 0, 0));
        hboxnumOfCards.getChildren().addAll(numOfCards);
        numOfCards.getItems().addAll("Easy", "Medium", "Hard", "Extreme");
        numOfCards.getSelectionModel().selectFirst();
        settings.setNumOfCards(12);
        numOfCards.setOnAction(actionEvent -> getNumOfCards(numOfCards));

        //Placing and styling of the card theme label
        HBox hboxThemeOfCardsLabel = new HBox();
        hboxThemeOfCardsLabel.setAlignment(Pos.TOP_CENTER);
        hboxThemeOfCardsLabel.setPadding(new Insets(75, 0, 0, 135));
        hboxThemeOfCardsLabel.getChildren().addAll(themeOfCardsLabel);
        themeOfCardsLabel.setStyle("-fx-text-fill: darkslateblue;");
        themeOfCardsLabel.setFont(new Font(20));
        themeOfCardsLabel.setMinWidth(200);

        //Placing and styling of the card theme selection
        HBox hboxThemeOfCards = new HBox();
        hboxThemeOfCards.setAlignment(Pos.TOP_CENTER);
        hboxThemeOfCards.setPadding(new Insets(0, 0, 0, 0));
        hboxThemeOfCards.getChildren().addAll(themeOfCards);
        themeOfCards.getItems().addAll("Sehensw??rdigkeiten", "Katzen");
        themeOfCards.getSelectionModel().selectFirst();
        settings.setTheme(themeOfCards.getValue());
        themeOfCards.setOnAction(actionEvent -> getThemeOfCards(themeOfCards));

        //Placing of the start memory button
        HBox hboxButton = new HBox();
        hboxButton.setAlignment(Pos.TOP_CENTER);
        hboxButton.setPadding(new Insets(75, 0, 0, 0));
        hboxButton.getChildren().addAll(button);

        //Creating scenen and handing over the neccesary (h)orizontal boxes to a (v)ertical box
        vbox.getChildren().addAll(hboxButtonBack, hboxPlayerNameLabels, hboxPlayerNames, hboxnumOfCardsLabel, hboxnumOfCards, hboxThemeOfCardsLabel, hboxThemeOfCards, hboxButton);
        Scene scene = new Scene(vbox, windowSize[0], windowSize[1]);

        //setting the background
        String pathToBg = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/background2.jpg";
        File directoryToBg = new File(pathToBg);

        BackgroundImage myBI = new BackgroundImage(new Image(new FileInputStream(directoryToBg.getAbsoluteFile()), windowSize[0], windowSize[1], false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        vbox.setBackground(new Background(myBI));

        // Returning the scene, button and player chosen settings to the app, so the scene transition can be implemented
        return new Object[]{scene, button, settings, exitButton};
    }

    /**
     * Is used to assign a value to the selected difficulty and hand it to the GameSettings object
     *
     * @param level
     *
     */
    private void getNumOfCards(ChoiceBox<String> level) {
        if ("Easy".equals(level.getValue())) {
            settings.setNumOfCards(12);
        } else if ("Medium".equals(level.getValue())) {
            settings.setNumOfCards(15);
        } else if ("Hard".equals(level.getValue())) {
            settings.setNumOfCards(16);
        } else if ("Extreme".equals(level.getValue())) {
            settings.setNumOfCards(20);
        }else {
            System.out.println("Invalid Difficulty");
            System.exit(1);
        }
    }

    /**
     * Is used to hand the selected theme to the GameSettings object
     * @param themeOfCards
     */
    private void getThemeOfCards(ChoiceBox<String> themeOfCards) {
        settings.setTheme(themeOfCards.getValue());
    }

    /**
     * Sets playername on keystroke and hands it to the GameSettings object
     * @param playerOneName
     */
    private void setPlayerOneName(TextField playerOneName) {
        settings.setPlayerOne(playerOneName.getText());
    }

    private void setPlayerTwoName(TextField playerTwoName) {
        settings.setPlayerTwo(playerTwoName.getText());
    }
/*
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

 */
}