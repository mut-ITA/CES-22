package ge;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustavo on 4/18/2015.
 */
public class GameEngine extends JFrame
{
    public float FPS = 60;
    private float MS_PER_UPDATE;

    private static GameEngine _instance;
    public static GameEngine Instance()
    {
        if(_instance == null)
            _instance = new GameEngine();
        return _instance;
    }
    private GameEngine()
    {
        MS_PER_UPDATE = 1/FPS;
        setTitle("Game Tutorial");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private List<GameObject> _gameObjects = new ArrayList<GameObject>();
    public void AddGameObject(GameObject go)
    {
        _gameObjects.add(go);
    }
    public void RemoveGameObject(GameObject go)
    {
        _gameObjects.remove(go);
    }

    public InputHandler input = new InputHandler(this);



    public void Run()
    {
        double previousTime = System.currentTimeMillis();
        double totalTime = 0;
        double lag = 0.0;
        while (totalTime < 10000)
        {

            double currentTime = System.currentTimeMillis();
            double elapsedTime = currentTime - previousTime;
            totalTime += elapsedTime;
            previousTime = currentTime;
            lag += elapsedTime;

            HandleInput();

            while (lag >= MS_PER_UPDATE)
            {
                Update();
                lag -= MS_PER_UPDATE;
            }

            Render(lag / MS_PER_UPDATE);
        }

    }

    private void Render(double interpolation) {
    }


    private void Update()
    {
        for(GameObject go : _gameObjects)
        {
            go.Update();
        }
    }

    private void HandleInput()
    {
    }
}
