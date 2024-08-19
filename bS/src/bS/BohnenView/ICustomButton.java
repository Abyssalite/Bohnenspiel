package bS.BohnenView;

import java.awt.Color;
import java.util.LinkedHashMap;
import javax.swing.JButton;

public interface ICustomButton {

	public default void highlineButton(LinkedHashMap<String, JButton> buttons, String object, String command) {
        switch (command) {
            case "enter":{
                buttons.get(object).setForeground(Color.BLUE);;
                break;
            }
            case "exit":{
                buttons.get(object).setForeground(Color.WHITE);;
                break;
            }
            case "pressed":{
                buttons.get(object).setForeground(Color.RED);;
                break;
            }
            default:
                break;
        }
    }
 
}