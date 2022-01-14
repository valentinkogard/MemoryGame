package at.ac.fhcampuswien.memorygame.welcomepage;

import at.ac.fhcampuswien.memorygame.welcomepage.env.ButtonStyle;
import at.ac.fhcampuswien.memorygame.welcomepage.env.WindowSize;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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

        //vertical box for creditsPage
        VBox credVbox = new VBox();
        Scene credScene = new Scene(credVbox, windowSize[0], windowSize[1]);

        //added a image as background
        String path1 = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/backgroundCredits.png";
        File directory1 = new File(path1);
        Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

        BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background bg = new Background(bi);

        credVbox.setBackground(bg);

        //Title and text for Credit Page
        Text title1 = new Text("CREDITS");
        title1.setFont(Font.font("Calibri", FontWeight.BOLD, 70));
        title1.setFill(Color.BLACK);

        Text names = new Text("Magdalena\nMax\nValentin\nChristina\nNiko");
        names.setFont(Font.font("Calibri",40 ));
        names.setFill(Color.BLACK);

        ButtonStyle bs = new ButtonStyle();

        BorderPane test = new BorderPane();
        ToggleButton tg = new ToggleButton();

        //color of button  + cursor as hand
        Button back = new Button("Back");
        back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        back.setFont(new Font(20));
        back.setMinWidth(200);
        back.setCursor(Cursor.HAND);
        back = bs.ButtonStyleInit(back, test, null, null, tg);

        //position, spacing and allignement
        credVbox.setPrefWidth(200);
        credVbox.setSpacing(20);

        credVbox.setAlignment(Pos.CENTER);

        back.setAlignment(Pos.BOTTOM_CENTER);

        credVbox.getChildren().addAll(title1, names, back);

        return new Object[] {credScene, back} ;

    }

}
