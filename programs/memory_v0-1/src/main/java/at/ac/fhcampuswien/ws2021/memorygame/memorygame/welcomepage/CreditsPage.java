package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.WindowSize;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CreditsPage {

    public static int[] windowSize;

    public Object [] CreditsPageInit() throws FileNotFoundException {
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();

        VBox credVbox = new VBox();
        Scene credScene = new Scene(credVbox, windowSize[0], windowSize[1]);

        String path1 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/old-black-background.jpg.jpg";
        File directory1 = new File(path1);
        Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

        BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bi);


        credVbox.setBackground(bg);


        Text title1 = new Text("CREDITS");
        title1.setFont(Font.font("Calibri", FontWeight.BOLD, 70));
        title1.setFill(Color.WHITE);

        Text names = new Text("Project supervisor: \nValentin\n\nRest of the team:\nMagdalena\nMax\nChristina\nNiko");
        names.setFont(Font.font("Calibri",40 ));
        names.setFill(Color.WHITE);


        Button back = new Button("Back");
        back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        back.setFont(new Font(20));
        back.setMinWidth(200);

        credVbox.setPrefWidth(200);
        credVbox.setSpacing(20);

        credVbox.setAlignment(Pos.CENTER);

        back.setAlignment(Pos.BOTTOM_CENTER);

        credVbox.getChildren().addAll(title1, names, back);

        return new Object[] {credScene, back} ;

    }

}
