package pl.rdk.vision2.figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import pl.rdk.vision2.library.Functions;
import pl.rdk.vision2.tests.Test;

/**
 *
 * @author rdk
 */
public class Pointer {

    final static double alphaSmaller = 20;
    final static double alphaLarger = 1;
    int centerX;
    int centerY;
    int radiusSmaller;
    int radiusLarger;
    int angle;
    int eye;

    public Pointer(int srodekX, int srodekY, int radiusSmaller, int radiusLarger, int kat) {
        this.centerX = srodekX;
        this.centerY = srodekY;
        this.radiusSmaller = radiusSmaller;
        this.radiusLarger = radiusLarger;
        this.angle = kat;
    }

    public int getEye() {
        return eye;
    }

    public void setEye(int eye) {
        this.eye = eye;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Deprecated
    public int getXmniejsze1() {
        double wynik = centerX;
        wynik += radiusSmaller * Math.cos(stopnie2radiany(angle - alphaSmaller));
        return (int) Math.round(wynik);
    }

    @Deprecated
    public int getYmniejsze1() {
        double wynik = centerY;
        wynik += radiusSmaller * Math.sin(stopnie2radiany(angle - alphaSmaller));
        return (int) Math.round(wynik);
    }

    @Deprecated
    public int getXmniejsze2() {
        double wynik = centerX;
        wynik += radiusSmaller * Math.cos(stopnie2radiany(angle + alphaSmaller));
        return (int) Math.round(wynik);
    }

    @Deprecated
    public int getYmniejsze2() {
        double wynik = centerY;
        wynik += radiusSmaller * Math.sin(stopnie2radiany(angle + alphaSmaller));
        return (int) Math.round(wynik);
    }

    @Deprecated
    public int getXwieksze1() {
        double wynik = centerX;
        wynik += radiusLarger * Math.cos(stopnie2radiany(angle - alphaLarger));
        return (int) Math.round(wynik);
    }

    @Deprecated
    public int getYwieksze1() {
        double wynik = centerY;
        wynik += radiusLarger * Math.sin(stopnie2radiany(angle - alphaLarger));
        return (int) Math.round(wynik);
    }

    @Deprecated
    public int getXwieksze2() {
        double wynik = centerX;
        wynik += radiusLarger * Math.cos(stopnie2radiany(angle + alphaLarger));
        return (int) Math.round(wynik);
    }

    @Deprecated
    public int getYwieksze2() {
        double wynik = centerY;
        wynik += radiusLarger * Math.sin(stopnie2radiany(angle + alphaLarger));
        return (int) Math.round(wynik);
    }

    private double stopnie2radiany(double ileStopni) {
        return ileStopni * Math.PI / 180.0;
    }

    public int getCenterX() {
        return centerX;
    }

    public Rectangle setCenterX(int centerX) {
        Rectangle bounds = getBounds();
        this.centerX = centerX;
        bounds.add(getBounds());
        return bounds;
    }

    public int getCenterY() {
        return centerY;
    }

    public Rectangle setCenterY(int centerY) {
        Rectangle bounds = getBounds();
        this.centerY = centerY;
        bounds.add(getBounds());
        return bounds;
    }

    public Rectangle getBounds() {
        GeneralPath wskazowka = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);
        wskazowka.moveTo(getXmniejsze1(), getYmniejsze1());
        wskazowka.lineTo(getXmniejsze2(), getYmniejsze2());
        wskazowka.lineTo(getXwieksze2(), getYwieksze2());
        wskazowka.lineTo(getXwieksze1(), getYwieksze1());
        wskazowka.closePath();
        return wskazowka.getBounds();
    }

    public void paintComponent(Graphics g) {
        GeneralPath wskazowka = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);
        wskazowka.moveTo(getXmniejsze1(), getYmniejsze1());
        wskazowka.lineTo(getXmniejsze2(), getYmniejsze2());
        wskazowka.lineTo(getXwieksze2(), getYwieksze2());
        wskazowka.lineTo(getXwieksze1(), getYwieksze1());
        wskazowka.closePath();
        Graphics2D g2 = Graphics2D.class.cast(g);
        g2.setPaint(Functions.getTextureForEye(eye));
        g2.fill(wskazowka);
    }
}
