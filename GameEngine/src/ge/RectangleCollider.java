package ge;

public class RectangleCollider extends Collider<RectangleCollider>{

	private double _height;
	private double _width;
	private double _angle;
	
	public RectangleCollider(Transform transform, double height, double width)
	{		
		SetHeight(height);
		
		SetWidth(width);
		
		_angle = transform.GetAngle();
		
		Init(transform);
	}
	
	public void SetHeight (double H)
	{
		if(H < 0){
			_height = 0;
		}
		else {
			_height = H;
		}
	}	
	public double GetHeight()
	{
		return _height;
	}
	
	public void SetWidth (double W)
	{
		if(W < 0){
			_width = 0;
		}
		else {
			_width = W;
		}
	}	
	public double GetWidth()
	{
		return _width;
	}
	
	/**
     * Angle in radians between 0 and 2*pi
     */
	public double GetAngle()
	{
		return _angle;
	}
	
	
	@Override
	public boolean HasCollided(RectangleCollider other) {
		//If their _angle is equal
		if(_angle != other.GetAngle())
		{
			try {
				throw new Exception("Collision for rotating rect_angles not implemented");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		if(Math.abs(GetCenter().x - other.GetCenter().x) > (GetWidth() + other.GetWidth())/2) return false;
		
		if(Math.abs(GetCenter().y - other.GetCenter().y) > (GetHeight() + other.GetHeight())/2) return false;
		
		return true;				
	}
	
	public void Update()
	{
		SetWidth(GetWidth() * GetTransform().Scale.x);
		SetHeight(GetHeight() * GetTransform().Scale.y);
	}
	
}
