package bS;

public class Player {
    private final String POSITION;
	private final String NAME;
	private int score;

	public Player(String name, int score, String position) {
		this.NAME = name;
		this.score = score;
        this.POSITION = position;
	} 

    public String getPosition(){
        return POSITION;
    }

    public String getName(){
        return NAME;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

}

