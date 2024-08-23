package bS;
import java.util.ArrayList;
import java.util.Random;

public class BohnenModel {
    private ArrayList<Player> playerList;
    private Board board;
    private int playerIndex;
    private Player currentPlayer;
    private Holes currentHole;
    private final boolean ISDEBUG;
    private boolean canChange;

    Random rand = new Random();

    protected  BohnenModel(boolean isDebug) {
        this.ISDEBUG = isDebug;
        playerIndex = rand.nextInt(2);
    }

    protected void startGame(String[] player) {
        board = new Board();
        playerList = new ArrayList<Player>();
        playerList.add(new Player(player[0] , 0, "B", 7));
        playerList.add(new Player(player[1] , 0, "R", 0));
        currentPlayer = playerList.get(playerIndex);
        canChange = false;
    }

    protected void changePlayer() {
        String[] position = currentHole.getPosition().split("_");

        if (position[1].equals("0") || currentHole.getStone() == 0) 
            canChange = false;
        else
            canChange = true;

        if (canChange) {
            playerIndex++;
            if (playerIndex >= playerList.size()) 
                playerIndex = 0;
    
            currentPlayer = playerList.get(playerIndex);
        }
    }

    // it's a loopHole alright Q.Q
    protected void loopHole(int selectedIndex) {
        currentHole = getHolesList().get(selectedIndex);
        int step = currentHole.getStone();
        int loop = 0;
        int[] subStep = new int[8];
        String[] position  = new String[2];
        currentHole.setStone(0);

        subStep[loop] =  Math.min((13 - selectedIndex), step);
        step -= (13 - selectedIndex);

        while(step > 0) {
            loop++;
            if (step  < 14) {
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

                currentHole = getHolesList().get(selectedIndex + j);
                position = currentHole.getPosition().split("_");
                
                if (!position[1].equals("0")) {    
                    setStone(selectedIndex + j, 1, true); 
                }
                else if (position[0].equals(currentPlayer.getPosition())) {
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
        if (currentHole.getStone() == 1 && position[0].equals(String.valueOf(currentPlayer.getPosition()))) {
            setStone(currentPlayer.getCollect(), opposite.getStone(), true);
            opposite.setStone(0);
        }
    }

    protected void setStone(int index, int stone, boolean add) {
        Holes hole = getHolesList().get(index);
        if (add)
            hole.addStone(stone);
        else
            hole.setStone(stone);

        if (hole.getIndex() == 0 )
            playerList.get(1).setScore(hole.getStone()); 
        else if (hole.getIndex() == 7) 
            playerList.get(0).setScore(hole.getStone());       
    }

    protected ArrayList<Player> getPlayerList() {
        return playerList;
    }

    protected ArrayList<Holes> getHolesList() {
        return board.getHolesList();
    }

    protected Player getCurrentPlayer() {
        return currentPlayer;
    }

    protected boolean isDebug() {
        return ISDEBUG;
    }

}