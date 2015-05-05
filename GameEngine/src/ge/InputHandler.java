package ge;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by gustavo on 4/19/2015.
 */
class InputHandler implements KeyListener
{
    private boolean[] keys = new boolean[256];

    /**
     * Assigns the newly created InputHandler to a Component
     * @param c Component to get input from
     */
    protected InputHandler(Component c)
    {
        c.addKeyListener(this);
    }

    /**
     * Checks whether a specific key is down
     * @param keyCode The key to check
     * @return Whether the key is pressed or not
     */
    public boolean isKeyDown(int keyCode)
    {
        if (keyCode > 0 && keyCode < 256)
        {
            return keys[keyCode];
        }

        return false;
    }

    /**
     * Called when a key is pressed while the component is focused
     * @param e KeyEvent sent by the component
     */
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
        {
            keys[e.getKeyCode()] = true;
        }
    }

    /**
     * Called when a key is released while the component is focused
     * @param e KeyEvent sent by the component
     */
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
        {
            keys[e.getKeyCode()] = false;
        }
    }


    public void keyTyped(KeyEvent e){}
}
