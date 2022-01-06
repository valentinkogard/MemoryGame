/*
https://www.youtube.com/watch?v=FLkOX4Eez6o

stage: is the whole window
scene: what happens

 */

package at.ac.fhcampuswien.ws2021.memorygame.memorygame;

import at.ac.fhcampuswien.ws2021.memorygame.memorygame.game.Gameview;

public class App  {

    public static void main(String[] args) {
        System.out.println("Starting memory");
        //new gameview();
        Gameview.launch();
    }


}