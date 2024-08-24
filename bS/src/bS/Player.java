package bS;

public class Player {
    private final String POSITION;
	private final String NAME;
	private int score;
    private final int COLLECT;

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