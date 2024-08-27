package bS;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class controls the logic of the game.
 **/

public class BohnenModel {
    private ArrayList<Player> playerList;
    private Board board;
    private int playerIndex;
    private Player currentPlayer;
    private Holes currentHole;
    private final boolean ISDEBUG;
    private boolean canChange;

    Random rand = new Random();

    /**
     * Constructor for the BohnenModel class.
     * 
     * @param isDebug - the flag to show that the game is in debug mode.
     **/
    
    protected  BohnenModel(boolean isDebug){
        this.ISDEBUG = isDebug;
        playerIndex = rand.nextInt(2);
    }
    
    /**
     * Function to start the game.
     * 
     * @param player - the array of the players name.
     **/
    
    protected void startGame(String[] player){
        board = new Board();
        playerList = new ArrayList<Player>();
        playerList.add(new Player(player[0] , 0, "B", 7));
        playerList.add(new Player(player[1] , 0, "R", 0));
        currentPlayer = playerList.get(playerIndex);
        canChange = false;
    }
    
    /**
     * Function to check the condition of stones / holes and switch the player.
     **/
    
    protected void changePlayer(){
        String[] position = currentHole.getPosition().split("_");

        if (position[1].equals("0") || currentHole.getStone() == 0)
            canChange = false;
        else 
            canChange = true;

        if (canChange){
            playerIndex = playerIndex == 0 ? 1 : 0;
            currentPlayer = playerList.get(playerIndex);
        }
    }
    
    /**
     * Function to pick up the stone(s) in the selected index and put to the next hole(s) in an anti clockwise direction.
     * 
     * @param selectedIndex - the index of the selected hole.
     **/
    
    protected void loopHole(int selectedIndex){
        currentHole = getHolesList().get(selectedIndex);
        int step = currentHole.getStone();
        int loop = 0;
        int[] subStep = new int[8];
        String[] position  = new String[2];
        currentHole.setStone(0);

        subStep[loop] =  Math.min((13 - selectedIndex), step);
        step -= (13 - selectedIndex);

        while(step > 0){
            loop++;
            if (step  < 14){
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

                currentHole = getHolesList().get(selectedIndex + j);
                position = currentHole.getPosition().split("_");
                
                if (!position[1].equals("0")){    
                    setStone(selectedIndex + j, 1, true); 
                }
                else if (position[0].equals(currentPlayer.getPosition())){
                    setStone(selectedIndex + j, 1, true); 
                }
                else {
                    selectedIndex = 0;
                    currentHole = getHolesList().get(selectedIndex + j);
                    setStone(selectedIndex, 1, true); 
                }
            }
            selectedIndex = -1;
        }

        Holes opposite = getHolesList().get(currentHole.getOpposite());
        if (currentHole.getStone() == 1 && position[0].equals(currentPlayer.getPosition()) ){
            int oppositeStone = opposite.getStone();
            opposite.setStone(0);
            setStone(currentPlayer.getCollect(), oppositeStone, true);

        }
    }

    /**
     * Function to check the condition for the end of the game.
     * 
     * @return isEndGame - the game ends.
     **/
    
    protected boolean endGame(){
        boolean isEndGame = false;
        int number = 0;
        for (int i = (playerIndex * 7 + 1); i <= (playerIndex * 7 + 6); i++){
            if (getHolesList().get(i).getStone() == 0)
                number++;
        }

        if (number == 6){
            int next = playerIndex == 0 ? 1 : 0;
            number = playerList.get(next).getScore();
            for (int i = (next * 7 + 1); i <= (next * 7 + 6); i++){
                    number += getHolesList().get(i).getStone();
            }
            playerList.get(next).setScore(number);

            if (playerList.get(0).getScore() > playerList.get(1).getScore()) 
                currentPlayer = playerList.get(0);
            else if (playerList.get(0).getScore() < playerList.get(1).getScore())
                currentPlayer = playerList.get(1);
            else 
                currentPlayer = null;

            isEndGame = true;
        }
        return isEndGame;
    }
    
    /**
     * Function to set or add the number of stones into the hole.
     * 
     * @param index - the index of the hole
     * @param stone - the number of the stone
     * @param add - the flag whether to set or add the stone depending on the mode
     **/
    
    protected void setStone(int index, int stone, boolean add){
        Holes hole = getHolesList().get(index);
        if (add)
            hole.addStone(stone);
        else
            hole.setStone(stone);

        if (hole.getIndex() == 0)
            playerList.get(1).setScore(hole.getStone()); 
        if (hole.getIndex() == 7) 
            playerList.get(0).setScore(hole.getStone());     
    }

    protected ArrayList<Player> getPlayerList(){
        return playerList;
    }

    protected ArrayList<Holes> getHolesList(){
        return board.getHolesList();
    }

    protected Player getCurrentPlayer(){
        return currentPlayer;
    }

    protected boolean isDebug(){
        return ISDEBUG;
    }

}