package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import at.ac.fhcampuswien.ws2021.memorygame.memorygame.game.Gameview;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.*;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.BackgroundPage;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.ButtonStyle;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.Music;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.WindowSize;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


import java.io.IOException;


public class App extends Application {

    //window size
    public static int[] windowSize;
    //minimum button size
    private static final int[] minButtonSize = {200, 40};  //0: Width; 1: Height

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();

        primaryStage.setTitle("MEMORY");

        //for general background settings - Mouse entered / Mouse exited
        ButtonStyle bs = new ButtonStyle();

        VBox vbox = new VBox();
        vbox.setPrefWidth(200); //spacing
        vbox.setSpacing(50);
        vbox.setAlignment(Pos.CENTER);  //alignment

        //VBox vbox1 = new VBox();

        HBox hbox = new HBox();
        //spacing settings
        hbox.setPrefWidth(50);
        hbox.setSpacing(5);
        //alignment
        hbox.setAlignment(Pos.CENTER);

        BorderPane border = new BorderPane();
        border.setCenter(vbox);
        border.setTop(hbox);

        Scene mainpageScene = new Scene(border, windowSize[0], windowSize[1]);
        primaryStage.setScene(mainpageScene);
        primaryStage.setResizable(false);

        ToggleButton toggleButton2 = new ToggleButton();

        //-------------------------Title & Background-------------------------

        BackgroundPage buttonback = new BackgroundPage();

        Button mBtn = new Button();
        Button mBtn1 = new Button();
        ImageView CoverM = new ImageView();
        ImageView CoverM1 = new ImageView();
        CoverM = buttonback.ButtonBack("CoverM");
        CoverM1 = buttonback.ButtonBack("CoverM");
        mBtn.setGraphic(CoverM);
        mBtn1.setGraphic(CoverM1);
        mBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        mBtn1.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

        Button eBtn = new Button();
        ImageView CoverE = new ImageView();
        CoverE = buttonback.ButtonBack("CoverE");
        eBtn.setGraphic(CoverE);
        eBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

        Button oBtn = new Button();
        ImageView CoverO = new ImageView();
        CoverO = buttonback.ButtonBack("CoverO");
        oBtn.setGraphic(CoverO);
        oBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

        Button rBtn = new Button();
        ImageView CoverR = new ImageView();
        CoverR = buttonback.ButtonBack("CoverR");
        rBtn.setGraphic(CoverR);
        rBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

        Button yBtn = new Button();
        ImageView CoverY = new ImageView();
        CoverY = buttonback.ButtonBack("CoverY");
        yBtn.setGraphic(CoverY);
        yBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

        BackgroundPage pageBack = new BackgroundPage();
        String pathToBg = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/";
        Background bg = pageBack.PageBack(pathToBg + "background5.png");
        Background bg2 = pageBack.PageBack(pathToBg + "background6.png");
        Background bg3 = pageBack.PageBack(pathToBg + "catLove2.gif");
        Background bg4 = pageBack.PageBack(pathToBg + "background4.png");
        border.setBackground(bg);

        //-------------------------Music-------------------------

        Music media = new Music();
        MediaPlayer mediaPlayer = media.MusicPlayer();

        //-------------------------Singleplayer Button-------------------------

        Button singlePlayer = new Button();
        singlePlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        singlePlayer.setFont(Font.font("Calibri", 25));
        singlePlayer.setText("Singleplayer");
        singlePlayer.setMinWidth(minButtonSize[0]);
        singlePlayer.setMinHeight(minButtonSize[1]);
        singlePlayer.setCursor(Cursor.HAND);
        singlePlayer = bs.ButtonStyleInit(singlePlayer, border, bg, bg, toggleButton2);

        singlePlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //MultiPlayerInitPage

                //Loading Page
                LoadingPage lp = new LoadingPage();
                try {
                    Scene loadSc = lp.loadingPageInit();
                    primaryStage.setScene(loadSc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //game page - Class: Gameview
                Gameview gv = new Gameview();
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                pause.setOnFinished(e ->
                {
                    try {
                        primaryStage.setScene(gv.mainGame());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                pause.play();
            }
        });

        //-------------------------Multiplayer Button-------------------------

        Button multiPlayer = new Button();
        multiPlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        multiPlayer.setFont(Font.font("Calibri", 25));
        multiPlayer.setText("Multiplayer");
        multiPlayer.setMinWidth(minButtonSize[0]);
        multiPlayer.setMinHeight(minButtonSize[1]);
        multiPlayer.setCursor(Cursor.HAND);
        multiPlayer = bs.ButtonStyleInit(multiPlayer, border, bg3, bg, toggleButton2);

        VBox multiPlyVbox = new VBox();
        Scene multiPlyScene = new Scene(multiPlyVbox, windowSize[0], windowSize[1]);
        multiPlyVbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));

        Text title3 = new Text("Multiplayer placeholder");
        title3.setFont(new Font(40));

        //Button back3 = new Button("Back");
        //back3.setFont(new Font(20));
        //back3.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        //back3.setMinWidth(200);
        //back3.setOnAction(e -> primaryStage.setScene(mainpageScene));

        MultiPlayerIntermidiatePage mp = new MultiPlayerIntermidiatePage();
        multiPlayer.setOnAction(e -> {
            try {
                primaryStage.setScene(mp.multiPlayerIntInit());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //-------------------------Option Button-------------------------

        Button options = new Button();
        options.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        options.setFont(Font.font("Calibri", 25));
        options.setText("Optionen");
        options.setMinWidth(minButtonSize[0]);
        options.setMinHeight(minButtonSize[1]);
        options.setCursor(Cursor.HAND);
        options = bs.ButtonStyleInit(options, border, bg4, bg,toggleButton2);

        //-------------------------Options-------------------------

        VBox optnVbox = new VBox();
        optnVbox.setSpacing(20);    //spacing
        optnVbox.setAlignment(Pos.CENTER);  //alinment
        optnVbox.setBackground(bg4);

        Scene optnScene = new Scene(optnVbox, windowSize[0], windowSize[1]);

        Text volSliderText = new Text(10,50, "Volume");
        volSliderText.setFont(Font.font("Calibri", 50));
        volSliderText.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        Slider volSlider = new Slider(0,100,50);
        volSlider.setMajorTickUnit(8.0);
        volSlider.setMinorTickCount(3);
        volSlider.setMaxWidth(500);
        volSlider.setMinHeight(50);
        volSlider.setSnapToTicks(false);
        volSlider.setShowTickMarks(false);
        volSlider.setShowTickLabels(false);
        //volSlider.setBackground();
        volSlider.setStyle("-fx-background-color: darkslateblue; ");
        volSlider.setValue(mediaPlayer.getVolume() * 100);

        volSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(volSlider.getValue() / 100);

            }
        });

        Text musicBtnText = new Text(10,50, "Music");
        musicBtnText.setFont(Font.font("Calibri", 50));
        musicBtnText.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        ToggleButton toggleButton = new ToggleButton();
        toggleButton.setMinSize(150,100);
        toggleButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        toggleButton.setSelected(true);
        toggleButton.setText("ON");
        toggleButton.setFont(Font.font("Calibri", 50));


        toggleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (toggleButton.isSelected()) {
                    toggleButton.setText("ON");
                    toggleButton.setMinSize(150, 100);
                    toggleButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
                    mediaPlayer.play();
                }
                else {
                    toggleButton.setText("OFF");
                    toggleButton.setMinSize(150, 100);
                    toggleButton.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
                    mediaPlayer.pause();
                }
            }
        });

        Text musicBtnText2 = new Text(10,50, "Soundeffect");
        musicBtnText2.setFont(Font.font("Calibri", 50));
        musicBtnText2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        toggleButton2.setMinSize(150,100);
        toggleButton2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        toggleButton2.setSelected(true);
        toggleButton2.setText("ON");
        toggleButton2.setFont(Font.font("Calibri", 50));

        toggleButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (toggleButton2.isSelected()) {
                    toggleButton2.setText("ON");
                    toggleButton2.setMinSize(150, 100);
                    toggleButton2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
                }
                else {
                    toggleButton2.setText("OFF");
                    toggleButton2.setMinSize(150, 100);
                    toggleButton2.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
                }
            }
        });

        Button back1 = new Button("Back");
        back1.setFont(new Font(25));
        back1.setMinWidth(200);
        back1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        back1 = bs.ButtonStyleInit(back1, border, bg, bg, toggleButton2);

        back1.setCursor(Cursor.HAND);
        //back3.setCursor(Cursor.HAND);
        toggleButton.setCursor(Cursor.HAND);
        volSlider.setCursor(Cursor.HAND);

        options.setOnAction(e -> primaryStage.setScene(optnScene));
        back1.setOnAction(e -> primaryStage.setScene(mainpageScene));

        //-------------------------Credit Button-------------------------

        Button credits = new Button();
        credits.setText("Credits");
        credits.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        credits.setFont(Font.font("Calibri", 25));
        credits.setMinWidth(minButtonSize[0]);
        credits.setMinHeight(minButtonSize[1]);
        credits.setCursor(Cursor.HAND);
        credits = bs.ButtonStyleInit(credits, border, bg, bg,toggleButton2);

        CreditsPage cp = new CreditsPage();
        Object o1[] = cp.CreditsPageInit();
        Scene credScene = (Scene) o1[0];
        Button button = (Button) o1[1];

        button.setOnAction(e -> primaryStage.setScene(mainpageScene));
        credits.setOnAction(e -> primaryStage.setScene(credScene));

        //-------------------------Exit Button-------------------------

        Button exit = new Button();
        exit.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        exit.setFont(Font.font("Calibri", 25));
        exit.setText("Exit");
        exit.setMinWidth(minButtonSize[0]);
        exit.setMinHeight(minButtonSize[1]);
        exit.setCursor(Cursor.HAND);

        exit = bs.ButtonStyleInit(exit, border, bg2, bg, toggleButton2);
        /*
        Button exit1 = new Button();
        exit1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        exit1.setFont(Font.font("Calibri", 25));
        exit1.setText("Exit");
        */
        Button finalExit = exit;
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) finalExit.getScene().getWindow();
                stage.close();
            }
        });

        //-------------------------VBox Button Width & Spacing  Setting-------------------------

        //multiPlyVbox.setPrefWidth(200);
        //multiPlyVbox.setSpacing(400);

        //-------------------------vBox Alignment-------------------------

        hbox.getChildren().addAll(mBtn, eBtn, mBtn1, oBtn, rBtn, yBtn);
        vbox.getChildren().addAll(singlePlayer, multiPlayer, options, credits, exit);
        //vbox1.getChildren().add(exit1);

        optnVbox.getChildren().addAll(musicBtnText, toggleButton ,musicBtnText2,toggleButton2,volSliderText, volSlider, back1);

        //multiPlyVbox.setAlignment(Pos.CENTER);
        //multiPlyVbox.getChildren().addAll(title3, back3);

        primaryStage.show();

        /*
        border.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Rotate rotate = new Rotate();

                rotate.setAngle(0.5);

                rotate.setPivotX(50);
                rotate.setPivotY(50);

                mBtn.getTransforms().addAll(rotate);
                mBtn1.getTransforms().addAll(rotate);
                eBtn.getTransforms().addAll(rotate);
                oBtn.getTransforms().addAll(rotate);
                rBtn.getTransforms().addAll(rotate);
                yBtn.getTransforms().addAll(rotate);
            }
        });
         */
    }
}
