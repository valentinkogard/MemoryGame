package at.ac.fhcampuswien.memorygame.game;


import at.ac.fhcampuswien.memorygame.welcomepage.env.WindowSize;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayerWonScene {

    public static int[] windowSize;

    public Object[] playerWonScene(TextField playerWon) throws FileNotFoundException {
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();

        //VBox outerVBox = new VBox();
        StackPane stackPane = new StackPane();

        //Crown + PlayerName
        VBox vBox = new VBox();
        String pathToGif = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/crown.png";
        File directoryToCrown = new File(pathToGif);
        Image crown = new Image(new FileInputStream(directoryToCrown.getAbsoluteFile()),300, 300, false, false);
        ImageView imageView = new ImageView(crown);
        imageView.resize(150,150);
        //imageView.setPreserveRatio(true);

        vBox.getChildren().add(imageView);

        Text names = new Text("Player: " + playerWon.getText() + " won");
        names.setFont(Font.font("Calibri",40 ));
        names.setFill(Color.BLACK);
        vBox.getChildren().add(names);

        Text cong = new Text("CONGRATULATION!!!");
        cong.setFont(Font.font("Calibri",40 ));
        cong.setFill(Color.YELLOWGREEN);
        vBox.getChildren().add(cong);

        Button backToGame = new Button();
        backToGame.setText("Back to Game");
        backToGame.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backToGame.setFont(new Font(20));
        backToGame.setMinWidth(200);
        backToGame.setCursor(Cursor.HAND);
        backToGame.setOnMouseEntered(mouseEvent -> {
            backToGame.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
        });

        backToGame.setOnMouseExited(mouseEvent -> {
            backToGame.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        });
        vBox.getChildren().add(backToGame);

        Button toMenu = new Button();
        toMenu.setText("To Menu");
        toMenu.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        toMenu.setFont(new Font(20));
        toMenu.setMinWidth(200);
        toMenu.setCursor(Cursor.HAND);
        toMenu.setOnMouseEntered(mouseEvent -> {
            toMenu.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
        });

        toMenu.setOnMouseExited(mouseEvent -> {
            toMenu.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        });
        vBox.getChildren().add(toMenu);

        vBox.setAlignment(Pos.TOP_CENTER);
        stackPane.getChildren().add(vBox);
        vBox.setSpacing(20);

        //Background
        String pathToBg = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/background2.jpg";
        File directoryToBg = new File(pathToBg);

        BackgroundImage myBI = new BackgroundImage(new Image(new FileInputStream(directoryToBg.getAbsoluteFile()), windowSize[0], windowSize[1], false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        stackPane.setBackground(new Background(myBI));

        Scene playerWonScene = new Scene(stackPane, windowSize[0], windowSize[1]);
        return new Object[] {playerWonScene, toMenu, backToGame};
    }

}
