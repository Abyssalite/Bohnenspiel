package bS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BohnenView extends JFrame implements ICustomButton{
    private JPanel menuPanel;
    private LinkedHashMap<String, JButton> menuButtonMap;
	private JButton startBtn;
    private JButton debugBtn;
    private JButton quitBtn;

    private JLabel backgroundLabel;
    private ImageIcon imageIcon;
    private BohnenView view;

	protected BohnenView() {
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
        menuButtonMap = new LinkedHashMap<String, JButton>();
        menuButtonMap.put("startBtn", startBtn = new JButton("Start"));
        menuButtonMap.put("debugBtn", debugBtn = new JButton("Debug"));
        menuButtonMap.put("quitBtn", quitBtn = new JButton("Quit"));


		// Titelbildschirm erstellen
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(width, height));
		menuPanel.setLayout(null);

        backgroundLabel = new JLabel();
		imageIcon = new ImageIcon("Menu.png");
		backgroundLabel.setIcon(imageIcon);
		backgroundLabel.setBounds(0, 0, width, height);


		// Tasten erstellen
        for(Map.Entry<String, JButton> entry : menuButtonMap.entrySet()){
            entry.getValue().setFont(new Font("Arial", Font.BOLD, 50));
            entry.getValue().setBackground(Color.BLACK);
            entry.getValue().setForeground(Color.WHITE);
            entry.getValue().setContentAreaFilled(false);
            entry.getValue().setBorderPainted(false);
            entry.getValue().setFocusPainted(false);
            entry.getValue().setOpaque(false);
        }
		startBtn.setBounds(301, 384, 303, 102);
		debugBtn.setBounds(301, 517, 303, 102);
		quitBtn.setBounds(301, 647, 303, 102);

		// Set ActionCommand
		startBtn.setActionCommand("startBtn");
        debugBtn.setActionCommand("debugBtn");
        quitBtn.setActionCommand("quitBtn");

        for(Map.Entry<String, JButton> entry : menuButtonMap.entrySet()){
            entry.getValue().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    highlineButton(view, entry.getKey(), "enter");
                }
                @Override
	            public void mouseExited(MouseEvent e) {
                    highlineButton(view, entry.getKey(), "exit");
	            }
                @Override
	            public void mousePressed(MouseEvent e) {
                    highlineButton(view, entry.getKey(), "pressed");
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
	protected void menuActionListener(ActionListener evt) {
		startBtn.addActionListener(evt);
		debugBtn.addActionListener(evt);
        quitBtn.addActionListener(evt);
	}

    public LinkedHashMap<String, JButton> getButtonMap(){
        return menuButtonMap;
        
    }
    
}
