package game;

/**
 * Représente un joueur du jeu Puissance 4.
 * Chaque joueur est identifié par un nom et une couleur (ROUGE ou JAUNE).
 */
public class Player {

    private String name;
    private PlayerColor couleur;

    /**
     * Crée un joueur avec un nom et une couleur donnée.
     *
     * @param name    nom du joueur
     * @param couleur couleur associée au joueur (ROUGE ou JAUNE)
     */
    public Player(String name, PlayerColor couleur) {
        this.name = name;
        this.couleur = couleur;
    }

    /**
     * Retourne le nom du joueur.
     *
     * @return nom du joueur
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne la couleur du joueur.
     *
     * @return couleur du joueur
     */
    public PlayerColor getCouleur() {
        return couleur;
    }
}
