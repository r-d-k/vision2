package pl.rdk.vision2.tests;

import pl.rdk.vision2.library.TestName;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import pl.rdk.vision2.UserInterface;
import pl.rdk.vision2.data.ResultData;
import pl.rdk.vision2.figures.TriangleFigure;
import pl.rdk.vision2.library.Functions;

/** Test Punktów Przypadkowych (Random Dot Test) */
public class RandomDotTest extends JPanel implements KeyListener {

    private Test t;
    private BufferedImage imageRandomBackgroud,  imageWithTriangles;
    private int nrTrojkata;
    private int rozsuniecie;
    private String iloscMinut;
    private String result;
    private String wynikPozytywny;
    private String wynikNegatywny;
    private int pozostaloTestow;
    private TriangleFigure trojkat1,  trojkat2;
    private ResourceBundle labels;

    /** konstruktor */
    public RandomDotTest(UserInterface userInterface, String iloscMinut, int rozsuniecie) {
        labels = ResourceBundle.getBundle("pl/rdk/vision2/languages/i18n");
        this.iloscMinut = iloscMinut;
        this.rozsuniecie = rozsuniecie;
        wynikPozytywny = new String(iloscMinut + "' " + labels.getString("pass"));
        wynikNegatywny = new String(iloscMinut + "' " + labels.getString("fail"));
        this.pozostaloTestow = userInterface.getUstawienia().getKropkowePowtorzenia();

        t = new Test(this, userInterface);
        setBounds(t.getCenterPosition());
        setBackground(Configuration.KOLOR_TLA);
        initComponents();
    }

    private void initComponents() {
        // przygotowanie losowego tła
        imageRandomBackgroud = prepareRandomBackgroud();
        // wylosowanie numeru jednego z czterech trójkątów
        nrTrojkata = Functions.chooseTriangleDirection();
        // stworzenie dwóch trójkątów
        createTriangles();
        // drukujemy wynik
        if(t.testHelper!=null){
            t.testHelper.jTextFieldResult.setText(result);
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(TestName.KROPKOWY) + " " + iloscMinut + "'");
        }
        // ustawienie polaryzacji trójkątów wg ustawień globalnych
        setPolarisation();
        // rozsunięcie trójkątów (jednego w lewo, drugiego w prawo)
        ustawRozsuniecieTrojkata(trojkat1);
        ustawRozsuniecieTrojkata(trojkat2);
        // wrysowanie trójkątów na losowe tło stworzone wcześniej
        imageWithTriangles = drawTriangleOnPicture(imageRandomBackgroud);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Configuration.KOLOR_TESTU);

        //OBRAZEK
        g2.drawImage(imageWithTriangles, null, 0, 0);
        // ZEWNĘTRZNE KOŁO
        g2.setStroke(Configuration.LINIA_GRUBA);
        g2.drawOval(Configuration.MAX_X / 2 - Configuration.MAX_Y / 2 - Configuration.LINIA_GRUBA_INT / 2, -Configuration.LINIA_GRUBA_INT / 2, Configuration.MAX_Y + Configuration.LINIA_GRUBA_INT, Configuration.MAX_Y + Configuration.LINIA_GRUBA_INT);
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
                // CENTRALNA ZMIANA POLARYZACJI
                Test.polarisationChanged = ! Test.polarisationChanged;
                t.userInterface.jCheckBoxMenuItemPolarisationChanged.setState(Test.polarisationChanged);
                // LOKALNA ZMIANA POLARYZACJI
                // stworzenie dwóch trójkątów
                createTriangles();
                // ustawienie polaryzacji trójkątów wg ustawień globalnych
                setPolarisation();
                // rozsunięcie trójkątów (jednego w lewo, drugiego w prawo)
                ustawRozsuniecieTrojkata(trojkat1);
                ustawRozsuniecieTrojkata(trojkat2);
                // wrysowanie trójkątów na losowe tło stworzone wcześniej
                imageWithTriangles = drawTriangleOnPicture(imageRandomBackgroud);
                repaint();
                break;
        }
    }

    private void createTriangles() {
        switch (nrTrojkata) {
            case TriangleFigure.HOUR_12:
                trojkat1 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_12, Configuration.MAX_X / 2, Configuration.MARGINES);
                trojkat2 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_12, Configuration.MAX_X / 2, Configuration.MARGINES);
                result = labels.getString("hour12");
                break;
            case TriangleFigure.HOUR_03:
                trojkat1 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_03, Configuration.MAX_X - Configuration.ROZNICA - Configuration.MARGINES, Configuration.MAX_Y / 2);
                trojkat2 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_03, Configuration.MAX_X - Configuration.ROZNICA - Configuration.MARGINES, Configuration.MAX_Y / 2);
                result = labels.getString("hour03");
                break;
            case TriangleFigure.HOUR_06:
                trojkat1 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_06, Configuration.MAX_X / 2, Configuration.MAX_Y - Configuration.MARGINES);
                trojkat2 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_06, Configuration.MAX_X / 2, Configuration.MAX_Y - Configuration.MARGINES);
                result = labels.getString("hour06");
                break;
            default: //HOUR_09
                trojkat1 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_09, Configuration.ROZNICA + Configuration.MARGINES, Configuration.MAX_Y / 2);
                trojkat2 = new TriangleFigure(Configuration.BOK_TROJKATA, TriangleFigure.HOUR_09, Configuration.ROZNICA + Configuration.MARGINES, Configuration.MAX_Y / 2);
                result = labels.getString("hour09");
                break;
        }
    }

    private BufferedImage prepareRandomBackgroud() {
        // utworzenie obiektu obrazka
        BufferedImage result = new BufferedImage(Configuration.MAX_X, Configuration.MAX_Y, BufferedImage.TYPE_INT_RGB);
        Graphics2D grafika = result.createGraphics();
        // wypełnienie kolorem tła (czarnym)
        grafika.setPaint(Configuration.KOLOR_TLA);
        grafika.fillRect(0, 0, Configuration.MAX_X, Configuration.MAX_Y);
        grafika.setPaint(Configuration.KOLOR_TESTU);
        // pokrycie kropkami (białymi)
        Random rand = new Random();
        for (int j = 0; j < Configuration.MAX_Y; j += Configuration.ZIARNISTOSC) {
            for (int i = Configuration.ROZNICA; i < Configuration.MAX_X - Configuration.ROZNICA; i += Configuration.ZIARNISTOSC) {
                if (rand.nextDouble() < Configuration.GESTOSC) {
                    grafika.fillRect(i, j, Configuration.ZIARNISTOSC, Configuration.ZIARNISTOSC);
                }
            }
        }
        // zwracamy result
        return result;
    }

    private BufferedImage drawTriangleOnPicture(BufferedImage image) {
        // tworzymy nowy obrazek, żeby nie rysować na starym
        BufferedImage result = new BufferedImage(Configuration.MAX_X, Configuration.MAX_Y, BufferedImage.TYPE_INT_RGB);
        image.copyData(result.getRaster());

        // tworzymy obiekt Graphics2D z obrazka
        Graphics2D grafika = result.createGraphics();

        //pobieramy zawartosc prostokąta opisanego na lewym trójkącie
        Rectangle obszar = trojkat1.getBounds();
        BufferedImage subImage = result.getSubimage(obszar.x, obszar.y, obszar.width, obszar.height);
        // ograniczamy rysowanie do prawego trójkąta (poprzez założenie maski)
        grafika.setClip(trojkat2.getPath());
        // przerysowujemy parzyste linie z lewego kwadratu na nieparzyste linie w prawym kwadracie
        // (ale obszar spoza trójkąta jest zamaskowany)
        obszar = trojkat2.getBounds();
        for (int j = 0; j < subImage.getHeight(); j = j + 2) {
            for (int i = 0; i < subImage.getWidth(); i++) {
                grafika.setPaint(new Color(subImage.getRGB(i, j)));
                grafika.drawLine(obszar.x + i, obszar.y + j + 1, obszar.x + i, obszar.y + j + 1);
            }
        }


        // zwracamy result
        return result;
    }

    private void setPolarisation() {
        if (Test.polarisationChanged==false) {
            trojkat1.setEye(Configuration.EYE_LEFT);
            trojkat2.setEye(Configuration.EYE_RIGHT);
        } else {
            trojkat1.setEye(Configuration.EYE_RIGHT);
            trojkat2.setEye(Configuration.EYE_LEFT);
        }
    }

    private void ustawRozsuniecieTrojkata(TriangleFigure trojkat) {
        if (trojkat.getEye() == Configuration.EYE_LEFT) {
            trojkat.setX(trojkat.getX() - rozsuniecie / 2);
        } else {
            trojkat.setX(trojkat.getX() + rozsuniecie / 2);
        }
    }

    private void sendResult() {
        t.userInterface.getPacjent().addWynikTestu(new ResultData(TestName.KROPKOWY, result));
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
