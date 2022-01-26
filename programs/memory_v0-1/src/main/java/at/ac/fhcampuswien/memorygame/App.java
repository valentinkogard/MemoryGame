package at.ac.fhcampuswien.memorygame;

import at.ac.fhcampuswien.memorygame.game.Gameview;
import at.ac.fhcampuswien.memorygame.game.Player;
import at.ac.fhcampuswien.memorygame.game.PlayerWonScene;
import at.ac.fhcampuswien.memorygame.welcomepage.*;
import at.ac.fhcampuswien.memorygame.welcomepage.env.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.event.ChangeEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        String pathToIcon = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/Logo_Wasserball.png";
        File directoryToGif = new File(pathToIcon);
        Image icon = new Image(new FileInputStream(directoryToGif.getAbsoluteFile()));
        primaryStage.getIcons().add(icon);

        //for general background settings - Mouse entered / Mouse exited
        ButtonStyle bs = new ButtonStyle();

        Gameview gv = new Gameview();

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
        String pathToBg = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/";
        Background bg = pageBack.PageBack(pathToBg + "background5.png");
        Background bg2 = pageBack.PageBack(pathToBg + "background6.png");
        Background bg3 = pageBack.PageBack(pathToBg + "catLove2.gif");
        Background bg4 = pageBack.PageBack(pathToBg + "background4.png");
        border.setBackground(bg);

        //-------------------------Music-------------------------

        Music media = new Music();
        MediaPlayer mediaPlayer = media.MusicPlayer();

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

        OptionsPage op = new OptionsPage();
        Object[] optnSceneObj = op.OptionsPageInit(bg4, mediaPlayer, toggleButton2);
        Scene optnScene = (Scene) optnSceneObj[0];
        Button back1 = (Button) optnSceneObj[1];
        //ToggleButton toggleButton = (ToggleButton) optnSceneObj[2];
        back1 = bs.ButtonStyleInit(back1, border, bg, bg, toggleButton2);

        options.setOnAction(e -> primaryStage.setScene(optnScene));
        back1.setOnAction(e -> primaryStage.setScene(mainpageScene));

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
        Object[] sPScene = sp.singlePlayerIntInit();

        //open SinglePlayerIntermidiatePage
        Object[] finalSPScene1 = sPScene;
        finalSinglePlayer.setOnAction(e -> {
            primaryStage.setScene((Scene) finalSPScene1[0]);
        });

        //start Gameview in SinglePlayer Mode
        Button startMemory = (Button) sPScene[1];
        Button exitMemory = (Button) sPScene[3];
        Object[] finalSPScene = sPScene;

        startMemory.setOnAction(e -> {
            Object[] gvObjSing = new Object[0];
            try {
                GameSettings settings = (GameSettings) sPScene[2];
                if (settings.getPlayerOne() != null) {
                    gvObjSing = gv.mainGame((GameSettings) finalSPScene[2]);
                    Scene singlePlayerScene = (Scene) gvObjSing[0];
                    Button singlePlayerBack = (Button) gvObjSing[1];
                    TextField singlePlayerWon = (TextField) gvObjSing[2];
                    primaryStage.setScene(singlePlayerScene);

                    singlePlayerBack.setOnAction(e2 -> {
                        primaryStage.setScene(mainpageScene);
                    });
                    singlePlayerWon.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            Object[] singlePlayerWonClass;
                            try {
                                PlayerWonScene singlePlayerSceneWon = new PlayerWonScene();
                                singlePlayerWonClass = singlePlayerSceneWon.playerWonScene(singlePlayerWon);
                                Scene playerWonScene = (Scene) singlePlayerWonClass[0];
                                Button toMenuFromPlayerWon = (Button) singlePlayerWonClass[1];
                                Button backToGame = (Button) singlePlayerWonClass[2];
                                primaryStage.setScene(playerWonScene);
                                toMenuFromPlayerWon.setOnAction(e3 -> {
                                    primaryStage.setScene(mainpageScene);
                                });
                                backToGame.setOnAction(e3 -> {
                                    primaryStage.setScene(singlePlayerScene);
                                });
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        exitMemory.setOnAction(event -> {
            Button exitSingle=(Button) sPScene[3];
            exitSingle.setOnAction(e -> primaryStage.setScene(mainpageScene));
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

        //Text title3 = new Text("Multiplayer placeholder");
        //title3.setFont(new Font(40));

        MultiPlayerIntermidiatePage mp = new MultiPlayerIntermidiatePage();
        Object[] mPScene = mp.multiPlayerIntInit();
        Button startMemorymulty = (Button) mPScene[1];
        Button exitMemryMulty = (Button) mPScene [3];

        multiPlayer.setOnAction(event -> {
            try {
                primaryStage.setScene((Scene) mPScene[0]);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        startMemorymulty.setOnAction(e -> {
            Object[] gvObjMulti = new Object[0];
            try {
              GameSettings settings = (GameSettings) mPScene[2];

                if (settings.getPlayerOne() != null && settings.getPlayerTwo() != null) {
                    gvObjMulti = gv.mainGame((GameSettings) mPScene[2]);
                    Scene multiPlayerScene = (Scene) gvObjMulti[0];
                    Button fromMultiPlayerToMenu = (Button) gvObjMulti[1];
                    TextField multiPlayerWon = (TextField) gvObjMulti[2];
                    primaryStage.setScene(multiPlayerScene);
                    fromMultiPlayerToMenu.setOnAction(e2 -> {
                        primaryStage.setScene(mainpageScene);
                    });
                    System.out.println(multiPlayerWon.getOnAction());

                    multiPlayerWon.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            Object[] playerWonClass;
                            try {
                                PlayerWonScene pws = new PlayerWonScene();
                                playerWonClass = pws.playerWonScene(multiPlayerWon);
                                Scene playerWonScene = (Scene) playerWonClass[0];
                                Button toMenuFromPlayerWon = (Button) playerWonClass[1];
                                Button backToGame = (Button) playerWonClass[2];
                                primaryStage.setScene(playerWonScene);
                                toMenuFromPlayerWon.setOnAction(e3 -> {
                                    primaryStage.setScene(mainpageScene);
                                });
                                backToGame.setOnAction(e3 -> {
                                    primaryStage.setScene(multiPlayerScene);
                                });
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        exitMemryMulty.setOnAction(e -> {
            Button exit =(Button) mPScene[3];
            exit.setOnAction(event -> primaryStage.setScene(mainpageScene));
        });

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
