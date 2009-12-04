package pl.rdk.vision2.tests;

import pl.rdk.vision2.library.TestName;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import pl.rdk.vision2.UserInterface;
import pl.rdk.vision2.data.ResultData;
import pl.rdk.vision2.figures.Pointer;
import pl.rdk.vision2.figures.RectangleFigure;


/** Test Wskazówkowy (Pointer test) */
public class PointerTest_Double extends JPanel implements KeyListener {
    private Test t;
    private pl.rdk.vision2.figures.RectangleFigure podzialka1, podzialka2, podzialka3, podzialka4, podzialka5, podzialka6, podzialka7, podzialka8, podzialka9, podzialka10, podzialka11, podzialka12;
    private String result;
    private final int krokOsi=1;
    private Pointer w1, w2, w3, w4;

    
    /** konstruktor */
    public PointerTest_Double(UserInterface userInterface) {
        t=new Test(this,userInterface);
        setBounds(t.getCenterPosition());
        setBackground(Configuration.KOLOR_TLA);

        // WSKAZOWKI
        w1=new Pointer(Configuration.MAX_X/2, Configuration.MAX_Y/2, Configuration.POINTER_SMALLER_RADIUS, Configuration.POINTER_BIGGER_RADIUS, 0);
        w2=new Pointer(Configuration.MAX_X/2, Configuration.MAX_Y/2, Configuration.POINTER_SMALLER_RADIUS, Configuration.POINTER_BIGGER_RADIUS, 90);
        w3=new Pointer(Configuration.MAX_X/2, Configuration.MAX_Y/2, Configuration.POINTER_SMALLER_RADIUS, Configuration.POINTER_BIGGER_RADIUS, 180);
        w4=new Pointer(Configuration.MAX_X/2, Configuration.MAX_Y/2, Configuration.POINTER_SMALLER_RADIUS, Configuration.POINTER_BIGGER_RADIUS, 270);
        
        // PODZIAŁKA LEWA
        podzialka1 = new RectangleFigure(Configuration.ROZNICA,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2-2*Configuration.ODSTEP,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        podzialka2 = new RectangleFigure(Configuration.ROZNICA,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        podzialka3 = new RectangleFigure(Configuration.ROZNICA,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2+2*Configuration.ODSTEP,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        // PODZIAŁKA PRAWA
        podzialka4 = new RectangleFigure(Configuration.MAX_X-Configuration.ROZNICA-Configuration.WYS_PODZIALKI,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2-2*Configuration.ODSTEP,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        podzialka5 = new RectangleFigure(Configuration.MAX_X-Configuration.ROZNICA-Configuration.WYS_PODZIALKI,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        podzialka6 = new RectangleFigure(Configuration.MAX_X-Configuration.ROZNICA-Configuration.WYS_PODZIALKI,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2+2*Configuration.ODSTEP,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        // PODZIAŁKA GÓRNA
        podzialka7 = new RectangleFigure(Configuration.MAX_X/2-Configuration.SZER_PODZIALKI/2-2*Configuration.ODSTEP,1,Configuration.SZER_PODZIALKI,Configuration.WYS_PODZIALKI);
        podzialka8 = new RectangleFigure(Configuration.MAX_X/2-Configuration.SZER_PODZIALKI/2,1,Configuration.SZER_PODZIALKI,Configuration.WYS_PODZIALKI);
        podzialka9 = new RectangleFigure(Configuration.MAX_X/2-Configuration.SZER_PODZIALKI/2+2*Configuration.ODSTEP,1,Configuration.SZER_PODZIALKI,Configuration.WYS_PODZIALKI);
        // PODZIAŁKA DOLNA
        podzialka10= new RectangleFigure(Configuration.MAX_X/2-Configuration.SZER_PODZIALKI/2-2*Configuration.ODSTEP,Configuration.MAX_Y-Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI,Configuration.WYS_PODZIALKI);
        podzialka11= new RectangleFigure(Configuration.MAX_X/2-Configuration.SZER_PODZIALKI/2,Configuration.MAX_Y-Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI,Configuration.WYS_PODZIALKI);
        podzialka12= new RectangleFigure(Configuration.MAX_X/2-Configuration.SZER_PODZIALKI/2+2*Configuration.ODSTEP,Configuration.MAX_Y-Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI,Configuration.WYS_PODZIALKI);

        // POLARYZACJA WG CENTRALNYCH USTAWIEN
        setPolarisation();

        // WYNIK
        calculateResult();
        if(t.testHelper!=null)
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(TestName.WSKAZOWKOWY_PODWOJNY));
    }
        
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D) g;
        super.paintComponent(g2);
            
        // WSKAZÓWKI
        g2.setColor(Configuration.KOLOR_TESTU);
        w1.paintComponent(g2); //prawa
        w2.paintComponent(g2); //dolna
        w3.paintComponent(g2); //lewa
        w4.paintComponent(g2); //górna

        // PODZIAŁKI
        g2.setStroke(Configuration.LINIA_NORMALNA);
        podzialka1.paintComponent(g2);
        podzialka2.paintComponent(g2);
        podzialka3.paintComponent(g2);
        podzialka4.paintComponent(g2);
        podzialka5.paintComponent(g2);
        podzialka6.paintComponent(g2);
        podzialka7.paintComponent(g2);
        podzialka8.paintComponent(g2);
        podzialka9.paintComponent(g2);
        podzialka10.paintComponent(g2);
        podzialka11.paintComponent(g2);
        podzialka12.paintComponent(g2);
                   
        // WEWNĘTRZNE I ZEWNĘTRZNE KOŁA
        g2.setColor(Configuration.KOLOR_TESTU);
        // rysujemy zewnetrze kolo
        g2.setStroke(Configuration.LINIA_GRUBA);
        g2.drawOval(Configuration.MAX_X/2-Configuration.MAX_Y/2-Configuration.LINIA_GRUBA_INT/2,-Configuration.LINIA_GRUBA_INT/2,Configuration.MAX_Y+Configuration.LINIA_GRUBA_INT,Configuration.MAX_Y+Configuration.LINIA_GRUBA_INT);
        // rysujemy wewnetrzne kolo
        g2.setStroke(Configuration.LINIA_SREDNIA);
        g2.drawOval(Configuration.MAX_X/2-Configuration.SREDNICA_KOLA_Z_DZIURKA/2, Configuration.MAX_Y/2-Configuration.SREDNICA_KOLA_Z_DZIURKA/2,Configuration.SREDNICA_KOLA_Z_DZIURKA,Configuration.SREDNICA_KOLA_Z_DZIURKA);
        // powracamy do standardowej grubosci lini
        g2.setStroke(Configuration.LINIA_NORMALNA);
        
        // AKTUALNY WYNIK TESTU
        g2.setColor(Configuration.KOLOR_TLA);
        if(Test.showResult)
            g.drawString(result, Configuration.WYNIK_X, Configuration.WYNIK_Y);
        
    }

    public void keyPressed(KeyEvent e) {
         switch(e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                t.exit();
                break;
             case KeyEvent.VK_UP:
                // obracanie wskazówką poziomą
                w1.setAngle(w1.getAngle()-krokOsi);
                w3.setAngle(w3.getAngle()-krokOsi);
                calculateResult();
                repaint();
                break;
             case KeyEvent.VK_DOWN:
                // obracanie wskazówką poziomą
                w1.setAngle(w1.getAngle()+krokOsi);
                w3.setAngle(w3.getAngle()+krokOsi);
                calculateResult();
                repaint();
                 break;
            case KeyEvent.VK_LEFT:
                // obracanie wskazówką pionową
                w2.setAngle(w2.getAngle()-krokOsi);
                w4.setAngle(w4.getAngle()-krokOsi);
                calculateResult();
                repaint();
                break;
             case KeyEvent.VK_RIGHT:
                 // obracanie wskazówką pionową
                w2.setAngle(w2.getAngle()+krokOsi);
                w4.setAngle(w4.getAngle()+krokOsi);
                calculateResult();
                repaint(); 
                break;
             case KeyEvent.VK_P:
                Test.polarisationChanged = ! Test.polarisationChanged;
                t.userInterface.jCheckBoxMenuItemPolarisationChanged.setState(Test.polarisationChanged);
                setPolarisation();
                repaint();
                break;
             case KeyEvent.VK_SPACE:
                 Test.showResult=!Test.showResult;
                 t.userInterface.jCheckBoxMenuItemShowResult.setState(Test.showResult);
                 repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                 break; 
             case KeyEvent.VK_ENTER:
                 t.userInterface.getPacjent().addWynikTestu(new ResultData(TestName.WSKAZOWKOWY_PODWOJNY,result));
                 t.userInterface.getModelTabeli().fireTableStructureChanged();
                 t.exit();
                 break;
        }
    }

    private void setPolarisation(){
        if(Test.polarisationChanged==false){
            w1.setEye(Configuration.EYE_LEFT);
            w2.setEye(Configuration.EYE_RIGHT);
            w3.setEye(Configuration.EYE_LEFT);
            w4.setEye(Configuration.EYE_RIGHT);
            podzialka1.setEye(Configuration.EYE_RIGHT);
            podzialka2.setEye(Configuration.EYE_RIGHT);
            podzialka3.setEye(Configuration.EYE_RIGHT);
            podzialka4.setEye(Configuration.EYE_RIGHT);
            podzialka5.setEye(Configuration.EYE_RIGHT);
            podzialka6.setEye(Configuration.EYE_RIGHT);
            podzialka7.setEye(Configuration.EYE_LEFT);
            podzialka8.setEye(Configuration.EYE_LEFT);
            podzialka9.setEye(Configuration.EYE_LEFT);
            podzialka10.setEye(Configuration.EYE_LEFT);
            podzialka11.setEye(Configuration.EYE_LEFT);
            podzialka12.setEye(Configuration.EYE_LEFT);
        }else{
            w1.setEye(Configuration.EYE_RIGHT);
            w2.setEye(Configuration.EYE_LEFT);
            w3.setEye(Configuration.EYE_RIGHT);
            w4.setEye(Configuration.EYE_LEFT);
            podzialka1.setEye(Configuration.EYE_LEFT);
            podzialka2.setEye(Configuration.EYE_LEFT);
            podzialka3.setEye(Configuration.EYE_LEFT);
            podzialka4.setEye(Configuration.EYE_LEFT);
            podzialka5.setEye(Configuration.EYE_LEFT);
            podzialka6.setEye(Configuration.EYE_LEFT);
            podzialka7.setEye(Configuration.EYE_RIGHT);
            podzialka8.setEye(Configuration.EYE_RIGHT);
            podzialka9.setEye(Configuration.EYE_RIGHT);
            podzialka10.setEye(Configuration.EYE_RIGHT);
            podzialka11.setEye(Configuration.EYE_RIGHT);
            podzialka12.setEye(Configuration.EYE_RIGHT);
        }
    }
    
    private void calculateResult(){
        result= Integer.toString(w1.getAngle());
        result+= "\u00b0";
        
        result+=" / ";
        result+= Integer.toString(w2.getAngle()-90);
        result+= "\u00b0";

        if(t.testHelper!=null)
            t.testHelper.jTextFieldResult.setText(result);
    } 
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
