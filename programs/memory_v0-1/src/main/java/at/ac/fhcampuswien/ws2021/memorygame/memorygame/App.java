package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import at.ac.fhcampuswien.ws2021.memorygame.memorygame.game.Gameview;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.*;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.*;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
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
    //title button style
    private static final String titleButtonStyle = "-fx-background-color: transparent;";
    //menu button style
    private static final String menuButtonStyle = "-fx-background-color: darkslateblue; -fx-text-fill: white;";
    // button text style
    private static final String[] buttonTextStyle  = {"Calibri", String.valueOf(25)};   //0: Schriftart; 1: Schriftgröße


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

        ImageView CoverM = buttonback.ButtonBack("CoverM");
        ImageView CoverM1 = buttonback.ButtonBack("CoverM");
        Button mBtn = new Button();
        Button mBtn1 = new Button();
        mBtn.setGraphic(CoverM);
        mBtn1.setGraphic(CoverM1);
        mBtn.setStyle(titleButtonStyle);
        mBtn1.setStyle(titleButtonStyle);

        ImageView CoverE = buttonback.ButtonBack("CoverE");
        Button eBtn = new Button();
        eBtn.setGraphic(CoverE);
        eBtn.setStyle(titleButtonStyle);

        ImageView CoverO = buttonback.ButtonBack("CoverO");
        Button oBtn = new Button();
        oBtn.setGraphic(CoverO);
        oBtn.setStyle(titleButtonStyle);

        Button rBtn = new Button();
        ImageView CoverR = buttonback.ButtonBack("CoverR");
        rBtn.setGraphic(CoverR);
        rBtn.setStyle(titleButtonStyle);

        Button yBtn = new Button();
        ImageView CoverY = buttonback.ButtonBack("CoverY");
        yBtn.setGraphic(CoverY);
        yBtn.setStyle(titleButtonStyle);

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
        singlePlayer.setStyle(menuButtonStyle);
        singlePlayer.setFont(Font.font(buttonTextStyle[0], Integer.parseInt(buttonTextStyle[1])));
        singlePlayer.setText("Singleplayer");
        singlePlayer.setMinWidth(minButtonSize[0]);
        singlePlayer.setMinHeight(minButtonSize[1]);
        singlePlayer.setCursor(Cursor.HAND);
        singlePlayer = bs.ButtonStyleInit(singlePlayer, border, bg, bg, toggleButton2);

        Button finalSinglePlayer = singlePlayer;

            SinglePlayerIntermidiatePage sp = new SinglePlayerIntermidiatePage();
            Object[] sPScene = new Object[0];
            try {
                sPScene = sp.singlePlayerIntInit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Button startMemorySingle = (Button) sPScene[1];
            Object[] finalSPScene1 = sPScene;
            finalSinglePlayer.setOnAction(e -> {
                try {
                    primaryStage.setScene((Scene) finalSPScene1[0]);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            Button startMemory = (Button) sPScene[1];

            Object[] finalSPScene = sPScene;
            startMemory.setOnAction(e -> {
                try {
                    Gameview gv = new Gameview();
                    primaryStage.setScene(gv.mainGame((GameSettings) finalSPScene[2]));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

        Object[] finalSPScene2 = sPScene;
        startMemory.setOnAction(e -> {
                try {
                    Gameview gv = new Gameview();
                    primaryStage.setScene(gv.mainGame((GameSettings) finalSPScene2[2]));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            //-------------------------Multiplayer Button-------------------------

        Button multiPlayer = new Button();
        multiPlayer.setStyle(menuButtonStyle);
        multiPlayer.setFont(Font.font(buttonTextStyle[0], Integer.parseInt(buttonTextStyle[1])));
        multiPlayer.setText("Multiplayer");
        multiPlayer.setMinWidth(minButtonSize[0]);
        multiPlayer.setMinHeight(minButtonSize[1]);
        multiPlayer.setCursor(Cursor.HAND);
        multiPlayer = bs.ButtonStyleInit(multiPlayer, border, bg3, bg, toggleButton2);

        //VBox multiPlyVbox = new VBox();
        //Scene multiPlyScene = new Scene(multiPlyVbox, windowSize[0], windowSize[1]);
        //multiPlyVbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, new CornerRadii(0), Insets.EMPTY)));

        Text title3 = new Text("Multiplayer placeholder");
        title3.setFont(new Font(40));

        MultiPlayerIntermidiatePage mp = new MultiPlayerIntermidiatePage();
        Object[] mPScene = mp.multiPlayerIntInit();
        Button startMemorymulty = (Button) mPScene[1];
        multiPlayer.setOnAction(e -> {
            try {
                primaryStage.setScene((Scene) mPScene[0]);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        startMemorymulty.setOnAction(e -> {
            try {
                Gameview gv = new Gameview();
                primaryStage.setScene(gv.mainGame((GameSettings) mPScene[2]));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        //-------------------------Option Button-------------------------

        Button options = new Button();
        options.setStyle(menuButtonStyle);
        options.setFont(Font.font(buttonTextStyle[0], Integer.parseInt(buttonTextStyle[1])));
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
        volSliderText.setFont(Font.font(buttonTextStyle[0], 50));
        volSliderText.setStyle(menuButtonStyle);

        Slider volSlider = new Slider(0,100,50);
        volSlider.setMajorTickUnit(8.0);
        volSlider.setMinorTickCount(3);
        volSlider.setMaxWidth(500);
        volSlider.setMinHeight(50);
        volSlider.setSnapToTicks(false);
        volSlider.setShowTickMarks(false);
        volSlider.setShowTickLabels(false);
        volSlider.setStyle("-fx-background-color: darkslateblue; ");
        volSlider.setValue(mediaPlayer.getVolume() * 100);

        volSlider.valueProperty().addListener(observable -> mediaPlayer.setVolume(volSlider.getValue() / 100));

        Text musicBtnText = new Text(10,50, "Music");
        musicBtnText.setFont(Font.font(buttonTextStyle[0], 50));
        musicBtnText.setStyle(menuButtonStyle);

        ToggleButton toggleButton = new ToggleButton();
        toggleButton.setMinSize(150,100);
        toggleButton.setStyle(menuButtonStyle);
        toggleButton.setSelected(true);
        toggleButton.setText("ON");
        toggleButton.setFont(Font.font(buttonTextStyle[0], 50));

        toggleButton.setOnAction(event -> {

            if (toggleButton.isSelected()) {
                toggleButton.setText("ON");
                toggleButton.setMinSize(150, 100);
                toggleButton.setStyle(menuButtonStyle);
                mediaPlayer.play();
            }
            else {
                toggleButton.setText("OFF");
                toggleButton.setMinSize(150, 100);
                toggleButton.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
                mediaPlayer.pause();
            }
        });

        Text musicBtnText2 = new Text(10,50, "Soundeffect");
        musicBtnText2.setFont(Font.font(buttonTextStyle[0], 50));
        musicBtnText2.setStyle(menuButtonStyle);

        toggleButton2.setMinSize(150,100);
        toggleButton2.setStyle(menuButtonStyle);
        toggleButton2.setSelected(true);
        toggleButton2.setText("ON");
        toggleButton2.setFont(Font.font(buttonTextStyle[0], 50));

        toggleButton2.setOnAction(event -> {

            if (toggleButton2.isSelected()) {
                toggleButton2.setText("ON");
                toggleButton2.setMinSize(150, 100);
                toggleButton2.setStyle(menuButtonStyle);
            }
            else {
                toggleButton2.setText("OFF");
                toggleButton2.setMinSize(150, 100);
                toggleButton2.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
            }
        });

        Button back1 = new Button("Back");
        back1.setFont(new Font(25));
        back1.setMinWidth(200);
        back1.setStyle(menuButtonStyle);
        back1 = bs.ButtonStyleInit(back1, border, bg, bg, toggleButton2);

        back1.setCursor(Cursor.HAND);
        toggleButton.setCursor(Cursor.HAND);
        volSlider.setCursor(Cursor.HAND);

        options.setOnAction(e -> primaryStage.setScene(optnScene));
        back1.setOnAction(e -> primaryStage.setScene(mainpageScene));

        //-------------------------Credit Button-------------------------

        Button credits = new Button();
        credits.setText("Credits");
        credits.setStyle(menuButtonStyle);
        credits.setFont(Font.font(buttonTextStyle[0], Integer.parseInt(buttonTextStyle[1])));
        credits.setMinWidth(minButtonSize[0]);
        credits.setMinHeight(minButtonSize[1]);
        credits.setCursor(Cursor.HAND);
        credits = bs.ButtonStyleInit(credits, border, bg, bg,toggleButton2);

        CreditsPage cp = new CreditsPage();
        Object[] o1 = cp.CreditsPageInit();
        Scene credScene = (Scene) o1[0];
        Button button = (Button) o1[1];

        button.setOnAction(e -> primaryStage.setScene(mainpageScene));
        credits.setOnAction(e -> primaryStage.setScene(credScene));

        //-------------------------Exit Button-------------------------

        Button exit = new Button();
        exit.setStyle(menuButtonStyle);
        exit.setFont(Font.font(buttonTextStyle[0], Integer.parseInt(buttonTextStyle[1])));
        exit.setText("Exit");
        exit.setMinWidth(minButtonSize[0]);
        exit.setMinHeight(minButtonSize[1]);
        exit.setCursor(Cursor.HAND);

        exit = bs.ButtonStyleInit(exit, border, bg2, bg, toggleButton2);

        Button finalExit = exit;
        exit.setOnAction(event -> {
            Stage stage = (Stage) finalExit.getScene().getWindow();
            stage.close();
        });

        //-------------------------vBox Alignment-------------------------

        hbox.getChildren().addAll(mBtn, eBtn, mBtn1, oBtn, rBtn, yBtn);
        vbox.getChildren().addAll(finalSinglePlayer, multiPlayer, options, credits, exit);

        optnVbox.getChildren().addAll(musicBtnText, toggleButton ,musicBtnText2,toggleButton2,volSliderText, volSlider, back1);

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
