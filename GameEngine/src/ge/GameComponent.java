package ge;

public abstract class GameComponent 
{
	protected Sprite Sprite;
	
	public GameComponent()
	{		
		GameEngine.Instance().AddGameComponent(this);
		System.out.println("New Game Component added");
	}
	
	protected void Destroy()
    {
        GameEngine.Instance().RemoveGameComponent(this);
    }
	
	public abstract void Update();
}
