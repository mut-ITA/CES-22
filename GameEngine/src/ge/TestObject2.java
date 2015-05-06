package ge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import sun.security.krb5.internal.crypto.Des;

public class TestObject2 extends GameObject 
{		
	public double maxSpeed = 0.008;
	int radius;
	int baseRadius;
	public int maxRadius = 80;
	public int minRadius = 15;
	
	TestObject2(Vector2 position)
	{
		Transform.Position = position;
	}
		
	@Override
	public void Update() 
	{		
		HelperMethods.ForceCircularBounds(this, radius);
		
		radius = (int)(baseRadius * Transform.Scale.x);	
	}

	@Override
	public void Initialize() 
	{		
		Random generator = new Random();
		baseRadius = minRadius + generator.nextInt(maxRadius - minRadius);
		radius = baseRadius;
		
		
		Sprite Sprite = new Sprite();
		AddComponent(Sprite);		
		
		Sprite.LoadedImage = new BufferedImage(2*radius, 2*radius, BufferedImage.TRANSLUCENT);
		Graphics g = Sprite.LoadedImage.getGraphics();
		g.setColor(Color.PINK);
		g.fillOval(0, 0, 2*radius, 2*radius);
		
		Sprite CenterSprite = new Sprite();
		AddComponent(CenterSprite);		
		
		CenterSprite.LoadedImage = new BufferedImage(20, 20, BufferedImage.TRANSLUCENT);
		g = CenterSprite.LoadedImage.getGraphics();
		g.setColor(Color.RED);
		g.fillOval(0, 0, 20, 20);
				
		Collider c = new CircleCollider(radius);
		c.Name = "Enemy";
		AddComponent(c);
		
		
		double speed = generator.nextDouble() * maxSpeed;
		Transform.Velocity = new Vector2(generator.nextDouble() - 0.5, generator.nextDouble() - 0.5);
		Transform.Velocity.Normalize(speed);
	}

	@Override
	public void OnCollision(CollisionInfo collisionInfo) 
	{	
		if(collisionInfo.Collider().get(0).Name == "Player")
		{
			if(!GameEngine.Instance().input.isKeyDown(KeyEvent.VK_SPACE)) return;
			Destroy();
		}		
	}
}
