package ge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class TestObject extends GameObject 
{		
	public double speed = 0.01;
	
	@Override
	public void Update() 
	{
		Transform.Velocity = Vector2.Zero();
		if(GameEngine.Instance().input.isKeyDown(KeyEvent.VK_RIGHT)) Transform.Velocity.x = 1;
		if(GameEngine.Instance().input.isKeyDown(KeyEvent.VK_LEFT)) Transform.Velocity.x = -1;
		if(GameEngine.Instance().input.isKeyDown(KeyEvent.VK_DOWN)) Transform.Velocity.y = 1;
		if(GameEngine.Instance().input.isKeyDown(KeyEvent.VK_UP)) Transform.Velocity.y = -1;	
		Transform.Velocity.Normalize(speed);
		//System.out.println(Transform.Position.x + " " + Transform.Position.y);	
			
	}

	@Override
	public void Initialize() 
	{
		
		System.out.println("Initialize");
		Transform = new Transform(new Vector2(50, 50));
		Sprite = new Sprite(Transform);
		Sprite.LoadedImage = new BufferedImage(50, 50, BufferedImage.TRANSLUCENT);
		Graphics g = Sprite.LoadedImage.getGraphics();
		g.setColor(Color.CYAN);
		g.fillOval(0, 0, 50, 50);
	}

}
