package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.InputStream;

import static javafx.scene.paint.Color.BLANCHEDALMOND;
import static javafx.scene.paint.Color.color;


public class Cover extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Mainpage");

        VBox vbox = new VBox ();
        Scene mainpageScene = new Scene(vbox, 1200, 800);



        //-------------------------Title & Background-------------------------
        Text title = new Text(10, 50, "MEMORY");
        title.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 80));
        title.setFill(Color.DARKSEAGREEN);

        vbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));




        //-------------------------Singleplayer Button-------------------------
        Button singlePlayer = new Button();
        singlePlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        singlePlayer.setFont(new Font(20));
        singlePlayer.setText("Einzelspieler");

        VBox snglPlyVbox = new VBox();
        Scene snglPlyScene = new Scene(snglPlyVbox, 1200, 800);
        snglPlyVbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));


        Text title2 = new Text(10, 50,"Singleplayer placeholder");
        title2.setFont(new Font(40));

        Button back2 = new Button("Back");
        back2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        back2.setFont(new Font(20));

        back2.setMinWidth(200);


        back2.setOnAction(e -> primaryStage.setScene(mainpageScene));
        singlePlayer.setOnAction(e -> primaryStage.setScene(snglPlyScene));



        //-------------------------Multiplayer Button-------------------------
        Button multiPlayer = new Button();
        multiPlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        multiPlayer.setFont(new Font(20));
        multiPlayer.setText("Mehrspieler");

        VBox multiPlyVbox = new VBox();
        Scene multiPlyScene = new Scene(multiPlyVbox, 1200, 800);
        multiPlyVbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));


        Text title3 = new Text("Multiplayer placeholder");
        title3.setFont(new Font(40));

        Button back3 = new Button("Back");
        back3.setFont(new Font(20));
        back3.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        back3.setMinWidth(200);


        back3.setOnAction(e -> primaryStage.setScene(mainpageScene));
        multiPlayer.setOnAction(e -> primaryStage.setScene(multiPlyScene));



        //-------------------------Option Button-------------------------
        Button options = new Button();
        options.setText("Optionen");
        options.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        options.setFont(new Font(20));

        VBox optnVbox = new VBox();
        optnVbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));



        Image image = new Image(new FileInputStream("C:\\Users\\nikol\\Desktop\\pic\\pic1.jpg"));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(600);
        imageView.setFitWidth(800);

        Scene optnScene = new Scene(optnVbox, 1200, 800);

        Button back1 = new Button("Back");
        back1.setFont(new Font(20));
        back1.setMinWidth(200);
        back1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");



        options.setOnAction(e -> primaryStage.setScene(optnScene));
        back1.setOnAction(e -> primaryStage.setScene(mainpageScene));



        //-------------------------Credit Button-------------------------
        Button credits = new Button();
        credits.setText("Credits");
        credits.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        credits.setFont(new Font(20));

        VBox credVbox = new VBox ();
        Scene credScene = new Scene(credVbox, 1200, 800);
        credVbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));


        Text title1 = new Text("CREDITS");
        title1.setFont(Font.font("Calibri", FontWeight.BOLD,  80));

        Text names = new Text("Magdalena\n\nMax\n\nValentin\n\nChristina\n\nNiko");
        names.setFont(Font.font("Calibri",  40));


        Button back = new Button("Back");
        back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        back.setFont(new Font(20));

        back.setMinWidth(200);

        back.setOnAction(e -> primaryStage.setScene(mainpageScene));
        credits.setOnAction(e -> primaryStage.setScene(credScene));



        //-------------------------Exit Button-------------------------
        Button exit = new Button();
        exit.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        exit.setFont(new Font(20));
        exit.setText("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();

            }
        });

        //-------------------------width Setting-------------------------
        singlePlayer.setMinWidth(200);
        multiPlayer.setMinWidth(200);
        options.setMinWidth(200);
        credits.setMinWidth(200);
        exit.setMinWidth(200);

        //-------------------------VBox Button Width & Spacing  Setting-------------------------

        vbox.setPrefWidth(200);
        vbox.setSpacing(50);

        credVbox.setPrefWidth(200);
        credVbox.setSpacing(50);

        snglPlyVbox.setPrefWidth(200);
        snglPlyVbox.setSpacing(400);

        multiPlyVbox.setPrefWidth(200);
        multiPlyVbox.setSpacing(400);

        //-------------------------vBox Alignment-------------------------

        vbox.setAlignment(Pos.CENTER);
        credVbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(title, singlePlayer, multiPlayer, options, credits, exit);

        back.setAlignment(Pos.BOTTOM_CENTER);

        credVbox.getChildren().addAll(title1, names, back);

        optnVbox.setAlignment(Pos.CENTER);
        optnVbox.getChildren().addAll(imageView, back1);

        snglPlyVbox.setAlignment(Pos.CENTER);
        snglPlyVbox.getChildren().addAll(title2, back2);

        multiPlyVbox.setAlignment(Pos.CENTER);
        multiPlyVbox.getChildren().addAll(title3, back3);



        primaryStage.setScene(mainpageScene);

        primaryStage.show();


    }

}
