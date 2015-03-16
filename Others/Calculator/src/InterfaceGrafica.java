import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;


public class InterfaceGrafica extends JFrame implements IUserInterface{

	JPanel[] Paineis = new JPanel[5]; //Criando os paines que terão os botoes. 1 - Input e output
									 //2 - 7 8 9 + -; 3 - 4 5 6 * /; 4 - 1 2 3 +- Raiz; 5 - 0 . =
	
	JButton[] Botoes = new JButton[19]; //Numero de butoes
	String[] NomedosButoes = { "7", "8", "9", "+", "C", "4", "5", "6", "-", "*", "1", "2", "3", "+-","V","/", ".","=","0"};
	JTextArea Visor = new JTextArea();	
	
	InterfaceGrafica (){
		super("Calculator");
		setDesign();
		setSize(380,250);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(5,5));
		
		
		
		//Criando os Paineis
		for(int i = 0; i < 5; i++)
			Paineis[i] = new JPanel();
		
		//Escolhendo o Layout de cada painel
		
		Paineis[0].setLayout(new FlowLayout(FlowLayout.CENTER));
		for(int i = 1; i < 5; i++)
			Paineis[i].setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
	
		//Inicializando os butões
		for(int i = 0; i < 19; i++) {
		    Botoes[i] = new JButton();
		    Botoes[i].setText(NomedosButoes[i]);
		    Botoes[i].setFont(new Font("Times new Roman", Font.BOLD, 14));
		    //Botoes[i].addActionListener(this);
		}
		
		//Ajustando o Visor
		Visor.setFont(new Font("Times new Roman", Font.BOLD, 14));
		Visor.setEditable(false);
		Visor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Visor.setPreferredSize(new Dimension(300, 35));
		
		//Ajustado os botoes
		for(int i = 0; i < 18; i++)
		    Botoes[i].setPreferredSize(new Dimension(45, 40));

		Botoes[18].setPreferredSize(new Dimension(90, 40));

		//Adicionando os botoes nos paineis
		Paineis[0].add(Visor);
		add(Paineis[0]);
		for(int i = 0; i <= 4; i++)
			Paineis[1].add(Botoes[i]);
			add(Paineis[1]);
		for(int i = 5; i <= 9; i++)
			Paineis[2].add(Botoes[i]);
			add(Paineis[2]);

		for(int i = 10; i <= 14; i++)
			Paineis[3].add(Botoes[i]);
			add(Paineis[3]);
		
		Paineis[4].add(Botoes[18]);	
		for(int i = 15; i <= 17; i++)
			Paineis[4].add(Botoes[i]);
			add(Paineis[4]);
			
		setVisible(true);
						
		



	}
	
	private String MeuInput(ActionEvent ae){
		 if (ae.getSource() == button[0]){
			 return "7";
			 }
		 if (ae.getSource() == button[1]){
			 return "8";
			 }
		 if (ae.getSource() == button[2]){
			 return "9";
			 }
		 if (ae.getSource() == button[3]){
			 return Operation.Sum;
			 }
		 if (ae.getSource() == button[4]){
			 return "7";
			 }
		 if (ae.getSource() == button[5]){
			 return "7";
			 }
		 if (ae.getSource() == button[6]){
			 return "7";
			 }
		 if (ae.getSource() == button[7]){
			 return "7";
			 }
		 if (ae.getSource() == button[8]){
			 return "7";
			 }
		 if (ae.getSource() == button[9]){
			 return "7";
			 }
			 	 		
	}
	
	public String Input(){
		return MeuInput;		
		
	}

	public final void setDesign() {
	    try {
	        UIManager.setLookAndFeel(
	                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	    } catch(Exception e) {   
	    }
	}


}

