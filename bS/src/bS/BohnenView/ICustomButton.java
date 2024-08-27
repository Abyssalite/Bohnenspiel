package bS.BohnenView;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.JButton;

/**
 * Interface to edit the default behavior of the buttons.
 **/

public interface ICustomButton {

	/**
	 * custom behavior for functional buttons.
	 * 
	 * @param buttons - array list of all the buttons
	 * @param object - which button is currently selected
	 * @param command - the button commands
	 **/
	
	public default void highlineButton(LinkedHashMap<String, JButton> buttons, String object, String command){
        switch (command){
            case "enter": {
                buttons.get(object).setForeground(Color.BLUE);;
                break;
            }
            case "exit": {
                buttons.get(object).setForeground(Color.WHITE);;
                break;
            }
            case "pressed": {
                buttons.get(object).setForeground(Color.RED);;
                break;
            }
            default:
                break;
        }
    }

	/**
	 * custom behavior for hole buttons.
	 * 
	 * @param buttons - array list of all the holes as a button
	 * @param index - the index of the hole as a button
	 * @param command - 
	 **/
	
    public default void highlineHole(ArrayList<JButton> buttons, int index, String command){
        switch (command){
            case "enter": {
                if (index > 0 && index < 8)
                    buttons.get(index).setForeground(Color.BLUE);
                else
                    buttons.get(index).setForeground(Color.RED);
                break;
            }
            case "exit": {
                buttons.get(index).setForeground(Color.WHITE);;
                break;
            }
            default:
                break;
        }
    }
 
}