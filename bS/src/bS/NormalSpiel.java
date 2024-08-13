package bS;

import java.util.ArrayList;

// This class will later rename to BohnenModel!!!

public class NormalSpiel {
    private ArrayList<Player> playerList;
    private Board board;
    private int playerIndex;


    protected  NormalSpiel() {
        playerIndex = 0;
    }

    public void startGame() {
        board = new Board();

        playerList = new ArrayList<Player>();
        for (int i = 0; i <= 1; i++){
            playerList.add(new Player("Player "+ (i + 1) , 0));
        }
    }

    public void printBoard(){
        System.out.println("Player list");
        for(int i = 0; i < playerList.size(); i++){
            System.out.println(playerList.get(i).getName() + "; " + playerList.get(i).getScore());
        }
        System.out.println("Holes list");
        for(int i = 0; i < board.getHolesList().size(); i++){
            System.out.println(board.getHolesList().get(i).getIndex()+ "; " 
                            + board.getHolesList().get(i).getPosition() + "; "
                            + board.getHolesList().get(i).getStone());
        }
    }

}
