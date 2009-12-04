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

/** Test Krzyżowy (Cross Test)*/
public class CrossTest extends JPanel implements KeyListener {
    /* PRYWATNE */
    private RectangleFigure prost1,prost2,prost3,prost4;
    private Test t;
    private int przesPoziome;
    private int przesPionowe;
    private String result;
    private boolean centralCircle;
    private int nrTestu;

    /** konstruktor */
    public CrossTest(UserInterface userInterface, boolean centralCircle) {
        this.centralCircle = centralCircle;
        if(centralCircle){
            nrTestu=TestName.KRZYZOWY_Z_KOLKIEM;
        }else{
            nrTestu=TestName.KRZYZOWY;
        }
        t=new Test(this,userInterface);
        setBounds(t.getCenterPosition());        
        setBackground(Configuration.KOLOR_TLA);

        prost1 = new RectangleFigure(
                Configuration.MAX_X/2-Configuration.SZER_BELKI/2,
                Configuration.MAX_Y/2-Configuration.WYS_BELKI/2-Configuration.SZER_BELKI/2+1,
                Configuration.SZER_BELKI,
                Configuration.WYS_BELKI/2);
        if(centralCircle)
            prost1.setY(prost1.getY()-Configuration.SREDNICA_KOLA_Z_DZIURKA/2);

        prost2 = new RectangleFigure(
                Configuration.MAX_X/2-Configuration.SZER_BELKI/2,
                Configuration.MAX_Y/2+Configuration.SZER_BELKI/2-1,
                Configuration.SZER_BELKI,
                Configuration.WYS_BELKI/2);
        if(centralCircle)
            prost2.setY(prost2.getY()+Configuration.SREDNICA_KOLA_Z_DZIURKA/2);

        prost3 = new RectangleFigure(
                Configuration.MAX_X/2-Configuration.WYS_BELKI/2-Configuration.SZER_BELKI/2,
                Configuration.MAX_Y/2-Configuration.SZER_BELKI/2,
                Configuration.WYS_BELKI/2,
                Configuration.SZER_BELKI);
        if(centralCircle)
            prost3.setX(prost3.getX()-Configuration.SREDNICA_KOLA_Z_DZIURKA/2);

        prost4 = new RectangleFigure(
                Configuration.MAX_X/2+Configuration.SZER_BELKI/2,
                Configuration.MAX_Y/2-Configuration.SZER_BELKI/2,
                Configuration.WYS_BELKI/2,
                Configuration.SZER_BELKI);
        if(centralCircle)
            prost4.setX(prost4.getX()+Configuration.SREDNICA_KOLA_Z_DZIURKA/2);


        // POLARYZACJA WG CENTRALNYCH USTAWIEN
        setPolarisation();

        // OBLICZANIE WYNIKU
        przesPoziome=0;
        przesPionowe=0;
        calculateResult();
        if(t.testHelper!=null)
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(nrTestu));
    }
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Configuration.KOLOR_TESTU);
        prost1.paintComponent(g);
        prost2.paintComponent(g);
        prost3.paintComponent(g);
        prost4.paintComponent(g);

        // WEWNĘTRZNE KOŁO
        if(centralCircle){
            Graphics2D g2 = Graphics2D.class.cast(g);
            g2.setStroke(Configuration.LINIA_SREDNIA);
            g2.drawOval(Configuration.MAX_X/2-Configuration.SREDNICA_KOLA_Z_DZIURKA/2, Configuration.MAX_Y/2-Configuration.SREDNICA_KOLA_Z_DZIURKA/2,Configuration.SREDNICA_KOLA_Z_DZIURKA,Configuration.SREDNICA_KOLA_Z_DZIURKA);
            g2.setStroke(Configuration.LINIA_NORMALNA);
        }
        
        // AKTUALNY WYNIK TESTU
        if(Test.showResult)
            g.drawString(result, Configuration.WYNIK_X, Configuration.WYNIK_Y);
    }

    public void keyPressed(KeyEvent e) {
         switch(e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                t.exit();
                break;
             case KeyEvent.VK_DOWN:
                 przesPionowe+=  -Configuration.STEP;
                 calculateResult();
                 repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                 repaint(prost3.setY(prost3.getY()+Configuration.STEP));
                 repaint(prost4.setY(prost4.getY()+Configuration.STEP));
                 break;
             case KeyEvent.VK_UP:
                 przesPionowe+=   Configuration.STEP;
                 calculateResult();
                 repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                 repaint(prost3.setY(prost3.getY()-Configuration.STEP));
                 repaint(prost4.setY(prost4.getY()-Configuration.STEP));
                 break;
              case KeyEvent.VK_LEFT:
                 przesPoziome+=   -Configuration.STEP;
                 calculateResult();
                 repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                 repaint(prost1.setX(prost1.getX()-Configuration.STEP));
                 repaint(prost2.setX(prost2.getX()-Configuration.STEP));
                 break;
             case KeyEvent.VK_RIGHT:
                 przesPoziome+=   Configuration.STEP;
                 calculateResult();
                 repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                 repaint(prost1.setX(prost1.getX()+Configuration.STEP));
                 repaint(prost2.setX(prost2.getX()+Configuration.STEP));
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
            prost3.setEye(Configuration.EYE_LEFT);
            prost4.setEye(Configuration.EYE_LEFT);
        }else{
            prost1.setEye(Configuration.EYE_LEFT);
            prost2.setEye(Configuration.EYE_LEFT);
            prost3.setEye(Configuration.EYE_RIGHT);
            prost4.setEye(Configuration.EYE_RIGHT);
        }
    }

    private void calculateResult(){
        result=  t.userInterface.getUstawienia().wadaPozioma(przesPoziome);
        result+="' / ";
        result+= t.userInterface.getUstawienia().wadaPionowa(przesPionowe);
        result+="'";
        if(t.testHelper!=null)
            t.testHelper.jTextFieldResult.setText(result);
    }
    

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
