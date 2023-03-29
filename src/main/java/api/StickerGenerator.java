package api;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StickerGenerator {
    protected static void create(String URL, String fileName, String text) throws IOException { //change this.
        //read image (WITHOUT "._V1_UX128_CR0,12,128,176_AL_", to make the image bigger)
        InputStream inputStream = new URL(fixURL(URL)).openStream();
        BufferedImage image = ImageIO.read(inputStream);

        //create new translucent image
        int width = image.getWidth();
        int height = image.getHeight();
        int newHeight = height + 200; //+ 200px
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        //copy original image to the new image
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(image, 0, 0, null);

        //configure font
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 80);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        //centralize text
        FontMetrics fontMetrics = graphics.getFontMetrics(font);
        int stringWidth = fontMetrics.stringWidth(text);
        int x = (width - stringWidth) / 2; //center horizontally
        int y = newHeight - fontMetrics.getHeight() / 2; //center vertically at the bottom

        //write phrase on the new image
        graphics.drawString(text, x, y);

        //put new image in file
        ImageIO.write(newImage, "png", new File("images/" + fileName + ".png"));
    }

    private static String fixURL(String URL) {
        return URL.replace("._V1_UX128_CR0,12,128,176_AL_", "");
    }
}