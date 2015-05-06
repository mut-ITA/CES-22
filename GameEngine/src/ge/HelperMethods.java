package ge;

public class HelperMethods 
{
	public static void ForceCircularBounds(GameObject go, double radius)
	{
		Vector2 nextTransform = Vector2.Add(go.Transform.Position, go.Transform.Velocity);
		Vector2 velocityBounds = new Vector2();
		velocityBounds.Add(new Vector2(Sign(go.Transform.Velocity.x),Sign(go.Transform.Velocity.y)));
		velocityBounds.ScalarMult(radius);
		Vector2 nextTransformBounds = Vector2.Add(nextTransform, velocityBounds );
		if(nextTransformBounds.x < 0 || nextTransformBounds.x > GameEngine.WINDOW_WIDTH) 
			go.Transform.Velocity.x = - go.Transform.Velocity.x;
		if(nextTransformBounds.y < 0 || nextTransformBounds.y > GameEngine.WINDOW_HEIGHT) 
			go.Transform.Velocity.y = - go.Transform.Velocity.y;
	}
	
	public static double Sign(double a)
	{
		if(a == 0) return 0;
		return a > 0 ? 1 : -1;
	}
}
