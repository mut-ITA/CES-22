package ge;

public class CircleCollider extends Collider<CircleCollider> 
{

	private double _radius;
	private double _baseRadius;
	
	public void SetRadius (double radius)
	{
		if(radius < 0){
			_baseRadius = 0;
		}
		else{
			_baseRadius = radius;
		}
	}
	
	public double GetRadius ()
	{
		return _radius;
	}
	
	@Override
	public boolean HasCollided(CircleCollider other) 
	{
		//If the distance of the center is greater than the sum of the radius, they don't collide
		
		if(Vector2.Subtract(GetCenter(), other.GetCenter()).Length() > (GetRadius() + other.GetRadius()))
		{			
			return false;
		}
		else 
		{
			return true;
		}
	}

	public CircleCollider(double radius)
	{		
		SetRadius(radius);
	}
	
	@Override
	public void Update()
	{	_radius = _baseRadius * Math.max(AbsoluteTransform.Scale.x, AbsoluteTransform.Scale.y);
		super.Update();		
	}
}
