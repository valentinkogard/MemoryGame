package at.ac.fhcampuswien.memorygame.game;

public class Card {
    private int id;
    private int x_position, y_position; //are no pixel - the top/left card has the id 0/0 then 0/1, 0/2, ...
    private int x1_pixel, y1_pixel, x2_pixel, y2_pixel;  //pixel where the card is located on the screen
    private int pictureId;
    private boolean isPictureShown;
    private boolean isCardShown;

    private static int cardscounter = 0;

    private static int numberOfCardsX = 0;
    private static int numberOfCardsY = 0;

    public Card(int x_position, int y_position, int pictureId) {
        this.id = cardscounter;
        cardscounter++;
        this.x_position = x_position;
        this.y_position = y_position;
        this.x1_pixel = 0;
        this.y1_pixel = 0;
        this.x2_pixel = 0;
        this.y2_pixel = 0;
        this.pictureId = pictureId;
        this.isCardShown = true;
        this.isPictureShown = false;

        if(x_position > numberOfCardsX){
            numberOfCardsX = x_position + 1;
        }
        if(y_position > numberOfCardsY){
            numberOfCardsY = y_position + 1;
        }
    }

    //set-Methods
    public void setPictureShown(boolean ispictureShown) {
        this.isPictureShown = ispictureShown;
    }

    public void setCardShown(boolean isCardShown) {
        if(!isCardShown) {
            this.isCardShown = false;
        }
    }

    public void setPixel(int x1, int y1, int x2, int y2){
        this.x1_pixel = x1;
        this.y1_pixel = y1;
        this.x2_pixel = x2;
        this.y2_pixel = y2;
        //System.out.println("Card location: "+ this.x1_pixel + " " + this.y1_pixel);
    }

    //get-Methods
    public int[] getPosition(){
        return new int[]{this.x_position, this.y_position};
    }

    public int[] getNumberOfCardsXY(){
        return new int[]{numberOfCardsX, numberOfCardsY};
    }

    public int getPictureId(){
        return this.pictureId;
    }

    public boolean isCardShown(){
        return this.isCardShown;
    }

    public boolean isPictureShown(){
        return this.isPictureShown;
    }

    public int[] getPixel(){
        return new int[]{this.x1_pixel, this.y1_pixel, this.x2_pixel, this.y2_pixel};
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

