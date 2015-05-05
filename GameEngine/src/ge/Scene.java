package ge;

public class Scene
{
	private static Scene _instance;
    public static Scene Instance()
    {
        if(_instance == null)
            _instance = new Scene();
        return _instance;
    }

	public void Load() 
	{
		GameObject test = new TestObject();
		test.Initialize();
		System.out.println("Scene Loaded...");
	}	
}
