package pl.rdk.vision2.figures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;
import pl.rdk.vision2.tests.Configuration;

/**
 * trójąt złożony z poziomych lini rysowanych co druga 
 */
public class TriangleFigure extends Figure {
    /** lewy górny róg */
    private int x;
    /** lewy góry róg */
    private int y;
    /** szerokość */
    private int width;
    /** wysokość */
    private int height;
    /** oko */
    private int eye;

    private int a;
    private int rodzaj;
    private int h;
    
    /** trójkąt będzie skierowany w prawo */
    final static public int HOUR_03=3;
    /** trójkąt będzie skierowany w dół */
    final static public int HOUR_06=6;
    /** trójkąt będzie skierowany w lewo */
    final static public int HOUR_09=9;
    /** trójkąt będzie skierowany do góry */
    final static public int HOUR_12=12;

    /** 
    * @param    int a       długość boku trójkąta 
    * @param    rodzaj      w którą stronę ma wskazywać trójkąt
    * @param    x,y         współrzędne wskazującego wierzchołka (np górnego dla {@link #HOUR_12})
    * @param    eye         które oko ma widzieć trójkąt
    * @see      #HOUR_03
    * @see      #HOUR_06
    * @see      #HOUR_09
    * @see      #HOUR_12
    * @see      Test#EYE_LEFT
    * @see      Test#EYE_RIGHT
    * @see      Test#EYE_BOTH
     */
    public TriangleFigure(int a, int rodzaj, int x, int y) {
        this.a = a;
        this.rodzaj = rodzaj;
        this.x = x;
        this.y = y;
        this.h = (int)(a*Math.sqrt(0.75));
    }

     /** 
     * Wierzchołki są numerowane od wskazującego wierzchołka
     * (np górnego dla {@link #HOUR_12})
     * zgodnie z kierunkiem obrotu wskazówek zegara
     * @return <code>x</code> pozioma współrzędna i-tego wierzchołka, i=0,1,2
     * @see #Trojkat */
    public int getX(int i) {
        switch(rodzaj){
            case HOUR_12:
                switch(i){
                    case 0:     return x;
                    case 1:     return x+a/2;
                    default:    return x-a/2;
                }
            case HOUR_03:
                switch(i){
                    case 0:     return x;
                    case 1:     return x-h;
                    default:    return x-h;
                }
            case HOUR_06:
                switch(i){
                    case 0:     return x;
                    case 1:     return x-a/2;
                    default:    return x+a/2;
                }
            default:
                switch(i){
                    case 0:     return x;
                    case 1:     return x+h;
                    default:    return x+h;
                }
        }
    }
    
     /** 
     * Wierzchołki są numerowane od wskazującego wierzchołka
     * (np górnego dla {@link #HOUR_12})
     * zgodnie z kierunkiem obrotu wskazówek zegara
     * @return <code>y</code> pionowa współrzędna i-tego wierzchołka, i=0,1,2
     * @see #Trojkat */
    public int getY(int i) {
        switch(rodzaj){
            case HOUR_12:
                switch(i){
                    case 0:     return y;
                    case 1:     return y+h;
                    default:    return y+h;
                }
            case HOUR_03:
                switch(i){
                    case 0:     return y;
                    case 1:     return y+a/2;
                    default:    return y-a/2;
                }
            case HOUR_06:
                switch(i){
                    case 0:     return y;
                    case 1:     return y-h;
                    default:    return y-h;
                }
            default:
                switch(i){
                    case 0:     return y;
                    case 1:     return y-a/2;
                    default:    return y+a/2;
                }
        }
    }
    
    /** 
     * @return <code>h</code> wysokość trójkąta
     * @see #Trojkat */
    public int getH() {
        return h;
    }
    
    /** 
     * Rysuje trójkąt składający się z poziomych linii. 
     * Efekt zależy od parametru <code>eye</code>
     * <ul>
     * <li>{@link Test#EYE_RIGHT} - rysowane są parzyste linie</li>
     * <li>{@link Test#EYE_LEFT} - rysowane są parzyste linie</li>
     * <li>{@link Test#EYE_BOTH} - rysowane są parzyste linie</li>
     * </ul>
     * @param g kontekst graficzny bierzącego testu, 
     * (który dziedziczy po {@link javax.swing.JPanel})
     */
    public void paintComponent(Graphics g){
        g.setColor(Configuration.KOLOR_TESTU);
        switch(rodzaj){
            case HOUR_12:
                for(int i=y;i<y+h;i++){
                    int j=(a*(i-y))/(2*h);
                    if(((eye==Configuration.EYE_RIGHT)&&(i%2==0))||((eye==Configuration.EYE_LEFT)&&(i%2==1))||(eye==Configuration.EYE_BOTH))
                        g.drawLine(x-j, i, x+j, i); 
                }
                break;
            case HOUR_03:
                for(int i=y-a/2;i<y+a/2;i++){
                    int j=(2*(i-y+a/2)*h)/a;
                    if((j)>h)
                        j=2*h-j;
                    if(((eye==Configuration.EYE_RIGHT)&&(i%2==0))||((eye==Configuration.EYE_LEFT)&&(i%2==1))||(eye==Configuration.EYE_BOTH))
                        g.drawLine(x-h, i, x-h+j, i); 
                }
                break;
            case HOUR_06:
                for(int i=y-h;i<=y+Configuration.OFFSET;i++){
                    int j=a/2-(a*(i-y+h))/(2*h);
                    if(((eye==Configuration.EYE_RIGHT)&&(i%2==0))||((eye==Configuration.EYE_LEFT)&&(i%2==1))||(eye==Configuration.EYE_BOTH))
                        g.drawLine(x-j, i, x+j, i); 
                }
                break;
            default:  //HOUR_09
                for(int i=y-a/2;i<y+a/2;i++){
                    int j=(2*(i-y+a/2)*h)/a;
                    if((j)>h)
                        j=2*h-j;
                    if(((eye==Configuration.EYE_RIGHT)&&(i%2==0))||((eye==Configuration.EYE_LEFT)&&(i%2==1))||(eye==Configuration.EYE_BOTH))
                        g.drawLine(x+h-j, i, x+h, i); 
                }
                break;
        }
    }
    
    /** zwraca kształt trójkąta w postaci GeneralPath */
    public GeneralPath getPath(){
        GeneralPath gp = new GeneralPath(GeneralPath.WIND_EVEN_ODD,3);
        gp.moveTo(getX(0), getY(0));
        gp.lineTo(getX(1), getY(1));
        gp.lineTo(getX(2), getY(2));
        gp.closePath();
        return gp;
    }   
    
    /** @return prostokąt opisany na trójkącie  */
    @Override
    public Rectangle getBounds(){
        int _x,_y,_width,_height;
        switch(this.rodzaj){
            case HOUR_12:
                _x=x-a/2;
                _y=y;
                _width=a;
                _height=h;
                break; 
            case HOUR_03:
                _x=x-h;;
                _y=y-a/2;
                _width=h;
                _height=a;
                break;
            case HOUR_06:
                _x=x-a/2;
                _y=y-h;
                _width=a;
                _height=h;
                break;          
            default: //HOUR_09
                _x=x;
                _y=y-a/2;
                _width=h;
                _height=a;
                break;
        }
        return new Rectangle(_x-2*Configuration.OFFSET, _y, _width+5*Configuration.OFFSET, _height+2*Configuration.OFFSET);
         
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

    @Override
    public int getX(){
        return x;
    }

    @Override
    public int getY(){
        return y;
    }

    
}

