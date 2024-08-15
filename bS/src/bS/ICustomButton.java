package bS;

import java.awt.Color;
public interface ICustomButton {

	public default void highlineButton(BohnenView view, String object, String command) {
        switch (command) {
            case "enter":{
                view.getButtonMap().get(object).setForeground(Color.BLUE);;
                break;
            }
            case "exit":{
                view.getButtonMap().get(object).setForeground(Color.WHITE);;
                break;
            }
            case "pressed":{
                view.getButtonMap().get(object).setForeground(Color.RED);;
                break;
            }
            default:
                break;
        }
    }
 
}
