package bS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bS.BohnenView.*;

public class BohnenController implements ActionListener {
	private TitleScreen view;
    private NameInput nameInput;

	protected BohnenController(TitleScreen view) {
		this.view = view;
		view.titleActionListener(this);
	}

    public void actionPerformed(ActionEvent evt) {
        String actionEvent = evt.getActionCommand();
        switch (actionEvent) {
            case "startBtn":{
                nameInput = new NameInput();
                NameInputController nameInputController = new NameInputController(nameInput, view, false);
                nameInput.nameActionListener(nameInputController); 
                nameInput.setVisible(true);
                break;                
            }
            case "debugBtn":{
                nameInput = new NameInput();
                NameInputController nameInputController = new NameInputController(nameInput, view, true);
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
    private GameBoard gameBoard;
    private final boolean ISDEBUG;

    protected  NameInputController(NameInput view, TitleScreen parent, boolean isDebug) {
        this.view = view;
        this.parent = parent;
        this.ISDEBUG = isDebug;
    }

    public void actionPerformed(ActionEvent evt) {
        String actionEvent = evt.getActionCommand();
        switch (actionEvent) {
            case "okBtn": {
                model = new BohnenModel();
                view.dispose();
                parent.setVisible(false);

                gameBoard = new GameBoard(ISDEBUG);
                model.startGame(view.getPlayerName(), ISDEBUG);
                GameBoardController gameBoardController = new GameBoardController(model, gameBoard, parent);
                gameBoard.boardActionListener(gameBoardController); 
                gameBoard.setVisible(true);
  
                break;
            }
            case "clrBtn": {
                view.dispose();
                break;
            }
        }
    }

}

class GameBoardController implements ActionListener, IUpdateBoard{
    private BohnenModel model;
    private TitleScreen parent;
    private GameBoard view;
    
    protected  GameBoardController(BohnenModel model, GameBoard view, TitleScreen parent) {
        this.model = model;
        this.view = view;
        this.parent = parent;
        init(view.getPlayerElements(), model.getPlayerList());
    }

    public void actionPerformed(ActionEvent evt) {
        String actionEvent = evt.getActionCommand();
        switch (actionEvent) {
            case "quitBtn": {
                parent.dispose();
                view.dispose();
                break;
            }
            case "menuBtn": {
                view.dispose();
                parent.setVisible(true);;
                break;
            }
            case "restartBtn": {
                this.model = new BohnenModel();
                break;
            }
            case "startBtn": {
                break;
            }
        }
 
    }

}