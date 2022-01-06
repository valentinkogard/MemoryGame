package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import at.ac.fhcampuswien.ws2021.memorygame.memorygame.game.Gameview;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
//import javafx.animation.SequentialTransitionBuilder;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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


        VBox vbox = new VBox ();
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        HBox hbox = new HBox();

        border.setCenter(vbox);
        border.setTop(hbox);

        Scene mainpageScene = new Scene(border, windowSize[0], windowSize[1]);


        primaryStage.setScene(mainpageScene);

        primaryStage.setResizable(false);



        //-------------------------Title & Background-------------------------

        String pathCoverM = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverM.png";
        File directoryCoverM = new File(pathCoverM);
        Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
        ImageView CoverM = new ImageView(imageCoverM);
        ImageView CoverM1 = new ImageView(imageCoverM);
        CoverM.setFitHeight(100);
        CoverM.setPreserveRatio(true);

        String pathCoverE = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverE.png";
        File directoryCoverE = new File(pathCoverE);
        Image imageCoverE = new Image(new FileInputStream(directoryCoverE.getAbsoluteFile()));
        ImageView CoverE = new ImageView(imageCoverE);

        String pathCoverO = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverO.png";
        File directoryCoverO = new File(pathCoverO);
        Image imageCoverO = new Image(new FileInputStream(directoryCoverO.getAbsoluteFile()));
        ImageView CoverO = new ImageView(imageCoverO);

        String pathCoverR = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverR.png";
        File directoryCoverR = new File(pathCoverR);
        Image imageCoverR = new Image(new FileInputStream(directoryCoverR.getAbsoluteFile()));
        ImageView CoverR = new ImageView(imageCoverR);

        String pathCoverY = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverY.png";
        File directoryCoverY = new File(pathCoverY);
        Image imageCoverY = new Image(new FileInputStream(directoryCoverY.getAbsoluteFile()));
        ImageView CoverY = new ImageView(imageCoverY);



        String path0 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/cover/cover1.png";
        File directory0 = new File(path0);
        Image image0 = new Image(new FileInputStream(directory0.getAbsoluteFile()));
        ImageView card1 = new ImageView(image0);
        ImageView card2 = new ImageView(image0);
        ImageView card3 = new ImageView(image0);
        ImageView card4 = new ImageView(image0);
        ImageView card5 = new ImageView(image0);
        ImageView card6 = new ImageView(image0);
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


        Button mBtn = new Button();
        mBtn.setGraphic(card1);
        mBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        mBtn.setFont(Font.font("Calibri", 25));
        mBtn.setText("");
        mBtn.setPrefSize(10,10);

        Button eBtn = new Button();
        eBtn.setGraphic(card2);
        eBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        eBtn.setFont(Font.font("Calibri", 25));
        eBtn.setText("");
        eBtn.setPrefSize(10,10);

        Button mBtn1 = new Button();
        mBtn1.setGraphic(card3);
        mBtn1.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        mBtn1.setFont(Font.font("Calibri", 25));
        mBtn1.setText("");
        mBtn1.setPrefSize(10,10);

        Button oBtn = new Button();
        oBtn.setGraphic(card4);
        oBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        oBtn.setFont(Font.font("Calibri", 25));
        oBtn.setText("");
        oBtn.setPrefSize(10,10);

        Button rBtn = new Button();
        rBtn.setGraphic(card5);
        rBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        rBtn.setFont(Font.font("Calibri", 25));
        rBtn.setText("");
        rBtn.setPrefSize(10,10);

        Button yBtn = new Button();
        yBtn.setGraphic(card6);
        yBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        yBtn.setFont(Font.font("Calibri", 25));
        yBtn.setText("");
        yBtn.setPrefSize(10,10);

        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(mBtn,eBtn,mBtn1,oBtn,rBtn,yBtn);

        mainpageScene.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                FadeTransition fadeOut = new FadeTransition();
                fadeOut.setDuration(Duration.millis(1000));
                fadeOut.setFromValue(10);
                fadeOut.setToValue(0.1);
                fadeOut.setCycleCount(1000);
                fadeOut.setAutoReverse(true);
                fadeOut.setNode(card1);
                //fade.setNode(CoverM);
                fadeOut.play();



            }
        });

        mainpageScene.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                mBtn.setGraphic(CoverM);

                FadeTransition fadeIn = new FadeTransition();
                fadeIn.setDuration(Duration.millis(1000));
                fadeIn.setFromValue(10);
                fadeIn.setToValue(0.1);
                fadeIn.setCycleCount(1000);
                fadeIn.setAutoReverse(true);
                //fadeIn.setNode(card1);
                fadeIn.setNode(CoverM);
                fadeIn.play();

            }
        });



        /*Text title = new Text(10, 50, "MEMORY");
        title.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 80));
        title.setFill(Color.ORANGERED);

         */



        //vbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));

        String path1 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background5.png";
        File directory1 = new File(path1);
        //FileInputStream inp = new FileInputStream("c:\\Users\\nikol\\Desktop\\pic\\background5.png");
        Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

        BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        Background bg = new Background(bi);

        border.setBackground(bg);

        String path2 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background6.png";
        File directory2 = new File(path2);
        //FileInputStream inp1 = new FileInputStream("c:\\Users\\nikol\\Desktop\\pic\\background6.png");
        Image bgImage2 = new Image(new FileInputStream(directory2.getAbsoluteFile()));

        BackgroundImage bi2 = new BackgroundImage(bgImage2, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        Background bg2 = new Background(bi2);


        String path3 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/catLove2.gif";
        File directory3 = new File(path3);
        //FileInputStream inp = new FileInputStream("c:\\Users\\nikol\\Desktop\\pic\\background5.png");
        Image bgImage3 = new Image(new FileInputStream(directory3.getAbsoluteFile()));

        BackgroundImage bi3 = new BackgroundImage(bgImage3, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background bg3 = new Background(bi3);


        String path4 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background4.png";
        File directory4 = new File(path4);
        //FileInputStream inp = new FileInputStream("c:\\Users\\nikol\\Desktop\\pic\\background5.png");
        Image bgImage4 = new Image(new FileInputStream(directory4.getAbsoluteFile()));

        BackgroundImage bi4 = new BackgroundImage(bgImage4, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background bg4 = new Background(bi4);







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

        singlePlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = (Stage) singlePlayer.getScene().getWindow();
                stage.close();
                Stage gameStage;

                Scene mainpageScene = new Scene(border, windowSize[0], windowSize[1]);

                //gameStage.setScene(mainpageScene);

                primaryStage.setResizable(false);



                //Application.launch(Gameview.class);





            }
        });






        //-------------------------Multiplayer Button-------------------------
        Button multiPlayer = new Button();
        multiPlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        multiPlayer.setFont(Font.font("Calibri", 25));
        multiPlayer.setText("Mehrspieler");

        multiPlayer.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                multiPlayer.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
                border.setBackground(bg3);
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
                border.setBackground(bg4);
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


        //String path2 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/Logo_Wasserball.png";
        //File directory2 = new File(path2);
        //Image image = new Image(new FileInputStream(directory2.getAbsoluteFile()));
        //ImageView imageView = new ImageView(image);

        //imageView.setFitHeight(400);
        //imageView.setFitWidth(400);

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

                border.setBackground(bg2);
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

        multiPlyVbox.setPrefWidth(200);
        multiPlyVbox.setSpacing(400);

        //-------------------------vBox Alignment-------------------------

        vbox.setAlignment(Pos.CENTER);
        credVbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(singlePlayer, multiPlayer, options, credits, exit);

        vbox1.getChildren().add(exit1);


        back.setAlignment(Pos.BOTTOM_CENTER);

        credVbox.getChildren().addAll(title1, names, back);

        optnVbox.setAlignment(Pos.CENTER);
        optnVbox.getChildren().addAll(back1);

        multiPlyVbox.setAlignment(Pos.CENTER);
        multiPlyVbox.getChildren().addAll(title3, back3);


        primaryStage.show();


    }

}
