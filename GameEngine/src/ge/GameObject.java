package ge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gustavo on 4/19/2015.
 */
public abstract class GameObject extends GameComponent
{
    //TODO: Add list of components
	//protected Transform Transform;   
	
	CollisionInfo collisionInfo = new CollisionInfo();
    
    GameObject()
    {
    	GameEngine.Instance().AddGameObject(this);
    }
    
    public void Destroy()
    {
    	Iterator<GameComponent> it = Components.iterator();
    	while (it.hasNext()) 
    	{
    		GameComponent gc = it.next();
    		it.remove();
    		gc.Destroy();    	 
    	}
    		
    	GameEngine.Instance().RemoveGameObject(this);
    }
    
    private List<GameComponent> Components = new ArrayList<GameComponent>(); 
    
    public <T extends GameComponent> void AddComponent(T component)
    {
    	Components.add(component);
    	component.SetParent(this);
    	Debug.Write("Added a new component: " + component.getClass());
    	if(component instanceof ge.Collider)
    	{
    		collisionInfo.AddCollider((ge.Collider) component);
    	}
    }
    
    public <T extends GameComponent> void RemoveComponent(T component)
    {
    	Debug.Write("Removed a  component: " + component.getClass());
    	Components.remove(component);
    }
    
    public <T extends GameComponent> T GetComponentByClass(Class<T> ComponentClass)
    {
    	for(GameComponent gc : Components)
    	{
    		if(gc.getClass() == ComponentClass)
    			return (T) gc;
    	}
    	return null;
    }
    
    public <T extends GameComponent> T GetComponentByName(String ComponentName)
    {
    	for(GameComponent gc : Components)
    	{
    		if(gc.Name == ComponentName)
    			return (T) gc;
    	}
    	return null;
    }
    
    public <T extends GameComponent> List<T> GetComponentsByClass(Class<T> ComponentClass)
    {
    	List<T> returnComponents = new ArrayList<T>();
    	
    	for(GameComponent gc : Components)
    	{
    		if(gc.getClass() == ComponentClass)
    			returnComponents.add((T) gc);
    	}
    	return returnComponents;
    }    

    public void BaseUpdate()
    {
    	super.BaseUpdate();
    	for(GameComponent gc : Components)
    	{
    		gc.BaseUpdate();
    	}
    	
    	CollisionUpdate(); 	
    }
    
    public void CollisionUpdate()
    {
    	if(collisionInfo.IsColliding()) OnCollision(collisionInfo);
    }
    
    public abstract void OnCollision(CollisionInfo collisionInfo);
    
    public abstract void Update();
    
    public abstract void Initialize();
    
}
