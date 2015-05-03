package ge;

/**
 * Created by gustavo on 4/19/2015.
 */
public class Transform
{
    public Vector2 position; //Center of the transform
    public double angle; // Angle in radians
    public Vector2 scale;

    public Transform()
    {
        position = Vector2.Zero();
        angle = 0;
        scale = new Vector2(1, 1);
    }

    public Transform(Vector2 position)
    {
        this.position = position;
        angle = 0;
        scale = new Vector2(1, 1);
    }

    public Transform(Vector2 position, double angle)
    {
        this.position = position;
        this.angle = angle;
        scale = new Vector2(1, 1);
    }

    public Transform(Vector2 position, double angle, Vector2 scale)
    {
        this.position = position;
        this.angle = angle;
        this.scale = scale;
    }
}
