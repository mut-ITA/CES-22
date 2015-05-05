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
    
    private Transform _transform;
    
    public int PositionX()
    {
    	return (int)_transform.Position.x;
    }
    
    public int PositionY()
    {
    	return (int)_transform.Position.y;
    }
    
    public Sprite(Transform transform)
    {
    	Renderer.Instance().AddSprite(this);
    	_transform = transform;
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
    public void Destroy()
    {
    	Renderer.Instance().RemoveSprite(this);
    	super.Destroy();
    }
}
