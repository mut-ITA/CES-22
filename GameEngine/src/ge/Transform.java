package ge;

/**
 * Created by gustavo on 4/19/2015.
 */
public class Transform
{
    public Vector2 Position; //Center of the transform    
    public Vector2 Scale;
    private double _angle;
    
    /**
     * Transform Unit per GameTick (GameEngine.MS_PER_UPDATE())
     */
    public Vector2 Velocity = new Vector2();
    
	/**
     * Angle in radians
     */
	public void SetAngle (double A){
		while(A > 2*Math.PI)
		{		
			A -= 2*Math.PI;
		}
		while(A < 0)
		{		
			A += 2*Math.PI;
		}
		
		_angle = A;
	}
	
	/**
     * Angle in radians between 0 and 2*pi
     */
	public double GetAngle()
	{
		return _angle;
	}

    public Transform()
    {
        Position = Vector2.Zero();
        _angle = 0;
        Scale = new Vector2(1, 1);
    }

    public Transform(Vector2 position)
    {
        this.Position = position;
        _angle = 0;
        Scale = new Vector2(1, 1);
    }

    public Transform(Vector2 position, double angle)
    {
        this.Position = position;
        SetAngle(angle);
        Scale = new Vector2(1, 1);
    }

    public Transform(Vector2 position, double angle, Vector2 scale)
    {
        Position = position;
        SetAngle(angle);
        Scale = scale;
    }
    
    public Transform(Vector2 position, double angle, Vector2 scale, Vector2 velocity)
    {
        Position = position;
        SetAngle(angle);
        Scale = scale;
        Velocity = velocity;
    }
    
    public static Transform Add(Transform a, Transform b)
    {    	
    	Vector2 position = Vector2.Add(a.Position, b.Position);
        double angle = a.GetAngle() + b.GetAngle();
        Vector2 scale = new Vector2(a.Scale.x * b.Scale.x, a.Scale.y * b.Scale.y);
        Vector2 velocity = Vector2.Add(a.Velocity, b.Velocity);
    	
    	return new Transform(position, angle, scale, velocity);
    }
    
    public void Update()
    {
    	Position.Add(Velocity);
    }
}
