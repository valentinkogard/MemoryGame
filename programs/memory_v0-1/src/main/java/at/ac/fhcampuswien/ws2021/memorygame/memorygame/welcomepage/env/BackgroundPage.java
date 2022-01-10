package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BackgroundPage {

    public Background PageBack (String path) throws FileNotFoundException {

        File directory1 = new File(path);
        Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

        BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bi);
        return bg;
    }


    public ImageView ButtonBack (String str) throws FileNotFoundException {


    if (str == "CoverM") {

        String pathCoverM = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverM.png";
        File directoryCoverM = new File(pathCoverM);
        Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
        ImageView Cover = new ImageView(imageCoverM);
        Cover.setFitHeight(100);
        Cover.setPreserveRatio(true);


        return Cover;

    }else if (str == "CoverE") {

        String pathCoverM = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverE.png";
        File directoryCoverM = new File(pathCoverM);
        Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
        ImageView Cover = new ImageView(imageCoverM);
        Cover.setFitHeight(100);
        Cover.setPreserveRatio(true);

        return Cover;

    }else if (str == "CoverO") {

        String pathCoverM = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverO.png";
        File directoryCoverM = new File(pathCoverM);
        Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
        ImageView Cover = new ImageView(imageCoverM);
        Cover.setFitHeight(100);
        Cover.setPreserveRatio(true);

        return Cover;

    }else if (str == "CoverR") {

        String pathCoverM = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverR.png";
        File directoryCoverM = new File(pathCoverM);
        Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
        ImageView Cover = new ImageView(imageCoverM);
        Cover.setFitHeight(100);
        Cover.setPreserveRatio(true);

        return Cover;

    }else if (str == "CoverY") {

        String pathCoverM = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/titleCards/coverY.png";
        File directoryCoverM = new File(pathCoverM);
        Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
        ImageView Cover = new ImageView(imageCoverM);
        Cover.setFitHeight(100);
        Cover.setPreserveRatio(true);

        return Cover;

    }



        return null;
    }


}
