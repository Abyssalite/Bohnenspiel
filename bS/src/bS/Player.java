package bS;

/**
 * This class constructs and saves the players of the game.
 **/

public class Player {
    private final String POSITION;
	private final String NAME;
	private int score;
    private final int COLLECT;
    
	/**
	 * Constructor for the Player class.
	 * 
	 * @param name - the name of the players
	 * @param score - the sum of the stones in the collecting hole
	 * @param position - the player's hole position on the board
	 * @param collect - the index of the collecting hole, that belongs to each player
	 **/
	    
	protected Player(String name, int score, String position, int collect){
		this.NAME = name;
		this.score = score;
        this.POSITION = position;
        this.COLLECT = collect;
	} 

    public String getPosition(){
        return POSITION;
    }

    public int getCollect(){
        return COLLECT;
    }

    public String getName(){
        return NAME;
    }

    public int getScore(){
        return score;
    }

    protected void setScore(int score){
        this.score = score;
    }

}