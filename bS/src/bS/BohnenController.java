package bS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bS.BohnenView.*;

/**
 * The controller for the menu screen.
 **/

public class BohnenController implements ActionListener {
	private TitleScreen view;
    private NameInput nameInput;

    /**
     * Constructor for the controller title menu screen.
     * 
     * @param view - the menu screen
     **/
    
	protected BohnenController(TitleScreen view){
		this.view = view;
		view.titleActionListener(this);
	}

	 /**
     * The action for the main screen.
     * 
     * @param evt - the event of the menu
     **/
	
    public void actionPerformed(ActionEvent evt){
        String actionEvent = evt.getActionCommand();
        switch (actionEvent){
            case "startBtn": {
                nameInput = new NameInput();
                NameInputController nameInputController = new NameInputController(nameInput, view, false);
                nameInput.nameActionListener(nameInputController); 
                nameInput.setVisible(true);
                break;              
            }
            case "debugBtn": {
                nameInput = new NameInput();
                NameInputController nameInputController = new NameInputController(nameInput, view, true);
                nameInput.nameActionListener(nameInputController); 
                nameInput.setVisible(true);
                break;                       
            }
            case "quitBtn": {
                view.dispose();
                break;              
            }
            default: {
                System.err.println("What did you do?");
                break;
            }
        }
    }

}

/**
 * Controller for the name input window.
 **/

class NameInputController implements ActionListener {
	private NameInput view;
    private TitleScreen parent;
    private GameBoard gameBoard;
    private final boolean ISDEBUG;

    /**
     * Constructor for the controller.
     * 
     * @param view - the name input screen
     * @param parent - the menu window screen
     * @param isDebug - the flag of the selected game mode
     **/
    
    protected  NameInputController(NameInput view, TitleScreen parent, boolean isDebug){
        this.view = view;
        this.parent = parent;
        this.ISDEBUG = isDebug;
    }

    /**
     * The action for the main screen.
     * 
     * @param evt - the event
     **/
    
    public void actionPerformed(ActionEvent evt){
        String actionEvent = evt.getActionCommand();
        switch (actionEvent){
            case "okBtn": {
                view.dispose();
                parent.setVisible(false);

                gameBoard = new GameBoard(ISDEBUG);
                GameBoardController gameBoardController = new GameBoardController(gameBoard, parent, ISDEBUG, view.getPlayerName());
                gameBoard.boardActionListener(gameBoardController); 
                gameBoard.setVisible(true);
  
                break;
            }
            case "clrBtn": {
                view.dispose();
                break;
            }
            default: {
                System.err.println("What did you do?");
                break;
            }
        }
    }

}

/**
 * Controller for the board game window.
 **/

class GameBoardController implements ActionListener, IUpdateBoard {
    private BohnenModel model;
    private TitleScreen parent;
    private GameBoard view;
    private final boolean ISDEBUG;
    private String[] players;
    private boolean isEditing;
    private boolean isEndGame;
    
    /**
     * Constructor for the board game controller
     * 
     * @param view - the the board game screen
     * @param parent - the menu screen
     * @param isDebug - the flag of the debug mode
     * @param players - the array of player names
     **/
    
    protected  GameBoardController(GameBoard view, TitleScreen parent, boolean isDebug, String[] players){
        this.view = view;
        this.parent = parent;
        this.ISDEBUG = isDebug;
        this.players = players;
        isEditing = isDebug;
        isEndGame = false;

        model = new BohnenModel(ISDEBUG);
        model.startGame(players);
        init(view.getPlayerElements(), model.getPlayerList());
        update(isEndGame);
    }

    /**
     * The action for the board game screen.
     * 
     * @param evt - the event
     **/
    
    public void actionPerformed(ActionEvent evt){
        String actionEvent = evt.getActionCommand();
        switch (actionEvent){
            case "quitBtn": {
                parent.dispose();
                view.dispose();
                break;
            }
            case "menuBtn": {
                view.dispose();
                parent.setVisible(true);
                break;
            }
            case "restartBtn": {
                isEndGame = false;
                this.model = new BohnenModel(ISDEBUG);
                model.startGame(players);
                init(view.getPlayerElements(), model.getPlayerList());
                update(isEndGame);
                
                break;
            }
            case "editBtn": {
                isEditing = !isEditing;
                update(isEndGame); 
                break;
            }
            default: {
                try {
                    handleHoleClick(Integer.parseInt(actionEvent), isEditing);

                } catch (NumberFormatException nfe){
                    System.err.println("What did you do?");
                }
                break;
            }
        }
    }

    /**
     * Function to handle the click on the hole button.
     * 
     * @param index - the index of the hole
     * @param isEditing - the flag on the debug mode that shows whether the holes are editable
     **/
    
    private void handleHoleClick(int index, boolean isEditing){
        if (!isEditing){
            model.loopHole(index);
            update(isEndGame);
        }
        else {
            int stone;
            boolean flag = true;
            while (flag){
                try {
                    String s = JOptionPane.showInputDialog(view,"Insert the number of the stones");
                    if (s != null){
                        stone = Integer.parseInt(s); 
                        if (stone <= 96)
                            model.setStone(index, stone, false);
                        else
                            JOptionPane.showMessageDialog(view, "Maximum number is 96");
                    }
                    flag = false;
                    
                } catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(view, "Insert number only");
                }
            }
        }
        isEndGame = model.endGame();
        if(!isEndGame && !isEditing) model.changePlayer();

        update(isEndGame);
    }

    /**
     * Function to update the element in the GUI.
     **/
    
    private void update(boolean isEndGame){
        highlinePlayer(view.getPlayerElements(), model.getCurrentPlayer(), isEndGame);
        updateStoneNumber(view.getHoleButton(),model.getHolesList());
        disableButton(view.getHoleButton(), model.getCurrentPlayer(), isEditing, isEndGame);
        updateScore(view.getPlayerElements(), model.getPlayerList());

        if (isEndGame && !isEditing){
            if (model.getCurrentPlayer() != null){
                JOptionPane.showMessageDialog(view, model.getCurrentPlayer().getName() + " won the game ");
            }
            else
                JOptionPane.showMessageDialog(view, "Draw");
        }
    }

}