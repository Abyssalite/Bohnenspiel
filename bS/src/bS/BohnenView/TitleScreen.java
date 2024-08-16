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

import java.util.LinkedHashMap;
import java.util.Map;

public class TitleScreen extends JFrame implements ICustomButton{
    private JPanel menuPanel;
    private LinkedHashMap<String, JButton> TitleButtonMap;
	private JButton startBtn;
    private JButton debugBtn;
    private JButton quitBtn;

    private JLabel backgroundLabel;
    private ImageIcon imageIcon;
    private TitleScreen view;

	public TitleScreen() {
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

        view = this;
	}

	private JPanel titelPanel(int width, int height)  {
		// Titelbildschirm erstellen
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(width, height));
		menuPanel.setLayout(null);

        backgroundLabel = new JLabel();
		imageIcon = new ImageIcon("Menu.png");
        backgroundLabel.setVerticalAlignment(1);
        backgroundLabel.setHorizontalAlignment(2);
		backgroundLabel.setIcon(imageIcon);
		backgroundLabel.setBounds(0, 0, width, height);

        // Tasten erstellen
        TitleButtonMap = new LinkedHashMap<String, JButton>();
        TitleButtonMap.put("startBtn", startBtn = new JButton("Start"));
        TitleButtonMap.put("debugBtn", debugBtn = new JButton("Debug"));
        TitleButtonMap.put("quitBtn", quitBtn = new JButton("Quit"));

        for(Map.Entry<String, JButton> button : TitleButtonMap.entrySet()) {
            button.getValue().setFont(new Font("Arial", Font.BOLD, 50));
            button.getValue().setBackground(Color.BLACK);
            button.getValue().setForeground(Color.WHITE);
            button.getValue().setContentAreaFilled(false);
            button.getValue().setBorderPainted(false);
            button.getValue().setFocusPainted(false);
            button.getValue().setOpaque(false);
        }
		startBtn.setBounds(301, 421, 303, 102);
		debugBtn.setBounds(301, 554, 303, 102);
		quitBtn.setBounds(301, 684, 303, 102);

		// Set ActionCommand
		startBtn.setActionCommand("startBtn");
        debugBtn.setActionCommand("debugBtn");
        quitBtn.setActionCommand("quitBtn");

        for(Map.Entry<String, JButton> button : TitleButtonMap.entrySet()) {
            button.getValue().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    highlineButton(view, button.getKey(), "enter");
                }
                @Override
	            public void mouseExited(MouseEvent e) {
                    highlineButton(view, button.getKey(), "exit");
	            }
                @Override
	            public void mousePressed(MouseEvent e) {
                    highlineButton(view, button.getKey(), "pressed");
	            }
            });
        }

		menuPanel.add(startBtn);
        menuPanel.add(debugBtn);
        menuPanel.add(quitBtn);
        menuPanel.add(backgroundLabel);
   
		return menuPanel;
	}

	// actionListener für die Titelbildschirm
	public void titleActionListener(ActionListener evt) {
		startBtn.addActionListener(evt);
		debugBtn.addActionListener(evt);
        quitBtn.addActionListener(evt);
	}

    protected LinkedHashMap<String, JButton> getButtonMap() {
        return TitleButtonMap;
    }
    
}