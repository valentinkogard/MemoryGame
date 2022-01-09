package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LoadingPage {

    public static final int[] windowSize = {1000, 600};

    public Scene loadingPageInit() throws FileNotFoundException {
        StackPane stackPane = new StackPane();

        //Loading GIF
        String pathToGif = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/loader.gif";
        File directoryToGif = new File(pathToGif);
        Image gif = new Image(new FileInputStream(directoryToGif.getAbsoluteFile()));
        ImageView imageView = new ImageView(gif);
        imageView.resize(150,150);
        stackPane.getChildren().add(imageView);

        //Background
        String pathToBg = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background2.jpg";
        File directoryToBg = new File(pathToBg);

        BackgroundImage myBI = new BackgroundImage(new Image(new FileInputStream(directoryToBg.getAbsoluteFile()), windowSize[0], windowSize[1], false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //stackPane.setBackground(new Background(myBI));

        Scene loadScene = new Scene(stackPane, windowSize[0], windowSize[1]);

        return loadScene;
    }
}
