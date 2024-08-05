package main.java.GUI.Utility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class IconLoader {
    static public ImageIcon loadImageIcon(String fileHandle)
    {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(fileHandle));

            return new ImageIcon(bufferedImage);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
