package bS;

public class Holes {
    private int[] board;

    public Holes(int stonesPerHole) {
        this.board = new int[14];
        for (int i = 0; i < 6; i++) {
            board[i] = stonesPerHole;  // Player 1's holes
            board[i + 7] = stonesPerHole;  // Player 2's holes
        }
    }

    public int[] getBoard() {
        return board;
    }

    public void updateBoard(int index, int stones) {
        board[index] = stones;
    }

    public void displayBoard() {
        // Implement board display logic
    }
}
