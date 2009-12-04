package pl.rdk.vision2.tests;

import pl.rdk.vision2.library.TestName;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import pl.rdk.vision2.UserInterface;
import pl.rdk.vision2.data.ResultData;
import pl.rdk.vision2.figures.ImageFigure;

/** Symulacja Synoptoforu 
 *
 * Klasa służy do symulacji synoptoforu za pomocą okularów migawkowych.
 * Lewemu i prawego oku wyswietlane są dwa różne obrazki o maksymalnej
 * rozdzielczosci 800*300 (szerokość*wysokość).
 * Drugim obrazkiem można poruszać za pomocą klawiszy ze strzałkami.
 * Obrazki moga byc zapisane w formatach png lub jpg, ale po niewielkich
 * modyfikacjach można obsłużyć również inne formaty.
 */
public class SynoptiscopeTest extends JPanel implements KeyListener {
    private Test t;
    private ImageFigure background,image;
    private String result;
    private int przesPoziome;
    private int przesPionowe;
    private int numer;

    /** konstruktor
     * @param ui User Interface
     * @param numer Numer testu symulujacego synoptofor
     * @param przesX Poczatkowe przesuniecie drugiego obrazka w plaszczyznie poziomej
     * @param przesY Poczatkowe przesuniecie drugiego obrazka w plaszczyznie pionowej
     */
    public SynoptiscopeTest(UserInterface userInterface, int numer, int korektaX, int korektaY) throws Exception {
        // zapamietanie numeru
        this.numer=numer;

        // wczytywanie i ustawienie nieruchomego obrazka
        background = new ImageFigure("/pl/rdk/vision2/images/"+numer+"a");
        background.center(Configuration.MAX_X, Configuration.MAX_Y);
        background.setEye(Configuration.EYE_LEFT);

        // wczytywanie i ustawienie ruchomego obrazka
        image = new ImageFigure("/pl/rdk/vision2/images/"+numer+"b");
        image.center(Configuration.MAX_X, Configuration.MAX_Y);
        image.setX(image.getX()+korektaX);
        image.setY(image.getY()+korektaY);
        image.setEye(Configuration.EYE_RIGHT);

        // to jest poniżej, żeby ewentualne błędy wystąpiły wcześniej
        t = new Test(this, userInterface);
        setBounds(t.getCenterPosition());

        // inicjacja wyniku badania
        przesPoziome=0;
        przesPionowe=0;
        calculateResult();
        if(t.testHelper!=null)
            t.testHelper.jTextFieldDefect.setText(TestName.getTestName().getOpisBadanejWady(numer+13));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        background.paintComponent(g);
        image.paintComponent(g);

        // AKTUALNY WYNIK TESTU
        g.setColor(Color.BLACK);
        if(Test.showResult)
            g.drawString(result, Configuration.WYNIK_X, Configuration.WYNIK_Y);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                t.exit();
                break;
            case KeyEvent.VK_UP:
                repaint(image.setY(image.getY()-Configuration.STEP));
                // result
                przesPionowe+=  +Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                break;
            case KeyEvent.VK_DOWN:
                repaint(image.setY(image.getY()+Configuration.STEP));
                // result
                przesPionowe+=  -Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                break;
            case KeyEvent.VK_LEFT:
                repaint(image.setX(image.getX()-Configuration.STEP));
                // result
                przesPoziome+=  -Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                break;
            case KeyEvent.VK_RIGHT:
                repaint(image.setX(image.getX()+Configuration.STEP));
                // result
                przesPoziome+=  +Configuration.STEP;
                calculateResult();
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                break;
            case KeyEvent.VK_MINUS:
                repaint(image.setBrightness(image.getBrightness()-1));
                break;
            case KeyEvent.VK_EQUALS:
                // TODO: Działa teraz tylko klawisz "=", powinien również "+"
                repaint(image.setBrightness(image.getBrightness()+1));
                break;
            case KeyEvent.VK_SPACE:
                Test.showResult=!Test.showResult;
                t.userInterface.jCheckBoxMenuItemShowResult.setState(Test.showResult);
                repaint(Configuration.WYNIK_X,   Configuration.WYNIK_Y-Configuration.WYNIK_WYS,   Configuration.WYNIK_X+Configuration.WYNIK_SZER,   Configuration.WYNIK_Y+2*Configuration.OFFSET);
                break;
            case KeyEvent.VK_P:
                // centralna zamiana polaryzacji
                Test.polarisationChanged = ! Test.polarisationChanged;
                t.userInterface.jCheckBoxMenuItemPolarisationChanged.setState(Test.polarisationChanged);
                // lokalna zamiana polaryzacji
                Rectangle r1 = background.setEye(1-background.getEye());
                Rectangle r2 = image.setEye(1-image.getEye());
                r2.add(r1);
                repaint(r2);
                break;
            case KeyEvent.VK_ENTER:
                t.userInterface.getPacjent().addWynikTestu(new ResultData(numer+13,result));
                t.userInterface.getModelTabeli().fireTableStructureChanged();
                t.exit();
                break;
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

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
