package pl.rdk.vision2.tests;

import pl.rdk.vision2.library.TestName;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import pl.rdk.vision2.UserInterface;
import pl.rdk.vision2.data.ResultData;
import pl.rdk.vision2.figures.RectangleFigure;


/** Test klamrowy pionowy (Vertical Rectangle Test) */
public class BracketTest_Vertical extends JPanel implements KeyListener {
    private RectangleFigure prost1,prost2,prost3,prost4,prost5,prost6;
    private Test t;
    private String result;
    private int przesPionowe;
    private int wysRuchomejBelki;
    private boolean centralCircle;
    private int nrTestu;
    
    /** konstruktor */
    public BracketTest_Vertical(UserInterface userInterface,boolean centralCircle) {
        this.centralCircle = centralCircle;
        if(centralCircle){
            nrTestu=TestName.KLAMROWY_PIONOWY_Z_KOLKIEM;
        }else{
            nrTestu=TestName.KLAMROWY_PIONOWY;
        }
        t=new Test(this,userInterface);
        setBounds(t.getCenterPosition());
        setBackground(Configuration.KOLOR_TLA);

        prost1 = new RectangleFigure(Configuration.MAX_X/2-Configuration.WYS_BELKI/2,Configuration.MAX_Y/2-Configuration.WYS_BELKI/2,Configuration.SZER_BELKI,Configuration.WYS_BELKI);
        prost2 = new RectangleFigure(Configuration.MAX_X/2-Configuration.WYS_BELKI/2+Configuration.SZER_BELKI,Configuration.MAX_Y/2-Configuration.WYS_BELKI/2,Configuration.WYS_BELKI/2-Configuration.SZER_BELKI-Configuration.SZER_BELKI/2,Configuration.SZER_BELKI);
        prost3 = new RectangleFigure(Configuration.MAX_X/2-Configuration.WYS_BELKI/2+Configuration.SZER_BELKI,Configuration.MAX_Y/2+Configuration.WYS_BELKI/2-Configuration.SZER_BELKI,Configuration.WYS_BELKI/2-Configuration.SZER_BELKI-Configuration.SZER_BELKI/2,Configuration.SZER_BELKI);
        prost4 = new RectangleFigure(Configuration.MAX_X/2+Configuration.WYS_BELKI/2-Configuration.SZER_BELKI,Configuration.MAX_Y/2-Configuration.WYS_BELKI/2,Configuration.SZER_BELKI,Configuration.WYS_BELKI);
        prost5 = new RectangleFigure(Configuration.MAX_X/2+Configuration.SZER_BELKI/2,Configuration.MAX_Y/2-Configuration.WYS_BELKI/2,Configuration.WYS_BELKI/2-Configuration.SZER_BELKI-Configuration.SZER_BELKI/2,Configuration.SZER_BELKI);
        prost6 = new RectangleFigure(Configuration.MAX_X/2+Configuration.SZER_BELKI/2,Configuration.MAX_Y/2+Configuration.WYS_BELKI/2-Configuration.SZER_BELKI,Configuration.WYS_BELKI/2-Configuration.SZER_BELKI-Configuration.SZER_BELKI/2,Configuration.SZER_BELKI);

        // POLARYZACJA WG CENTRALNYCH USTAWIEN
        setPolarisation();

        // OBLICZANIE WYNIKU
        przesPionowe=0;
        wysRuchomejBelki=Configuration.WYS_BELKI;
        calculateResult();
        if(t.testHelper!=null)
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(nrTestu));
    }
        
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Configuration.KOLOR_TESTU);

        // CENTRALNY BODZIEC (PIERSCIEN)
        if(centralCircle){
            g2.setStroke(Configuration.LINIA_SREDNIA);
            g2.drawOval(Configuration.MAX_X/2-Configuration.SREDNICA_KOLA_Z_DZIURKA/2, Configuration.MAX_Y/2-Configuration.SREDNICA_KOLA_Z_DZIURKA/2,Configuration.SREDNICA_KOLA_Z_DZIURKA,Configuration.SREDNICA_KOLA_Z_DZIURKA);
            g2.setStroke(Configuration.LINIA_NORMALNA);
        }

        // KLAMRY
        prost1.paintComponent(g2);
        prost2.paintComponent(g2);
        prost3.paintComponent(g2);
        prost4.paintComponent(g2);
        prost5.paintComponent(g2);
        prost6.paintComponent(g2);
        if(Test.showResult)
            g.drawString(result, Configuration.WYNIK_X, Configuration.WYNIK_Y);
    }

    public void keyPressed(KeyEvent e) {
         switch(e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                t.exit();
                break;
            case KeyEvent.VK_DOWN:
                przesPionowe+= -Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                // przesuwamy lewa strone w dol
                prost4.przesun(this,0,Configuration.STEP);
                prost5.przesun(this,0,Configuration.STEP);
                prost6.przesun(this,0,Configuration.STEP);
                break;               
             case KeyEvent.VK_LEFT:
                wysRuchomejBelki+= -2*Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                // zmnieszamy lewa strone
                prost4.przesun(this,0,+Configuration.STEP);
                prost4.setHeight(prost4.getHeight()-2*Configuration.STEP);
                prost5.przesun(this,0,+Configuration.STEP);
                prost6.przesun(this,0,-Configuration.STEP);
                break;
             case KeyEvent.VK_UP:
                przesPionowe+= +Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                // przesuwamy lewa strone w gore
                prost4.przesun(this,0,-Configuration.STEP);
                prost5.przesun(this,0,-Configuration.STEP);
                prost6.przesun(this,0,-Configuration.STEP);
                break;
             case KeyEvent.VK_RIGHT:
                 wysRuchomejBelki+= +2*Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                // zwiekszamy lewa strone
                prost4.przesun(this,0,-Configuration.STEP);
                prost4.setHeight(prost4.getHeight()+2*Configuration.STEP);
                prost5.przesun(this,0,-Configuration.STEP);
                prost6.przesun(this,0,+Configuration.STEP);
                break;
            case KeyEvent.VK_P:
                Test.polarisationChanged = !Test.polarisationChanged;
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
                t.userInterface.getPacjent().addWynikTestu(new ResultData(nrTestu,result));
                t.userInterface.getModelTabeli().fireTableStructureChanged();
                t.exit();
                break;
        }
    }

    private void setPolarisation(){
        if(Test.polarisationChanged==false){
            prost1.setEye(Configuration.EYE_RIGHT);
            prost2.setEye(Configuration.EYE_RIGHT);
            prost3.setEye(Configuration.EYE_RIGHT);
            prost4.setEye(Configuration.EYE_LEFT);
            prost5.setEye(Configuration.EYE_LEFT);
            prost6.setEye(Configuration.EYE_LEFT);
        }else{
            prost1.setEye(Configuration.EYE_LEFT);
            prost2.setEye(Configuration.EYE_LEFT);
            prost3.setEye(Configuration.EYE_LEFT);
            prost4.setEye(Configuration.EYE_RIGHT);
            prost5.setEye(Configuration.EYE_RIGHT);
            prost6.setEye(Configuration.EYE_RIGHT);
        }
    }

    private void calculateResult(){
        result = t.userInterface.getUstawienia().wadaPionowa(przesPionowe);
        result+= "' / ";
        result+= t.userInterface.getUstawienia().anizejkonia(wysRuchomejBelki, Configuration.WYS_BELKI);
        result+= "%";
        if(t.testHelper!=null)
            t.testHelper.jTextFieldResult.setText(result);
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
