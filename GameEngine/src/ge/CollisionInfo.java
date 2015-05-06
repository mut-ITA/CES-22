package ge;

import java.util.ArrayList;
import java.util.List;

public class CollisionInfo 
{
	public static List<Collider> AllColliders = new ArrayList<Collider>();
	
	private List<Collider> _colliders = new ArrayList<Collider>();
	
	private List<Collider> _collidingColliders = new ArrayList<Collider>();
	
	public void AddCollider(Collider component) 
	{
		_colliders.add(component);
	}
	
	public boolean IsColliding() 
	{
		for (Collider c : _colliders) 
		{
			if(!c.GetCollisions().isEmpty())
			{
				if(!_collidingColliders.contains(c)) _collidingColliders.add(c);
			}
			else if(_collidingColliders.contains(c)) _collidingColliders.remove(c);
		}
		
		if(!_collidingColliders.isEmpty()) return true;
		return false;
	}
	
	public List<GameObject> GameObject()
	{
		for (Collider cc : _collidingColliders) 
		{
			
		}
		return null;		
	}
	
	public List<Collider> Collider()
	{
		List<Collider> returnList = new ArrayList<Collider>();
		for (Collider cc : _collidingColliders) 
		{
			for (Object c : cc.GetCollisions()) 
			{
				returnList.add((Collider) c);					
			}
		}
		return returnList;		
	}
}
