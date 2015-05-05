package ge;


public abstract class Collider<T extends Collider<?>> extends GameComponent 
{

	private Transform _transform;
	
	protected Transform GetTransform()
	{
		return _transform;
	}
	
	public Vector2 GetCenter (){
		return _transform.Position;
	}
		
	public abstract boolean HasCollided(T Other);
	
	public void Init(Transform transform)
	{		
		_transform = transform;
		ColliderThread.Instance().AddList(this);
	}
	
	public abstract void Update();
}
