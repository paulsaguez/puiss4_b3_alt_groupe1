package game;
import javax.swing.*;
import java.awt.*;

class Plateau extends JPanel {
    static final int ROWS = 6;
    static final int COLS = 7;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellWidth = getWidth() / COLS;
        int cellHeight = getHeight() / ROWS;
        int cellSize = Math.min(cellWidth, cellHeight);

        int boardWidth  = COLS * cellSize;
        int boardHeight = ROWS * cellSize;

        // Décalages pour centrer et aligner en bas
        int xOffset = (getWidth() - boardWidth) / 2;      // centré
        int yOffset = getHeight() - boardHeight;

        g.setColor(Color.BLUE);
        g.fillRect(xOffset, yOffset, boardWidth, boardHeight); // fond bleu

        // boucle sur toutes les cases
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int x = xOffset + c * cellSize;
                int y = yOffset + r * cellSize;

                // case vide = trou blanc
                g.setColor(Color.WHITE);
                g.fillOval(x + 10, y + 10, cellSize - 20, cellSize - 20);
            }
        }
    }
}

public class board {
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

