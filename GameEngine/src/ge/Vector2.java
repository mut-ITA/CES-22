package ge;

import static java.lang.Math.*;

/**
 * Created by gustavo on 4/19/2015.
 */
public class Vector2
{
    public double x;
    public double y;
    
    Vector2()
    {
    	x = 0;
    	y = 0;
    }
    
    Vector2(Vector2 Copy)
    {
        this.x = Copy.x;
        this.y = Copy.y;
    }

    Vector2(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public static Vector2 Zero()
    {
        return new Vector2(0, 0);
    }

    public double Length()
    {
        return sqrt(x*x + y*y);
    }

    public void Normalize()
    {
    	if(x==0 && y==0) return;
        
        x /= Length();
        y /= Length();
    }
    
    public void Normalize(double size)
    {
        if(x==0 && y==0) return;
        
        x /= Length();
        y /= Length();
        x *= size;
        y *= size;
    }

    public Vector2 Normalized()
    {
        Vector2 normalized = new Vector2(x, y);
        normalized.Normalize();

        return normalized;
    }
    
    public double GetAngle()
    {
    	if(x==0 && y==0) return 0;
    	
    	double angle = Math.atan(y/x);
    	while(angle > 2*Math.PI)	angle -= 2*Math.PI;
    	while(angle < 0)	angle += 2*Math.PI;
    	
    	return angle;
    }
    
    /**
     * a + b
     */
    public static Vector2 Add(Vector2 a, Vector2 b)
    {
    	return new Vector2(a.x + b.x, a.y + b.y);
    }  
    
    /**
     * this + other
     */
    public void Add(Vector2 other)
    {
    	x += other.x;
    	y += other.y;
    }
    
    /**
     * a - b
     */
    public static Vector2 Subtract(Vector2 a, Vector2 b)
    {
    	return new Vector2(a.x - b.x, a.y - b.y);
    }
    
    /**
     * this - other
     */
    public void Subtract(Vector2 other)
    {
    	x -= other.x;
    	y -= other.y;
    }
    
    /**
     * a dot b
     */
    public static double Dot(Vector2 a, Vector2 b)
    {
    	return a.x * b.x + a.y * b.y;
    }
    
    /**
     * this dot other
     */
    public double Dot(Vector2 other)
    {
    	return x * other.x + y * other.y;
    }    
    
    public void ScalarMult(double scalar)
    {
    	x = scalar*x;
    	y = scalar*y;
    }
    
}
