package game;

import java.util.HashMap;

public class Game {

    public int[][] plateau;
    public HashMap<Player, int[][]> playerBoards = new HashMap<>();
    public Player activePlayer;
    public int[] lastOne;
    public int lastRow = -1;
    public int lastCol = -1;

    public Game(Player player1, Player player2) {
        this.plateau = new int[6][7];
        this.lastOne = new int[7];
        for(int i = 0; i < 7; i++) {
            this.lastOne[i] = -1;
        }
        playerBoards.put(player1, new int[6][7]);
        playerBoards.put(player2, new int[6][7]);
        this.activePlayer = player1;
    }

    public boolean play(int col){
        //1 représente un pion du joueur 1 et 2 un pion du joueur 2
        if (col < 0 || col >= 7) return false;

        if (lastOne[col] >= 5) return false;

        int nextRow = lastOne[col] + 1;

        //le joueur 1 a l'id 1 et le joueur 2 à l'id 2
        plateau[nextRow][col] = (activePlayer.getId() == 1) ? 1 : 2;

        lastOne[col] = nextRow;
        return true;
    }
    

    public boolean checkVictory(){
        return true;
    }



}
