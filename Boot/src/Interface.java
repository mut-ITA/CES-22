import java.awt.EventQueue;

import javax.naming.directory.SearchControls;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
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

import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;



public class Interface {

	private JFrame frmBootProject;
	private JTextField AddName;
	private JTextField AddUrl;
	private JTextField AddtextName1;
	private JTextField AddtextDescription1;
	private JTextField AddtextName2;
	private JTextField AddtextName3;
	private JTextField AddtextName4;
	private JTextField AddtextDescription2;
	private JTextField AddtextDescription3;
	private JTextField AddtextDescription4;
	private JLabel AddlblComments;
	private JTextArea AddtextAreaComment1;
	private JLabel AddlblName;
	private JLabel AddlblUrl;
	private JPanel Search;
	private JPanel Edit;
	private JTextField EditName;
	private JTextField EditUrl;
	private JLabel EditlblMetatag;
	private JTextField EdittxtName1;
	private JTextField EdittxtDescription1;
	private JTextField EdittxtName2;
	private JTextField EdittxtName3;
	private JTextField EdittxtName4;
	private JTextField EdittxtDescription2;
	private JTextField EdittxtDescription3;
	private JTextField EdittxtDescription4;
	private JLabel EditlblComments;
	private JTextArea EdittextAreaComment1;
	private JButton EditbtnPrevMetatag;
	private JButton EditbtnNextMetatag;
	private JButton EditbtnEdit;
	private JLabel EditlblName;
	private JLabel label_3;
	private JPanel View;
	private JLabel SearchlblTypetheKey;
	private JLabel lblSearchResults;
	private JButton btnAddMetatags;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

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
		frmBootProject.setTitle("Boot project\r\n");
		frmBootProject.setBounds(100, 100, 782, 496);
		frmBootProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		SearchlblTypetheKey.setBounds(12, 26, 376, 42);
		Search.add(SearchlblTypetheKey);
		
		View = new JPanel();
		SearchViewEdit.add(View, "name_338038723236807");
		View.setLayout(null);
		
		lblSearchResults = new JLabel("Search Results:");
		lblSearchResults.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSearchResults.setBounds(12, 35, 162, 31);
		View.add(lblSearchResults);
		
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
		
		EdittxtName1 = new JTextField();
		EdittxtName1.setText("         Name");
		EdittxtName1.setColumns(10);
		EdittxtName1.setBounds(12, 145, 116, 22);
		Edit.add(EdittxtName1);
		
		EdittxtDescription1 = new JTextField();
		EdittxtDescription1.setText("            Description");
		EdittxtDescription1.setColumns(10);
		EdittxtDescription1.setBounds(145, 145, 169, 22);
		Edit.add(EdittxtDescription1);
		
		EdittxtName2 = new JTextField();
		EdittxtName2.setText("         Name");
		EdittxtName2.setColumns(10);
		EdittxtName2.setBounds(12, 190, 116, 22);
		Edit.add(EdittxtName2);
		
		EdittxtName3 = new JTextField();
		EdittxtName3.setText("         Name");
		EdittxtName3.setColumns(10);
		EdittxtName3.setBounds(12, 235, 116, 22);
		Edit.add(EdittxtName3);
		
		EdittxtName4 = new JTextField();
		EdittxtName4.setText("         Name");
		EdittxtName4.setColumns(10);
		EdittxtName4.setBounds(12, 280, 116, 22);
		Edit.add(EdittxtName4);
		
		EdittxtDescription2 = new JTextField();
		EdittxtDescription2.setText("            Description");
		EdittxtDescription2.setColumns(10);
		EdittxtDescription2.setBounds(145, 190, 169, 22);
		Edit.add(EdittxtDescription2);
		
		EdittxtDescription3 = new JTextField();
		EdittxtDescription3.setText("            Description");
		EdittxtDescription3.setColumns(10);
		EdittxtDescription3.setBounds(145, 235, 169, 22);
		Edit.add(EdittxtDescription3);
		
		EdittxtDescription4 = new JTextField();
		EdittxtDescription4.setText("            Description");
		EdittxtDescription4.setColumns(10);
		EdittxtDescription4.setBounds(145, 280, 169, 22);
		Edit.add(EdittxtDescription4);
		
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
		
		EditbtnPrevMetatag = new JButton("Prev <<");
		EditbtnPrevMetatag.setBounds(12, 326, 97, 25);
		Edit.add(EditbtnPrevMetatag);
		
		EditbtnNextMetatag = new JButton("Next >>");
		EditbtnNextMetatag.setBounds(217, 326, 97, 25);
		Edit.add(EditbtnNextMetatag);
		
		EditbtnEdit = new JButton("Edit");
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
		
		JPanel Add = new JPanel();
		tabbedPane.addTab("Add", null, Add, null);
		Add.setLayout(null);
		
		AddName = new JTextField();
		AddName.setBounds(12, 55, 169, 22);
		Add.add(AddName);
		AddName.setColumns(10);
		
		AddUrl = new JTextField();
		AddUrl.setBounds(206, 55, 541, 22);
		Add.add(AddUrl);
		AddUrl.setColumns(10);
		
		JLabel AddlblMetatags = new JLabel("Meta-tags");
		AddlblMetatags.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		AddlblMetatags.setBounds(12, 103, 104, 29);
		Add.add(AddlblMetatags);
		
		AddtextName1 = new JTextField();
		AddtextName1.setText("         Name");
		AddtextName1.setBounds(12, 145, 116, 22);
		Add.add(AddtextName1);
		AddtextName1.setColumns(10);
		
		AddtextDescription1 = new JTextField();
		AddtextDescription1.setText("            Description");
		AddtextDescription1.setBounds(145, 145, 169, 22);
		Add.add(AddtextDescription1);
		AddtextDescription1.setColumns(10);
		
		AddtextName2 = new JTextField();
		AddtextName2.setText("         Name");
		AddtextName2.setColumns(10);
		AddtextName2.setBounds(12, 190, 116, 22);
		Add.add(AddtextName2);
		
		AddtextName3 = new JTextField();
		AddtextName3.setText("         Name");
		AddtextName3.setColumns(10);
		AddtextName3.setBounds(12, 235, 116, 22);
		Add.add(AddtextName3);
		
		AddtextName4 = new JTextField();
		AddtextName4.setText("         Name");
		AddtextName4.setColumns(10);
		AddtextName4.setBounds(12, 280, 116, 22);
		Add.add(AddtextName4);
		
		AddtextDescription2 = new JTextField();
		AddtextDescription2.setText("            Description");
		AddtextDescription2.setColumns(10);
		AddtextDescription2.setBounds(145, 190, 169, 22);
		Add.add(AddtextDescription2);
		
		AddtextDescription3 = new JTextField();
		AddtextDescription3.setText("            Description");
		AddtextDescription3.setColumns(10);
		AddtextDescription3.setBounds(145, 235, 169, 22);
		Add.add(AddtextDescription3);
		
		AddtextDescription4 = new JTextField();
		AddtextDescription4.setText("            Description");
		AddtextDescription4.setColumns(10);
		AddtextDescription4.setBounds(145, 280, 169, 22);
		Add.add(AddtextDescription4);
		
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
		
		btnAddMetatags = new JButton("Add Meta-tags");
		btnAddMetatags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAddMetatags.setBounds(72, 326, 157, 25);
		Add.add(btnAddMetatags);
	}
		//Creating button commands
		
	
		
	}


