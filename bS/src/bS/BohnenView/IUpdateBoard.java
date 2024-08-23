package bS.BohnenView;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import bS.Holes;
import bS.Player;

public interface IUpdateBoard {
        public default void init(ArrayList<JLabel> playerElements, ArrayList<Player> players) {
            playerElements.get(0).setText(players.get(0).getName());
            playerElements.get(1).setText(players.get(1).getName());
            playerElements.get(2).setText(String.valueOf(players.get(0).getScore()));
            playerElements.get(3).setText(String.valueOf(players.get(1).getScore()));
    }

    public default void updateStoneNumber(ArrayList<JButton> holeButton, ArrayList<Holes> holes) {
        for(int i = 0; i <= 13; i++) {
                holeButton.get(i).setText(String.valueOf(holes.get(i).getStone()));
        }
    }

    public default void disableButton(ArrayList<JButton> holeButton, Player currentPlayer, boolean isEditing) {
        if (!isEditing) {
                holeButton.get(0).setEnabled(false);  
                holeButton.get(7).setEnabled(false);  
                if (currentPlayer.getPosition().equals("B")) {
                        for(int i = 8; i <= 13; i++)
                                holeButton.get(i).setEnabled(false);  
        
                        for(int i = 1; i <= 6; i++)
                                holeButton.get(i).setEnabled(true); 
                }
                else {
                        for(int i = 8; i <= 13; i++)
                                holeButton.get(i).setEnabled(true);  
        
                        for(int i = 1; i <= 6; i++)
                                holeButton.get(i).setEnabled(false); 
                }
        }
        else {
                for(int i = 0; i <= 13; i++)
                holeButton.get(i).setEnabled(true);  
        }
    }

    public default void highlinePlayer(ArrayList<JLabel> playerElements, Player currentPlayer) {
        if (currentPlayer.getPosition().equals("B")) {
                playerElements.get(0).setFont(new Font( "Arial", Font.BOLD, 40));
                playerElements.get(0).setForeground(Color.CYAN);   
                playerElements.get(1).setFont(new Font( "Arial", Font.PLAIN, 40));
                playerElements.get(1).setForeground(Color.WHITE); 
        }
        else {
                playerElements.get(0).setFont(new Font( "Arial", Font.PLAIN, 40));
                playerElements.get(0).setForeground(Color.WHITE);   
                playerElements.get(1).setFont(new Font( "Arial", Font.BOLD, 40));
                playerElements.get(1).setForeground(Color.ORANGE); 
        }
    }

    public default void updateScore(ArrayList<JLabel> playerElements, ArrayList<Player> players) {
        playerElements.get(2).setText(String.valueOf(players.get(0).getScore()));
        playerElements.get(3).setText(String.valueOf(players.get(1).getScore()));
    }

}