package bS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bS.BohnenView.*;

public class BohnenController implements ActionListener {
	private TitleScreen view;
    private NameInput nameInput;

	protected BohnenController(TitleScreen view){
		this.view = view;
		view.titleActionListener(this);
	}

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
                System.err.println("Unexpected input");
                break;
            }
        }
    }

}

class NameInputController implements ActionListener {
	private NameInput view;
    private TitleScreen parent;
    private GameBoard gameBoard;
    private final boolean ISDEBUG;

    protected  NameInputController(NameInput view, TitleScreen parent, boolean isDebug){
        this.view = view;
        this.parent = parent;
        this.ISDEBUG = isDebug;
    }

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
                System.err.println("Unexpected input");
                break;
            }
        }
    }

}

class GameBoardController implements ActionListener, IUpdateBoard{
    private BohnenModel model;
    private TitleScreen parent;
    private GameBoard view;
    private final boolean ISDEBUG;
    private String[] players;
    private boolean isEditing;
    private boolean isEndGame;
    
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
                    System.err.println("Unexpected input");
                }
                break;
            }
        }
    }

    private void handleHoleClick(int index, boolean isEditing){
        if (!isEditing){
            model.loopHole(index);
            update(isEndGame);
            model.changePlayer();
            update(isEndGame);
        }
        else {
            int stone;
            boolean flag = true;
            while (flag){
                try {
                    String s = JOptionPane.showInputDialog(view,"Enter stone");
                    if (s != null){
                        stone = Integer.parseInt(s); 
                        if (stone <= 96){
                            model.setStone(index, stone, false);
                            update(isEndGame); 
                        }
                        else
                            JOptionPane.showMessageDialog(view, "There are only 9(6) Infinity Stones");
                    }
                    flag = false;
                    
                } catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(view, "Wuhttt??");
                }
            }
        }

        isEndGame = model.endGame();
        if (isEndGame){
            if (model.getCurrentPlayer() != null){
                JOptionPane.showMessageDialog(view, "End??");
            }
            else
                JOptionPane.showMessageDialog(view, "How??");
        }
    }

    private void update(boolean isEndGame){
        highlinePlayer(view.getPlayerElements(), model.getCurrentPlayer());
        updateStoneNumber(view.getHoleButton(),model.getHolesList());
        disableButton(view.getHoleButton(), model.getCurrentPlayer(), isEditing);
        updateScore(view.getPlayerElements(), model.getPlayerList());
    }

}