package bS;

public class Holes {
    private final int INDEX;
	private final String  POSITION;
    private int stone;

    protected Holes(int stone, int index, String position) {
       this.INDEX = index;
       this.POSITION = position;
       this.stone = stone;
    }

    protected int getIndex() {
        return INDEX;
    }

    protected int getStone() {
        return stone;
    }

    protected String getPosition() {
        return POSITION;
    }

    protected void setStone(int amount) {
        if (amount == 0)
            stone = amount;
        else
            stone += amount;
    }

}