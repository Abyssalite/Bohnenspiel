package bS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bS.BohnenView.*;

public class BohnenController implements ActionListener {
    private BohnenModel model;
	private TitleScreen view;
    private NameInput nameInput;

	protected BohnenController(BohnenModel model, TitleScreen view) {
		this.model = model;
		this.view = view;

		view.titleActionListener(this);
	}

    public void actionPerformed(ActionEvent evt) {
        String actionEvent = evt.getActionCommand();
        switch (actionEvent) {
            case "startBtn":{
                nameInput = new NameInput();
                NameInputController nameInputController = new NameInputController(model, nameInput, view, false);
                nameInput.nameActionListener(nameInputController); 
                nameInput.setVisible(true);
                break;                
            }
            case "debugBtn":{
                nameInput = new NameInput();
                NameInputController nameInputController = new NameInputController(model, nameInput, view, true);
                nameInput.nameActionListener(nameInputController); 
                nameInput.setVisible(true);
                break;                         
            }
            case "quitBtn":{
                view.dispose();
                break;                
            }

            default:
                break;
        }
    }

}

class NameInputController implements ActionListener {
	private BohnenModel model;
	private NameInput view;
    private TitleScreen parent;
    protected boolean isDebug;

    protected  NameInputController(BohnenModel model, NameInput view, TitleScreen parent, boolean isDebug) {
        this.model = model;
        this.view = view;
        this.parent = parent;
        this.isDebug = isDebug;
    }

    public void actionPerformed(ActionEvent evt) {
        String actionEvent = evt.getActionCommand();
        switch (actionEvent) {
            case "okBtn": {
                model.startGame(view.getPlayerName(), isDebug); // Will be changed to actual game UI
                model.printBoard(); // Will be changed to actual game UI

                //parent.setVisible(false);
                view.dispose();
                break;
            }
            case "clrBtn": {
                view.dispose();
                break;
            }
        }
    }

}