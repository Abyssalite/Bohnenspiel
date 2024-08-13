package bS;

public class SetDebug {
    private int[] customBoard;

    public SetDebug() {
        // Logic to show a pop-up window with arrow buttons to set the number of stones
        // OK button to save the values and Cancel to discard
        customBoard = new int[14];
        // Assume values are set and stored in customBoard
    }

    public int[] getCustomBoard() {
        return customBoard;
    }
}
