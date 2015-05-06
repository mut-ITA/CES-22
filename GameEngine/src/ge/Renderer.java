package ge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Renderer 
{	
	private BufferedImage _current;
	private BufferedImage _next;
	private Graphics _graphics;
	int x = 0;
	
	private static Renderer _instance;
    public static Renderer Instance()
    {
        if(_instance == null)
            _instance = new Renderer();
        return _instance;
    }
    
    Insets insets;
    
    Renderer()
    {
    	_graphics = GameEngine.Instance().getGraphics();
    	_current = new BufferedImage(GameEngine.WINDOW_WIDTH, GameEngine.WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB); 
    	_next = new BufferedImage(GameEngine.WINDOW_WIDTH, GameEngine.WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB); 
    	insets = GameEngine.Instance().getInsets();
    	GameEngine.Instance().setSize(insets.left + GameEngine.WINDOW_WIDTH + insets.right,
    	                insets.top + GameEngine.WINDOW_HEIGHT + insets.bottom); 
    }
    
    private List<Sprite> _sprites = new ArrayList<Sprite>();
    public void AddSprite(Sprite s)
    {
    	_sprites.add(s);
    }
    public void RemoveSprite(Sprite s)
    {
    	_sprites.remove(s);
    }
    
    public void Draw(double interpolation)
    {
    	Graphics backBuffer = _next.getGraphics();
    	
    	backBuffer.setColor(Color.WHITE);
    	backBuffer.fillRect(0, 0, GameEngine.WINDOW_WIDTH, GameEngine.WINDOW_HEIGHT);
		
    	for(Sprite s : _sprites)
    	{
    		int drawX = (int)(s.AbsolutePositionX() + interpolation * s.AbsoluteVelocityX());
    		int drawY = (int)(s.AbsolutePositionY() + interpolation * s.AbsoluteVelocityY());
    		int width = (int)(s.LoadedImage.getWidth() * s.AbsoluteTransform.Scale.x);
    		int height = (int)(s.LoadedImage.getHeight() * s.AbsoluteTransform.Scale.y);
    		backBuffer.drawImage(s.LoadedImage, drawX - width/2,
    				drawY - height/2, 
    				width,
    				height,
    				null);
    	}
    	
    	Swap();
    }
    
    private void Swap() 
    {
    	BufferedImage temp = _next;
    	_next = _current;
    	_current = temp;    	
	}

	public void Render(double interpolation)
    {	
		Draw(interpolation);
		_graphics.drawImage(_current, insets.left, insets.top, GameEngine.Instance());         
    }

}
