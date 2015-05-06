package ge;

import java.util.ArrayList;
import java.util.List;


public abstract class Collider<T extends Collider<?>> extends GameComponent implements Runnable
{
	public boolean isColliding;
	
	private List<Collider> Collisions = new ArrayList<Collider>();
	public List<Collider> GetCollisions()
	{
		return Collisions;
	}
	
	Collider()
	{
		CollisionInfo.AllColliders.add(this);
		thisThread = new Thread(this);
	}
	
	public Vector2 GetCenter ()
	{
		return AbsoluteTransform.Position;
	}
		
	protected abstract boolean HasCollided(T Other);
	
	Thread thisThread;
	public void Update()
	{
		//if(!thisThread.isAlive()) thisThread.start();
		Collisions = new ArrayList<Collider>();
		for (Collider c : CollisionInfo.AllColliders) 
		{
			if(this.equals(c)) continue;
				
			if(HasCollided((T) c))
			{
				if(!Collisions.contains(c)) Collisions.add(c);
			}
			else if(Collisions.contains(c)) Collisions.remove(c);
		}
	}
	
	@Override
	public void Destroy() 
	{
		CollisionInfo.AllColliders.remove(this);
		super.Destroy();
	}
	
	public void run ()
	{
		while(true)
		{
				
		}
			
		
	}
}
