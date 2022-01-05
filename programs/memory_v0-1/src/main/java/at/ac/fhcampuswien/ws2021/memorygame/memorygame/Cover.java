package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;


public class Cover extends Application {

    public static final int[] windowSize = {1000, 600};

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("MEMORY");
        BorderPane border = new BorderPane();

        VBox vbox = new VBox();
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        HBox hbox = new HBox();


        border.setCenter(vbox);
        border.setTop(hbox);


        Scene mainpageScene = new Scene(border, windowSize[0], windowSize[1]);



        primaryStage.setScene(mainpageScene);

        String path1 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/cover/cover1.png";
        File directory1 = new File(path1);
        Image image1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));
        ImageView card1 = new ImageView(image1);
        ImageView card2 = new ImageView(image1);
        ImageView card3 = new ImageView(image1);
        ImageView card4 = new ImageView(image1);
        ImageView card5 = new ImageView(image1);
        ImageView card6 = new ImageView(image1);
        card1.setFitHeight(100);
        card1.setPreserveRatio(true);
        card2.setFitHeight(100);
        card2.setPreserveRatio(true);
        card3.setFitHeight(100);
        card3.setPreserveRatio(true);
        card4.setFitHeight(100);
        card4.setPreserveRatio(true);
        card5.setFitHeight(100);
        card5.setPreserveRatio(true);
        card6.setFitHeight(100);
        card6.setPreserveRatio(true);





        Button m = new Button();
        m.setGraphic(card1);
        m.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        m.setFont(Font.font("Calibri", 25));
        m.setText("");
        m.setPrefSize(10,10);



        Button e1 = new Button();
        e1.setGraphic(card2);
        e1.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        e1.setFont(Font.font("Calibri", 25));
        e1.setText("");
        e1.setPrefSize(10,10);

        Button m1 = new Button();
        m1.setGraphic(card3);
        m1.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        m1.setFont(Font.font("Calibri", 25));
        m1.setText("");
        m1.setPrefSize(10,10);

        Button o = new Button();
        o.setGraphic(card4);
        o.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        o.setFont(Font.font("Calibri", 25));
        o.setText("");
        o.setPrefSize(10,10);

        Button r = new Button();
        r.setGraphic(card5);
        r.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        r.setFont(Font.font("Calibri", 25));
        r.setText("");
        r.setPrefSize(10,10);

        Button y = new Button();
        y.setGraphic(card6);
        y.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        y.setFont(Font.font("Calibri", 25));
        y.setText("");
        y.setPrefSize(10,10);





        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(m,e1,m1,o,r,y);









        //-------------------------Title & Background-------------------------
        //Text title = new Text(10, 50, "MEMORY");
        //title.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 80));
        //title.setFill(Color.ORANGERED);



        //vbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));

        String path0 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background5.png";
        File directory0 = new File(path0);
        //FileInputStream inp = new FileInputStream("c:\\Users\\nikol\\Desktop\\pic\\background5.png");
        Image bgImage = new Image(new FileInputStream(directory0.getAbsoluteFile()));

        BackgroundImage bi = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        Background bg = new Background(bi);

        border.setBackground(bg);

        String path4 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background6.png";
        File directory4 = new File(path4);
        //FileInputStream inp1 = new FileInputStream("c:\\Users\\nikol\\Desktop\\pic\\background6.png");
        Image bgImage4 = new Image(new FileInputStream(directory4.getAbsoluteFile()));

        BackgroundImage bi1 = new BackgroundImage(bgImage4, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        Background bg1 = new Background(bi1);

        String path5 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/catLove2.gif";
        //FileInputStream inp2 = new FileInputStream("c:\\Users\\nikol\\Desktop\\pic\\catLove2.gif");
        Image bgImage2 = new Image(path5);

        BackgroundImage bi2 = new BackgroundImage(bgImage2, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        Background bg2 = new Background(bi2);

        String path6 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background4.png";
        //FileInputStream inp3 = new FileInputStream("c:\\Users\\nikol\\Desktop\\pic\\background4.png");
        Image bgImage3 = new Image(path6);

        BackgroundImage bi3 = new BackgroundImage(bgImage3, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        Background bg3 = new Background(bi3);






        //-------------------------Singleplayer Button-------------------------
        Button singlePlayer = new Button();
        singlePlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        singlePlayer.setFont(Font.font("Calibri", 25));

        singlePlayer.setText("Einzelspieler");

        singlePlayer.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                singlePlayer.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");

            }
        });

        singlePlayer.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                singlePlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

            }
        });



        VBox snglPlyVbox = new VBox();
        Scene snglPlyScene = new Scene(snglPlyVbox, windowSize[0], windowSize[1]);
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
        multiPlayer.setFont(Font.font("Calibri", 25));
        multiPlayer.setText("Mehrspieler");

        multiPlayer.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                multiPlayer.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
                border.setBackground(bg2);

            }
        });

        multiPlayer.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                multiPlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
                border.setBackground(bg);
            }
        });

        VBox multiPlyVbox = new VBox();
        Scene multiPlyScene = new Scene(multiPlyVbox, windowSize[0], windowSize[1]);
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
        options.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        options.setFont(Font.font("Calibri", 25));
        options.setText("Optionen");

        options.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                options.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
                border.setBackground(bg3);
            }
        });

        options.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                options.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
                border.setBackground(bg);

            }
        });

        VBox optnVbox = new VBox();
        optnVbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));


        String path2 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/Logo_Wasserball.png";
        File directory2 = new File(path2);
        Image image = new Image(new FileInputStream(directory2.getAbsoluteFile()));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(400);
        imageView.setFitWidth(400);

        Scene optnScene = new Scene(optnVbox, windowSize[0], windowSize[1]);

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
        credits.setFont(Font.font("Calibri", 25));

        credits.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                credits.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");

            }
        });

        credits.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                credits.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

            }
        });

        VBox credVbox = new VBox ();
        Scene credScene = new Scene(credVbox, windowSize[0], windowSize[1]);
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
        exit.setFont(Font.font("Calibri", 25));
        exit.setText("Exit");

        Button exit1 = new Button();
        exit1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        exit1.setFont(Font.font("Calibri", 25));
        exit1.setText("Exit");


        exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                border.setBackground(bg1);
                exit.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");

            }
        });

        exit.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                border.setBackground(bg);
                exit.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
            }
        });


        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();


            }
        });





        //-------------------------width & height Setting-------------------------

        singlePlayer.setMinWidth(200);
        singlePlayer.setMinHeight(40);
        singlePlayer.setCursor(Cursor.HAND);

        multiPlayer.setMinWidth(200);
        multiPlayer.setMinHeight(40);
        multiPlayer.setCursor(Cursor.HAND);

        options.setMinWidth(200);
        options.setMinHeight(40);
        options.setCursor(Cursor.HAND);

        credits.setMinWidth(200);
        credits.setMinHeight(40);
        credits.setCursor(Cursor.HAND);

        exit.setMinWidth(200);
        exit.setMinHeight(40);
        exit.setCursor(Cursor.HAND);

        //-------------------------VBox Button Width & Spacing  Setting-------------------------

        hbox.setPrefWidth(50);
        hbox.setSpacing(5);


        vbox.setPrefWidth(200);
        vbox.setSpacing(50);

        optnVbox.setSpacing(20);

        credVbox.setPrefWidth(200);
        credVbox.setSpacing(20);

        snglPlyVbox.setPrefWidth(200);
        snglPlyVbox.setSpacing(400);

        multiPlyVbox.setPrefWidth(200);
        multiPlyVbox.setSpacing(400);

        //-------------------------vBox Alignment-------------------------

        vbox.setAlignment(Pos.CENTER);
        credVbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll( singlePlayer, multiPlayer, options, credits, exit);

        vbox1.getChildren().add(exit1);


        back.setAlignment(Pos.BOTTOM_CENTER);

        credVbox.getChildren().addAll(title1, names, back);

        optnVbox.setAlignment(Pos.CENTER);
        optnVbox.getChildren().addAll(imageView, back1);

        snglPlyVbox.setAlignment(Pos.CENTER);
        snglPlyVbox.getChildren().addAll(title2, back2);

        multiPlyVbox.setAlignment(Pos.CENTER);
        multiPlyVbox.getChildren().addAll(title3, back3);


        primaryStage.show();


    }

}
