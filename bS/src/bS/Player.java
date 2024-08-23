package bS;

public class Player {
    private final String POSITION;
	private final String NAME;
	private int score;
    private final int INDEX;

	protected Player(String name, int score, String position, int index) {
		this.NAME = name;
		this.score = score;
        this.POSITION = position;
        this.INDEX = index;
	} 

    protected String getPosition() {
        return POSITION;
    }

    public String getName() {
        return NAME;
    }

    public int getIndex() {
        return INDEX;
    }

    public int getScore() {
        return score;
    }

    protected void setScore(int score) {
        this.score = score;
    }

}