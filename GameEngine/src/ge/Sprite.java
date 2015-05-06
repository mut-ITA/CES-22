package ge;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by gustavo on 4/19/2015.
 */
public class Sprite extends GameComponent
{
    public BufferedImage LoadedImage = null;
    
    
    public double AbsolutePositionX()
    {
    	return AbsoluteTransform.Position.x;
    }
    
    public double AbsolutePositionY()
    {
    	return AbsoluteTransform.Position.y;
    }
    
    public double AbsoluteVelocityX()
    {
    	return AbsoluteTransform.Velocity.x;
    }
    
    public double AbsoluteVelocityY()
    {
    	return AbsoluteTransform.Velocity.y;
    } 
    
    
    public Sprite()
    {    	
    	Renderer.Instance().AddSprite(this);    	
    }

    public void Load(String filepath)
    {
        try
        {
            LoadedImage = ImageIO.read(new File(filepath));
        }
        catch(IOException e)
        {
        }
    }

	public void Update() 
	{
		
	}
	
	@Override
	public void Destroy() {
		Renderer.Instance().RemoveSprite(this);
		super.Destroy();
	}
}
