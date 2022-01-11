package at.ac.fhcampuswien.ws2021.memorygame.memorygame.game;

public class EventController {
    public double[] controller(double mouseX, double mouseY){
        System.out.println(mouseX + " | " + mouseY);
        return new double[]{mouseX,mouseY-Gameview.gameheaderSize};
    }
}