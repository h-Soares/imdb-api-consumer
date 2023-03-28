package api;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StickerGenerator {
    public void create(String URL, String fileName) throws IOException { //change this.
        //read image ( WITHOUT @|THIS|.jpg , to make the image bigger !! )
        //String URL = "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@.jpg";
        InputStream inputStream = new URL(URL).openStream();
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
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        //centralize text
        String text = "YEAH FILM"; //maybe that could be an argument
        FontMetrics fontMetrics = graphics.getFontMetrics(font);
        int stringWidth = fontMetrics.stringWidth(text);
        int x = (width - stringWidth) / 2; //center horizontally
        int y = newHeight - fontMetrics.getHeight() / 2; //center vertically at the bottom

        //write phrase on the new image
        graphics.drawString(text, x, y);

        //put new image in file
        ImageIO.write(newImage, "png", new File("images/" + fileName + ".png"));
    }
}