package at.ac.fhcampuswien.ws2021.memorygame.memorygame.game;

import at.ac.fhcampuswien.ws2021.memorygame.memorygame.App;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.GameSettings;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.WindowSize;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import java.awt.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static java.awt.SystemColor.text;
import static javafx.scene.text.Font.*;

public class Gameview { // implements EventHandler<MouseEvent>{

    private AnchorPane[] arr;
    private List<Player> gamePlayer = new ArrayList<>();
    private List<Label> gameHeaderLabel = new ArrayList<>();

    public static Card[] cards;

    public static int size, spaceX, spaceY;

    public static int gameheaderSize = 50;
    public static int[] windowSize;

    protected static GameSettings settings;

    public void findImageToChange(double mouseX, double mouseY, Rules r) throws FileNotFoundException {
        for(int i = 0; i < cards.length; i++){
            int[] pixel = cards[i].getPixel();
            //0 -> x1; 1 -> y1; 2 -> x2; 3 -> y2
            if(pixel[0] < mouseX && mouseX < pixel[2] && pixel[1] < mouseY && mouseY < pixel[3] && cards[i].isCardShown()){
                //cards[i].setPictureShown(!cards[i].isPictureShown());
                cards[i].setPictureShown(true);
                ImageController.removeChildren(i, arr);
                arr[i] = ImageController.setImage(i, arr[i]);
                //System.out.println("Children of " + i + ": "+ arr[i].getChildren().size());
                //r.setPlayerInTurn(gamePlayer);
                break;
            }
        }
        //System.out.println("0");
    }

    public Scene mainGame(GameSettings settings) throws IOException{
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();

        this.settings = settings;

        if(settings.getPlayerOne() != ""){
            gamePlayer.add(new Player(settings.getPlayerOne()));
        }
        if(settings.getPlayerTwo() != null){
            gamePlayer.add(new Player(settings.getPlayerTwo()));
        }

        //stage.setTitle("Mem(ory) game :<)");

        EventHandler<MouseEvent> eventHandler = new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                EventController evC = new EventController();
                double[] feedback = evC.controller(mouseEvent.getSceneX(), mouseEvent.getSceneY());
                try {
                    Rules r = new Rules();
                    System.out.println(gamePlayer.get(r.getPlayerInTurn(gamePlayer)).getPlayerName() + " it's your turn");
                    if(r.isMoveAllowed(cards)){
                        findImageToChange(feedback[0], feedback[1], r);
                    }
                    else {
                        if(r.twoCardsUncovered(cards, arr)){
                            //p1.incPlayerPoints();
                            gamePlayer.get(r.getPlayerInTurn(gamePlayer)).incPlayerPoints();
                            gameHeaderLabel.get(r.getPlayerInTurn(gamePlayer)).setText(gamePlayer.get(r.getPlayerInTurn(gamePlayer)).getHeader());
                            System.out.println("Bravo...");
                        }
                        else {
                            r.setPlayerInTurn(gamePlayer);
                        }
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
        //!!! change methode that is can also handle e.g 80 cards
        //current problem: algorithm cases empty objects which leads in gameview to an error(1)

        cards = CardInitialisation.cardGeneration(settings.getNumOfCards()*2);
        StackPane root = new StackPane();

        arr = new AnchorPane[cards.length];

        size = 85;
        spaceX = (windowSize[0] - (size * cards[0].getNumberOfCardsXY()[0]))/(cards[0].getNumberOfCardsXY()[0] + 1);
        spaceY = (windowSize[1] - gameheaderSize - (size * cards[0].getNumberOfCardsXY()[1]))/(cards[0].getNumberOfCardsXY()[1] + 7);
        //spaceY = (window_height - (size * cards[0].getNumberOfCardsXY()[1]))/(cards[0].getNumberOfCardsXY()[1] + 3);

        //create gameheader
        HBox header = new HBox();
        header.setPadding(new Insets(15, 30, 10, 40));
        header.setSpacing(20);

        //Label player1 = new Label();
        gameHeaderLabel.add(new Label());
        gameHeaderLabel.get(0).setFont(font("Calibri", 25));
        gameHeaderLabel.get(0).setVisible(true);
        gameHeaderLabel.get(0).setText(gamePlayer.get(0).getHeader());

        gameHeaderLabel.add(new Label());
        gameHeaderLabel.get(1).setFont(font("Calibri", 25));
        gameHeaderLabel.get(1).setVisible(true);
        gameHeaderLabel.get(1).setText(gamePlayer.get(1).getHeader());

        Button back = new Button("Back");
        back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        back.setFont(new Font(15));
        back.setMinWidth(80);



        Button options = new Button();
        options.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        options.setFont(new Font(9));
        options.setMinWidth(35);

        String optionPic = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/zahnrad1.png";
        File directoryoptionPic = new File(optionPic);
        Image imageOptionPic = new Image(new FileInputStream(directoryoptionPic.getAbsoluteFile()));
        ImageView imageViewOptionPic = new ImageView(imageOptionPic);
        imageViewOptionPic.setFitHeight(25);
        imageViewOptionPic.setPreserveRatio(true);
        options.setGraphic(imageViewOptionPic);


        //header.setVisible(true);
        header.getChildren().addAll(gameHeaderLabel);//, player2, tab, options, back);
        root.getChildren().add(header);

        //create cards and there corresponding nodes
        for(int i = 0; i < cards.length; i++){
            AnchorPane holder = new AnchorPane(); //each "holder" should contain one playing card
            arr[i] = holder;

            holder.resize(size,size);
            if(cards[i].getPictureId() != -1) {
                arr[i] = ImageController.setImage(i, arr[i]);
            }
            root.getChildren().add(arr[i]);
        }

        //Background
        ImageController.setBackground(root);

        //add all nodes to the main stage
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        //stage.setScene(new Scene(root, windowSize[0], windowSize[1]));
        Scene gamescene = new Scene(root, windowSize[0], windowSize[1]);
        //stage.show();
        //stage.setResizable(false);

        return gamescene;

    }

}