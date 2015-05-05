package ge;

import java.awt.Color;
import java.awt.Graphics;
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
    
    Renderer()
    {
    	_graphics = GameEngine.Instance().getGraphics();
    	_current = new BufferedImage(GameEngine.WINDOW_WIDTH, GameEngine.WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB); 
    	_next = new BufferedImage(GameEngine.WINDOW_WIDTH, GameEngine.WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB); 
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
    
    public void Draw()
    {
    	Graphics backBuffer = _next.getGraphics();
    	
    	backBuffer.setColor(Color.WHITE);
    	backBuffer.fillRect(0, 0, GameEngine.WINDOW_WIDTH, GameEngine.WINDOW_HEIGHT);
		
    	for(Sprite s : _sprites)
    	{
    		backBuffer.drawImage(s.LoadedImage, s.PositionX(), s.PositionY(), null);
    	}
    	
    	Swap();
    }
    
    private void Swap() 
    {
    	BufferedImage temp = _next;
    	_next = _current;
    	_current = temp;    	
	}

	public void Render()
    {	
		Draw();
		_graphics.drawImage(_current, 0, 0, GameEngine.Instance());         
    }

}
