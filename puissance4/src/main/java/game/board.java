package game;
import javax.swing.*;
import java.awt.*;

class Plateau extends JPanel {
    static final int ROWS = 6;
    static final int COLS = 7;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int cellWidth = getWidth() / COLS;
        int cellHeight = getHeight() / ROWS;
        int cellSize = Math.min(cellWidth, cellHeight);

        int boardWidth  = COLS * cellSize;
        int boardHeight = ROWS * cellSize;

        // Décalages pour centrer et aligner en bas
        int xOffset = (getWidth() - boardWidth) / 2;      // centré
        int yOffset = getHeight() - boardHeight;

        g2d.setColor(Color.BLUE);
        g2d.fillRect(xOffset, yOffset, boardWidth, boardHeight); // fond bleu

        // boucle sur toutes les cases
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int x = xOffset + c * cellSize;
                int y = yOffset + r * cellSize;

                // case vide = trou blanc
                g2d.setColor(Color.WHITE);
                g2d.fillOval(x + 10, y + 10, cellSize - 20, cellSize - 20);
            }
        }
    }
}

