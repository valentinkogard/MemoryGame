package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Background {

    public javafx.scene.layout.Background BackgroundInit (Button button, int num) throws FileNotFoundException {


        String path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background"+ num + ".png";
        File directory = new File(path);
        javafx.scene.image.Image bgImage = new Image(new FileInputStream(directory.getAbsoluteFile()));
        BackgroundImage bi = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bi);

        return bg;



    }

    //public


}
