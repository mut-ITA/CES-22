
public class Main 
{		
	public static void main(String[] args)
	{		
		IUserInterface userInterface = new InterfaceGrafica();		
		ICalculator calculator = new Calculator();
		
		for(String input = userInterface.Input(); !input.equals("exit"); input = userInterface.Input())
		{
			calculator.Input(input);			
			userInterface.Output(calculator.Output());	
		};		
		
		System.out.print("Exiting...");
	}

}
