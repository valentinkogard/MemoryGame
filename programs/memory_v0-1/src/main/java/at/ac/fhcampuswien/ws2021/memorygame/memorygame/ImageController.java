package at.ac.fhcampuswien.ws2021.memorygame.memorygame;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageController extends Gameview {

    public static AnchorPane setImage(int i, AnchorPane holder) throws FileNotFoundException {

        String path;
        if (cards[i].isPictureShown()) {
            path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/theme2/image" + cards[i].getPictureId() + ".png";
        } else {
            path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/cover/cover1.png";
        }
        File directory = new File(path);
        Image image = new Image(new FileInputStream(directory.getAbsoluteFile()));
        ImageView imageView = new ImageView(image);
        int x = spaceX + cards[i].getPosition()[0] * (size + spaceX);
        int y = spaceY + cards[i].getPosition()[1] * (size + spaceY) + gameheaderSize;
        imageView.setX(x);
        imageView.setY(y);
        //imageView.setTranslateZ(20);
        cards[i].setPixel(x, y, x + size, y + size);
        imageView.setFitWidth(size);
        imageView.setPreserveRatio(true);
        holder.getChildren().add(imageView);
        return holder;
    }

    public static void removeChildren(int i, AnchorPane[] arr) {
        for (int j = 0; j < arr[i].getChildren().size(); j++) {
            arr[i].getChildren().remove(j);
        }
    }

    public static void setBackground(StackPane stackPane) throws FileNotFoundException {
        String path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/background/3.gif";
        File directory = new File(path);
        BackgroundImage myBI = new BackgroundImage(new Image(new FileInputStream(directory.getAbsoluteFile()), windowSize[0], windowSize[1], false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        stackPane.setBackground(new Background(myBI));
    }
}