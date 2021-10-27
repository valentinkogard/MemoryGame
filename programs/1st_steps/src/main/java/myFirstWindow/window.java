package myFirstWindow;

import javax.swing.*;

public class window {
    public static void main(String[] args) {
        JFrame f1 = new JFrame();
        f1.setTitle("MyFirstWindow");
        f1.setSize(600, 400);
        f1.setLocation(550, 550);

        JPanel p1 = new JPanel();
        JTextArea ta1 = new JTextArea(5,25);
        ta1.append("Hello World");

        p1.add(ta1);

        f1.getContentPane().add(p1);
        f1.setVisible(true);
    }
}
