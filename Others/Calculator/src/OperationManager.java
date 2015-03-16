import java.util.ArrayList;
import java.util.List;


public class OperationManager {	
	
	private double keep;
	private double value;
	private double result;
	public List<String> operations = new ArrayList<String>();
	
	OperationManager()
	{
		Operate(0, 0, "init");
	}
	
	public double Operate(double keep, double value, String operator)
	{
		this.keep = keep;
		this.value = value;
		
		Sum(operator);
		Difference(operator);
		Product(operator);
		Quocient(operator);
		
		return result;
	}
	
	public void Difference(String operator)
	{
		String thisOperator = Operations.Difference;
		
		if(operator.equals("init"))
			operations.add(thisOperator);
		
		if(operator.equals(thisOperator))
			result =  keep - value;
	}
	
	private void Sum(String operator)
	{
		String thisOperator = Operations.Sum;
		
		if(operator.equals("init"))
			operations.add(thisOperator);
		
		if(operator.equals(thisOperator))
			result =  keep + value;
	}
	
	private void Product(String operator)
	{
		String thisOperator = Operations.Product;
		
		if(operator.equals("init"))
			operations.add(thisOperator);
		
		if(operator.equals(thisOperator))
			result =  keep * value;
	}	
	
	private void Quocient(String operator)
	{
		String thisOperator = Operations.Quocient;
		
		if(operator.equals("init"))
			operations.add(thisOperator);
		
		if(operator.equals(thisOperator))
			result =  keep / value;
	}	
}
