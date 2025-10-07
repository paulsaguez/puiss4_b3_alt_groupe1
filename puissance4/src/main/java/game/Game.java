package game;

public class Game {

    public int[][] plateau;
    public Player player1;
    public Player player2;
    public int[][] player1pieces;
    public int[][] player2pieces;
    public Player activePlayer;
    public int[] lastOne;

    public Game() {
        this.plateau = new int[6][7];
        this.lastOne = new int[6];
        for(int i = 0; i < 6; i++) {
            this.lastOne[i] = -1;
        }
    }

    public void play(int col){
        //1 représente un pion du joueur 1 et 2 un pion du joueur 2
        if (col < 0 || col >= 7) return;

        if (lastOne[col] >= 5) return;

        int nextRow = lastOne[col] + 1;

        plateau[nextRow][col] = (activePlayer.equals(player1)) ? 1 : 2;

        lastOne[col] = nextRow;
    }

}
