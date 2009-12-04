package pl.rdk.vision2.tests;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import pl.rdk.vision2.TestHelper;
import pl.rdk.vision2.UserInterface;

/** KLASA INICJUJĄCA TEST */
public class Test {
    // PRYWATNE
    private GraphicsEnvironment env;
    private GraphicsDevice devices[], device;
    private GraphicsConfiguration graphicsConf;
    private JFrame frame;
    private int monitorNumber;

    // WSKAŹNIKI DOSTĘPNE Z TESTÓW
    /** interfejs użytkownika */
    UserInterface userInterface;
    /** okienko pomocnicze przy pracy dwumonitorowej */
    TestHelper testHelper;

    // USTAWIENIA DOSTĘPNE WSZĘDZIE
    /** Pokazywanie wyniku w trakcie testu
     * Zmiana wymaga uaktulanienia kontrolki w userInterface*/
    public static boolean showResult = false;
    /** zamiana polaryzacji
     * * Zmiana wymaga uaktulanienia kontrolki w userInterface*/
    public static boolean polarisationChanged = false;
    /** praca dwumonitorowa
    * Zmiana wymaga uaktulanienia kontrolki w userInterface*/
    public static boolean dualMonitorWork = false;

    /** KONSTRUKTOR KLASY INICJUJĄCEJ TEST */
    public Test(Object panel, UserInterface userInterface) {
        this.userInterface = userInterface;

        env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        // WYBÓR NAJLEPSZEGO MONITORA (jeżeli jest, to drugi)
        devices = env.getScreenDevices();
        if(devices.length>1)
            monitorNumber=1;
        else
            monitorNumber=0;
        
        // zawsze wybieramy główny (zerowy) monitor, bo okulary bezprzewodowe
        // potrafia działać tylko na głównym monitorze !!!
        monitorNumber=0;

        device=devices[monitorNumber];

        graphicsConf = device.getDefaultConfiguration();
        frame = new JFrame(Configuration.NAME, graphicsConf);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.add((Component) panel);
        frame.addKeyListener((KeyListener) panel);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setUndecorated(true);
        device.setFullScreenWindow(frame);

        if(dualMonitorWork){
            // DWA MONITORY
            userInterface.setEnabled(false);
            testHelper = new TestHelper(this);
            testHelper.setVisible(true);
            testHelper.setLocationRelativeTo(userInterface);
        }else{
            // JEDEN MONITOR
            userInterface.setVisible(false);
            userInterface.setIgnoreRepaint(true);
        }

        frame.setVisible(true);
        frame.requestFocus();
    }

    /** Wyjście z testu */
    public void exit() {
        frame.dispose();
        userInterface.setIgnoreRepaint(false); // na wszelki wypadek
        userInterface.setVisible(true);
        userInterface.repaint();
        userInterface.setEnabled(true); // na wszelki wypadek
        if(testHelper!=null){
            testHelper.dispose();
        }
    }

        /**
     * @return Rectangle w którym nalezy umieścić test,
     * aby był wyśroskowany na ekranie
     */
    Rectangle getCenterPosition() {
        Rectangle rec = frame.getBounds();
        int x = (rec.width - Configuration.MAX_X) / 2;
        int y = (rec.height - Configuration.MAX_Y) / 2;
        // aby zapewnić powtarzalność polaryzacji y zawsze musi być zawsze parzysty
        if (y % 2 != 0) {
            y++;
        }
        return new Rectangle(x, y, Configuration.MAX_X, Configuration.MAX_Y);
    }
}