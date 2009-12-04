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

/** Test klamrowy poziomy (Horizontal Rectangle Test) */
public class BracketTest_Horizontal extends JPanel implements KeyListener {

    private RectangleFigure prost1,  prost2,  prost3,  prost4,  prost5,  prost6;
    private Test t;
    private String result;
    private int przesPoziome;
    private int szerRuchomejBelki;
    private boolean centralCircle;
    private int nrTestu;

    /** konstruktor */
    public BracketTest_Horizontal(UserInterface userInterface, boolean centralCircle) {
        this.centralCircle = centralCircle;
        if(centralCircle){
            nrTestu=TestName.KLAMROWY_POZIOMY_Z_KOLKIEM;
        }else{
            nrTestu=TestName.KLAMROWY_POZIOMY;
        }
        t = new Test(this, userInterface);
        setBounds(t.getCenterPosition());
        setBackground(Configuration.KOLOR_TLA);

        prost1 = new RectangleFigure(Configuration.MAX_X / 2 - Configuration.WYS_BELKI / 2, Configuration.MAX_Y / 2 - Configuration.WYS_BELKI / 2, Configuration.WYS_BELKI, Configuration.SZER_BELKI);
        prost2 = new RectangleFigure(Configuration.MAX_X / 2 - Configuration.WYS_BELKI / 2, Configuration.MAX_Y / 2 - Configuration.WYS_BELKI / 2 + Configuration.SZER_BELKI, Configuration.SZER_BELKI, Configuration.WYS_BELKI / 2 - Configuration.SZER_BELKI - Configuration.SZER_BELKI / 2);
        prost3 = new RectangleFigure(Configuration.MAX_X / 2 + Configuration.WYS_BELKI / 2 - Configuration.SZER_BELKI, Configuration.MAX_Y / 2 - Configuration.WYS_BELKI / 2 + Configuration.SZER_BELKI, Configuration.SZER_BELKI, Configuration.WYS_BELKI / 2 - Configuration.SZER_BELKI - Configuration.SZER_BELKI / 2);
        prost4 = new RectangleFigure(Configuration.MAX_X / 2 - Configuration.WYS_BELKI / 2, Configuration.MAX_Y / 2 + Configuration.WYS_BELKI / 2 - Configuration.SZER_BELKI, Configuration.WYS_BELKI, Configuration.SZER_BELKI);
        prost5 = new RectangleFigure(Configuration.MAX_X / 2 - Configuration.WYS_BELKI / 2, Configuration.MAX_Y / 2 + Configuration.SZER_BELKI / 2, Configuration.SZER_BELKI, Configuration.WYS_BELKI / 2 - Configuration.SZER_BELKI - Configuration.SZER_BELKI / 2);
        prost6 = new RectangleFigure(Configuration.MAX_X / 2 + Configuration.WYS_BELKI / 2 - Configuration.SZER_BELKI, Configuration.MAX_Y / 2 + Configuration.SZER_BELKI / 2, Configuration.SZER_BELKI, Configuration.WYS_BELKI / 2 - Configuration.SZER_BELKI - Configuration.SZER_BELKI / 2);

        // POLARYZACJA WG CENTRALNYCH USTAWIEN
        setPolarisation();

        // OBLICZANIE WYNIKU
        przesPoziome = 0;
        szerRuchomejBelki = Configuration.WYS_BELKI;
        calculateResult();
        if (t.testHelper != null) {
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(nrTestu));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Configuration.KOLOR_TESTU);
        if (centralCircle) {
            g2.setStroke(Configuration.LINIA_SREDNIA);
            g2.drawOval(Configuration.MAX_X / 2 - Configuration.SREDNICA_KOLA_Z_DZIURKA / 2, Configuration.MAX_Y / 2 - Configuration.SREDNICA_KOLA_Z_DZIURKA / 2, Configuration.SREDNICA_KOLA_Z_DZIURKA, Configuration.SREDNICA_KOLA_Z_DZIURKA);
            g2.setStroke(Configuration.LINIA_NORMALNA);
        }
        prost1.paintComponent(g2);
        prost2.paintComponent(g2);
        prost3.paintComponent(g2);
        prost4.paintComponent(g2);
        prost5.paintComponent(g2);
        prost6.paintComponent(g2);
        if (Test.showResult) {
            g.drawString(result, Configuration.WYNIK_X, Configuration.WYNIK_Y);
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                t.exit();
                break;
            case KeyEvent.VK_LEFT:
                przesPoziome += -Configuration.PIXEL;
                calculateResult();
                repaint(Configuration.WYNIK_X, Configuration.WYNIK_Y - Configuration.WYNIK_WYS, Configuration.WYNIK_X + Configuration.WYNIK_SZER, Configuration.WYNIK_Y + 2 * Configuration.OFFSET);
                // przesuwamy dół w lewo
                prost4.przesun(this, -Configuration.PIXEL, 0);
                prost5.przesun(this, -Configuration.PIXEL, 0);
                prost6.przesun(this, -Configuration.PIXEL, 0);
                break;
            case KeyEvent.VK_DOWN:
                szerRuchomejBelki += -2 * Configuration.PIXEL;
                calculateResult();
                repaint(Configuration.WYNIK_X, Configuration.WYNIK_Y - Configuration.WYNIK_WYS, Configuration.WYNIK_X + Configuration.WYNIK_SZER, Configuration.WYNIK_Y + 2 * Configuration.OFFSET);
                // zmnieszamy dół
                prost4.przesun(this, Configuration.PIXEL, 0);
                prost4.setWidth(prost4.getWidth() - 2 * Configuration.PIXEL);
                prost5.przesun(this, +Configuration.PIXEL, 0);
                prost6.przesun(this, -Configuration.PIXEL, 0);
                break;
            case KeyEvent.VK_RIGHT:
                przesPoziome += Configuration.PIXEL;
                calculateResult();
                repaint(Configuration.WYNIK_X, Configuration.WYNIK_Y - Configuration.WYNIK_WYS, Configuration.WYNIK_X + Configuration.WYNIK_SZER, Configuration.WYNIK_Y + 2 * Configuration.OFFSET);
                // przesuwamy dół w prawo
                prost4.przesun(this, Configuration.PIXEL, 0);
                prost5.przesun(this, Configuration.PIXEL, 0);
                prost6.przesun(this, Configuration.PIXEL, 0);
                break;
            case KeyEvent.VK_UP:
                szerRuchomejBelki += +2 * Configuration.PIXEL;
                calculateResult();
                repaint(Configuration.WYNIK_X, Configuration.WYNIK_Y - Configuration.WYNIK_WYS, Configuration.WYNIK_X + Configuration.WYNIK_SZER, Configuration.WYNIK_Y + 2 * Configuration.OFFSET);
                // zwiększamy dół 
                prost4.przesun(this, -Configuration.PIXEL, 0);
                prost4.setWidth(prost4.getWidth() + 2 * Configuration.PIXEL);
                prost5.przesun(this, -Configuration.PIXEL, 0);
                prost6.przesun(this, +Configuration.PIXEL, 0);
                break;
            case KeyEvent.VK_P:
                Test.polarisationChanged = !Test.polarisationChanged;
                t.userInterface.jCheckBoxMenuItemPolarisationChanged.setState(Test.polarisationChanged);
                setPolarisation();
                repaint();
                break;
            case KeyEvent.VK_SPACE:
                Test.showResult = !Test.showResult;
                t.userInterface.jCheckBoxMenuItemShowResult.setState(Test.showResult);
                repaint(Configuration.WYNIK_X, Configuration.WYNIK_Y - Configuration.WYNIK_WYS, Configuration.WYNIK_X + Configuration.WYNIK_SZER, Configuration.WYNIK_Y + 2 * Configuration.OFFSET);
                break;
            case KeyEvent.VK_ENTER:
                t.userInterface.getPacjent().addWynikTestu(new ResultData(nrTestu, result));
                t.userInterface.getModelTabeli().fireTableStructureChanged();
                t.exit();
                break;
        }
    }

    private void setPolarisation() {
        if (Test.polarisationChanged == false) {
            prost1.setEye(Configuration.EYE_RIGHT);
            prost2.setEye(Configuration.EYE_RIGHT);
            prost3.setEye(Configuration.EYE_RIGHT);
            prost4.setEye(Configuration.EYE_LEFT);
            prost5.setEye(Configuration.EYE_LEFT);
            prost6.setEye(Configuration.EYE_LEFT);
        } else {
            prost1.setEye(Configuration.EYE_LEFT);
            prost2.setEye(Configuration.EYE_LEFT);
            prost3.setEye(Configuration.EYE_LEFT);
            prost4.setEye(Configuration.EYE_RIGHT);
            prost5.setEye(Configuration.EYE_RIGHT);
            prost6.setEye(Configuration.EYE_RIGHT);
        }
    }

    private void calculateResult() {
        result = t.userInterface.getUstawienia().wadaPionowa(przesPoziome);
        result += "' / ";
        result += t.userInterface.getUstawienia().anizejkonia(szerRuchomejBelki, Configuration.WYS_BELKI);
        result += "%";
        if (t.testHelper != null) {
            t.testHelper.jTextFieldResult.setText(result);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
