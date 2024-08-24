package bS.BohnenView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameBoard extends JFrame implements ICustomButton {
    private JPanel boardPanel;
    private ArrayList<JButton> holeButtonList;
    private LinkedHashMap<String, JButton> boardButtonMap;
    private ArrayList<JLabel> playerElements;
	private JButton editBtn;
    private JButton restartBtn;
    private JButton quitBtn;
    private JButton menuBtn;
    private JLabel player1Name;
    private JLabel player2Name;
    private JLabel player1Score;
    private JLabel player2Score;
    private JButton inx1, inx2, inx3, inx4, inx5, inx6, inx7, inx8, inx9, inx10, inx11, inx12, inx13, inx0;
    private boolean isDebug;

    private JLabel backgroundLabel;
    private ImageIcon imageIcon;

	public GameBoard(boolean isDebug){
        this.isDebug = isDebug;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
        int width = (int) (size.getWidth() * 0.99);
        int height = (int) (size.getHeight() * 0.93);

		setTitle("BohnenSpiel v0.06");
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		add(titelPanel(width, height));

		pack();
		setVisible(true);
		toFront();
	}

	private JPanel titelPanel(int width, int height){
		// Game screen
		boardPanel = new JPanel();
		boardPanel.setPreferredSize(new Dimension(width, height));
		boardPanel.setLayout(null);

        backgroundLabel = new JLabel();
        if (isDebug)
            imageIcon = new ImageIcon("Board_debug.png");
        else
            imageIcon = new ImageIcon("Board.png");

        backgroundLabel.setVerticalAlignment(1);
        backgroundLabel.setHorizontalAlignment(2);
		backgroundLabel.setIcon(imageIcon);
		backgroundLabel.setBounds(0, 0, width, height);

        playerElements = new ArrayList<JLabel>();

        playerElements.add(player1Name = new JLabel(""));
        playerElements.add(player2Name = new JLabel(""));
        playerElements.add(player1Score = new JLabel("", JLabel.CENTER));
        playerElements.add(player2Score = new JLabel("", JLabel.CENTER));

        player1Name.setBounds(344, 370, 330, 80);
        player1Name.setForeground(Color.WHITE);
        player1Name.setFont(new Font( "Arial", Font.PLAIN, 40));

        player1Score.setBounds(724, 370, 100, 80);
        player1Score.setForeground(Color.WHITE);
        player1Score.setFont(new Font( "Arial", Font.BOLD, 45));

        player2Name.setBounds(1138, 830, 330, 80);
        player2Name.setForeground(Color.WHITE);
        player2Name.setFont(new Font( "Arial", Font.PLAIN, 40));

        player2Score.setBounds(1522, 830, 100, 80);
        player2Score.setForeground(Color.WHITE);
        player2Score.setFont(new Font( "Arial", Font.BOLD, 45));

        // Create button
        holeButtonList = new ArrayList<JButton>();
        holeButtonList.add(inx0 = new JButton("0"));
        holeButtonList.add(inx1 = new JButton("0"));
        holeButtonList.add(inx2 = new JButton("0"));
        holeButtonList.add(inx3 = new JButton("0"));
        holeButtonList.add(inx4 = new JButton("0"));
        holeButtonList.add(inx5 = new JButton("0"));
        holeButtonList.add(inx6 = new JButton("0"));
        holeButtonList.add(inx7 = new JButton("0"));
        holeButtonList.add(inx8 = new JButton("0"));
        holeButtonList.add(inx9 = new JButton("0"));
        holeButtonList.add(inx10 = new JButton("0"));
        holeButtonList.add(inx11 = new JButton("0"));
        holeButtonList.add(inx12 = new JButton("0"));
        holeButtonList.add(inx13 = new JButton("0"));

        for(int i = 0; i <= 13; i++){
            holeButtonList.get(i).setFont(new Font("Arial", Font.BOLD, 40));
            holeButtonList.get(i).setBackground(Color.BLACK);
            holeButtonList.get(i).setForeground(Color.WHITE);
            holeButtonList.get(i).setContentAreaFilled(false);
            holeButtonList.get(i).setBorderPainted(false);
            holeButtonList.get(i).setFocusPainted(false);
            holeButtonList.get(i).setOpaque(false);

            int index = i;
            // Override default mouse behaviour for custom button
            holeButtonList.get(i).addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    highlineHole(holeButtonList, index, "enter");
                }
                @Override
	            public void mouseExited(MouseEvent e){
                    highlineHole(holeButtonList, index, "exit");
	            }
            });
            holeButtonList.get(i).setActionCommand(String.valueOf(index));
            boardPanel.add(holeButtonList.get(i));
        }

        inx1.setBounds(1290, 507,110, 110);
        inx2.setBounds(1143, 507, 110, 110);
        inx3.setBounds(998, 507, 110, 110);
        inx4.setBounds(854, 507, 110, 110);
        inx5.setBounds(709, 507, 110, 110);
        inx6.setBounds(563, 507, 110, 110);
        inx7.setBounds(415, 580, 110, 110);
        inx8.setBounds(563, 663, 110, 110);
        inx9.setBounds(709, 663, 110, 110);
        inx10.setBounds(854, 663, 110, 110);
        inx11.setBounds(998, 663, 110, 110);
        inx12.setBounds(1143, 663, 110, 110);
        inx13.setBounds(1290, 663, 110, 110);
        inx0.setBounds(1438, 580, 110, 110);

        boardButtonMap = new LinkedHashMap<String, JButton>();
        boardButtonMap.put("restartBtn", restartBtn = new JButton("Restart"));
        boardButtonMap.put("menuBtn", menuBtn = new JButton("Menu"));
        boardButtonMap.put("quitBtn", quitBtn = new JButton("Quit"));
        if (isDebug)
        {
            boardButtonMap.put("editBtn", editBtn = new JButton("Edit"));
            editBtn.setBounds(36, 378, 244, 81);
            editBtn.setActionCommand("editBtn");
            boardPanel.add(editBtn);
        } 

        for(Map.Entry<String, JButton> button : boardButtonMap.entrySet()){
            button.getValue().setFont(new Font("Arial", Font.BOLD, 40));
            button.getValue().setBackground(Color.BLACK);
            button.getValue().setForeground(Color.WHITE);
            button.getValue().setContentAreaFilled(false);
            button.getValue().setBorderPainted(false);
            button.getValue().setFocusPainted(false);
            button.getValue().setOpaque(false);

            // Override default mouse behaviour for custom button
            button.getValue().addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    highlineButton(boardButtonMap, button.getKey(), "enter");
                }
                @Override
	            public void mouseExited(MouseEvent e){
                    highlineButton(boardButtonMap, button.getKey(), "exit");
	            }
                @Override
	            public void mousePressed(MouseEvent e){
                    highlineButton(boardButtonMap, button.getKey(), "pressed");
	            }
            });
            boardPanel.add(button.getValue());
        }
        quitBtn.setBounds(36, 40, 244, 82);
		restartBtn.setBounds(36, 154, 244, 82);
		menuBtn.setBounds(36, 263, 244, 82);
        
		// Set ActionCommand
		restartBtn.setActionCommand("restartBtn");
        menuBtn.setActionCommand("menuBtn");
        quitBtn.setActionCommand("quitBtn");

        boardPanel.add(player1Name);
        boardPanel.add(player1Score);
        boardPanel.add(player2Name);
        boardPanel.add(player2Score);
        boardPanel.add(backgroundLabel);

		return boardPanel;
	}

	// actionListener for the game board
	public void boardActionListener(ActionListener evt){
		restartBtn.addActionListener(evt);
		menuBtn.addActionListener(evt);
        quitBtn.addActionListener(evt);
        if (isDebug) editBtn.addActionListener(evt);
        for(JButton button: holeButtonList)
            button.addActionListener(evt);
	}

    public LinkedHashMap<String, JButton> getButtonMap(){
        return boardButtonMap;
    }

    public ArrayList<JLabel> getPlayerElements(){
        return playerElements;
    }

    public ArrayList<JButton> getHoleButton(){
        return holeButtonList;
    }
    
}