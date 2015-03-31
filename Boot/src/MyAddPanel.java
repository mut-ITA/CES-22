import java.awt.Dimension;
import java.awt.EventQueue;

import javax.naming.directory.SearchControls;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;


public class MyAddPanel extends JPanel {
	private JTextField AddName;
	private JTextField AddUrl;
	private JLabel AddlblComments;
	private JTextArea AddtextAreaComment1;
	private JLabel AddlblName;
	private JLabel AddlblUrl;private JButton btnAddMetatags;
	private JScrollPane scrollPane;
	private ArrayList<MetaTagPanel> rows;
	private static int count;
	public static ArrayList<JTextField> metaTagFields = new ArrayList<JTextField>();
	
	
	public MyAddPanel (){
	JPanel Add = new JPanel();
	Add.setLayout(null);
	
	final JScrollPane scrollPane_2 = new JScrollPane();
	scrollPane_2.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	scrollPane_2.setBounds(12, 145, 302, 157);
	Add.add(scrollPane_2);
	
	final JPanel panel = new JPanel();
	scrollPane_2.setViewportView(panel);
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
	
	AddName = new JTextField();
	AddName.setBounds(12, 55, 169, 22);
	Add.add(AddName);
    AddUrl = new JTextField();
	AddUrl.setBounds(206, 55, 541, 22);
	Add.add(AddUrl);
	AddUrl.setColumns(10);
	
	JLabel AddlblMetatags = new JLabel("Meta-tags");
	AddlblMetatags.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	AddlblMetatags.setBounds(12, 103, 104, 29);
	Add.add(AddlblMetatags);
	
	AddlblComments = new JLabel("Comments");
	AddlblComments.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	AddlblComments.setBounds(334, 103, 104, 29);
	Add.add(AddlblComments);
	
	scrollPane = new JScrollPane();
	scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	scrollPane.setBounds(326, 145, 413, 157);
	Add.add(scrollPane);
	
	AddtextAreaComment1 = new JTextArea();
	AddtextAreaComment1.setWrapStyleWord(true);
	scrollPane.setViewportView(AddtextAreaComment1);
	AddtextAreaComment1.setLineWrap(true);
	
	JButton AddbtnAdd = new JButton("Add Hyperlink");
	AddbtnAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {}
		
	});
	AddbtnAdd.setBounds(609, 371, 138, 35);
	Add.add(AddbtnAdd);
	
	AddlblName = new JLabel("Name");
	AddlblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	AddlblName.setBounds(12, 13, 104, 29);
	Add.add(AddlblName);
	
	AddlblUrl = new JLabel("Url");
	AddlblUrl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	AddlblUrl.setBounds(206, 13, 104, 29);
	Add.add(AddlblUrl);
	

	rows = new ArrayList<MetaTagPanel>(1);
	btnAddMetatags = new JButton("Add Meta-tags");
	count = 0;
	btnAddMetatags.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int i;
			if (count >= 1){
			if (rows.get(count - 1).GetNameTextField().equals(""));
			else{
			MetaTagPanel row = new MetaTagPanel(count);
			rows.add(row);
			panel.add(row);
			i = 30*count;
			row.setBounds(0, i, 276, 30);
			scrollPane_2.repaint();
			scrollPane_2.revalidate();	
			count++;
			}
			}
			else{
				MetaTagPanel row = new MetaTagPanel(count);
				rows.add(row);
				panel.add(row);
				i = 30*count;
				row.setBounds(0, i, 276, 30);
				scrollPane_2.repaint();
				scrollPane_2.revalidate();
				count++;
				
			}
			
		}
	});
	btnAddMetatags.setBounds(72, 326, 157, 25);
	Add.add(btnAddMetatags);
}
}


