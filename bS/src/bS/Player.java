package bS;

public class Player {
	private final String NAME;
	private int score;

	public Player(String name, int score) {
		this.NAME = name;
		this.score = score;

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

