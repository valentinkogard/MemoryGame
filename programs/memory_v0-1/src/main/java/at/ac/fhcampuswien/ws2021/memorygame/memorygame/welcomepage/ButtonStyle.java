package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;


public class ButtonStyle {

    public Button ButtonStyleInit(Button button, BorderPane border, Background bgOn
            , Background bgOff, ToggleButton tg1) {

        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                button.setStyle("-fx-background-color: linear-gradient(to bottom, darkslateblue, violet); -fx-text-fill: white;");
                border.setBackground(bgOn);
                Music media = new Music();

                if (tg1.isSelected()) {
                    MediaPlayer mediaPlayer = media.Soundeffect();
                    mediaPlayer.play();
                }else {

                }

            }
        });

        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
                border.setBackground(bgOff);
            }
        });

        return button;



    }
    //public Button ButtonStyleInit

}
