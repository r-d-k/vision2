package pl.rdk.vision2.tests;

import pl.rdk.vision2.library.TestName;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import pl.rdk.vision2.UserInterface;
import pl.rdk.vision2.data.ResultData;
import pl.rdk.vision2.figures.TriangleFigure;
import pl.rdk.vision2.library.Functions;

/** Test Wektograficzny */
public class VectographicTest extends JPanel implements KeyListener {
    private Test t;
    private int nrTrojkata;
    private TriangleFigure trojkat1,  trojkat2,  trojkat3,  trojkat4,  trojkat5;
    private int rozsuniecie;
    private String iloscMinut;
    private String result;
    private String wynikPozytywny;
    private String wynikNegatywny;
    private int pozostaloTestow;
    private ResourceBundle labels;

    /**
     * konstruuje test wektograficzny z 4 trojkatami
     * (jeden z nich losowany do rozsuniecia)
     * @param ui główna klasa programu
     * @param rozsuniecie rozsuniecie trojkatow w pixelach
     */
    public VectographicTest(UserInterface userInterface, String iloscMinut, int rozsuniecie) {
        labels = ResourceBundle.getBundle("pl/rdk/vision2/languages/i18n");
        this.iloscMinut = iloscMinut;
        this.rozsuniecie = rozsuniecie;
        this.pozostaloTestow = userInterface.getUstawienia().getWektograficznePowtorzenia();
        wynikPozytywny = new String(iloscMinut + "' " + labels.getString("pass"));
        wynikNegatywny = new String(iloscMinut + "' " + labels.getString("fail"));

        t = new Test(this, userInterface);
        setBounds(t.getCenterPosition());
        setBackground(Configuration.KOLOR_TLA);

        initComponents();
    }

    private void initComponents() {
        // losowanie, ktory trojkat pokazac przestrzenny
        nrTrojkata = Functions.chooseTriangleDirection();
        switch (nrTrojkata) {
            case TriangleFigure.HOUR_03:
                result = labels.getString("hour03");
                break;
            case TriangleFigure.HOUR_06:
                result = labels.getString("hour06");
                break;
            case TriangleFigure.HOUR_09:
                result = labels.getString("hour09");
                break;
            default:
                result = labels.getString("hour12");
                break;
        }

        // drukujemy wynik
        if(t.testHelper!=null){
            t.testHelper.jTextFieldResult.setText(result);
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(TestName.WEKTOGRAFICZNY) + " " + iloscMinut + "'");
        }

        //wypadl trojkat gorny
        if (nrTrojkata == TriangleFigure.HOUR_12) {
            trojkat1 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_12, Configuration.MAX_X / 2 - rozsuniecie / 2, Configuration.MARGINES);
            trojkat5 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_12, Configuration.MAX_X / 2 + rozsuniecie / 2, Configuration.MARGINES);
        } else {
            trojkat1 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_12, Configuration.MAX_X / 2, Configuration.MARGINES);
        }

        //wypadl trojkat prawy
        if (nrTrojkata == TriangleFigure.HOUR_03) {
            trojkat2 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_03, Configuration.MAX_X - Configuration.ROZNICA - Configuration.MARGINES - rozsuniecie / 2, Configuration.MAX_Y / 2);
            trojkat5 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_03, Configuration.MAX_X - Configuration.ROZNICA - Configuration.MARGINES + rozsuniecie / 2, Configuration.MAX_Y / 2);
        } else {
            trojkat2 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_03, Configuration.MAX_X - Configuration.ROZNICA - Configuration.MARGINES, Configuration.MAX_Y / 2);
        }

        //wypadl trojkat dolny
        if (nrTrojkata == TriangleFigure.HOUR_06) {
            trojkat3 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_06, Configuration.MAX_X / 2 - rozsuniecie / 2, Configuration.MAX_Y - Configuration.MARGINES);
            trojkat5 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_06, Configuration.MAX_X / 2 + rozsuniecie / 2, Configuration.MAX_Y - Configuration.MARGINES);
        } else {
            trojkat3 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_06, Configuration.MAX_X / 2, Configuration.MAX_Y - Configuration.MARGINES);
        }

        //wypadl trojkat lewy
        if (nrTrojkata == TriangleFigure.HOUR_09) {
            trojkat4 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_09, Configuration.ROZNICA + Configuration.MARGINES - rozsuniecie / 2, Configuration.MAX_Y / 2);
            trojkat5 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_09, Configuration.ROZNICA + Configuration.MARGINES + rozsuniecie / 2, Configuration.MAX_Y / 2);
        } else {
            trojkat4 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_09, Configuration.ROZNICA + Configuration.MARGINES, Configuration.MAX_Y / 2);
        }

        // POLARYZACJA WG CENTRALNYCH USTAWIEN
        setPolarisation();

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Configuration.KOLOR_TESTU);

        // WEWNĘTRZNE I ZEWNĘTRZNE KOŁA
        g2.setColor(Configuration.KOLOR_TESTU);
        // rysujemy zewnetrze kolo
        g2.setStroke(Configuration.LINIA_GRUBA);
        g2.drawOval(Configuration.MAX_X / 2 - Configuration.MAX_Y / 2 - Configuration.LINIA_GRUBA_INT / 2, -Configuration.LINIA_GRUBA_INT / 2, Configuration.MAX_Y + Configuration.LINIA_GRUBA_INT, Configuration.MAX_Y + Configuration.LINIA_GRUBA_INT);
        // powracamy do standardowej grubosci lini
        g2.setStroke(Configuration.LINIA_NORMALNA);

        // TRÓJKĄTY
        trojkat1.paintComponent(g);
        trojkat2.paintComponent(g);
        trojkat3.paintComponent(g);
        trojkat4.paintComponent(g);
        trojkat5.paintComponent(g);

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
            case KeyEvent.VK_UP:
                if (nrTrojkata == TriangleFigure.HOUR_12) {
                    result = wynikPozytywny;
                } else {
                    result = wynikNegatywny;
                }
                sendResult();
                break;
            case KeyEvent.VK_DOWN:
                if (nrTrojkata == TriangleFigure.HOUR_06) {
                    result = wynikPozytywny;
                } else {
                    result = wynikNegatywny;
                }
                sendResult();
                break;
            case KeyEvent.VK_LEFT:
                if (nrTrojkata == TriangleFigure.HOUR_09) {
                    result = wynikPozytywny;
                } else {
                    result = wynikNegatywny;
                }
                sendResult();
                break;
            case KeyEvent.VK_RIGHT:
                if (nrTrojkata == TriangleFigure.HOUR_03) {
                    result = wynikPozytywny;
                } else {
                    result = wynikNegatywny;
                }
                sendResult();
                break;
            case KeyEvent.VK_SPACE:
                Test.showResult = !Test.showResult;
                t.userInterface.jCheckBoxMenuItemShowResult.setState(Test.showResult);
                repaint(Configuration.WYNIK_X, Configuration.WYNIK_Y - Configuration.WYNIK_WYS, Configuration.WYNIK_X + Configuration.WYNIK_SZER, Configuration.WYNIK_Y + 2 * Configuration.OFFSET);
                break;
            case KeyEvent.VK_P:
                Test.polarisationChanged = ! Test.polarisationChanged;
                t.userInterface.jCheckBoxMenuItemPolarisationChanged.setState(Test.polarisationChanged);
                setPolarisation();
                repaint();
                break;
        }
    }

    private void setPolarisation() {
        if (Test.polarisationChanged==false) {
            //wypadl trojkat gorny
            if (nrTrojkata == TriangleFigure.HOUR_12) {
                trojkat1.setEye(Configuration.EYE_LEFT);
                trojkat5.setEye(Configuration.EYE_RIGHT);
            } else {
                trojkat1.setEye(Configuration.EYE_BOTH);
            }

            //wypadl trojkat prawy
            if (nrTrojkata == TriangleFigure.HOUR_03) {
                trojkat2.setEye(Configuration.EYE_LEFT);
                trojkat5.setEye(Configuration.EYE_RIGHT);
            } else {
                trojkat2.setEye(Configuration.EYE_BOTH);
            }

            //wypadl trojkat dolny
            if (nrTrojkata == TriangleFigure.HOUR_06) {
                trojkat3.setEye(Configuration.EYE_LEFT);
                trojkat5.setEye(Configuration.EYE_RIGHT);
            } else {
                trojkat3.setEye(Configuration.EYE_BOTH);
            }

            //wypadl trojkat lewy
            if (nrTrojkata == TriangleFigure.HOUR_09) {
                trojkat4.setEye(Configuration.EYE_LEFT);
                trojkat5.setEye(Configuration.EYE_RIGHT);
            } else {
                trojkat4.setEye(Configuration.EYE_BOTH);
            }
        } else {
            //wypadl trojkat gorny
            if (nrTrojkata == TriangleFigure.HOUR_12) {
                trojkat1.setEye(Configuration.EYE_RIGHT);
                trojkat5.setEye(Configuration.EYE_LEFT);
            } else {
                trojkat1.setEye(Configuration.EYE_BOTH);
            }

            //wypadl trojkat prawy
            if (nrTrojkata == TriangleFigure.HOUR_03) {
                trojkat2.setEye(Configuration.EYE_RIGHT);
                trojkat5.setEye(Configuration.EYE_LEFT);
            } else {
                trojkat2.setEye(Configuration.EYE_BOTH);
            }

            //wypadl trojkat dolny
            if (nrTrojkata == TriangleFigure.HOUR_06) {
                trojkat3.setEye(Configuration.EYE_RIGHT);
                trojkat5.setEye(Configuration.EYE_LEFT);
            } else {
                trojkat3.setEye(Configuration.EYE_BOTH);
            }

            //wypadl trojkat lewy
            if (nrTrojkata == TriangleFigure.HOUR_09) {
                trojkat4.setEye(Configuration.EYE_RIGHT);
                trojkat5.setEye(Configuration.EYE_LEFT);
            } else {
                trojkat4.setEye(Configuration.EYE_BOTH);
            }
        }
    }

    private void sendResult() {
        t.userInterface.getPacjent().addWynikTestu(new ResultData(TestName.WEKTOGRAFICZNY, result));
        t.userInterface.getModelTabeli().fireTableStructureChanged();
        pozostaloTestow--;
        if (pozostaloTestow > 0) {
            initComponents();
            repaint();
        } else {
            t.exit();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
