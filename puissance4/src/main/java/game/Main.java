package game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Player p1 = new Player("joueur1",PlayerColor.ROUGE, 1);
            Player p2 = new Player("joueur1",PlayerColor.JAUNE, 2);

            Game game = new Game(p1, p2);
            Plateau plateau = new Plateau(game);

            JFrame frame = new JFrame("Puissance 4");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 600);
            frame.setResizable(false);
            frame.add(plateau);
            frame.setVisible(true);
        });
    }
}