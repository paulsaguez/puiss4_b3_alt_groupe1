package game;

public class Player {

    private String name;
    private Color couleur;

    public Player(String name, Color couleur) {
        this.name = name;
        this.couleur = couleur;
    }

    public String getName() {
        return name;
    }

    public Color getCouleur() {
        return couleur;
    }
}
