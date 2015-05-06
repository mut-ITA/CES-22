package ge;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gustavo on 4/18/2015.
 */
public class GameEngine extends JFrame
{
	final static public double FPS = 60;
	
	final static public int WINDOW_WIDTH = 1280;
	final static public int WINDOW_HEIGHT = 720;
	
	
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
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private List<GameObject> _gameObjects = new ArrayList<GameObject>();
    private List<GameObject> _markedForCreation = new ArrayList<GameObject>();
    public void AddGameObject(GameObject go)
    {
    	_markedForCreation.add(go);
    }
    private List<GameObject> _markedForRemoval = new ArrayList<GameObject>();
    public void RemoveGameObject(GameObject go)
    {
    	_markedForRemoval.add(go);
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
            Debug.Call();
            
        	double currentTime = System.currentTimeMillis();
            double elapsedTime = currentTime - previousTime;
            totalTime += elapsedTime;
            previousTime = currentTime;
            lag += elapsedTime;

            HandleInput();
            
            CreateObjects();

            while (lag >= MS_PER_UPDATE())
            {         	
            	Update();
                lag -= MS_PER_UPDATE(); 
            }
            
            Render(lag / MS_PER_UPDATE());
            
            DestroyObjects();
        }

    }

    private void CreateObjects() {
    	for (GameObject go : _markedForCreation) 
		{
			_gameObjects.add(go);
		}
    	_markedForCreation =  new ArrayList<GameObject>();
	}

	private void DestroyObjects() 
    {		
		for (GameObject go : _markedForRemoval) 
		{
			_gameObjects.remove(go);
		}
		_markedForRemoval =  new ArrayList<GameObject>();
	}

	private void Initialize() 
    {
    	Scene.Instance().Load();	
	}


	private void Render(double interpolation) 
    {
		Renderer.Instance().Render(interpolation);
    }


    private void Update()
    {
    	Debug.Clear();
    	for(GameObject go : _gameObjects)
        {
        	go.BaseUpdate();
        }
    }

    private void HandleInput()
    {
    }
}
