module fh.campuswien.memorygame.javafxsetup {
    requires javafx.controls;
    requires javafx.fxml;


    opens fh.campuswien.memorygame.javafxsetup to javafx.fxml;
    exports fh.campuswien.memorygame.javafxsetup;
}