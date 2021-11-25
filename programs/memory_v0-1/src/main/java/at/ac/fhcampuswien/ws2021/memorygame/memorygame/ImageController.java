package at.ac.fhcampuswien.ws2021.memorygame.memorygame;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageController {

    public static AnchorPane setImage(int i, AnchorPane holder) throws FileNotFoundException {

        String path;
        if(Gameview.cards[i].isPictureShown()){
            path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/theme0/image" + Gameview.cards[i].getPictureId() + ".png";
        }
        else {
            path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/cover/cover0.jpg";
        }
        File directory = new File(path);
        Image image = new Image(new FileInputStream(directory.getAbsoluteFile()));
        ImageView imageView = new ImageView(image);
        int x = Gameview.spaceX + Gameview.cards[i].getPosition()[0] * (Gameview.size + Gameview.spaceX);
        int y = Gameview.spaceY + Gameview.cards[i].getPosition()[1] * (Gameview.size + Gameview.spaceY) + Gameview.gameheaderSize;
        imageView.setX(x);
        imageView.setY(y);
        //imageView.setTranslateZ(20);
        Gameview.cards[i].setPixel(x, y, x+Gameview.size, y+Gameview.size);
        imageView.setFitWidth(Gameview.size);
        imageView.setPreserveRatio(true);
        holder.getChildren().add(imageView);
        return holder;
    }

    public static void removeChildren(int i, AnchorPane[] arr){
        for(int j = 0; j < arr[i].getChildren().size(); j++){
            arr[i].getChildren().remove(j);
        }
    }


        /*
    //one try...
    private AnchorPane initialiseImage(int i, AnchorPane holder) throws FileNotFoundException {
        String[] path = {"src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/image1.png",
                         "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/cover.jpg"};
        for(int k = 0; k < 2; k++){
            File directory = new File(path[k]);
            Image image = new Image(new FileInputStream(directory.getAbsoluteFile()));
            ImageView imageView = new ImageView(image);
            int x = spaceX + cards[i].getPosition()[0] * (size + spaceX);
            int y = spaceY + cards[i].getPosition()[1] * (size + spaceY);
            imageView.setX(x);
            imageView.setY(y);
            //imageView.setTranslateZ(20);
            cards[i].setPixel(x, y, x+size, y+size);
            imageView.setFitWidth(size);
            imageView.setPreserveRatio(true);
            holder.getChildren().add(imageView);
        }
        return holder;
    }
    */

        /*
    public ImageView setImage(int i) throws FileNotFoundException {
        String path;
        if(cards[i].isPictureShown()){
            path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/image1.png";
        }
        else {
            path = "src/main/java/at/ac/fhcampuswien/ws2021/memorygame/memorygame/pics/cover.jpg";
        }
        File directory = new File(path);
        Image image = new Image(new FileInputStream(directory.getAbsoluteFile()));
        ImageView imageView = new ImageView(image);
        int x = spaceX + cards[i].getPosition()[0] * (size + spaceX);
        int y = spaceY + cards[i].getPosition()[1] * (size + spaceY);
        imageView.setX(x);
        imageView.setY(y);
        //imageView.setTranslateZ(20);
        cards[i].setPixel(x, y, x+size, y+size);
        imageView.setFitWidth(size);
        imageView.setPreserveRatio(true);
        return imageView;
    }

     */

}
