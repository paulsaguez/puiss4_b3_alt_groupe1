package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Plateau plateau;

    @BeforeEach
    void setUp() {
        player1 = new Player("Joueur1", PlayerColor.ROUGE, 1);
        player2 = new Player("Joueur2", PlayerColor.JAUNE, 2);
        game = new Game(player1, player2);
        plateau = new Plateau(game);
    }

    @Test
    void paintComponent() {
        // Test que paintComponent ne lance pas d'exception avec un plateau vide
        BufferedImage image = new BufferedImage(700, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        
        assertDoesNotThrow(() -> {
            plateau.paintComponent(g2d);
        });
        
        g2d.dispose();
    }

    @Test
    void paintComponentWithPieces() {
        // Test que paintComponent fonctionne avec des pions sur le plateau
        game.play(0); // Joueur 1 joue dans la colonne 0
        game.switchActivePlayer();
        game.play(1); // Joueur 2 joue dans la colonne 1
        game.switchActivePlayer();
        game.play(0); // Joueur 1 joue dans la colonne 0
        
        BufferedImage image = new BufferedImage(700, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        
        assertDoesNotThrow(() -> {
            plateau.paintComponent(g2d);
        });
        
        g2d.dispose();
    }

    @Test
    void paintComponentWithFullBoard() {
        // Test que paintComponent fonctionne avec un plateau presque plein
        // Remplir plusieurs colonnes
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 3; row++) {
                game.play(col);
                game.switchActivePlayer();
            }
        }
        
        BufferedImage image = new BufferedImage(700, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        
        assertDoesNotThrow(() -> {
            plateau.paintComponent(g2d);
        });
        
        g2d.dispose();
    }

    @Test
    void plateauConstants() {
        // Test que les constantes ROWS et COLS sont correctes
        assertEquals(6, Plateau.ROWS);
        assertEquals(7, Plateau.COLS);
    }

    @Test
    void plateauConstructor() {
        // Test que le constructeur initialise correctement le plateau
        assertNotNull(plateau);
        // Vérifier que le plateau a bien un Game associé
        // On peut le vérifier indirectement en testant que paintComponent fonctionne
        BufferedImage image = new BufferedImage(700, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        
        assertDoesNotThrow(() -> {
            plateau.paintComponent(g2d);
        });
        
        g2d.dispose();
    }

    @Test
    void paintComponentWithDifferentSizes() {
        // Test que paintComponent fonctionne avec différentes tailles de fenêtre
        int[] sizes = {100, 500, 1000, 2000};
        
        for (int size : sizes) {
            BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            plateau.setSize(size, size);
            
            assertDoesNotThrow(() -> {
                plateau.paintComponent(g2d);
            });
            
            g2d.dispose();
        }
    }
}