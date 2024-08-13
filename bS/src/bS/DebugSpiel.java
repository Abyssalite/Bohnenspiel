package bS;

public class DebugSpiel {
    private Holes holes;
    private Score score;
    private boolean isPlayer1Turn;

    public DebugSpiel(int[] customBoard) {
        this.holes = new Holes(0);  // No default stones
        this.holes.updateBoard(customBoard);
        this.score = new Score();
        this.isPlayer1Turn = true;
    }

    public void startGame() {
        // Similar logic to NormalSpiel but with custom board setup
    }
}

