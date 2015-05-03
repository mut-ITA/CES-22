package ge;

/**
 * Created by gustavo on 4/19/2015.
 */
public abstract class GameObject
{
    protected Transform transform;
    protected Sprite sprite;

    protected GameObject()
    {
        GameEngine.Instance().AddGameObject(this);
        transform = new Transform();
        sprite = new Sprite();
    }

    public abstract void Update();

    protected void Destroy()
    {
        GameEngine.Instance().RemoveGameObject(this);
    }
}
