package at.ac.fhcampuswien.memorygame.welcomepage.env;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class BackgroundPage {

    public Background PageBack (String path) throws FileNotFoundException {

        File directory1 = new File(path);
        Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

        BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        return new Background(bi);
    }


    public ImageView ButtonBack (String str) throws FileNotFoundException {

        if (Objects.equals(str, "CoverM")) {

            String pathCoverM = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/titleCards/coverM.png";
            File directoryCoverM = new File(pathCoverM);
            Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
            ImageView Cover = new ImageView(imageCoverM);
            Cover.setFitHeight(100);
            Cover.setPreserveRatio(true);


            return Cover;

        }else if (Objects.equals(str, "CoverE")) {

            String pathCoverM = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/titleCards/coverE.png";
            File directoryCoverM = new File(pathCoverM);
            Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
            ImageView Cover = new ImageView(imageCoverM);
            Cover.setFitHeight(100);
            Cover.setPreserveRatio(true);

            return Cover;

        }else if (Objects.equals(str, "CoverO")) {

            String pathCoverM = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/titleCards/coverO.png";
            File directoryCoverM = new File(pathCoverM);
            Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
            ImageView Cover = new ImageView(imageCoverM);
            Cover.setFitHeight(100);
            Cover.setPreserveRatio(true);

            return Cover;

        }else if (Objects.equals(str, "CoverR")) {

            String pathCoverM = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/titleCards/coverR.png";
            File directoryCoverM = new File(pathCoverM);
            Image imageCoverM = new Image(new FileInputStream(directoryCoverM.getAbsoluteFile()));
            ImageView Cover = new ImageView(imageCoverM);
            Cover.setFitHeight(100);
            Cover.setPreserveRatio(true);

            return Cover;

        }else if (Objects.equals(str, "CoverY")) {

            String pathCoverM = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/titleCards/coverY.png";
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