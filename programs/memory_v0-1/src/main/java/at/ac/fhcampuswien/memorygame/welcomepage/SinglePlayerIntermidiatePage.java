package at.ac.fhcampuswien.memorygame.welcomepage;

import at.ac.fhcampuswien.memorygame.welcomepage.env.GameSettings;
import at.ac.fhcampuswien.memorygame.welcomepage.env.WindowSize;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;

public class SinglePlayerIntermidiatePage {

    public static int[] windowSize;

    private GameSettings settings;

    public Object[] singlePlayerIntInit() throws Exception {
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

        VBox vbox = new VBox();

        //Initialization of all graphical interactives
        ChoiceBox<String> numOfCards = new ChoiceBox<>();
        ChoiceBox<String> themeOfCards = new ChoiceBox<>();
        TextField playerOneName = new TextField();
        Label playerOneNameLabel = new Label("Player One");
        Label numOfCardsLabel = new Label("Difficulty");
        Label themeOfCardsLabel = new Label("Theme");

        //Label placing and styling for player names
        HBox hboxPlayerNameLabels = new HBox();
        hboxPlayerNameLabels.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNameLabels.setPadding(new Insets(75, 0, 0, 0));
        hboxPlayerNameLabels.getChildren().addAll(playerOneNameLabel);
        HBox.setMargin(playerOneNameLabel, new Insets(0, 0, 0, 110));
        playerOneNameLabel.setStyle("-fx-text-fill: darkslateblue;");
        playerOneNameLabel.setFont(new Font(20));
        playerOneNameLabel.setMinWidth(200);

        //Placing and styling of the player name inputs
        HBox hboxPlayerNames = new HBox();
        hboxPlayerNames.setAlignment(Pos.TOP_CENTER);
        hboxPlayerNames.setPadding(new Insets(0, 0, 0, 0));
        hboxPlayerNames.getChildren().addAll(playerOneName);
        HBox.setMargin(playerOneName, new Insets(0, 0, 0, 0));
        playerOneName.setOnKeyReleased(keyEvent -> setPlayerOneName(playerOneName));
        playerOneName.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        playerOneName.setFont(new Font(20));
        playerOneName.setMinWidth(200);

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
        themeOfCards.getItems().addAll("Sehenswürdigkeiten", "Katzen");
        themeOfCards.getSelectionModel().selectFirst();
        settings.setTheme(themeOfCards.getValue());
        themeOfCards.setOnAction(actionEvent -> getThemeOfCards(themeOfCards));

        //Placing of the start memory button
        HBox hboxButton = new HBox();
        hboxButton.setAlignment(Pos.TOP_CENTER);
        hboxButton.setPadding(new Insets(75, 0, 0, 0));
        hboxButton.getChildren().addAll(button);

        //Creating scenen and handing over the neccesary (h)orizontal boxes to a (v)ertical box
        vbox.getChildren().addAll(hboxPlayerNameLabels, hboxPlayerNames, hboxnumOfCardsLabel, hboxnumOfCards, hboxThemeOfCardsLabel, hboxThemeOfCards, hboxButton);
        Scene scene = new Scene(vbox, windowSize[0], windowSize[1]);
        String pathToBg = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/background2.jpg";
        File directoryToBg = new File(pathToBg);

        //setting the background
        BackgroundImage myBI = new BackgroundImage(new Image(new FileInputStream(directoryToBg.getAbsoluteFile()), windowSize[0], windowSize[1], false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        vbox.setBackground(new Background(myBI));
        //stage.setScene(scene);
        //stage.show();

        return new Object[]{scene, button, settings};
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
