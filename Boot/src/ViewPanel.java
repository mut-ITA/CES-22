import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ViewPanel extends JPanel {
	private JLabel HyperlinkName;
	private JButton GoToEdit;
	private Hyperlink Edited;
	private Dimension PanelDimension;
	
	public ViewPanel(final String Name){
		setLayout(null);
		PanelDimension = new Dimension(100,50);
		HyperlinkName = new JLabel(Name);
		HyperlinkName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		HyperlinkName.setBounds(12, 13, 220, 42);
		add(HyperlinkName);
		GoToEdit = new JButton("View/Edit");
		GoToEdit.setBounds(225, 24, 100, 20);
		add(GoToEdit);
		setPreferredSize(PanelDimension);
		
	}
	 public JButton getEditButton()
	    {
	       return GoToEdit;
	    }
}
