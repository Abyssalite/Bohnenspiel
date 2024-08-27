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

/**
 * The view of the menu screen.
 **/

public class TitleScreen extends JFrame implements ICustomButton {
    private JPanel menuPanel;
    private LinkedHashMap<String, JButton> titleButtonMap;
	private JButton startBtn;
    private JButton debugBtn;
    private JButton quitBtn;

    private JLabel backgroundLabel;
    private ImageIcon imageIcon;

    /**
     * Constructor for the menu screen.
     **/
    
	public TitleScreen(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
        int width = (int) (size.getWidth() * 0.99);
        int height = (int) (size.getHeight() * 0.93);

		setTitle("BohnenSpiel v0.09");
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		add(titelPanel(width, height));

		pack();
		setVisible(true);
		toFront();
	}

    /**
     * The elements of the menu screen.
     * 
     * @param width - the width of the screen
     * @param height - the height of the screen
     **/
	
	private JPanel titelPanel(int width, int height){
		// Menu screen
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(width, height));
		menuPanel.setLayout(null);
		
		// Background picture
        backgroundLabel = new JLabel();
		imageIcon = new ImageIcon("Menu.png");
        backgroundLabel.setVerticalAlignment(1);
        backgroundLabel.setHorizontalAlignment(2);
		backgroundLabel.setIcon(imageIcon);
		backgroundLabel.setBounds(0, 0, width, height);

        // Create button
        titleButtonMap = new LinkedHashMap<String, JButton>();
        titleButtonMap.put("startBtn", startBtn = new JButton("Start"));
        titleButtonMap.put("debugBtn", debugBtn = new JButton("Debug"));
        titleButtonMap.put("quitBtn", quitBtn = new JButton("Quit"));
        
        //Button style
        for(Map.Entry<String, JButton> button : titleButtonMap.entrySet()){
            button.getValue().setFont(new Font("Arial", Font.BOLD, 50));
            button.getValue().setBackground(Color.BLACK);
            button.getValue().setForeground(Color.WHITE);
            button.getValue().setContentAreaFilled(false);
            button.getValue().setBorderPainted(false);
            button.getValue().setFocusPainted(false);
            button.getValue().setOpaque(false);

            // Override default mouse behavior for custom button
            button.getValue().addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    highlineButton(titleButtonMap, button.getKey(), "enter");
                }
                @Override
	            public void mouseExited(MouseEvent e){
                    highlineButton(titleButtonMap, button.getKey(), "exit");
	            }
                @Override
	            public void mousePressed(MouseEvent e){
                    highlineButton(titleButtonMap, button.getKey(), "pressed");
	            }
            });
            menuPanel.add(button.getValue());
        }
		startBtn.setBounds(197, 397, 347, 116);
		debugBtn.setBounds(198, 551, 347, 116);
		quitBtn.setBounds(199, 697, 347, 116);

		// Set ActionCommand
		startBtn.setActionCommand("startBtn");
        debugBtn.setActionCommand("debugBtn");
        quitBtn.setActionCommand("quitBtn");

        menuPanel.add(backgroundLabel);
   
		return menuPanel;
	}

	// actionListener for the menu
	public void titleActionListener(ActionListener evt){
		startBtn.addActionListener(evt);
		debugBtn.addActionListener(evt);
        quitBtn.addActionListener(evt);
	}
	
    protected LinkedHashMap<String, JButton> getButtonMap(){
        return titleButtonMap;
    }
    
}