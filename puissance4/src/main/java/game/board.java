package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Plateau extends JPanel {
    static final int ROWS = 6;
    static final int COLS = 7;
    private Game game;

    public Plateau(Game game) {
        this.game = game;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cellWidth = getWidth() / COLS;
                int cellHeight = getHeight() / ROWS;
                int cellSize = Math.min(cellWidth, cellHeight);

                int boardWidth = COLS * cellSize;
                int xOffset = (getWidth() - boardWidth) / 2;

                int col = (e.getX() - xOffset) / cellSize;

                // On joue uniquement si c’est dans la grille
                if (col >= 0 && col < COLS) {
                    boolean ok = game.play(col);
                    if (ok) {
                        repaint(); // redessiner avant le message

                        if (game.checkVictory()) {
                            JOptionPane.showMessageDialog(Plateau.this,
                                    "Le joueur " + game.activePlayer.getName() + " a gagné !");
                        } else if (game.checkDraw()) {
                            JOptionPane.showMessageDialog(Plateau.this,
                                    "Match nul !");
                        } else {
                            // changer de joueur uniquement si pas de victoire
                            game.switchActivePlayer();
                        }
                        repaint();
                    } else {
                        // colonne pleine
                        JOptionPane.showMessageDialog(Plateau.this,
                                "Colonne pleine !");
                    }
                }
            }
        });
    }

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

        int xOffset = (getWidth() - boardWidth) / 2;
        int yOffset = getHeight() - boardHeight;

        // fond bleu du plateau
        g2d.setColor(Color.BLUE);
        g2d.fillRect(xOffset, yOffset, boardWidth, boardHeight);

        // dessin des pions
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int x = xOffset + c * cellSize;
                int y = yOffset + (ROWS - 1 - r) * cellSize; // inverser pour que la base soit en bas
                int value = game.plateau[r][c];

                switch (value) {
                    case 1 -> g2d.setColor(Color.RED);
                    case 2 -> g2d.setColor(Color.YELLOW);
                    default -> g2d.setColor(Color.WHITE);
                }

                g2d.fillOval(x + 10, y + 10, cellSize - 20, cellSize - 20);
            }
        }
    }
}

