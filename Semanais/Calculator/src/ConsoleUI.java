import java.util.Scanner;

public class ConsoleUI implements IUserInterface
{
	private Scanner scanner;
	ConsoleUI()
	{
		scanner = new Scanner(System.in);
	}
	
	public String Input()
	{
		return scanner.next();
	}
	
	public void Output(String output)
	{
		System.out.println(output);
	}
	
}
