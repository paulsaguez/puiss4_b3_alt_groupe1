package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getId() {
        // Test avec un id positif
        Player player1 = new Player("Alice", PlayerColor.ROUGE, 1);
        assertEquals(1, player1.getId());

        // Test avec un id différent
        Player player2 = new Player("Bob", PlayerColor.JAUNE, 2);
        assertEquals(2, player2.getId());

        // Test avec id = 0
        Player player3 = new Player("Charlie", PlayerColor.ROUGE, 0);
        assertEquals(0, player3.getId());
    }

    @Test
    void setId() {
        Player player = new Player("Alice", PlayerColor.ROUGE, 1);
        
        // Vérifier l'id initial
        assertEquals(1, player.getId());
        
        // Modifier l'id
        player.setId(5);
        assertEquals(5, player.getId());
        
        // Modifier à nouveau l'id
        player.setId(10);
        assertEquals(10, player.getId());
        
        // Modifier avec 0
        player.setId(0);
        assertEquals(0, player.getId());
    }

    @Test
    void getName() {
        // Test avec un nom simple
        Player player1 = new Player("Alice", PlayerColor.ROUGE, 1);
        assertEquals("Alice", player1.getName());

        // Test avec un nom différent
        Player player2 = new Player("Bob", PlayerColor.JAUNE, 2);
        assertEquals("Bob", player2.getName());

        // Test avec un nom contenant des espaces
        Player player3 = new Player("Jean Dupont", PlayerColor.ROUGE, 3);
        assertEquals("Jean Dupont", player3.getName());
    }

    @Test
    void getCouleur() {
        // Test avec la couleur ROUGE
        Player player1 = new Player("Alice", PlayerColor.ROUGE, 1);
        assertEquals(PlayerColor.ROUGE, player1.getCouleur());
        assertNotEquals(PlayerColor.JAUNE, player1.getCouleur());

        // Test avec la couleur JAUNE
        Player player2 = new Player("Bob", PlayerColor.JAUNE, 2);
        assertEquals(PlayerColor.JAUNE, player2.getCouleur());
        assertNotEquals(PlayerColor.ROUGE, player2.getCouleur());

        // Test que les deux joueurs ont des couleurs différentes
        assertNotEquals(player1.getCouleur(), player2.getCouleur());
    }
}