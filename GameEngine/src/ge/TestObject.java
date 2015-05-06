package ge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class TestObject extends GameObject 
{		
	public double speed = 0.005;
	public int baseRadius = 100;
	public int radius = baseRadius;
	boolean foundEnemy = false;
		
	@Override
	public void Update() 
	{		
		Transform.Velocity = Vector2.Zero();		
		
		
		if(GameEngine.Instance().input.isKeyDown(KeyEvent.VK_RIGHT)) Transform.Velocity.x = 1;
		if(GameEngine.Instance().input.isKeyDown(KeyEvent.VK_LEFT)) Transform.Velocity.x = -1;
		if(GameEngine.Instance().input.isKeyDown(KeyEvent.VK_DOWN)) Transform.Velocity.y = 1;
		if(GameEngine.Instance().input.isKeyDown(KeyEvent.VK_UP)) Transform.Velocity.y = -1;
		HelperMethods.ForceCircularBounds(this, radius);
		Transform.Velocity.Normalize(speed);
		//System.out.println(Transform.Position.x + " " + Transform.Position.y);
		Debug.Write(Transform.Position.x + " " + Transform.Position.y);
		radius = (int)(baseRadius * Transform.Scale.x);
		
		
		if(GameEngine.Instance().input.isKeyDown(KeyEvent.VK_SPACE))
		{
			if(foundEnemy) Transform.Scale.ScalarMult(1.3);
			else Transform.Scale.ScalarMult(1/1.00005);		
		}
		foundEnemy = false;
		
		if(radius < 10)
		{
			Destroy();
		}
		
	}

	@Override
	public void Initialize() 
	{		
		System.out.println("Initialize");
		Transform = new Transform(new Vector2(50, 50));
		
		Sprite Sprite = new Sprite();
		AddComponent(Sprite);		
		
		Sprite.LoadedImage = new BufferedImage(2 * radius, 2 * radius, BufferedImage.TRANSLUCENT);
		Graphics g = Sprite.LoadedImage.getGraphics();
		g.setColor(Color.CYAN);
		g.fillOval(0, 0, 2 * radius, 2 * radius);
		
		Sprite CenterSprite = new Sprite();
		AddComponent(CenterSprite);		
		
		CenterSprite.LoadedImage = new BufferedImage(20, 20, BufferedImage.TRANSLUCENT);
		g = CenterSprite.LoadedImage.getGraphics();
		g.setColor(Color.RED);
		g.fillOval(0, 0, 20, 20);
		
		Collider c = new CircleCollider(radius);
		c.Name = "Player";
		AddComponent(c);
	}

	@Override
	public void OnCollision(CollisionInfo collisionInfo) 
	{	
		
		
		for (Collider c : collisionInfo.Collider()) 
		{
				
			if(c.Name.equals("Enemy"))
			{
					
					foundEnemy = true;
			}
		}			
		
	}
	


}
