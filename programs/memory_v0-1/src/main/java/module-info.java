module at.ac.fhcampuswien.memorygame.memorygame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;

    //opens at.ac.fhcampuswien.ws2021.memorygame.memorygame to javafx.fxml;
    //exports at.ac.fhcampuswien.memorygame.memorygame;
    //exports at.ac.fhcampuswien.memorygame.memorygame.game;
    exports at.ac.fhcampuswien.memorygame;
    exports at.ac.fhcampuswien.memorygame.game;
    exports at.ac.fhcampuswien.memorygame.welcomepage;
    exports at.ac.fhcampuswien.memorygame.welcomepage.env;
}