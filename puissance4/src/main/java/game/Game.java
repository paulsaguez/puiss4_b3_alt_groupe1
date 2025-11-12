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

    public boolean play(int col) {
        if (col < 0 || col >= 7) return false;
        if (lastOne[col] >= 5) return false;

        int nextRow = lastOne[col] + 1;
        int playerValue = (activePlayer.getId() == 1) ? 1 : 2;

        plateau[nextRow][col] = playerValue;
        lastOne[col] = nextRow;

        lastRow = nextRow;
        lastCol = col;

        return true;
    }


    public void switchActivePlayer() {
        for (Player p : playerBoards.keySet()) {
            if (p.getId() != activePlayer.getId()) {
                activePlayer = p;
                return;
            }
        }
    }

    public boolean checkDraw(){
        for(int i = 0; i < 7; i++){
            if(lastOne[i] != 5){
                return false;
            }
        }
        return true;
    }

    private int countDirection(int row, int col, int dx, int dy, int playerId) {
        int count = 0;
        int x = row + dx;
        int y = col + dy;

        while (x >= 0 && x < 6 && y >= 0 && y < 7 && plateau[x][y] == playerId) {
            count++;
            x += dx;
            y += dy;
        }
        return count;
    }

    public boolean checkVictory() {
        int playerId = (activePlayer.getId() == 1) ? 1 : 2;

        int[][] directions = {
                {0, 1},
                {1, 0},
                {1, 1},
                {1, -1}
        };

        for (int[] dir : directions) {
            int count = 1;
            count += countDirection(lastRow, lastCol, dir[0], dir[1], playerId);
            count += countDirection(lastRow, lastCol, -dir[0], -dir[1], playerId);

            if (count >= 4) {
                return true;
            }
        }

        return false;
    }
}
