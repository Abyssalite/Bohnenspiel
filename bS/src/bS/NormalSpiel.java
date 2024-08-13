package bS;

public class NormalSpiel {
    private Holes holes;
    private Score score;
    private boolean isPlayer1Turn;

    public NormalSpiel() {
        this.holes = new Holes(4);  // 4 stones per hole by default
        this.score = new Score();
        this.isPlayer1Turn = true;
    }

    public void startGame() {
        // Game loop implementation
        while (!isGameOver()) {
            holes.displayBoard();
            if (isPlayer1Turn) {
                playTurn(1);
            } else {
                playTurn(2);
            }
            isPlayer1Turn = !isPlayer1Turn;
        }
        score.displayScores();
    }

    private void playTurn(int player) {
        // Implement game logic, similar to previous implementation
    }

    private boolean isGameOver() {
        // Implement game over check logic
        return false;
    }
}
