package bS;

import bS.BohnenView.TitleScreen;

public class Main {
    public static void main(String[] args) {
        BohnenModel model = new BohnenModel();
        TitleScreen view = new TitleScreen();
        new BohnenController(model, view);
    }
    
}