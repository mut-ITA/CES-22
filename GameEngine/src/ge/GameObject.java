package ge;

/**
 * Created by gustavo on 4/19/2015.
 */
public abstract class GameObject extends GameComponent
{
    //TODO: Add list of components
	protected Transform Transform;
    protected Sprite Sprite;
    protected Collider<?> Collider;

    public abstract void Update();
    
    public abstract void Initialize();
    
}
