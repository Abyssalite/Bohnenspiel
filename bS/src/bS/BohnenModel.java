package bS;
import java.util.Random;

public class BohnenModel {
    private int[][] cellules;
    private int playerIndex;
    private Player currentPlayer;
    private boolean isDebug;
    Random rand = new Random();

    protected BohnenModel() {
        cellules = new int[2][6];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                cellules[i][j] = 4; 
            }
        }
        playerIndex = rand.nextInt(2);
    }

    protected void startGame(String[] players, boolean isDebug) {
        this.isDebug = isDebug;
        currentPlayer = new Player(players[playerIndex], 0, playerIndex == 0 ? "B" : "R", playerIndex);
    }

    protected void changePlayer() {
        playerIndex = (playerIndex + 1) % 2;
        currentPlayer = new Player(currentPlayer.getName(), currentPlayer.getScore(), playerIndex == 0 ? "B" : "R", playerIndex);
    }

    protected int getCellule(int i, int j) {
        return cellules[i][j];
    }

    protected void setCellule(int i, int j, int value) {
        cellules[i][j] = value;
    }

    protected void ajoutGraine(int i, int j) {
        cellules[i][j]++;
    }

    protected int NbGraines() {
        int resultat = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                resultat += cellules[i][j];
            }
        }
        return resultat;
    }

    protected int NbGraines(int i) {
        int resultat = 0;
        for (int j = 0; j < 6; j++) {
            resultat += cellules[i][j];
        }
        return resultat;
    }

    protected void afficherPlateau() {
        System.out.println("Plateau actuel :");
        System.out.println("  0 1 2 3 4 5");
        for (int i = 0; i < 2; i++) {
            System.out.print("[");
            for (int j = 0; j < 6; j++) {
                System.out.print(" " + cellules[i][j]);
            }
            System.out.println(" ] J" + (i + 1));
        }
        System.out.println("  0 1 2 3 4 5\n");
    }

    protected int jouerCoup(int j) {
        int NbGraine = cellules[playerIndex][j];
        if (NbGraine == 0) return -1;

        setCellule(playerIndex, j, 0);

        for (int k = 1; k <= NbGraine; k++) {
            int currentRow = (playerIndex + (j + k) / 6) % 2;
            int currentCol = (j + k) % 6;
            ajoutGraine(currentRow, currentCol);

            if (k == NbGraine && currentRow != playerIndex) {
                return manger(currentRow, currentCol);
            }
        }
        return 0;
    }

    protected int manger(int i, int cellulefinale) {
        int score = 0;
        for (int j = cellulefinale; j >= 0 && (cellules[i][j] == 2 || cellules[i][j] == 3); j--) {
            score += cellules[i][j];
            cellules[i][j] = 0;
        }
        currentPlayer.setScore(currentPlayer.getScore() + score);
        return score;
    }

    protected int[][] coupPossibles() {
        int[][] coup = new int[2][6];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                coup[i][j] = (cellules[i][j] > 0) ? 1 : 0;
            }
        }
        return coup;
    }

    protected String coupPossiblesToString(int[][] coup) {
        StringBuilder coups = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            coups.append("J").append(i + 1).append(" peut jouer les cases :");
            for (int j = 0; j < 6; j++) {
                if (coup[i][j] == 1) {
                    coups.append(" ").append(j);
                }
            }
            coups.append("\n");
        }
        return coups.toString();
    }

    protected Player getCurrentPlayer() {
        return currentPlayer;
    }
}