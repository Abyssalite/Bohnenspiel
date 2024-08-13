package bS;

public class Menu {
    public void displayMenu() {
        // Code to display menu and get user input
        // For simplicity, assume input is captured as an integer
        int choice = getUserInput();
        switch (choice) {
            case 1:
                NormalSpiel normalSpiel = new NormalSpiel();
                normalSpiel.startGame();
                break;
            case 2:
                SetDebug setDebug = new SetDebug();
                DebugSpiel debugSpiel = new DebugSpiel(setDebug.getCustomBoard());
                debugSpiel.startGame();
                break;
            case 3:
                System.out.println("Exiting game...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                displayMenu();
        }
    }

    private int getUserInput() {
        // Implement user input logic
        return 1;  // Placeholder
    }
}