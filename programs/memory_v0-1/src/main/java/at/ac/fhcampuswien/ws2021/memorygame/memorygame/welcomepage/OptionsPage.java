package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class OptionsPage {

    //public static final int[] windowSize = {1000, 600};
    /*
            public static int[] windowSize;
            WindowSize ws = new WindowSize();
            windowSize = ws.getWindowSize();
     */

    public OptionsPage(Background bg, MediaPlayer mediaPlayer) {

        Background bg4 = bg;


    }


    public  OptionsPage() {

        /*

        VBox optnVbox = new VBox();

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

        Button back1 = new Button("Back");
        back1.setFont(new Font(25));
        back1.setMinWidth(200);
        back1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        back1 = bs.ButtonStyleInit(back1, border, bg, bg);



        options.setOnAction(e -> primaryStage.setScene(optnScene));
        back1.setOnAction(e -> primaryStage.setScene(mainpageScene));







        return optionsScene;

         */
    }

}
