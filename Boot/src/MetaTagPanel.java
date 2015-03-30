import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class MetaTagPanel extends JPanel{
	private JTextField textField1;
	private JTextField textField2;
	private Dimension PanelDimension;
	
	public MetaTagPanel (int count){
		setLayout(null);
		PanelDimension = new Dimension(50,50);
		textField1 = new JTextField();
		textField1.setBounds(12, 13, 96, 25);
		add(textField1);
		textField2 = new JTextField();
		textField2.setBounds(130, 13, 145, 25);
		add(textField2);
		setPreferredSize(PanelDimension);
		
	}
	public String GetNameTextField(){
		String batata = textField1.getText();
		return batata;
	}
	
	public String GetDescriptionTextField(){
		String batata = textField2.getText();
		return batata;
	}
	public void SetNameTextField(String Batata){
		textField1.setText(Batata);
	}
	public void SetDescriptionTextField(String Batata){
		textField2.setText(Batata);
	}
}
