package game;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenwidth = gd.getDisplayMode().getWidth();
        int screenheight = gd.getDisplayMode().getHeight();

        double percent = 0.8;
        int width = (int) (screenwidth * percent);
        int height = (int) (screenheight * percent);

        JFrame frame = new JFrame("Premiere fenetre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);

        Plateau plateau = new Plateau();
        frame.add(plateau).setLocation(screenwidth/2, 0);
        frame.setVisible(true);
    }
}
