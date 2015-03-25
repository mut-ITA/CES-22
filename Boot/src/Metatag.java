
public class Metatag 
{
	private String _name;
	public String GetName() { return _name; }
	
	private String _description;
	public String GetDescription() { return _description; }
	
	public Metatag(String name, String description)
	{
		_name = name;
		_description = description;
	}
	
	public void Log()
	{
		System.out.println("Name: " + _name + "  Description: " + _description);
	}
}
