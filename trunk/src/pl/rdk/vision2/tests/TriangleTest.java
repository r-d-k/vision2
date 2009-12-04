package pl.rdk.vision2.tests;

import pl.rdk.vision2.library.TestName;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import pl.rdk.vision2.UserInterface;
import pl.rdk.vision2.data.ResultData;
import pl.rdk.vision2.figures.TriangleFigure;

/** Test trójkątny (TriangleFigure Test)*/
public class TriangleTest extends JPanel implements KeyListener {
    private Test t;
    private TriangleFigure trojkat1, trojkat2, trojkat3, trojkat4;
    private String result;
    private int rozsuniecie;
     
    /** konstruktor */
    public TriangleTest(UserInterface userInterface) {
        t=new Test(this,userInterface);
        setBounds(t.getCenterPosition());
        setBackground(Configuration.KOLOR_TLA);

        // WYNIK
        rozsuniecie=userInterface.getUstawienia().rozsuniecieParzyste(Configuration.ROZSUNIECIE); //poczatkowo 10'
        calculateResult();
        
        // oba trójkąty wystają
        trojkat1=new TriangleFigure(Configuration.BOK_TROJKATA,TriangleFigure.HOUR_06, Configuration.MAX_X/2-rozsuniecie/2,Configuration.MARGINES+Configuration.WYSOKOSC_TROJKATA);
        trojkat2=new TriangleFigure(Configuration.BOK_TROJKATA,TriangleFigure.HOUR_06, Configuration.MAX_X/2+rozsuniecie/2,Configuration.MARGINES+Configuration.WYSOKOSC_TROJKATA);
        trojkat3=new TriangleFigure(Configuration.BOK_TROJKATA,TriangleFigure.HOUR_12,Configuration.MAX_X/2-rozsuniecie/2,Configuration.MAX_Y-Configuration.MARGINES-Configuration.WYSOKOSC_TROJKATA);
        trojkat4=new TriangleFigure(Configuration.BOK_TROJKATA,TriangleFigure.HOUR_12,Configuration.MAX_X/2+rozsuniecie/2,Configuration.MAX_Y-Configuration.MARGINES-Configuration.WYSOKOSC_TROJKATA);

        // POLARYZACJA WG CENTRALNYCH USTAWIEN
        setPolarisation();
                if(t.testHelper!=null)
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(TestName.TROJKATNY));
    }
        
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Configuration.KOLOR_TESTU);
        g2.fillOval(Configuration.MAX_X/2-Configuration.SREDNICA_PELNEGO_KOLA/2, Configuration.MAX_Y/2-Configuration.SREDNICA_PELNEGO_KOLA/2,Configuration.SREDNICA_PELNEGO_KOLA,Configuration.SREDNICA_PELNEGO_KOLA);
        trojkat1.paintComponent(g);
        trojkat2.paintComponent(g);
        trojkat3.paintComponent(g);
        trojkat4.paintComponent(g);
        
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
                 rozsuniecie+=   -2*Configuration.PIXEL;
                 calculateResult();
                 repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                 
                 repaint(trojkat1.setX(trojkat1.getX() + Configuration.PIXEL));
                 repaint(trojkat2.setX(trojkat2.getX() - Configuration.PIXEL));
                 repaint(trojkat3.setX(trojkat3.getX() + Configuration.PIXEL));
                 repaint(trojkat4.setX(trojkat4.getX() - Configuration.PIXEL));
                break;
             case KeyEvent.VK_UP:
                 rozsuniecie+=   +2*Configuration.PIXEL;
                 calculateResult();
                 repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                 
                 repaint(trojkat1.setX(trojkat1.getX() - Configuration.PIXEL));
                 repaint(trojkat2.setX(trojkat2.getX() + Configuration.PIXEL));
                 repaint(trojkat3.setX(trojkat3.getX() - Configuration.PIXEL));
                 repaint(trojkat4.setX(trojkat4.getX() + Configuration.PIXEL));
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
                 t.userInterface.getPacjent().addWynikTestu(new ResultData(TestName.TROJKATNY,result));
                 t.userInterface.getModelTabeli().fireTableStructureChanged();
                 t.exit();
                 break;
        }
    }

    private void setPolarisation(){
        if(Test.polarisationChanged==false){
            trojkat1.setEye(Configuration.EYE_LEFT);
            trojkat2.setEye(Configuration.EYE_RIGHT);
            trojkat3.setEye(Configuration.EYE_LEFT);
            trojkat4.setEye(Configuration.EYE_RIGHT);
        }else{
            trojkat1.setEye(Configuration.EYE_RIGHT);
            trojkat2.setEye(Configuration.EYE_LEFT);
            trojkat3.setEye(Configuration.EYE_RIGHT);
            trojkat4.setEye(Configuration.EYE_LEFT);
        }
    }

    private void calculateResult(){
        result=  t.userInterface.getUstawienia().wadaPozioma(rozsuniecie);
        result+="'";

        if(t.testHelper!=null)
            t.testHelper.jTextFieldResult.setText(result);
    }    
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
