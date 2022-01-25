package at.ac.fhcampuswien.memorygame.welcomepage.env;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class Music {
    public MediaPlayer MusicPlayer() {

        String musicPath = "src\\main\\resources\\at\\ac\\fhcampuswien\\memorygame\\music\\gameMusic.mp3";
        Media media = new Media(new File(musicPath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));

        mediaPlayer.setVolume(0.1);

        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(41));
        mediaPlayer.play();

        //mediaPlayer.setAutoPlay(true);

        return mediaPlayer;
    }

    public MediaPlayer Soundeffect() {

        String musicPath = "src\\main\\resources\\at\\ac\\fhcampuswien\\memorygame\\music\\buttonHoverSound.mp3";
        Media media = new Media(new File(musicPath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);

        mediaPlayer.play();

        return mediaPlayer;
    }





}
