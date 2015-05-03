package ge;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by gustavo on 4/19/2015.
 */
public class Sprite
{
    public BufferedImage LoadedImage;

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
}
