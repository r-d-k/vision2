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

/** Pionowy Test Wskazówkowy (Verical Pointer test) */
public class PointerTest_Vertical extends JPanel implements KeyListener {
    private Test t;
    private pl.rdk.vision2.figures.RectangleFigure podzialka1, podzialka2, podzialka3, podzialka4, podzialka5, podzialka6;
    private String result;
    private int przesPionowe;
    private Pointer w1,  w2;
      
    /** konstruktor */
    public PointerTest_Vertical(UserInterface userInterface) {
        t=new Test(this,userInterface);
        setBounds(t.getCenterPosition());
        setBackground(Configuration.KOLOR_TLA);

        // WSKAZOWKI
        w1=new Pointer(Configuration.MAX_X/2, Configuration.MAX_Y/2, Configuration.POINTER_SMALLER_RADIUS, Configuration.POINTER_BIGGER_RADIUS, 0);
        w2=new Pointer(Configuration.MAX_X/2, Configuration.MAX_Y/2, Configuration.POINTER_SMALLER_RADIUS, Configuration.POINTER_BIGGER_RADIUS, 180);

        // PODZIALKI LEWE
        podzialka1 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.ROZNICA,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2-2*Configuration.ODSTEP,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        podzialka2 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.ROZNICA,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        podzialka3 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.ROZNICA,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2+2*Configuration.ODSTEP,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);

        // PODZIALKI PRAWE
        podzialka4 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.MAX_X-Configuration.ROZNICA-Configuration.WYS_PODZIALKI,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2-2*Configuration.ODSTEP,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        podzialka5 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.MAX_X-Configuration.ROZNICA-Configuration.WYS_PODZIALKI,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);
        podzialka6 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.MAX_X-Configuration.ROZNICA-Configuration.WYS_PODZIALKI,Configuration.MAX_Y/2-Configuration.SZER_PODZIALKI/2+2*Configuration.ODSTEP,Configuration.WYS_PODZIALKI,Configuration.SZER_PODZIALKI);

        // POLARYZACJA WG CENTRALNYCH USTAWIEN
        setPolarisation();

        // WYNIK
        przesPionowe=0;
        calculateResult();
        if(t.testHelper!=null)
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(TestName.WSKAZOWKOWY_PIONOWY));
    }
        
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D) g;
        super.paintComponent(g2);

        // WSKAZÓWKI
        g2.setColor(Configuration.KOLOR_TESTU);
        w1.paintComponent(g2); //prawa
        w2.paintComponent(g2); //lewa
        
        // PODZIAŁKI (dla prawego oka - linie parzyste)
        podzialka1.paintComponent(g2);
        podzialka2.paintComponent(g2);
        podzialka3.paintComponent(g2);
        podzialka4.paintComponent(g2);
        podzialka5.paintComponent(g2);
        podzialka6.paintComponent(g2);
               
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
                przesPionowe+= + Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET); 
                repaint(w1.setCenterY(w1.getCenterY()-Configuration.STEP));
                repaint(w2.setCenterY(w2.getCenterY()-Configuration.STEP));
                break;
             case KeyEvent.VK_DOWN:
                przesPionowe+= - Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET); 
                repaint(w1.setCenterY(w1.getCenterY()+Configuration.STEP));
                repaint(w2.setCenterY(w2.getCenterY()+Configuration.STEP));
                 break;
             case KeyEvent.VK_ENTER:
                 t.userInterface.getPacjent().addWynikTestu(new ResultData(TestName.WSKAZOWKOWY_PIONOWY,result));
                 t.userInterface.getModelTabeli().fireTableStructureChanged();
                 t.exit();
                 break;
             case KeyEvent.VK_P:
                // centralna zamiana polaryzacji
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
        }
    }
    
    private void setPolarisation() {
        if (Test.polarisationChanged==false) {
            w1.setEye(Configuration.EYE_LEFT);
            w2.setEye(Configuration.EYE_LEFT);
            podzialka1.setEye(Configuration.EYE_RIGHT);
            podzialka2.setEye(Configuration.EYE_RIGHT);
            podzialka3.setEye(Configuration.EYE_RIGHT);
            podzialka4.setEye(Configuration.EYE_RIGHT);
            podzialka5.setEye(Configuration.EYE_RIGHT);
            podzialka6.setEye(Configuration.EYE_RIGHT);
        } else {
            w1.setEye(Configuration.EYE_RIGHT);
            w2.setEye(Configuration.EYE_RIGHT);
            podzialka1.setEye(Configuration.EYE_LEFT);
            podzialka2.setEye(Configuration.EYE_LEFT);
            podzialka3.setEye(Configuration.EYE_LEFT);
            podzialka4.setEye(Configuration.EYE_LEFT);
            podzialka5.setEye(Configuration.EYE_LEFT);
            podzialka6.setEye(Configuration.EYE_LEFT);
        }
    }

    private void calculateResult(){
        result = t.userInterface.getUstawienia().wadaPionowa(przesPionowe);
        result+= "'";

        if(t.testHelper!=null)
            t.testHelper.jTextFieldResult.setText(result);
    }    
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
