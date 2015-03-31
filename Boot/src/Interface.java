import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.List;

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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class Interface {

	private JFrame frmBootProject;
	private JTextField AddName;
	private JTextField AddUrl;
	private JLabel AddlblComments;
	private JTextArea AddtextAreaComment1;
	private JLabel AddlblName;
	private JLabel AddlblUrl;
	private JPanel Search;
	private JPanel Edit;
	private JTextField EditName;
	private JTextField EditUrl;
	private JLabel EditlblMetatag;
	private JLabel EditlblComments;
	private JTextArea EdittextAreaComment1;
	private JButton EditbtnEdit;
	private JLabel EditlblName;
	private JLabel label_3;
	private JPanel View;
	private JLabel SearchlblTypetheKey;
	private JLabel lblSearchResults;
	private JButton btnAddMetatags;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private ArrayList<MetaTagPanel> rows;
	private ArrayList<MetaTagPanel> Editrows;
	private static int count;
	public static ArrayList<JTextField> metaTagFields = new ArrayList<JTextField>();
	private JTextField textField;
	private JButton btnNewButton;
	private static String temp; 
	private static int countEdit;
	private static int countView;
	private ArrayList<ViewPanel> Viewrow;
	private JPanel panel_1;
	private JScrollPane scrollPane_3;
	private JButton btnBackToSearch;
	public static Hyperlink Searched;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmBootProject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBootProject = new JFrame();
		frmBootProject.setResizable(false);
		frmBootProject.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ManagerLocator.GetManager().Save();
				frmBootProject.dispose();
				System.exit(0);
			}
		});
		frmBootProject.setTitle("Boot project\r\n");
		frmBootProject.setBounds(100, 100, 782, 496);
		frmBootProject.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmBootProject.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		final JPanel SearchViewEdit = new JPanel();
		SearchViewEdit.setToolTipText("Search");
		tabbedPane.addTab("Search", null, SearchViewEdit, null);
		SearchViewEdit.setLayout(new CardLayout(0, 0));
		
		Search = new JPanel();
		SearchViewEdit.add(Search, "name_335780639983597");
		Search.setLayout(null);
		
		SearchlblTypetheKey = new JLabel("Type the key words you want to search for: ");
		SearchlblTypetheKey.setFont(new Font("Times New Roman", Font.BOLD, 17));
		SearchlblTypetheKey.setBounds(220, 68, 318, 42);
		Search.add(SearchlblTypetheKey);
		
		textField = new JTextField();
		textField.setBounds(53, 144, 653, 31);
		Search.add(textField);
		textField.setColumns(10);
		
	
		View = new JPanel();
		SearchViewEdit.add(View, "name_338038723236807");
		View.setLayout(null);
		
		lblSearchResults = new JLabel("Search Results:");
		lblSearchResults.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSearchResults.setBounds(320, 24, 118, 31);
		View.add(lblSearchResults);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_3.setBounds(180, 90, 400, 200);
		View.add(scrollPane_3);
		
		panel_1 = new JPanel();
		scrollPane_3.setViewportView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		btnBackToSearch = new JButton("Back to Search");
		btnBackToSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(countView != 0){
				for (int k = countView - 1; k >= 0; k--) {
					panel_1.remove(Viewrow.get(k));
					Viewrow.remove(k);
					
				}				
				}
				SearchViewEdit.remove(View);
				SearchViewEdit.remove(Edit);
				SearchViewEdit.add(Search);
				countView = 0;
				
			}
		});
		btnBackToSearch.setBounds(298, 318, 162, 25);
		View.add(btnBackToSearch);
		
		Edit = new JPanel();
		Edit.setLayout(null);
		SearchViewEdit.add(Edit, "name_336673368358098");
		
		EditName = new JTextField();
		EditName.setColumns(10);
		EditName.setBounds(12, 55, 169, 22);
		Edit.add(EditName);
		
		EditUrl = new JTextField();
		EditUrl.setColumns(10);
		EditUrl.setBounds(206, 55, 541, 22);
		Edit.add(EditUrl);
		
		EditlblMetatag = new JLabel("Meta-tags");
		EditlblMetatag.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		EditlblMetatag.setBounds(12, 103, 104, 29);
		Edit.add(EditlblMetatag);
		
		final JScrollPane EditscrollPane_2 = new JScrollPane();
		EditscrollPane_2.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		EditscrollPane_2.setBounds(12, 145, 302, 157);
		Edit.add(EditscrollPane_2);
		
		final JPanel editpanel = new JPanel();
		EditscrollPane_2.setViewportView(editpanel);
		editpanel.setLayout(new BoxLayout(editpanel, BoxLayout.Y_AXIS));	
		
		Editrows = new ArrayList<MetaTagPanel>();
		countEdit = 0;
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!textField.getText().equals("")){
				temp = textField.getText();
				textField.setText(null);
				Viewrow = new ArrayList<ViewPanel>();
				countView = 0;
				for(final Hyperlink h : ManagerLocator.GetManager().Search(temp))
				{
					int ji = 0;
					ViewPanel row = new ViewPanel(h.GetName());
					Viewrow.add(row);
					Viewrow.get(countView).getEditButton().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							EditName.setText(h.GetName());
							EditUrl.setText(h.GetUrl());
							EdittextAreaComment1.setText(h.GetComments());
							for (int j = 0; j < h.GetMetatags().size(); j++) {
								int i = 0;
								if (countEdit >= 1){
										MetaTagPanel row = new MetaTagPanel(countEdit);
										row.SetNameTextField(h.GetMetatags().get(j).GetName());
										row.SetDescriptionTextField(h.GetMetatags().get(j).GetDescription());
										Editrows.add(row);
										editpanel.add(row);
										i = 30*countEdit;
										row.setBounds(0, i, 276, 30);
										EditscrollPane_2.repaint();
										EditscrollPane_2.revalidate();	
										countEdit++;
									}
								else{
									MetaTagPanel row = new MetaTagPanel(countEdit);
									row.SetNameTextField(h.GetMetatags().get(j).GetName());
									row.SetDescriptionTextField(h.GetMetatags().get(j).GetDescription());
									Editrows.add(row);
									editpanel.add(row);
									i = 30*countEdit;
									row.setBounds(0, i, 276, 30);
									EditscrollPane_2.repaint();
									EditscrollPane_2.revalidate();
									countEdit++;
									
									}
							}
									SearchViewEdit.remove(View);
									SearchViewEdit.remove(Search);
									SearchViewEdit.add(Edit);
									Searched = h;
						}
					});
					panel_1.add(row);
					ji = 50*countView;
					row.setBounds(0, ji, 500, 50);
					scrollPane_3.repaint();
					scrollPane_3.revalidate();	
					countView++;
				}
				//}
				SearchViewEdit.remove(Search);
				SearchViewEdit.remove(Edit);
				SearchViewEdit.add(View);
			}
		});
		btnSearch.setBounds(314, 217, 130, 42);
		Search.add(btnSearch);
		
		
		btnAddMetatags = new JButton("Add Meta-tags");
		btnAddMetatags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				if (countEdit >= 1){
				if (Editrows.get(countEdit - 1).GetNameTextField().equals(""));
				else{
				MetaTagPanel row = new MetaTagPanel(countEdit);
				Editrows.add(row);
				editpanel.add(row);
				i = 30*countEdit;
				row.setBounds(0, i, 276, 30);
				EditscrollPane_2.repaint();
				EditscrollPane_2.revalidate();	
				countEdit++;
				}
				}
				else{
					MetaTagPanel row = new MetaTagPanel(countEdit);
					Editrows.add(row);
					editpanel.add(row);
					i = 30*countEdit;
					row.setBounds(0, i, 276, 30);
					EditscrollPane_2.repaint();
					EditscrollPane_2.revalidate();
					countEdit++;
					
				}
				
			}
		});
		
		btnAddMetatags.setBounds(72, 326, 157, 25);
		Edit.add(btnAddMetatags);
		
		EditlblComments = new JLabel("Comments");
		EditlblComments.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		EditlblComments.setBounds(334, 103, 104, 29);
		Edit.add(EditlblComments);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_1.setBounds(334, 145, 413, 157);
		Edit.add(scrollPane_1);
		
		EdittextAreaComment1 = new JTextArea();
		EdittextAreaComment1.setWrapStyleWord(true);
		scrollPane_1.setViewportView(EdittextAreaComment1);
		
		EditbtnEdit = new JButton("Edit");
		EditbtnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Metatag> HyperLinkMetaTag = new ArrayList<Metatag>();
				for (int k = countEdit - 1; k >= 0; k--) {
					Metatag temp = new Metatag(Editrows.get(k).GetNameTextField(),Editrows.get(k).GetDescriptionTextField());
					HyperLinkMetaTag.add(temp);
					editpanel.remove(Editrows.get(k));
					Editrows.remove(k);
					
				}
				Hyperlink HyperLinkAdded = new Hyperlink(EditName.getText(),EditUrl.getText(),HyperLinkMetaTag,EdittextAreaComment1.getText());
				ManagerLocator.GetManager().Edit(Searched, HyperLinkAdded);
				EditName.setText(null);
				EditUrl.setText(null);
				EdittextAreaComment1.setText(null);
				EditscrollPane_2.repaint();
				EditscrollPane_2.revalidate();
				countEdit = 0;
				if(countView != 0){
					for (int k = countView - 1; k >= 0; k--) {
						panel_1.remove(Viewrow.get(k));
						Viewrow.remove(k);
						
					}				
				}
				countView = 0;
				SearchViewEdit.remove(View);
				SearchViewEdit.remove(Edit);
				SearchViewEdit.add(Search);
			}
				
		});
		EditbtnEdit.setBounds(609, 371, 138, 35);
		Edit.add(EditbtnEdit);
		
		EditlblName = new JLabel("Name");
		EditlblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		EditlblName.setBounds(12, 13, 104, 29);
		Edit.add(EditlblName);
		
		label_3 = new JLabel("Url");
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		label_3.setBounds(206, 13, 104, 29);
		Edit.add(label_3);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int k = countEdit - 1; k >= 0; k--) {
					editpanel.remove(Editrows.get(k));
					Editrows.remove(k);
					
				}
				ManagerLocator.GetManager().RemoveByName(Searched.GetName());
				EditName.setText(null);
				EditUrl.setText(null);
				EdittextAreaComment1.setText(null);
				EditscrollPane_2.repaint();
				EditscrollPane_2.revalidate();
				countEdit = 0;
				if(countView != 0){
					for (int k = countView - 1; k >= 0; k--) {
						panel_1.remove(Viewrow.get(k));
						Viewrow.remove(k);
						
					}				
				}
				countView = 0;
				SearchViewEdit.remove(View);
				SearchViewEdit.remove(Edit);
				SearchViewEdit.add(Search);
				
			}
		});
		btnRemove.setBounds(12, 371, 138, 35);
		Edit.add(btnRemove);
		
		JPanel Add = new MyAddPanel();
		tabbedPane.addTab("Add", null, Add, null);
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
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Metatag> HyperLinkMetaTag = new ArrayList<Metatag>();
				for (int k = count - 1; k >= 0; k--) {
					Metatag temp = new Metatag(rows.get(k).GetNameTextField(),rows.get(k).GetDescriptionTextField());
					HyperLinkMetaTag.add(temp);
					panel.remove(rows.get(k));
					rows.remove(k);
					
				}
				Hyperlink HyperLinkAdded = new Hyperlink(AddName.getText(),AddUrl.getText(),HyperLinkMetaTag,AddtextAreaComment1.getText());
				ManagerLocator.GetManager().Add(HyperLinkAdded);
				AddName.setText(null);
				AddUrl.setText(null);
				AddtextAreaComment1.setText(null);
				scrollPane_2.repaint();
				scrollPane_2.revalidate();
				count = 0;				
				
			}
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
		

		rows = new ArrayList<MetaTagPanel>();
		btnAddMetatags = new JButton("Add Meta-tags");
		count = 0;
		btnAddMetatags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
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
	
