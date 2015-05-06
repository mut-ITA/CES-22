package ge;

public abstract class GameComponent 
{				
	public String Name;
	
	private GameComponent Parent = null;
	
	public void SetParent(GameComponent parent)
	{
		Parent = parent;
	}
	
	public boolean HasParent()
	{
		return Parent != null;
		
	}
	
	public Transform Transform =  new Transform();
	public Transform AbsoluteTransform =  new Transform();
	
	public GameComponent()
	{	
	}
	
	GameComponent(Transform transform)
	{
		Transform = transform;
	}
	
	public void BaseUpdate()
	{	
		if(HasParent())
			AbsoluteTransform = ge.Transform.Add(Transform, Parent.AbsoluteTransform);
		else
			AbsoluteTransform = Transform;
		Transform.Update();
		Update();
	}
	
	public abstract void Update();

	public void Destroy() 
	{		
		Debug.Write(this.getClass().toString() + " Destroyed");
	}
}


