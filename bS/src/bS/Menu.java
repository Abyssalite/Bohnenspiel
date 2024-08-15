package bS;

public class Menu {
    protected void displayMenu() {
        // Code to display menu and get user input

        // This function will later move to GUI!!!

        int choice = getUserInput();
        switch (choice) {
            case 1:
                // Placeholder, player name can be inputed at the game start
                String[] player = {"Anastasia" , "Huy"};
                
                NormalSpiel normalSpiel = new NormalSpiel();
                normalSpiel.startGame(player);
                normalSpiel.printBoard();
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

    protected int getUserInput() {
        // Implement user input logic
        return 1;  // Placeholder
    }

}