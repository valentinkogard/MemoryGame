package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.ButtonStyle;
import at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env.WindowSize;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class OptionsPage {

    public static int[] windowSize;

    public Object[] OptionsPageInit(Background bg4, MediaPlayer mediaPlayer, ToggleButton toggleButton2) {
        WindowSize ws = new WindowSize();
        windowSize = ws.getWindowSize();

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
        volSlider.setStyle("-fx-background-color: darkslateblue; ");
        volSlider.setValue(mediaPlayer.getVolume() * 100);

        volSlider.valueProperty().addListener(observable -> mediaPlayer.setVolume(volSlider.getValue() / 100));

        Text musicBtnText = new Text(10,50, "Music");
        musicBtnText.setFont(Font.font("Calibri", 50));
        musicBtnText.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        ToggleButton toggleButton = new ToggleButton();
        toggleButton.setMinSize(150,100);
        toggleButton.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
        toggleButton.setSelected(true);
        toggleButton.setText("ON");
        toggleButton.setFont(Font.font("Calibri", 50));



        Text musicBtnText2 = new Text(10,50, "Soundeffect");
        musicBtnText2.setFont(Font.font("Calibri", 50));
        musicBtnText2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        toggleButton2.setMinSize(150,100);
        toggleButton2.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
        toggleButton2.setSelected(true);
        toggleButton2.setText("ON");
        toggleButton2.setFont(Font.font("Calibri", 50));

        Button back1 = new Button("Back");
        back1.setFont(new Font(25));
        back1.setMinWidth(200);
        back1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");


        back1.setCursor(Cursor.HAND);
        toggleButton.setCursor(Cursor.HAND);
        volSlider.setCursor(Cursor.HAND);

        toggleButton.setOnAction(event -> {

            if (toggleButton.isSelected()) {
                toggleButton.setText("ON");
                toggleButton.setMinSize(150, 100);
                toggleButton.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
                mediaPlayer.play();
            }
            else {
                toggleButton.setText("OFF");
                toggleButton.setMinSize(150, 100);
                toggleButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
                mediaPlayer.pause();
            }
        });

        toggleButton2.setOnAction(event -> {

            if (toggleButton2.isSelected()) {
                toggleButton2.setText("ON");
                toggleButton2.setMinSize(150, 100);
                toggleButton2.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
            }
            else {
                toggleButton2.setText("OFF");
                toggleButton2.setMinSize(150, 100);
                toggleButton2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
            }
        });

        optnVbox.getChildren().addAll(musicBtnText, toggleButton ,musicBtnText2,toggleButton2,volSliderText, volSlider, back1);

        return new Object[] {optnScene, back1, toggleButton};
    }

}
