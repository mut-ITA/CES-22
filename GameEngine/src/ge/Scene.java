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
		GameObject test1 = new TestObject();
		test1.Initialize();
		
		for (int i = 1; i < 5; i++) 
		{
			for (int j = 1; j < 2; j++) 
			{
				GameObject test2 = new TestObject2(new Vector2(i*GameEngine.WINDOW_WIDTH/5, j*GameEngine.WINDOW_HEIGHT/2));
				test2.Initialize();
			}
		}		
		
		System.out.println("Scene Loaded...");
	}	
}
