package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

public class EventController {
    public double[] controller(double mouseX, double mouseY){
        //System.out.println(mouseX + " | " + mouseY);
        return new double[]{mouseX,mouseY};
    }
}