package ge;

import static java.lang.Math.*;

/**
 * Created by gustavo on 4/19/2015.
 */
public class Vector2
{
    public double x;
    public double y;

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
        x /= Length();
        y /= Length();
    }

    public Vector2 Normalized()
    {
        Vector2 normalized = new Vector2(x, y);
        normalized.Normalize();

        return normalized;
    }
}
