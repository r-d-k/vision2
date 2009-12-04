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

/** Poziomy Test Wskazówkowy (Horizontal Pointer test) */
public class PointerTest_Horizontal extends JPanel implements KeyListener {

    private Test t;
    private pl.rdk.vision2.figures.RectangleFigure podzialka1,  podzialka2,  podzialka3,  podzialka4,  podzialka5,  podzialka6;
    private String result;
    private int przesPoziome;
    private Pointer w1,  w2;

    /** konstruktor */
    public PointerTest_Horizontal(UserInterface userInterface) {
        t = new Test(this, userInterface);
        setBounds(t.getCenterPosition());
        setBackground(Configuration.KOLOR_TLA);
        
        w1 = new Pointer(Configuration.MAX_X/2, Configuration.MAX_Y/2, Configuration.POINTER_SMALLER_RADIUS, Configuration.POINTER_BIGGER_RADIUS, 90);
        w2 = new Pointer(Configuration.MAX_X/2, Configuration.MAX_Y/2, Configuration.POINTER_SMALLER_RADIUS, Configuration.POINTER_BIGGER_RADIUS, 270);
        
        podzialka1 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.MAX_X / 2 - Configuration.SZER_PODZIALKI / 2 - 2 * Configuration.ODSTEP, 0, Configuration.SZER_PODZIALKI, Configuration.WYS_PODZIALKI);
        podzialka2 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.MAX_X / 2 - Configuration.SZER_PODZIALKI / 2, 0, Configuration.SZER_PODZIALKI, Configuration.WYS_PODZIALKI);
        podzialka3 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.MAX_X / 2 - Configuration.SZER_PODZIALKI / 2 + 2 * Configuration.ODSTEP, 0, Configuration.SZER_PODZIALKI, Configuration.WYS_PODZIALKI);

        podzialka4 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.MAX_X / 2 - Configuration.SZER_PODZIALKI / 2 - 2 * Configuration.ODSTEP, Configuration.MAX_Y - Configuration.WYS_PODZIALKI, Configuration.SZER_PODZIALKI, Configuration.WYS_PODZIALKI);
        podzialka5 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.MAX_X / 2 - Configuration.SZER_PODZIALKI / 2, Configuration.MAX_Y - Configuration.WYS_PODZIALKI, Configuration.SZER_PODZIALKI, Configuration.WYS_PODZIALKI);
        podzialka6 = new pl.rdk.vision2.figures.RectangleFigure(Configuration.MAX_X / 2 - Configuration.SZER_PODZIALKI / 2 + 2 * Configuration.ODSTEP, Configuration.MAX_Y - Configuration.WYS_PODZIALKI, Configuration.SZER_PODZIALKI, Configuration.WYS_PODZIALKI);

        // POLARYZACJA WG CENTRALNYCH USTAWIEN
        setPolarisation();

        // WYNIK
        result = new String();
        przesPoziome = 0;
        calculateResult();
        if(t.testHelper!=null)
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(TestName.WSKAZOWKOWY_POZIOMY));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        // WSKAZÓWKI
        g2.setColor(Configuration.KOLOR_TESTU);
        w1.paintComponent(g2); //dolna
        w2.paintComponent(g2); //gorna

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
        g2.drawOval(Configuration.MAX_X / 2 - Configuration.MAX_Y / 2 - Configuration.LINIA_GRUBA_INT / 2, -Configuration.LINIA_GRUBA_INT / 2, Configuration.MAX_Y + Configuration.LINIA_GRUBA_INT, Configuration.MAX_Y + Configuration.LINIA_GRUBA_INT);
        // rysujemy wewnetrzne kolo
        g2.setStroke(Configuration.LINIA_SREDNIA);
        g2.drawOval(Configuration.MAX_X / 2 - Configuration.SREDNICA_KOLA_Z_DZIURKA / 2, Configuration.MAX_Y / 2 - Configuration.SREDNICA_KOLA_Z_DZIURKA / 2, Configuration.SREDNICA_KOLA_Z_DZIURKA, Configuration.SREDNICA_KOLA_Z_DZIURKA);
        // powracamy do standardowej grubosci lini
        g2.setStroke(Configuration.LINIA_NORMALNA);

        // AKTUALNY WYNIK TESTU
        g2.setColor(Configuration.KOLOR_TLA);
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
                repaint(w1.setCenterX(w1.getCenterX()-Configuration.PIXEL));
                repaint(w2.setCenterX(w2.getCenterX()-Configuration.PIXEL));
                repaint();
                break;
            case KeyEvent.VK_RIGHT:
                przesPoziome += +Configuration.PIXEL;
                calculateResult();
                repaint(Configuration.WYNIK_X, Configuration.WYNIK_Y - Configuration.WYNIK_WYS, Configuration.WYNIK_X + Configuration.WYNIK_SZER, Configuration.WYNIK_Y + 2 * Configuration.OFFSET);
                repaint(w1.setCenterX(w1.getCenterX()+Configuration.PIXEL));
                repaint(w2.setCenterX(w2.getCenterX()+Configuration.PIXEL));
                break;
            case KeyEvent.VK_ENTER:
                t.userInterface.getPacjent().addWynikTestu(new ResultData(TestName.WSKAZOWKOWY_POZIOMY, result));
                t.userInterface.getModelTabeli().fireTableStructureChanged();
                t.exit();
                break;
            case KeyEvent.VK_P:
                Test.polarisationChanged = ! Test.polarisationChanged;
                t.userInterface.jCheckBoxMenuItemPolarisationChanged.setState(Test.polarisationChanged);
                setPolarisation();
                repaint();
                break;
            case KeyEvent.VK_SPACE:
                Test.showResult = !Test.showResult;
                t.userInterface.jCheckBoxMenuItemShowResult.setState(Test.showResult);
                repaint(Configuration.WYNIK_X, Configuration.WYNIK_Y - Configuration.WYNIK_WYS, Configuration.WYNIK_X + Configuration.WYNIK_SZER, Configuration.WYNIK_Y + 2 * Configuration.OFFSET);
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

    private void calculateResult() {
        result = t.userInterface.getUstawienia().wadaPozioma(przesPoziome);
        result += "'";

        if(t.testHelper!=null)
            t.testHelper.jTextFieldResult.setText(result);
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
