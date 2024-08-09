package bS;

public class BsMain {

	public static void main(String[] args) {
		BohnenModel model = new BohnenModel();
		BohnenView view = new BohnenView();
		BohnenController controller = new BohnenController(model, view);

	}

}
