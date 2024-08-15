package bS;
import java.util.ArrayList;
import java.util.Random;

// This class will later rename to BohnenModel!!!

public class NormalSpiel {
    private ArrayList<Player> playerList;
    private Board board;
    private int playerIndex;
    private Player currentPlayer;
    private Holes currentHole;
    Random rand = new Random();

    protected  NormalSpiel() {
        playerIndex = rand.nextInt(2);
    }

    public void startGame(String[] player) {
        board = new Board();

        playerList = new ArrayList<Player>();
        for (int i = 0; i <= 1; i++){
            if(i == 0)
                playerList.add(new Player(player[i] , 0, "R"));
            else
                playerList.add(new Player(player[i] , 0, "B"));
        }
        currentPlayer = playerList.get(playerIndex);

    }

    public void changePlayer(){
        playerIndex++;
		if (playerIndex >= playerList.size()) 
            playerIndex = 0;

        currentPlayer = playerList.get(playerIndex);
        
    }

    // it's a loopHole alright Q.Q
    public void loopHole(int selectedIndex){
        currentHole = board.getHolesList().get(selectedIndex);
        int step = currentHole.getStone();
        int loop = 0;
        int[] subStep = new int[5];
        currentHole.setStone(0);

        subStep[loop] =  Math.min((13 - selectedIndex), step);
        step -= (13 - selectedIndex);

        while(step > 0){
            loop++;
            if(step  < 14){
                subStep[loop] = step;
                step = 0;
            }
            else {
                subStep[loop] = 13;
                step -= 13;
            }
        }

        for(int i = 0; i <= loop; i++){
           System.out.println(subStep[i]);
            for(int j = 1; j <= subStep[i]; j++){

                currentHole = board.getHolesList().get(selectedIndex + j);
                String[] position = currentHole.getPosition().split("_");
                
                if(!position[1].equals("0")){     
                    currentHole.setStone(1);
                }
                else if(position[0].equals(currentPlayer.getPosition())){
                    currentHole.setStone(1);
                    currentPlayer.setScore(board.getHolesList().get(selectedIndex + j).getStone()); 
                }
                else{
                    selectedIndex = 0;
                    currentHole = board.getHolesList().get(selectedIndex + j);
                    currentHole.setStone(1);
                }
            }
            selectedIndex = -1;
        }

    }

    // Test function only tobe delete
    public void printBoard(){
        // Print player
        System.out.println("Player list");
        for(int i = 0; i < playerList.size(); i++){
            System.out.println(playerList.get(i).getName() + "; " + playerList.get(i).getScore() + "; " + playerList.get(i).getPosition());
        }

        // Print Holes
        System.out.println("Holes list");
        for(int i = 0; i < board.getHolesList().size(); i++){
            System.out.println(board.getHolesList().get(i).getIndex()+ "; " 
                            + board.getHolesList().get(i).getPosition() + "; "
                            + board.getHolesList().get(i).getStone());
        }

        // Mock pick and place stones
        if(currentPlayer.getPosition() == "B")
            loopHole(2);
        else
            loopHole(11);

        System.out.println(currentPlayer.getName() + "; " + currentPlayer.getScore() + "; " + currentPlayer.getPosition());
        for(int i = 0; i < board.getHolesList().size(); i++){
            System.out.println(board.getHolesList().get(i).getIndex()+ "; " 
                            + board.getHolesList().get(i).getPosition() + "; "
                            + board.getHolesList().get(i).getStone());
        }

        /*/ Mock change player
        while (true) {
            int zahl = Integer.parseInt(JOptionPane.showInputDialog("1 to change player; else 0"));
				if (zahl == 1)
                    changePlayer();

            System.out.println(currentPlayer.getName());

        }*/
    }

}
