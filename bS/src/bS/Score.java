package bS;

public class Score {
    private int player1Score;
    private int player2Score;

    public Score() {
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public void updateScore(int player, int stones) {
        if (player == 1) {
            player1Score += stones;
        } else if (player == 2) {
            player2Score += stones;
        }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void displayScores() {
        System.out.println("Player 1's score: " + player1Score);
        System.out.println("Player 2's score: " + player2Score);
    }
}

