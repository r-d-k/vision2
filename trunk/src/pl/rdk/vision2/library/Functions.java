package pl.rdk.vision2.library;

import pl.rdk.vision2.tests.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.util.Random;
import pl.rdk.vision2.figures.TriangleFigure;

public class Functions {

    /**
     * @param oko
     * @return Teksturę umożliwiającą ograniczenie widoczności do podanego oka
     */
    public static TexturePaint getTextureForEye(int oko) {
        BufferedImage obrazek = new BufferedImage(1, 2, BufferedImage.TYPE_INT_RGB);
        Graphics2D grafika = obrazek.createGraphics();
        grafika.setPaint(Configuration.KOLOR_TLA); //obrazek jest caly czarny na poczatku
        if (oko == Configuration.EYE_LEFT) {
            grafika.fillRect(0, 0, 1, 1);  //dlatego musimy narysowac pixel kolorem tła
        } else {
            grafika.fillRect(0, 1, 1, 1);
        }
        Rectangle prostokacik = new Rectangle(0, 0, 1, 2);
        return new TexturePaint(obrazek, prostokacik);
    }

    /**
     * Losuje kierunek trójkąta (jeden z czterech)
     * @return HOUR_03, HOUR_06, HOUR_09 lub HOUR_12
     */
    public static int chooseTriangleDirection() {
        Random rand = new Random();
        double i = rand.nextDouble();
        if (i < 0.25) {
            return TriangleFigure.HOUR_12;
        } else {
            if (i < 0.5) {
                return TriangleFigure.HOUR_03;
            } else {
                if (i < 0.75) {
                    return TriangleFigure.HOUR_06;
                } else {
                    return TriangleFigure.HOUR_09;
                }
            }
        }
    }
}
