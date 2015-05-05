package ge;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustavo on 4/18/2015.
 */
public class GameEngine extends JFrame
{
	final static public double FPS = 60;
	
	final static public int WINDOW_HEIGHT = 500;
	final static public int WINDOW_WIDTH = 500;
	
	public static double MS_PER_UPDATE(){ return 1/FPS; }

    private static GameEngine _instance;
    public static GameEngine Instance()
    {
        if(_instance == null)
            _instance = new GameEngine();
        return _instance;
    }
    
    
    private GameEngine()
    {
        setTitle("Game Tutorial");
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private List<GameComponent> _components = new ArrayList<GameComponent>();
    public void AddGameComponent(GameComponent c)
    {
    	_components.add(c);
    }
    public void RemoveGameComponent(GameComponent c)
    {
    	_components.remove(c);
    }

    public InputHandler input = new InputHandler(this);



    public void Run()
    {
        double previousTime = System.currentTimeMillis();
        double totalTime = 0;
        double lag = 0.0;
        Initialize();
        while (true)
        {

            double currentTime = System.currentTimeMillis();
            double elapsedTime = currentTime - previousTime;
            totalTime += elapsedTime;
            previousTime = currentTime;
            lag += elapsedTime;

            HandleInput();

            while (lag >= MS_PER_UPDATE())
            {
                Update();
                lag -= MS_PER_UPDATE();
            }

            Render(lag / MS_PER_UPDATE());
        }

    }

    private void Initialize() 
    {
    	Scene.Instance().Load();	
	}


	private void Render(double interpolation) 
    {
		Renderer.Instance().Render();
    }


    private void Update()
    {
        for(GameComponent c : _components)
        {
        	//System.out.println("Updating " + c.getClass().toString());
        	c.Update();
        }
    }

    private void HandleInput()
    {
    }
}
