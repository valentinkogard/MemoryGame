package at.ac.fhcampuswien.ws2021.memorygame.memorygame.welcomepage.env;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Background {

    public javafx.scene.layout.Background PageBack (String str) throws FileNotFoundException {

        if(str == "background5") {

            String path1 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background5.png";
            File directory1 = new File(path1);
            Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

            BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);


            javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bi);
            return bg;

        }else if(str == "background6") {
            String path1 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background6.png";
            File directory1 = new File(path1);
            Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

            BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);


            javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bi);
            return bg;

        }else if(str == "catLove2") {
            String path1 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/catLove2.gif";
            File directory1 = new File(path1);
            Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

            BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);


            javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bi);
            return bg;

        }else if(str == "background4") {
            String path1 = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/background4.png";
            File directory1 = new File(path1);
            Image bgImage1 = new Image(new FileInputStream(directory1.getAbsoluteFile()));

            BackgroundImage bi = new BackgroundImage(bgImage1, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);


            javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bi);
            return bg;

        }



        return null;

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
