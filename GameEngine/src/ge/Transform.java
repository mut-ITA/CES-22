package ge;

/**
 * Created by gustavo on 4/19/2015.
 */
public class Transform extends GameComponent
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

    public Transform(Vector2 Position)
    {
        this.Position = Position;
        _angle = 0;
        Scale = new Vector2(1, 1);
    }

    public Transform(Vector2 Position, double Angle)
    {
        this.Position = Position;
        SetAngle(Angle);
        Scale = new Vector2(1, 1);
    }

    public Transform(Vector2 Position, double Angle, Vector2 Scale)
    {
        this.Position = Position;
        SetAngle(Angle);
        this.Scale = Scale;
    }
    
    public void Update()
    {
    	Position.Add(Velocity);
    }
}
