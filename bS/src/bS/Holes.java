package bS;

/**
 * This class constructs the holes of the board.
 **/

public class Holes {
    private final int INDEX;
	private final String  POSITION;
    private int stone;
    private final int OPPOSITE;

    /**
     * Constructor for the Holes class.
     * 
     * @param stone - the number of the stones
     * @param index - the index of the hole
     * @param position - the position of the hole on the board
     * @param opposite - the index of the opposite hole
     **/
    
    protected Holes(int stone, int index, String position, int opposite){
       this.INDEX = index;
       this.POSITION = position;
       this.stone = stone;
       this.OPPOSITE = opposite;
    }

    protected int getOpposite(){
        return OPPOSITE;
    }

    protected int getIndex(){
        return INDEX;
    }

    public int getStone(){
        return stone;
    }

    protected String getPosition(){
        return POSITION;
    }

    protected void addStone(int amount){
            stone += amount;
    }

    protected void setStone(int amount){
            stone = amount;
    }

}