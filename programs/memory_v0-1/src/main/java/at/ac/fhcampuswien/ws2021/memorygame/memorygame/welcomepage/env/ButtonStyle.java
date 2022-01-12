package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;

public class ButtonStyle {

    public Button ButtonStyleInit(Button button, BorderPane border, Background bgOn
            , Background bgOff, ToggleButton tg1) {

        button.setOnMouseEntered(mouseEvent -> {
            button.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
            border.setBackground(bgOn);
            Music media = new Music();

            if (tg1.isSelected()) {
                MediaPlayer mediaPlayer = media.Soundeffect();
                mediaPlayer.play();
            }
        });

        button.setOnMouseExited(mouseEvent -> {
            button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
            border.setBackground(bgOff);
        });
        return button;
    }
    //public Button ButtonStyleInit

}
