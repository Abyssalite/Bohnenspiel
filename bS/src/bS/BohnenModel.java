package bS;
import java.util.ArrayList;
import java.util.Random;

public class BohnenModel {
    private ArrayList<Player> playerList;
    private Board board;
    private int playerIndex;
    private Player currentPlayer;
    private Holes currentHole;
    private boolean isDebug;

    Random rand = new Random();

    protected  BohnenModel() {
        playerIndex = rand.nextInt(2);
    }

    protected void startGame(String[] player, boolean isDebug) {
        board = new Board();
        this.isDebug = isDebug;

        playerList = new ArrayList<Player>();
        playerList.add(new Player(player[0] , 0, "B", 0));
        playerList.add(new Player(player[1] , 0, "R", 1));
        currentPlayer = playerList.get(playerIndex);
    }

    protected void changePlayer() {
        playerIndex++;
		if (playerIndex >= playerList.size()) 
            playerIndex = 0;

        currentPlayer = playerList.get(playerIndex);
    }

    // it's a loopHole alright Q.Q
    protected void loopHole(int selectedIndex) {
        currentHole = board.getHolesList().get(selectedIndex);
        int step = currentHole.getStone();
        int loop = 0;
        int[] subStep = new int[5];
        currentHole.setStone(0);

        subStep[loop] =  Math.min((13 - selectedIndex), step);
        step -= (13 - selectedIndex);

        while(step > 0) {
            loop++;
            if(step  < 14) {
                subStep[loop] = step;
                step = 0;
            }
            else {
                subStep[loop] = 13;
                step -= 13;
            }
        }

        for(int i = 0; i <= loop; i++) {
           System.out.println(subStep[i]);
            for(int j = 1; j <= subStep[i]; j++) {

                currentHole = board.getHolesList().get(selectedIndex + j);
                String[] position = currentHole.getPosition().split("_");
                
                if(!position[1].equals("0")) {     
                    currentHole.setStone(1);
                }
                else if(position[0].equals(currentPlayer.getPosition())) {
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

    protected ArrayList<Player> getPlayerList(){
        return playerList;
    }

    protected ArrayList<Holes> getHoleList(){
        return board.getHolesList();
    }

    protected Player getCurrentPlayer(){
        return currentPlayer;
    }

}