package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CreditsPage {

    public static final int[] windowSize = {1000, 600};


    public Object [] CreditsPageInit() throws FileNotFoundException {

        VBox credVbox = new VBox();
        Scene credScene = new Scene(credVbox, windowSize[0], windowSize[1]);

        String path1 = "src\\main\\java\\at\\ac\\fhcampuswien\\ws2021\\memorygame\\memorygame\\pics\\background\\backgroundCredits.png";
        File directory1 = new File(path1);
        Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

        BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bi);


        credVbox.setBackground(bg);

        /*String path2 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/Logo_Wasserball.png";
        File directory2 = new File(path2);
        Image imageLogo = new Image(new FileInputStream(directory2.getAbsoluteFile()));
        ImageView imageViewL = new ImageView(imageLogo);

        imageViewL.setFitHeight(200);
        imageViewL.setFitWidth(200);*/


        Text title1 = new Text("CREDITS");
        title1.setFont(Font.font("Calibri", FontWeight.BOLD, 70));
        title1.setFill(Color.BLACK);

        Text names = new Text("Magdalena\nMax\nValentin\nChristina\nNiko");
        names.setFont(Font.font("Calibri",40 ));
        names.setFill(Color.BLACK);

        ButtonStyle bs = new ButtonStyle();

        BorderPane test = new BorderPane();
        ToggleButton tg = new ToggleButton();



        Button back = new Button("Back");
        back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        back.setFont(new Font(20));
        back.setMinWidth(200);
        back = bs.ButtonStyleInit(back, test, null, null, tg);

        /*back.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                back.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");

            }
        });

        back.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

            }
        });


         */

        credVbox.setPrefWidth(200);
        credVbox.setSpacing(50);

        credVbox.setAlignment(Pos.CENTER);

        back.setAlignment(Pos.BOTTOM_CENTER);

        credVbox.getChildren().addAll(title1, names, back);

        return new Object[] {credScene, back} ;

    }

}
