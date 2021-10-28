package GameWindow;

import java.util.Objects;

public class Card {
    private int id;
    private int x_position, y_position; //are no pixel - the top/left card has the id 0/0 then 0/1, 0/2, ...
    private int pictureId;
    private boolean isPictureShown;
    private boolean isCardShown;

    private static int cardscounter = 0;

    public Card(int x_position, int y_position, int pictureId) {
        this.id = cardscounter;
        cardscounter++;
        this.x_position = x_position;
        this.y_position = y_position;
        this.pictureId = pictureId;
        this.isCardShown = true;
        this.isPictureShown = false;
    }

    //set-Methods
    public void setPictureShown(boolean pictureShown) {
        isPictureShown = pictureShown;
    }

    public void setCardShown(boolean cardShown) {
        isCardShown = cardShown;
    }

    //check if two cards have the same picture on it (pictureId)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return pictureId == card.pictureId;
    }
}
