package at.ac.fhcampuswien.memorygame.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageController extends Gameview {
    /**
     * Method is used to flip the card when the mouse is clicked -
     * image is deleted and then a new one is inserted.
     * @param i which card should be turned over
     * @param holder
     * @return AnchorPane Object with updated image
     * @throws FileNotFoundException
     */
    public static AnchorPane setImage(int i, AnchorPane holder) throws FileNotFoundException {

        String path;
        if (cards[i].isPictureShown()) {
            path = settings.getTheme() + cards[i].getPictureId() + ".png";
        } else {
            path = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/cover/cover1.png";
        }
        File directory = new File(path);
        Image image = new Image(new FileInputStream(directory.getAbsoluteFile()));
        ImageView imageView = new ImageView(image);
        int x = spaceX + cards[i].getPosition()[0] * (size + spaceX);
        int y = spaceY + cards[i].getPosition()[1] * (size + spaceY);
        imageView.setX(x);
        imageView.setY(y);
        //imageView.setTranslateZ(20);
        cards[i].setPixel(x, y, x + size, y + size);
        imageView.setFitWidth(size);
        imageView.setPreserveRatio(true);
        holder.getChildren().add(imageView);
        return holder;
    }

    /**
     * Due to the layout, more card objects are generated than are actually displayed.
     * To delete these we use this method
     * @param i
     * @param arr
     */
    public static void removeChildren(int i, AnchorPane[] arr) {
        for (int j = 0; j < arr[i].getChildren().size(); j++) {
            arr[i].getChildren().remove(j);
        }
    }

    /**
     * is called once and sets the background of the board
     * @param stackPane
     * @throws FileNotFoundException
     */
    public static void setBackground(VBox stackPane) throws FileNotFoundException {
        String path = "src/main/resources/at/ac/fhcampuswien/memorygame/pics/background/background2.jpg"; //3.gif
        File directory = new File(path);
        BackgroundImage myBI = new BackgroundImage(new Image(new FileInputStream(directory.getAbsoluteFile()), windowSize[0], windowSize[1], false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        stackPane.setBackground(new Background(myBI));
    }
}