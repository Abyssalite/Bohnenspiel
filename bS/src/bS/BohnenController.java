package bS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class BohnenController  implements ActionListener{

	private BohnenModel model;
	private BohnenView view;

	public BohnenController(BohnenModel model, BohnenView view) {

		this.model = model;
		this.view = view;

		// actionListener für die Titelbildschirm
		view.testlActionListener(this);
	}
	public void actionPerformed(ActionEvent evt) {

		String actionEvent = evt.getActionCommand();
        String a = new String(view.getTextField1().getText());
        String b = new String(view.getTextField2().getText());
        double n1 = 0;
        double n2 = 0;
        try {
            n1 = Double.parseDouble(a);
            n2 = Double.parseDouble(b);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(view, "Wuhttt??");
        }

        switch (actionEvent) {

            case "plusBtn":{
                double result = model.add(n1, n2);
                view.getTextLabel().setText(String.valueOf(result));
                 break; 
            }
                
            case "mulBtn":{
                double result = model.mul(n1, n2);
                view.getTextLabel().setText(String.valueOf(result));
                break; 
            }
        
            default:{
                break;
            }
                
        }
	
	}

    
}
