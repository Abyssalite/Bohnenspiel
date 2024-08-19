package bS.BohnenView;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import bS.Player;

public interface IUpdateBoard {
    	public default void init(ArrayList<JLabel> playerElements, ArrayList<Player> players) {
            playerElements.get(0).setText(players.get(0).getName());
            playerElements.get(1).setText(players.get(1).getName());
            playerElements.get(2).setText(String.valueOf(players.get(0).getScore()));
            playerElements.get(3).setText(String.valueOf(players.get(1).getScore()));

    }
    
}
