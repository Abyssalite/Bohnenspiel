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

public class GameBoard extends JFrame implements ICustomButton{
    private JPanel boardPanel;
    private LinkedHashMap<String, JButton> TitleButtonMap;
    private ArrayList<JLabel> playerElements;
	private JButton startBtn;
    private JButton restartBtn;
    private JButton quitBtn;
    private JButton menuBtn;
    private JLabel player1Name;
    private JLabel player2Name;
    private JLabel player1Score;
    private JLabel player2Score;
    private boolean isDebug;

    private JLabel backgroundLabel;
    private ImageIcon imageIcon;

	public GameBoard(boolean isDebug) {
        this.isDebug = isDebug;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
        int width = (int) (size.getWidth() * 0.99);
        int height = (int) (size.getHeight() * 0.93);

		setTitle("BohnenSpiel v0.01");
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		add(titelPanel(width, height));

		pack();
		setVisible(true);
		toFront();
	}

	private JPanel titelPanel(int width, int height)  {
		// Titelbildschirm erstellen
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

        player1Name.setBounds(355, 380, 320, 60);
        player1Name.setForeground(Color.WHITE);
        player1Name.setFont(new Font( "Arial", Font.BOLD, 40));

        player1Score.setBounds(750, 380, 60, 60);
        player1Score.setForeground(Color.WHITE);
        player1Score.setFont(new Font( "Arial", Font.BOLD, 45));

        player2Name.setBounds(1130, 830, 320, 60);
        player2Name.setForeground(Color.WHITE);
        player2Name.setFont(new Font( "Arial", Font.BOLD, 40));

        player2Score.setBounds(1525, 830, 60, 60);
        player2Score.setForeground(Color.WHITE);
        player2Score.setFont(new Font( "Arial", Font.BOLD, 45));

        // Tasten erstellen
        TitleButtonMap = new LinkedHashMap<String, JButton>();
        TitleButtonMap.put("restartBtn", restartBtn = new JButton("Retart"));
        TitleButtonMap.put("menuBtn", menuBtn = new JButton("Menu"));
        TitleButtonMap.put("quitBtn", quitBtn = new JButton("Quit"));
        if (isDebug)
        {
            TitleButtonMap.put("startBtn", startBtn = new JButton("Start"));
            startBtn.setBounds(48, 337, 225, 75);
            startBtn.setActionCommand("startBtn");
            boardPanel.add(startBtn);
        } 

        for(Map.Entry<String, JButton> button : TitleButtonMap.entrySet()) {
            button.getValue().setFont(new Font("Arial", Font.BOLD, 40));
            button.getValue().setBackground(Color.BLACK);
            button.getValue().setForeground(Color.WHITE);
            button.getValue().setContentAreaFilled(false);
            button.getValue().setBorderPainted(false);
            button.getValue().setFocusPainted(false);
            button.getValue().setOpaque(false);
        }
        quitBtn.setBounds(48, 32, 225, 75);
		restartBtn.setBounds(48, 136, 225, 75);
		menuBtn.setBounds(48, 236, 225, 75);
		// Set ActionCommand
		restartBtn.setActionCommand("restartBtn");
        menuBtn.setActionCommand("menuBtn");
        quitBtn.setActionCommand("quitBtn");

        for(Map.Entry<String, JButton> button : TitleButtonMap.entrySet()) {
            button.getValue().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    highlineButton(TitleButtonMap, button.getKey(), "enter");
                }
                @Override
	            public void mouseExited(MouseEvent e) {
                    highlineButton(TitleButtonMap, button.getKey(), "exit");
	            }
                @Override
	            public void mousePressed(MouseEvent e) {
                    highlineButton(TitleButtonMap, button.getKey(), "pressed");
	            }
            });
        }

		boardPanel.add(restartBtn);
        boardPanel.add(menuBtn);
        boardPanel.add(quitBtn);

        boardPanel.add(player1Name);
        boardPanel.add(player1Score);
        boardPanel.add(player2Name);
        boardPanel.add(player2Score);
        boardPanel.add(backgroundLabel);   
		return boardPanel;
	}

	// actionListener für die Titelbildschirm
	public void boardActionListener(ActionListener evt) {
		restartBtn.addActionListener(evt);
		menuBtn.addActionListener(evt);
        quitBtn.addActionListener(evt);
        if (isDebug) startBtn.addActionListener(evt);
	}

    public LinkedHashMap<String, JButton> getButtonMap() {
        return TitleButtonMap;
    }

    public ArrayList<JLabel> getPlayerElements() {
        return playerElements;
    }
    
}