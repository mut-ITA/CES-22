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
		
		return result;
	}
	
	public void Difference(String operator)
	{
		String thisOperator = "-";
		
		if(operator.equals("init"))
			operations.add(thisOperator);
		
		if(operator.equals(thisOperator))
			result =  keep - value;
	}
	
	private void Sum(String operator)
	{
		String thisOperator = "+";
		
		if(operator.equals("init"))
			operations.add(thisOperator);
		
		if(operator.equals(thisOperator))
			result =  keep + value;
	}
	
	private void Product(String operator)
	{
		String thisOperator = "x";
		
		if(operator.equals("init"))
			operations.add(thisOperator);
		
		if(operator.equals(thisOperator))
			result =  keep * value;
	}	
}
