package bS.BohnenView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The view for the name input window.
 **/

public class NameInput extends JDialog {
    private JPanel namePanel;
    private JButton okBtn;
    private JButton clrBtn;
    private JLabel textLabel;
    private JLabel player1;
    private JLabel player2;
    private JTextField textField1;
    private JTextField textField2;
 
    /**
     * Constructor for the name input window.
     **/

	public NameInput(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
        int width = (int) (size.getWidth() * 0.35);
        int height = (int) (size.getHeight() * 0.30);

		setTitle("Name Input");
		setPreferredSize(new Dimension(575, 375));
		setResizable(false);
		add(NameInputPanel());
		setLocation(width, height);
        setModal(true);
		pack();
	}
	
	/**
	 * The element for the name input window.
	 **/

	
	private JPanel NameInputPanel(){
		// Name input screen
		namePanel = new JPanel();
		namePanel.setPreferredSize(new Dimension(575, 375));
		namePanel.setLayout(null);

        // Create button
		okBtn = new JButton("Start");
		okBtn.setBounds(95, 250, 140, 50);
		okBtn.setFont(new Font("Arial", Font.BOLD, 26));
		okBtn.setBackground(Color.lightGray);
        okBtn.setFocusPainted(false);
        okBtn.setBorderPainted(false);
		okBtn.setOpaque(true);

        clrBtn = new JButton("Back");
		clrBtn.setBounds(320, 250, 140, 50);
		clrBtn.setFont(new Font("Arial", Font.BOLD, 26));
		clrBtn.setBackground(Color.lightGray);
        clrBtn.setFocusPainted(false);
        clrBtn.setBorderPainted(false);
		clrBtn.setOpaque(true);

        textLabel = new JLabel("Players Name", JLabel.CENTER);
        textLabel.setBounds(85, 20, 400, 60);
        textLabel.setFont(new Font( "Arial", Font.BOLD, 35));
        
        player1 = new JLabel("Blue Side", JLabel.CENTER);
        player1.setBounds(80, 105, 120, 40);
        player1.setFont(new Font( "Arial", Font.BOLD, 25));

        textField1 = new JTextField();
        textField1.setBounds(215, 105, 260, 40);
        textField1.setFont(new Font( "Arial", Font.PLAIN, 20));
        textField1.setText("Player 1");

        player2 = new JLabel("Red Side", JLabel.CENTER);
        player2.setBounds(80, 165, 120, 40);
        player2.setFont(new Font( "Arial", Font.BOLD, 25));

        textField2 = new JTextField();
        textField2.setBounds(215, 165, 260, 40);
        textField2.setFont(new Font( "Arial", Font.PLAIN, 20));
        textField2.setText("Player 2");

		okBtn.setActionCommand("okBtn");
        clrBtn.setActionCommand("clrBtn");

		namePanel.add(okBtn);
        namePanel.add(clrBtn);
        namePanel.add(textLabel);
        namePanel.add(textField1);
        namePanel.add(textField2);
        namePanel.add(player1);
        namePanel.add(player2);
		return namePanel;
	}

    public void nameActionListener(ActionListener evt){
		okBtn.addActionListener(evt);
		clrBtn.addActionListener(evt);
	}

    public String[] getPlayerName(){
        String[] playerName = {textField1.getText(), textField2.getText()};
        return playerName;
    }

}