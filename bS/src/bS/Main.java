package bS;

import bS.BohnenView.TitleScreen;

/**
 * This class initiates the program.
 **/

public class Main {
    public static void main(String[] args){
        TitleScreen view = new TitleScreen();
        new BohnenController(view);
    }
    
}