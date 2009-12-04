package pl.rdk.vision2.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import pl.rdk.vision2.tests.Configuration;

/**
 * Obrazek wyświetlany dla pojedynczego oka
 * z możliwością przesuwania i zmiany oka.
 */
public class ImageFigure extends Figure {
    /** obrazek */
    private BufferedImage image;
    private int x, y, width, height;

    /**
     * Konstruuje nowy obrazek na podstawie nazwy zasobu
     * @param name nazwa zasobu (np. /pl/rdk/obrazki/1a.png)
     * @throws java.lang.Exception
     */
    public ImageFigure(String name) throws Exception {
        // tablica możliwych rozszerzeń
        String[] extensions = {"",".png",".jpg",".gif",".tif"};
        
        // próbujemy po kolei wszystkie rozszerzenia
        for (int i = 0; i < extensions.length; i++) {
            try {
                image = ImageIO.read(getClass().getResource(name+extensions[i]));
            } catch (Exception ex) {
            }
            if(image!=null)
                break;
        }

        // jeżeli się nie udało, zwracamy wyjątek
        if(image==null)
            throw new Exception("Nie udało się wczytać obrazka "+name+".");

        // ustawiamy wysokość i szerokość
        width = image.getWidth();
        height = 2 * image.getHeight();
        
    }


    /** rysuje komponent */
    public void paintComponent(Graphics g) {
        // przechodzimy po kolejnych rzedach obrazka
        for (int j = 0; j < height/2; j++) {
            // w każdym rzędzie przechodzimy po kolejnych pixelach
            for (int i = 0; i < width; i++) {
                // rysujemy pojedynczy pixel (jeżeli jest wystarczająco ciemny)
                Color color = new Color(image.getRGB(i, j));
                color = applyBrightness(color);
                if (color.getRed() + color.getGreen() + color.getBlue() < Configuration.CUTTING_SUM) {
                    g.setColor(color);
                    g.drawRect(x + i, y + 2 * j, 0, 0);
                }
            }
        }
    }

    /** @return prostokąt opisany na figurze */
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }

    public Rectangle setX(int x) {
        if(this.x!=x){
            Rectangle bounds = getBounds();
            this.x=x;
            bounds.add(getBounds());
            return bounds;
        }
        return new Rectangle(0, 0, 0, 0);
    }

    public Rectangle setY(int y) {
        if(this.y!=y){
            Rectangle bounds = getBounds();
            this.y=y;
            bounds.add(getBounds());
            return bounds;
        }
        return new Rectangle(0, 0, 0, 0);
    }

    public Rectangle setEye(int eye) {
        eye=eye%2;
        if(getEye()!=eye){
            Rectangle bounds = getBounds();

            if(eye==Configuration.EYE_RIGHT)
                y+=Configuration.PIXEL;
            else
                y-=Configuration.PIXEL;

            bounds.add(getBounds());
            return bounds;
        }
        return new Rectangle(0, 0, 0, 0);
    }

    public void center(int screenWidth, int screenHeight) {
        setX((screenWidth - width) / 2);
        setY((screenHeight - height) / 2);
    }

    @Override
    public int getEye() {
        return y%2;
    }

}
