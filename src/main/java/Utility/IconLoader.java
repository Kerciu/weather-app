package main.java.Utility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class IconLoader {
    private static final int SMALL_ICON_PX_SIZE = 40;

    public static ImageIcon loadImageIcon(String fileHandle, boolean scale)
    {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(fileHandle));
            if (scale) {
                BufferedImage scaledImage = scaleImageIcon(bufferedImage, SMALL_ICON_PX_SIZE, SMALL_ICON_PX_SIZE);
                return new ImageIcon(scaledImage);
            }

            else return new ImageIcon(bufferedImage);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static BufferedImage scaleImageIcon(BufferedImage bufferedImage, int iconPxSizeX, int iconPxSizeY)
    {
        BufferedImage scaledBufferedImage = new BufferedImage(iconPxSizeX, iconPxSizeY, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = scaledBufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(bufferedImage, 0, 0, iconPxSizeX, iconPxSizeY, null);
        graphics2D.dispose();

        return scaledBufferedImage;
    }

}
