package at.ac.fhcampuswien.memorygame.game;

import at.ac.fhcampuswien.memorygame.welcomepage.env.GameSettings;
import at.ac.fhcampuswien.memorygame.welcomepage.env.WindowSize;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javafx.scene.text.Font.font;

public class Gameview { // implements EventHandler<MouseEvent>{

    private AnchorPane[] arr;
    private final List<Player> gamePlayer = new ArrayList<>();
    private final List<Label> gameHeaderLabel = new ArrayList<>();

    public static Card[] cards;

    public static int size, spaceX, spaceY;

    public static final int gameheaderSize = 35;
    public static int gameHeaderOffset;
    public static int[] windowSize;

    protected static GameSettings settings;

    public static TextField playerWonName = new TextField(" ");

    /**
     * checks if the mouse click was on a card
     * @param mouseX
     * @param mouseY
     * @throws FileNotFoundException
     */
    public void findImageToChange(double mouseX, double mouseY) throws FileNotFoundException {
        for(int i = 0; i < cards.length; i++){
            int[] pixel = cards[i].getPixel();
            //0 -> x1; 1 -> y1; 2 -> x2; 3 -> y2
            if(pixel[0] < mouseX && mouseX < pixel[2] && pixel[1] < mouseY && mouseY < pixel[3] && cards[i].isCardShown()){
                cards[i].setPictureShown(true);
                ImageController.removeChildren(i, arr);
                arr[i] = ImageController.setImage(i, arr[i]);
                break;
            }
        }
        //System.out.println("0");
    }

    /**
     * creates the Game scene (i.e. the actual playing field).
     * @param settings
     * @return Scene and "back to main scene" button
     * @throws IOException
     */
    public Object[] mainGame(GameSettings settings) throws IOException{
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();

        Gameview.settings = settings;

        //is necessary to switch from multiplaer to single player
        gamePlayer.add(new Player("Default"));
        gamePlayer.get(0).resetPlayerCounter();
        gameHeaderLabel.add(new Label());
        for (int i = gamePlayer.size()-1; i >= 0; i--) {
            gamePlayer.remove(i);
            gameHeaderLabel.remove(i);
        }
        if(settings.getPlayerOne() != null){
            gamePlayer.add(new Player(settings.getPlayerOne()));
        }
        if(settings.getPlayerTwo() != null){
            gamePlayer.add(new Player(settings.getPlayerTwo()));
        }

        //listens to every mouse event in the StackPane "cardArea"
        //-> if an event occurs this code is being executed
        EventHandler<MouseEvent> eventHandler = mouseEvent -> {
            EventController evC = new EventController();
            double[] feedback = evC.controller(mouseEvent.getSceneX(), mouseEvent.getSceneY());
            //System.out.println(mouseEvent.getButton().toString());

            try {
                Rules r = new Rules();
                //System.out.println(gamePlayer.get(r.getPlayerInTurn(gamePlayer)).getPlayerName() + " it's your turn");
                if(Objects.equals(mouseEvent.getButton().toString(), "PRIMARY") && r.isMoveAllowed(cards)){
                    findImageToChange(feedback[0], feedback[1]);
                } else if(Objects.equals(mouseEvent.getButton().toString(), "PRIMARY") && r.twoCardsUncovered(cards, arr)){
                    //p1.incPlayerPoints();
                    gamePlayer.get(r.getPlayerInTurn(gamePlayer)).incPlayerPoints();
                    gameHeaderLabel.get(r.getPlayerInTurn(gamePlayer)).setText(gamePlayer.get(r.getPlayerInTurn(gamePlayer)).getHeader());
                    //System.out.println("Bravo...");
                } else if(Objects.equals(mouseEvent.getButton().toString(), "PRIMARY")){
                    r.setPlayerInTurn(gamePlayer);
                }

                for (Label label : gameHeaderLabel) {
                    label.setStyle("-fx-background-color: transparent;");
                }
                //highlight the player who's turn it is
                gameHeaderLabel.get(r.getPlayerInTurn(gamePlayer)).setStyle("-fx-border-color: darkslateblue;" +
                                                                            "-fx-boder-width: 2px;" +
                                                                            "-fx-background-color: linear-gradient(to bottom, darkslateblue, violet);" +
                                                                            "-fx-border-radius: 10 10 10 10;" +
                                                                            "-fx-background-radius: 10 10 10 10;");
                if(r.playerWon(gamePlayer.get(r.getPlayerInTurn(gamePlayer)))){
                    System.out.println(gamePlayer.get(r.getPlayerInTurn(gamePlayer)).getPlayerName() + " won! \n Congratulation!");
                    playerWonName.setText(gamePlayer.get(r.getPlayerInTurn(gamePlayer)).getPlayerName());
                    /*.addEventHandler();
                    playerWonName.setOnAction(e -> {
                        System.out.println("playerWonName accessed");
                    });
                    System.out.println(playerWonName.getText());*/
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        };

        cards = CardInitialisation.cardGeneration(settings.getNumOfCards()*2);
        //defines location of cards on the gameboard
        size = 85;
        spaceX = (windowSize[0] - (size * cards[0].getNumberOfCardsXY()[0]))/(cards[0].getNumberOfCardsXY()[0] + 1);
        spaceY = (windowSize[1] - gameheaderSize - (size * cards[0].getNumberOfCardsXY()[1]))/(cards[0].getNumberOfCardsXY()[1] + 10);
        gameHeaderOffset = spaceY;

        //create gameheader
        for (int i = 0; i < gamePlayer.size(); i++) {
            gameHeaderLabel.add(new Label());
            gameHeaderLabel.get(i).setFont(font("Calibri", 22));
            gameHeaderLabel.get(i).setVisible(true);
            gameHeaderLabel.get(i).setText(gamePlayer.get(i).getHeader());
        }

        Button back = new Button("Back");
        back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        back.setFont(new Font(15));
        back.setVisible(true);
        back.setMinWidth(80);

        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS); // buffer between player names (left) and back button (right)

        // create Stack pane, add h box, add label, region, button
        StackPane headerStackPane = new StackPane();
        headerStackPane.setMinHeight(gameheaderSize);
        headerStackPane.setMaxHeight(gameheaderSize);
        HBox header = new HBox();
        header.setPadding(new Insets(15, spaceX, 10, spaceX)); //align header with the playing cards
        header.setAlignment(Pos.CENTER);
        header.setSpacing(50);
        header.getChildren().addAll(gameHeaderLabel);
        header.getChildren().addAll(region1, back);
        headerStackPane.getChildren().add(header);


        arr = new AnchorPane[cards.length];
        //create cards and there corresponding nodes
        StackPane cardArea = new StackPane();
        //System.out.println("cardArea Size: " + cardArea.getBoundsInParent().getHeight());
        for(int i = 0; i < cards.length; i++){
            AnchorPane holder = new AnchorPane(); //each "holder" should contain one playing card
            arr[i] = holder;

            holder.resize(size,size);
            if(cards[i].getPictureId() != -1) {
                arr[i] = ImageController.setImage(i, arr[i]);
            }
            cardArea.getChildren().add(arr[i]);
        }
        cardArea.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);

        cardArea.setAlignment(Pos.CENTER);

        VBox root = new VBox();
        root.getChildren().addAll(headerStackPane, cardArea);
        //Background
        ImageController.setBackground(root);

        Scene gamescene = new Scene(root, windowSize[0], windowSize[1]);
        return new Object[] {gamescene, back, playerWonName};
    }
}