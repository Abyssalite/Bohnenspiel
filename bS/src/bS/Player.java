package bS;

public class Player {
    private final String POSITION;
	private final String NAME;
	private int score;

	protected Player(String name, int score, String position) {
		this.NAME = name;
		this.score = score;
        this.POSITION = position;
	} 

    protected String getPosition() {
        return POSITION;
    }

    protected String getName() {
        return NAME;
    }

    protected int getScore() {
        return score;
    }

    protected void setScore(int score) {
        this.score = score;
    }

}