package pl.rdk.vision2.figures;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;
import pl.rdk.vision2.tests.Configuration;

/** Wypełniony prostokąt */
public class RectangleFigure extends Figure {
    private int x,y,width,height,eye;

    public RectangleFigure(int x,int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    
    public void paintComponent(Graphics g){
        g.setColor(Configuration.KOLOR_TESTU);
        for(int i=y;i<y+height;i++){
            if(((getEye()==Configuration.EYE_RIGHT)&&(i%2==0))||((getEye()==Configuration.EYE_LEFT)&&(i%2==1))||(getEye()==Configuration.EYE_BOTH))
                g.drawLine(x, i, x+width-1, i);
        }
    }
    
    @Deprecated
    public void przesun(JPanel panel ,int x,int y){
        if ((this.x!=x)||(this.y!=y)) {
            // Odświerzamy starą pozycję
            panel.repaint(this.x,this.y,this.width+Configuration.OFFSET,this.height+Configuration.OFFSET);

            // Uaktualnienie pozycji prostokąta
            this.x+=x;
            this.y+=y;

            // Odświerzenie nowej pozycji
            panel.repaint(this.x, this.y, 
                    this.width+Configuration.OFFSET,
                    this.height+Configuration.OFFSET);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    public Rectangle setX(int x) {
        if(this.x!=x){
            Rectangle bounds = getBounds();
            this.x=x;
            bounds.add(getBounds());
            return bounds;
        }
        return new Rectangle(0,0,0,0);
    }

    public Rectangle setY(int y) {
        if(this.y!=y){
            Rectangle bounds = getBounds();
            this.y=y;
            bounds.add(getBounds());
            return bounds;
        }
        return new Rectangle(0,0,0,0);
    }

    public Rectangle setEye(int eye) {
        if(eye>-1 && eye<3 && this.eye!= eye){
            this.eye=eye;
            return getBounds();
        }
        return new Rectangle(0,0,0,0);
    }

    public int getEye() {
        return eye;
    }

    public Rectangle setWidth(int width){
        if(this.width!=width){
            Rectangle bounds = getBounds();
            this.width = width;
            bounds.add(getBounds());
            return bounds;
        }
        return new Rectangle(0,0,0,0);
    }

        public Rectangle setHeight(int height){
        if(this.height!=height){
            Rectangle bounds = getBounds();
            this.height = height;
            bounds.add(getBounds());
            return bounds;
        }
        return new Rectangle(0,0,0,0);
    }

}

