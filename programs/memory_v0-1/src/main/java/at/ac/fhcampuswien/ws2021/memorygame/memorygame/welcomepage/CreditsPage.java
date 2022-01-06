package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CreditsPage {

    public static final int[] windowSize = {1000, 600};


    public Object [] CreditsPageInit() {

        VBox credVbox = new VBox();
        Scene credScene = new Scene(credVbox, windowSize[0], windowSize[1]);
        credVbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));


        Text title1 = new Text("CREDITS");
        title1.setFont(Font.font("Calibri", FontWeight.BOLD, 80));

        Text names = new Text("Magdalena\n\nMax\n\nValentin\n\nChristina\n\nNiko");
        names.setFont(Font.font("Calibri", 40));


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
