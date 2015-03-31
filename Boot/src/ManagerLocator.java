
public class ManagerLocator 
{	
	public static IManager GetManager()
	{
		return XmlManager.GetInstance();
	}
}
