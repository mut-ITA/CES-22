package ge;

public class CircleCollider extends Collider<CircleCollider> {

	private double _radius;
	
	public void SetRadius (double radius){
		if(radius < 0){
			_radius = 0;
		}
		else{
			_radius = radius;
		}
	}
	
	public double GetRadius (){
		return _radius;
	}
	
	@Override
	public boolean HasCollided(CircleCollider other) {
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

	public CircleCollider(Transform transform, double radius)
	{		
		SetRadius(radius);
		
		Init(transform);
	}
	
	public void Update()
	{
		_radius *= Math.max(GetTransform().Scale.x, GetTransform().Scale.y);
	}
}
