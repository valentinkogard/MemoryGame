package at.ac.fhcampuswien.memorygame.game;

public class EventController {
    /**
     * returns the location of mouse click
     * @param mouseX
     * @param mouseY
     * @return
     */
    public double[] controller(double mouseX, double mouseY){
        //System.out.println(mouseX + " | " + mouseY);
        return new double[]{mouseX,mouseY- Gameview.gameheaderSize};
    }
}