module at.ac.fhcampuswien.ws2021.memorygame.memorygame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;

    //opens at.ac.fhcampuswien.ws2021.memorygame.memorygame to javafx.fxml;
    exports at.ac.fhcampuswien.ws2021.memorygame.memorygame;
    exports at.ac.fhcampuswien.ws2021.memorygame.memorygame.game;
}