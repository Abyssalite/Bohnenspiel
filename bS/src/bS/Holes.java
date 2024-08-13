package bS;

public class Holes {
    private final int INDEX;
	private final String  POSITION;
    private int stone;

    public Holes(int stone, int index, String position) {
       this.INDEX = index;
       this.POSITION = position;
       this.stone = stone;
    }

    public int getIndex() {
        return INDEX;
    }

    public int getStone() {
        return stone;
    }

    public String getPosition() {
        return POSITION;
    }

    public void setStone(int amount) {
        if (amount == 0)
            stone = amount;
        else
            stone += amount;
    }

}
