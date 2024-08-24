package bS;

import bS.BohnenView.TitleScreen;

public class Main {
    public static void main(String[] args){
        TitleScreen view = new TitleScreen();
        new BohnenController(view);
    }
    
}