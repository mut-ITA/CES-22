import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class Calculator implements ICalculator
{
	private double value;
	private double keep;
	private String operation;
	private String errorMessage = "";
	
	private List<String> digits = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
	
	private OperationManager operationManager = new OperationManager();
		
	public void Input(String input)
	{
		errorMessage = "";
		
		if(digits.contains(input))
		{
			Digit(Double.parseDouble(input));
		}
		else if(operationManager.operations.contains(input))
		{			
			if(operation != null) value = operationManager.Operate(keep, value, operation);
			keep = value;
			value = 0;
			operation = input;			
		}
		else if (input.equals(Operations.Equals))
		{
			value = operationManager.Operate(keep, value, operation);
			keep = 0;
		}
		else if (input.equals(Operations.Dot))
		{
			operation = Operations.Dot;
		}
		else if (input.equals(Operations.Clear))
		{
			value = 0;
			keep = 0;
			operation = "";			
		}
		else
		{
			errorMessage = "Invalid input";
		}
	}
	
	public String Output()
	{
		if(!errorMessage.equals("")) return errorMessage;
		
		return String.valueOf(value);
	}
	
	private void Digit(double digit)
	{
		value = 10 * value + digit;
	}
}
