package bS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class BohnenView extends JFrame{
    private JPanel newPanel;
	private JButton plusBtn;
    private JButton mulBtn;
	private JLabel textLabel;
    private JTextField textField1;
    private JTextField textField2;
    public String text = new String("0");


	protected BohnenView() {
		setTitle("Test");
		setSize(new Dimension(975, 566));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		add(titelPanel());

		pack();
		setVisible(true);
		toFront();
	}

	private JPanel titelPanel() {
		// Titelbildschirm erstellen
		newPanel = new JPanel();
		newPanel.setPreferredSize(new Dimension(500, 550));
		newPanel.setLayout(null);

		// Tasten erstellen
		plusBtn = new JButton("+");
		plusBtn.setBounds(130, 350, 100, 60);
		plusBtn.setFont(new Font("Arial", Font.BOLD, 26));
		plusBtn.setBackground(Color.lightGray);
		plusBtn.setOpaque(true);

        mulBtn = new JButton("x");
		mulBtn.setBounds(270, 350, 100, 60);
		mulBtn.setFont(new Font("Arial", Font.BOLD, 23));
		mulBtn.setBackground(Color.lightGray);
		mulBtn.setOpaque(true);

		// Legt ActionCommand fest
		plusBtn.setActionCommand("plusBtn");
        mulBtn.setActionCommand("mulBtn");

		textLabel = new JLabel(text, JLabel.CENTER);
        textLabel.setBounds(50, 120, 400, 60);
        textLabel.setFont(new Font( "Arial", Font.PLAIN, 30));

        textField1 = new JTextField();
        textField1.setBounds(120, 220, 260, 30);
        textField1.setText("0");

        textField2 = new JTextField();
        textField2.setBounds(120, 260, 260, 30);
        textField2.setText("0");

		// Schaltfläche zum Titel hinzufügen
		newPanel.add(plusBtn);
        newPanel.add(mulBtn);
		newPanel.add(textLabel);
        newPanel.add(textField1);
        newPanel.add(textField2);

   
		return newPanel;
	}
	protected JTextField getTextField1() {
		return textField1;
	}

	protected JTextField getTextField2() {
		return textField2;
	}

	protected JLabel getTextLabel() {
		return textLabel;
	}

	// actionListener für die Titelbildschirm
	protected void testlActionListener(ActionListener evt) {
		plusBtn.addActionListener(evt);
		mulBtn.addActionListener(evt);
	}
    
}
