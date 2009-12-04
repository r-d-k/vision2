package pl.rdk.vision2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import pl.rdk.vision2.data.PatientData;
import pl.rdk.vision2.data.SettingsData;
import pl.rdk.vision2.tests.Configuration;
import pl.rdk.vision2.tests.Test;

/** Interferjs użytkownika */
public class UserInterface extends javax.swing.JFrame {

    private PatientData pacjent;
    private SettingsData ustawienia;
    private AbstractTableModel modelTabeli;
    private ResourceBundle labels;

    /** Konstruktor */
    public UserInterface() {
        // pobiera etykietki dla domyślnej lokalizacji (ustawionej wg platformy)
        labels = ResourceBundle.getBundle("pl/rdk/vision2/languages/i18n");

        // inicjalizacja pacjenta, ustawień i tabeli z wynikami
        pacjent = new PatientData(); //tworzymy pustego pacjenta
        ustawienia = new SettingsData();
        modelTabeli = new ModelTabeli();

        // inicjacja kontrolek swinga i centrowanie
        initComponents();
        wycentruj();
        ((DefaultTableCellRenderer) tabelaWynikow.getDefaultRenderer(tabelaWynikow.getClass())).setHorizontalAlignment(SwingConstants.CENTER);

        // FileChooser localization
        UIManager.put("FileChooser.lookInLabelText",labels.getString("catalog"));
    }

    public PatientData getPacjent() {
        return pacjent;
    }

    public SettingsData getUstawienia() {
        return ustawienia;
    }

    public AbstractTableModel getModelTabeli() {
        return modelTabeli;
    }

    /** Centrowanie okienka */
    private void wycentruj() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        setLocation(x, y);
    }

    /** Generated code (don'testHelper modify) */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wyborPlci = new javax.swing.ButtonGroup();
        zakladki = new javax.swing.JTabbedPane();
        zakladkaUstawienia = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        wysokosc = new javax.swing.JTextField();
        szerokosc = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        odleglosc = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        zakladkaPacjent = new javax.swing.JPanel();
        daneOsobowe = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        imie = new javax.swing.JTextField();
        nazwisko = new javax.swing.JTextField();
        wiek = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        opis = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        woman = new javax.swing.JRadioButton();
        man = new javax.swing.JRadioButton();
        wadaRefrakcji = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        sferaPrawa = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        sferaLewa = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        cylinderPrawy = new javax.swing.JTextField();
        cylinderLewy = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        osPrawa = new javax.swing.JTextField();
        osLewa = new javax.swing.JTextField();
        zapisz = new javax.swing.JButton();
        wczytaj = new javax.swing.JButton();
        eksportuj = new javax.swing.JButton();
        zakladkaTesty = new javax.swing.JPanel();
        klasyczne = new javax.swing.JPanel();
        jButtonCrossTest = new javax.swing.JButton();
        jButtonVerticalBracketTest = new javax.swing.JButton();
        jButtonHorizontalBracketTest = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButtonCrossTestWithCircle = new javax.swing.JButton();
        jButtonVerticalBracketTestWithCircle = new javax.swing.JButton();
        jButtonHorizontalBracketTestWithCircle = new javax.swing.JButton();
        wektoraficzne = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        wektograficzneMinuty = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        wektograficznePowtorzenia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        kropkowe = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        KropkoweMinuty = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        kropkowePowtorzenia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        zakladkaSynoptofor = new javax.swing.JPanel();
        jednoczesnaPercepcja = new javax.swing.JPanel();
        jButtonLewWKlatce = new javax.swing.JButton();
        jButtonPiesWBudzie = new javax.swing.JButton();
        jButtonKoloZPiasta = new javax.swing.JButton();
        jButtonGwiazdaDawida = new javax.swing.JButton();
        jButtonSamochodWGarazu = new javax.swing.JButton();
        fuzja = new javax.swing.JPanel();
        jButtonLiniaIKropki = new javax.swing.JButton();
        jButtonZajacZBukietem = new javax.swing.JButton();
        jButtonMotylNadKwiatem = new javax.swing.JButton();
        jButtonWedkarz = new javax.swing.JButton();
        jButtonGentelman = new javax.swing.JButton();
        stereopsja = new javax.swing.JPanel();
        jButtonOkregi = new javax.swing.JButton();
        jButtonWiaderko = new javax.swing.JButton();
        jButtonOczy = new javax.swing.JButton();
        jButtonBierki = new javax.swing.JButton();
        jButtonFigury = new javax.swing.JButton();
        zakladkaWyniki = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaWynikow = new javax.swing.JTable();
        menu = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExport = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuConfiguration = new javax.swing.JMenu();
        jCheckBoxMenuItemPolarisationChanged = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemDualMonitorWork = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemShowResult = new javax.swing.JCheckBoxMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemHelpTopics = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(labels.getString("programTitle")); // NOI18N
        setMinimumSize(new java.awt.Dimension(550, 500));
        setName(""); // NOI18N

        zakladki.setToolTipText("");
        zakladki.setMinimumSize(new java.awt.Dimension(0, 0));

        zakladkaUstawienia.setToolTipText(labels.getString("measureCrossDimensionsAndWriteInAppropriateFields")); // NOI18N

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/01.Ruler.png"))); // NOI18N
        jLabel31.setToolTipText(labels.getString("measureCrossDimensionsAndWriteInAppropriateFields")); // NOI18N
        jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel32.setText(labels.getString("height") + " [mm]");

        wysokosc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wysokosc.setText(Integer.toString(ustawienia.getWysokosc()));
        wysokosc.setToolTipText(labels.getString("heightOfTheVerticalCrossBranchOnThePictureBelow")); // NOI18N
        wysokosc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                wysokoscFocusLost(evt);
            }
        });
        wysokosc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                wysokoscKeyTyped(evt);
            }
        });

        szerokosc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        szerokosc.setText(Integer.toString(ustawienia.getSzerokosc()));
        szerokosc.setToolTipText(labels.getString("widthOfTheHorizontalCrossBranchOnThePictureBelow")); // NOI18N
        szerokosc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                szerokoscFocusLost(evt);
            }
        });
        szerokosc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                szerokoscKeyTyped(evt);
            }
        });

        jLabel33.setText(labels.getString("width") + " [mm]");

        odleglosc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        odleglosc.setText(Integer.toString(ustawienia.getOdleglosc()));
        odleglosc.setToolTipText(labels.getString("distanceFromMonitorToPatientEyes")); // NOI18N
        odleglosc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                odlegloscFocusLost(evt);
            }
        });
        odleglosc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                odlegloscKeyTyped(evt);
            }
        });

        jLabel34.setText(labels.getString("distance") + " [cm]");

        javax.swing.GroupLayout zakladkaUstawieniaLayout = new javax.swing.GroupLayout(zakladkaUstawienia);
        zakladkaUstawienia.setLayout(zakladkaUstawieniaLayout);
        zakladkaUstawieniaLayout.setHorizontalGroup(
            zakladkaUstawieniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zakladkaUstawieniaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(zakladkaUstawieniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel34)
                    .addComponent(odleglosc, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(zakladkaUstawieniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel33)
                    .addComponent(szerokosc, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(zakladkaUstawieniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel32)
                    .addComponent(wysokosc, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zakladkaUstawieniaLayout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(123, 123, 123))
        );
        zakladkaUstawieniaLayout.setVerticalGroup(
            zakladkaUstawieniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zakladkaUstawieniaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zakladkaUstawieniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zakladkaUstawieniaLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(6, 6, 6)
                        .addComponent(szerokosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(zakladkaUstawieniaLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(6, 6, 6)
                        .addComponent(odleglosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(zakladkaUstawieniaLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wysokosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jLabel31)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        zakladkaUstawieniaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {odleglosc, szerokosc, wysokosc});

        zakladki.addTab(labels.getString("settings"), zakladkaUstawienia); // NOI18N

        daneOsobowe.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("personalData"))); // NOI18N

        jLabel22.setText(labels.getString("name")); // NOI18N

        jLabel23.setText(labels.getString("surname")); // NOI18N

        jLabel24.setText(labels.getString("age")); // NOI18N

        imie.setText(pacjent.getImie());
        imie.setToolTipText(labels.getString("patientName")); // NOI18N
        imie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                imieFocusLost(evt);
            }
        });

        nazwisko.setText(pacjent.getNazwisko());
        nazwisko.setToolTipText(labels.getString("patientSurname")); // NOI18N
        nazwisko.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nazwiskoFocusLost(evt);
            }
        });

        wiek.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wiek.setText(new String(pacjent.getWiek()));
        wiek.setToolTipText(labels.getString("ageInYears")); // NOI18N
        wiek.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                wiekFocusLost(evt);
            }
        });
        wiek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                wiekKeyTyped(evt);
            }
        });

        opis.setColumns(20);
        opis.setLineWrap(true);
        opis.setRows(2);
        opis.setTabSize(4);
        opis.setText(pacjent.getOpis());
        opis.setToolTipText(labels.getString("diseaseHistoryAndOtherDataFromInterview")); // NOI18N
        opis.setMinimumSize(new java.awt.Dimension(0, 0));
        opis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                opisFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(opis);

        jLabel25.setText(labels.getString("description")); // NOI18N

        wyborPlci.add(woman);
        woman.setSelected(pacjent.isKobieta());
        woman.setText(labels.getString("abbreviationForWoman")); // NOI18N
        woman.setToolTipText(labels.getString("woman")); // NOI18N
        woman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                womanActionPerformed(evt);
            }
        });

        wyborPlci.add(man);
        man.setSelected(! pacjent.isKobieta());
        man.setText(labels.getString("abbreviationForMan")); // NOI18N
        man.setToolTipText(labels.getString("man")); // NOI18N
        man.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout daneOsoboweLayout = new javax.swing.GroupLayout(daneOsobowe);
        daneOsobowe.setLayout(daneOsoboweLayout);
        daneOsoboweLayout.setHorizontalGroup(
            daneOsoboweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daneOsoboweLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(daneOsoboweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(daneOsoboweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(daneOsoboweLayout.createSequentialGroup()
                        .addComponent(imie, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addGap(64, 64, 64)
                        .addComponent(woman)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(man))
                    .addGroup(daneOsoboweLayout.createSequentialGroup()
                        .addComponent(nazwisko, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wiek, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                .addContainerGap())
        );
        daneOsoboweLayout.setVerticalGroup(
            daneOsoboweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daneOsoboweLayout.createSequentialGroup()
                .addGroup(daneOsoboweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(man)
                    .addComponent(woman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(daneOsoboweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(wiek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(daneOsoboweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(daneOsoboweLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel25)
                        .addGap(56, 56, 56))
                    .addGroup(daneOsoboweLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        daneOsoboweLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {imie, nazwisko});

        wadaRefrakcji.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("refractiveError"))); // NOI18N

        jLabel26.setText(labels.getString("abbreviationForRightEye")); // NOI18N

        jLabel27.setText(labels.getString("abbreviationForLeftEye")); // NOI18N

        sferaPrawa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sferaPrawa.setText(pacjent.getSferaPrawa());
        sferaPrawa.setToolTipText(labels.getString("sphericalPowerInDioptersRightEye")); // NOI18N
        sferaPrawa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sferaPrawaFocusLost(evt);
            }
        });

        jLabel28.setText(labels.getString("spherical")); // NOI18N

        sferaLewa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sferaLewa.setText(pacjent.getSferaLewa());
        sferaLewa.setToolTipText(labels.getString("sphericalPowerInDioptersLeftEye")); // NOI18N
        sferaLewa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sferaLewaFocusLost(evt);
            }
        });

        jLabel29.setText(labels.getString("cylindrical")); // NOI18N

        cylinderPrawy.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cylinderPrawy.setText(pacjent.getCylinderPrawy());
        cylinderPrawy.setToolTipText(labels.getString("cylindricalPowerInDioptersRightEye")); // NOI18N
        cylinderPrawy.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cylinderPrawyFocusLost(evt);
            }
        });

        cylinderLewy.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cylinderLewy.setText(pacjent.getCylinderLewy());
        cylinderLewy.setToolTipText(labels.getString("cylindricalPowerInDioptersLeftEye")); // NOI18N
        cylinderLewy.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cylinderLewyFocusLost(evt);
            }
        });

        jLabel30.setText(labels.getString("axis")); // NOI18N

        osPrawa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        osPrawa.setText(pacjent.getOsPrawa());
        osPrawa.setToolTipText(labels.getString("rightCylinderAxisInDegreesFrom0To180")); // NOI18N
        osPrawa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                osPrawaFocusLost(evt);
            }
        });
        osPrawa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                osPrawaKeyTyped(evt);
            }
        });

        osLewa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        osLewa.setText(pacjent.getOsLewa());
        osLewa.setToolTipText(labels.getString("leftCylinderAxisInDegreesFrom0To180")); // NOI18N
        osLewa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                osLewaFocusLost(evt);
            }
        });
        osLewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                osLewaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout wadaRefrakcjiLayout = new javax.swing.GroupLayout(wadaRefrakcji);
        wadaRefrakcji.setLayout(wadaRefrakcjiLayout);
        wadaRefrakcjiLayout.setHorizontalGroup(
            wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wadaRefrakcjiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26))
                .addGap(12, 12, 12)
                .addGroup(wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(sferaLewa, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(sferaPrawa, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(jLabel28))
                .addGap(14, 14, 14)
                .addGroup(wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cylinderLewy, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(cylinderPrawy, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel29))
                .addGap(22, 22, 22)
                .addGroup(wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(osLewa, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(osPrawa, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jLabel30))
                .addContainerGap())
        );
        wadaRefrakcjiLayout.setVerticalGroup(
            wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wadaRefrakcjiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(wadaRefrakcjiLayout.createSequentialGroup()
                        .addGroup(wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cylinderPrawy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sferaPrawa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(wadaRefrakcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cylinderLewy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sferaLewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)))
                    .addGroup(wadaRefrakcjiLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(osPrawa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(osLewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        zapisz.setText(labels.getString("save")); // NOI18N
        zapisz.setToolTipText(labels.getString("savePacientAndExaminationData")); // NOI18N
        zapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapiszActionPerformed(evt);
            }
        });

        wczytaj.setText(labels.getString("load")); // NOI18N
        wczytaj.setToolTipText(labels.getString("loadPatientAndExaminationData")); // NOI18N
        wczytaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wczytajActionPerformed(evt);
            }
        });

        eksportuj.setText(labels.getString("export")); // NOI18N
        eksportuj.setToolTipText(labels.getString("exportPatientAndExaminationData")); // NOI18N
        eksportuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eksportujActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout zakladkaPacjentLayout = new javax.swing.GroupLayout(zakladkaPacjent);
        zakladkaPacjent.setLayout(zakladkaPacjentLayout);
        zakladkaPacjentLayout.setHorizontalGroup(
            zakladkaPacjentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zakladkaPacjentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zakladkaPacjentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, zakladkaPacjentLayout.createSequentialGroup()
                        .addComponent(wczytaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zapisz)
                        .addGap(18, 18, 18)
                        .addComponent(eksportuj))
                    .addComponent(daneOsobowe, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wadaRefrakcji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        zakladkaPacjentLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {wczytaj, zapisz});

        zakladkaPacjentLayout.setVerticalGroup(
            zakladkaPacjentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zakladkaPacjentLayout.createSequentialGroup()
                .addComponent(daneOsobowe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wadaRefrakcji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(zakladkaPacjentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(zapisz)
                    .addComponent(wczytaj)
                    .addComponent(eksportuj))
                .addContainerGap())
        );

        zakladkaPacjentLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {wczytaj, zapisz});

        zakladki.addTab(labels.getString("patient"), zakladkaPacjent); // NOI18N

        klasyczne.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("classical"))); // NOI18N

        jButtonCrossTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/02.Cross.png"))); // NOI18N
        jButtonCrossTest.setToolTipText(labels.getString("crossTest")); // NOI18N
        jButtonCrossTest.setMaximumSize(new java.awt.Dimension(28, 28));
        jButtonCrossTest.setMinimumSize(new java.awt.Dimension(28, 28));
        jButtonCrossTest.setPreferredSize(new java.awt.Dimension(28, 28));
        jButtonCrossTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrossTestActionPerformed(evt);
            }
        });

        jButtonVerticalBracketTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/04.VerticalBracket.png"))); // NOI18N
        jButtonVerticalBracketTest.setToolTipText(labels.getString("verticalBracketTest")); // NOI18N
        jButtonVerticalBracketTest.setMaximumSize(new java.awt.Dimension(28, 28));
        jButtonVerticalBracketTest.setMinimumSize(new java.awt.Dimension(28, 28));
        jButtonVerticalBracketTest.setPreferredSize(new java.awt.Dimension(28, 28));
        jButtonVerticalBracketTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerticalBracketTestActionPerformed(evt);
            }
        });

        jButtonHorizontalBracketTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/06.HorizontalBracket.png"))); // NOI18N
        jButtonHorizontalBracketTest.setToolTipText(labels.getString("horizontalBracketTest")); // NOI18N
        jButtonHorizontalBracketTest.setMaximumSize(new java.awt.Dimension(28, 28));
        jButtonHorizontalBracketTest.setMinimumSize(new java.awt.Dimension(28, 28));
        jButtonHorizontalBracketTest.setPreferredSize(new java.awt.Dimension(28, 28));
        jButtonHorizontalBracketTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHorizontalBracketTestActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/10.VerticalPointer.png"))); // NOI18N
        jButton4.setToolTipText(labels.getString("verticalPointerTest")); // NOI18N
        jButton4.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton4.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton4.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/11.HorizontalPointer.png"))); // NOI18N
        jButton5.setToolTipText(labels.getString("horizontalPointerTest")); // NOI18N
        jButton5.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton5.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton5.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/12.DoublePointer.png"))); // NOI18N
        jButton6.setToolTipText(labels.getString("doublePointerTest")); // NOI18N
        jButton6.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton6.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton6.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/08.Triangle.png"))); // NOI18N
        jButton7.setToolTipText(labels.getString("triangleTest")); // NOI18N
        jButton7.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton7.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton7.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/09.Stereo.png"))); // NOI18N
        jButton8.setToolTipText(labels.getString("stereobalans")); // NOI18N
        jButton8.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton8.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton8.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButtonCrossTestWithCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/03.CrossWithCircle.png"))); // NOI18N
        jButtonCrossTestWithCircle.setToolTipText(labels.getString("crossTestWithCentralStimulus")); // NOI18N
        jButtonCrossTestWithCircle.setMaximumSize(new java.awt.Dimension(28, 28));
        jButtonCrossTestWithCircle.setMinimumSize(new java.awt.Dimension(28, 28));
        jButtonCrossTestWithCircle.setPreferredSize(new java.awt.Dimension(28, 28));
        jButtonCrossTestWithCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrossTestWithCircleActionPerformed(evt);
            }
        });

        jButtonVerticalBracketTestWithCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/05.VerticalBracketWithCircle.png"))); // NOI18N
        jButtonVerticalBracketTestWithCircle.setToolTipText(labels.getString("verticalBracketTestWithCentralStimulus")); // NOI18N
        jButtonVerticalBracketTestWithCircle.setMaximumSize(new java.awt.Dimension(28, 28));
        jButtonVerticalBracketTestWithCircle.setMinimumSize(new java.awt.Dimension(28, 28));
        jButtonVerticalBracketTestWithCircle.setPreferredSize(new java.awt.Dimension(28, 28));
        jButtonVerticalBracketTestWithCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerticalBracketTestWithCircleActionPerformed(evt);
            }
        });

        jButtonHorizontalBracketTestWithCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/07.HorizontalBracketWithCircle.png"))); // NOI18N
        jButtonHorizontalBracketTestWithCircle.setToolTipText(labels.getString("horizontalBracketTestWithCentralStimulus")); // NOI18N
        jButtonHorizontalBracketTestWithCircle.setMaximumSize(new java.awt.Dimension(28, 28));
        jButtonHorizontalBracketTestWithCircle.setMinimumSize(new java.awt.Dimension(28, 28));
        jButtonHorizontalBracketTestWithCircle.setPreferredSize(new java.awt.Dimension(28, 28));
        jButtonHorizontalBracketTestWithCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHorizontalBracketTestWithCircleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout klasyczneLayout = new javax.swing.GroupLayout(klasyczne);
        klasyczne.setLayout(klasyczneLayout);
        klasyczneLayout.setHorizontalGroup(
            klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(klasyczneLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(klasyczneLayout.createSequentialGroup()
                        .addComponent(jButtonCrossTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCrossTestWithCircle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(klasyczneLayout.createSequentialGroup()
                        .addComponent(jButtonVerticalBracketTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVerticalBracketTestWithCircle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(klasyczneLayout.createSequentialGroup()
                        .addComponent(jButtonHorizontalBracketTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonHorizontalBracketTestWithCircle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(klasyczneLayout.createSequentialGroup()
                        .addGroup(klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        klasyczneLayout.setVerticalGroup(
            klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(klasyczneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCrossTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCrossTestWithCircle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVerticalBracketTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerticalBracketTestWithCircle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonHorizontalBracketTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHorizontalBracketTestWithCircle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(klasyczneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(klasyczneLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        wektoraficzne.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("wectographic"))); // NOI18N

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/13.Vectographic.png"))); // NOI18N
        jButton9.setToolTipText(labels.getString("wectographicTest")+" 1'");
        jButton9.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton9.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton9.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel9.setText("1'");

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/13.Vectographic.png"))); // NOI18N
        jButton10.setToolTipText(labels.getString("wectographicTest")+" 2'");
        jButton10.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton10.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton10.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel10.setText("2'");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/13.Vectographic.png"))); // NOI18N
        jButton11.setToolTipText(labels.getString("wectographicTest")+" 5'");
        jButton11.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton11.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton11.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel11.setText("5'");

        jLabel12.setText("10'");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/13.Vectographic.png"))); // NOI18N
        jButton12.setToolTipText(labels.getString("wectographicTest")+" 10'");
        jButton12.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton12.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton12.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel13.setText("20'");

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/13.Vectographic.png"))); // NOI18N
        jButton13.setToolTipText(labels.getString("wectographicTest")+" 20'");
        jButton13.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton13.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton13.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel14.setText("50'");

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/13.Vectographic.png"))); // NOI18N
        jButton14.setToolTipText(labels.getString("wectographicTest")+" 50'");
        jButton14.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton14.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton14.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/13.Vectographic.png"))); // NOI18N
        jButton15.setToolTipText(labels.getString("wectographicTest")+" "+ustawienia.getWektograficzneMinuty()+"'");
        jButton15.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton15.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton15.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        wektograficzneMinuty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        wektograficzneMinuty.setText(Integer.toString(ustawienia.getWektograficzneMinuty()));
        wektograficzneMinuty.setToolTipText(labels.getString("anyValueInMinutes")); // NOI18N
        wektograficzneMinuty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                wektograficzneMinutyFocusLost(evt);
            }
        });
        wektograficzneMinuty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                wektograficzneMinutyKeyTyped(evt);
            }
        });

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/13.Vectographic.png"))); // NOI18N
        jButton23.setToolTipText(labels.getString("wectographicTest")+" 0,5'");
        jButton23.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton23.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton23.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel21.setText("0,5'");

        wektograficznePowtorzenia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        wektograficznePowtorzenia.setText(Integer.toString(ustawienia.getWektograficznePowtorzenia()));
        wektograficznePowtorzenia.setToolTipText(labels.getString("amountOfRepetitionsInWectographicTests")); // NOI18N
        wektograficznePowtorzenia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                wektograficznePowtorzeniaFocusLost(evt);
            }
        });
        wektograficznePowtorzenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                wektograficznePowtorzeniaKeyTyped(evt);
            }
        });

        jLabel2.setText(labels.getString("amountOfRepetitions")); // NOI18N

        javax.swing.GroupLayout wektoraficzneLayout = new javax.swing.GroupLayout(wektoraficzne);
        wektoraficzne.setLayout(wektoraficzneLayout);
        wektoraficzneLayout.setHorizontalGroup(
            wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wektoraficzneLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wektoraficzneLayout.createSequentialGroup()
                        .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(wektograficzneMinuty, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel21)))
                    .addComponent(jLabel2)
                    .addComponent(wektograficznePowtorzenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        wektoraficzneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, wektograficznePowtorzenia});

        wektoraficzneLayout.setVerticalGroup(
            wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wektoraficzneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wektoraficzneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(wektograficzneMinuty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wektograficznePowtorzenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kropkowe.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("dot"))); // NOI18N

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/14.Dots.png"))); // NOI18N
        jButton16.setToolTipText(labels.getString("dotTest")+" 20'");
        jButton16.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton16.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton16.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel15.setText("1'");

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/14.Dots.png"))); // NOI18N
        jButton17.setToolTipText(labels.getString("dotTest")+" 1'");
        jButton17.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton17.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton17.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel16.setText("2'");

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/14.Dots.png"))); // NOI18N
        jButton18.setToolTipText(labels.getString("dotTest")+" 2'");
        jButton18.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton18.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton18.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel17.setText("5'");

        jLabel18.setText("10'");

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/14.Dots.png"))); // NOI18N
        jButton19.setToolTipText(labels.getString("dotTest")+" 5'");
        jButton19.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton19.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton19.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel19.setText("20'");

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/14.Dots.png"))); // NOI18N
        jButton20.setToolTipText(labels.getString("dotTest")+" 10'");
        jButton20.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton20.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton20.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel20.setText("50'");

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/14.Dots.png"))); // NOI18N
        jButton21.setToolTipText(labels.getString("dotTest")+" 50'");
        jButton21.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton21.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton21.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/14.Dots.png"))); // NOI18N
        jButton22.setToolTipText(labels.getString("dotTest")+" "+ustawienia.getKropkoweMinuty()+"'");
        jButton22.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton22.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton22.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        KropkoweMinuty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        KropkoweMinuty.setText(Integer.toString(ustawienia.getKropkoweMinuty()));
        KropkoweMinuty.setToolTipText(labels.getString("anyValueInMinutes")); // NOI18N
        KropkoweMinuty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                KropkoweMinutyFocusLost(evt);
            }
        });
        KropkoweMinuty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                KropkoweMinutyKeyTyped(evt);
            }
        });

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/14.Dots.png"))); // NOI18N
        jButton26.setToolTipText(labels.getString("dotTest")+" 0,5'");
        jButton26.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton26.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton26.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel35.setText("0,5'");

        kropkowePowtorzenia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        kropkowePowtorzenia.setText(Integer.toString(ustawienia.getKropkowePowtorzenia()));
        kropkowePowtorzenia.setToolTipText(labels.getString("amountOfRepetitionsInDotTests")); // NOI18N
        kropkowePowtorzenia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                kropkowePowtorzeniaFocusLost(evt);
            }
        });
        kropkowePowtorzenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kropkowePowtorzeniaKeyTyped(evt);
            }
        });

        jLabel4.setText(labels.getString("amountOfRepetitions")); // NOI18N

        javax.swing.GroupLayout kropkoweLayout = new javax.swing.GroupLayout(kropkowe);
        kropkowe.setLayout(kropkoweLayout);
        kropkoweLayout.setHorizontalGroup(
            kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kropkoweLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kropkoweLayout.createSequentialGroup()
                        .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(KropkoweMinuty, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel35)))
                    .addComponent(jLabel4)
                    .addComponent(kropkowePowtorzenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        kropkoweLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, kropkowePowtorzenia});

        kropkoweLayout.setVerticalGroup(
            kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kropkoweLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel35)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kropkoweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(KropkoweMinuty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kropkowePowtorzenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout zakladkaTestyLayout = new javax.swing.GroupLayout(zakladkaTesty);
        zakladkaTesty.setLayout(zakladkaTestyLayout);
        zakladkaTestyLayout.setHorizontalGroup(
            zakladkaTestyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zakladkaTestyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(klasyczne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wektoraficzne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kropkowe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        zakladkaTestyLayout.setVerticalGroup(
            zakladkaTestyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zakladkaTestyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zakladkaTestyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(wektoraficzne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(klasyczne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kropkowe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        zakladki.addTab(labels.getString("tests"), zakladkaTesty); // NOI18N

        jednoczesnaPercepcja.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("simultaneousPerception"))); // NOI18N

        jButtonLewWKlatce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/15.Lion.png"))); // NOI18N
        jButtonLewWKlatce.setToolTipText(labels.getString("lionInCage")); // NOI18N
        jButtonLewWKlatce.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonLewWKlatce.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonLewWKlatce.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonLewWKlatce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLewWKlatceActionPerformed(evt);
            }
        });

        jButtonPiesWBudzie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/16.Dog.png"))); // NOI18N
        jButtonPiesWBudzie.setToolTipText(labels.getString("dogInKennel")); // NOI18N
        jButtonPiesWBudzie.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonPiesWBudzie.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonPiesWBudzie.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonPiesWBudzie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPiesWBudzieActionPerformed(evt);
            }
        });

        jButtonKoloZPiasta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/17.Wheels.png"))); // NOI18N
        jButtonKoloZPiasta.setToolTipText(labels.getString("hubInWheel")); // NOI18N
        jButtonKoloZPiasta.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonKoloZPiasta.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonKoloZPiasta.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonKoloZPiasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKoloZPiastaActionPerformed(evt);
            }
        });

        jButtonGwiazdaDawida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/18.Clepsydra.png"))); // NOI18N
        jButtonGwiazdaDawida.setToolTipText(labels.getString("hourglass")); // NOI18N
        jButtonGwiazdaDawida.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonGwiazdaDawida.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonGwiazdaDawida.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonGwiazdaDawida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGwiazdaDawidaActionPerformed(evt);
            }
        });

        jButtonSamochodWGarazu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/19.Car.png"))); // NOI18N
        jButtonSamochodWGarazu.setToolTipText(labels.getString("carInGarage")); // NOI18N
        jButtonSamochodWGarazu.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonSamochodWGarazu.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonSamochodWGarazu.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonSamochodWGarazu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSamochodWGarazuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jednoczesnaPercepcjaLayout = new javax.swing.GroupLayout(jednoczesnaPercepcja);
        jednoczesnaPercepcja.setLayout(jednoczesnaPercepcjaLayout);
        jednoczesnaPercepcjaLayout.setHorizontalGroup(
            jednoczesnaPercepcjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jednoczesnaPercepcjaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jednoczesnaPercepcjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonSamochodWGarazu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGwiazdaDawida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonKoloZPiasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPiesWBudzie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLewWKlatce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jednoczesnaPercepcjaLayout.setVerticalGroup(
            jednoczesnaPercepcjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jednoczesnaPercepcjaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLewWKlatce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPiesWBudzie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonKoloZPiasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGwiazdaDawida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSamochodWGarazu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        fuzja.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("fusion"))); // NOI18N

        jButtonLiniaIKropki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/20.LineAndDots.png"))); // NOI18N
        jButtonLiniaIKropki.setToolTipText(labels.getString("lineAndDot")); // NOI18N
        jButtonLiniaIKropki.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonLiniaIKropki.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonLiniaIKropki.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonLiniaIKropki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLiniaIKropkiActionPerformed(evt);
            }
        });

        jButtonZajacZBukietem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/21.Bunny.png"))); // NOI18N
        jButtonZajacZBukietem.setToolTipText(labels.getString("rabbit")); // NOI18N
        jButtonZajacZBukietem.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonZajacZBukietem.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonZajacZBukietem.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonZajacZBukietem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZajacZBukietemActionPerformed(evt);
            }
        });

        jButtonMotylNadKwiatem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/22.BeeUnderFlower.png"))); // NOI18N
        jButtonMotylNadKwiatem.setToolTipText(labels.getString("flower")); // NOI18N
        jButtonMotylNadKwiatem.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonMotylNadKwiatem.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonMotylNadKwiatem.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonMotylNadKwiatem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMotylNadKwiatemActionPerformed(evt);
            }
        });

        jButtonWedkarz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/23.Church.png"))); // NOI18N
        jButtonWedkarz.setToolTipText(labels.getString("church")); // NOI18N
        jButtonWedkarz.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonWedkarz.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonWedkarz.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonWedkarz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWedkarzActionPerformed(evt);
            }
        });

        jButtonGentelman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/24.Clock.png"))); // NOI18N
        jButtonGentelman.setToolTipText(labels.getString("clock")); // NOI18N
        jButtonGentelman.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonGentelman.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonGentelman.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonGentelman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGentelmanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fuzjaLayout = new javax.swing.GroupLayout(fuzja);
        fuzja.setLayout(fuzjaLayout);
        fuzjaLayout.setHorizontalGroup(
            fuzjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fuzjaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(fuzjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLiniaIKropki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonZajacZBukietem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMotylNadKwiatem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonWedkarz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGentelman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        fuzjaLayout.setVerticalGroup(
            fuzjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fuzjaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLiniaIKropki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonZajacZBukietem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMotylNadKwiatem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonWedkarz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGentelman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        stereopsja.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("stereopsis"))); // NOI18N

        jButtonOkregi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/25.Circles.png"))); // NOI18N
        jButtonOkregi.setToolTipText(labels.getString("circles")); // NOI18N
        jButtonOkregi.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonOkregi.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonOkregi.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonOkregi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkregiActionPerformed(evt);
            }
        });

        jButtonWiaderko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/26.Bucket.png"))); // NOI18N
        jButtonWiaderko.setToolTipText(labels.getString("bucket")); // NOI18N
        jButtonWiaderko.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonWiaderko.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonWiaderko.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonWiaderko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWiaderkoActionPerformed(evt);
            }
        });

        jButtonOczy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/27.Eyes.png"))); // NOI18N
        jButtonOczy.setToolTipText(labels.getString("eyes")); // NOI18N
        jButtonOczy.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonOczy.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonOczy.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonOczy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOczyActionPerformed(evt);
            }
        });

        jButtonBierki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/28.Cutlery.png"))); // NOI18N
        jButtonBierki.setToolTipText(labels.getString("pickAStick")); // NOI18N
        jButtonBierki.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonBierki.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonBierki.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonBierki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBierkiActionPerformed(evt);
            }
        });

        jButtonFigury.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/rdk/vision2/icons/29.Figures.png"))); // NOI18N
        jButtonFigury.setToolTipText(labels.getString("figures")); // NOI18N
        jButtonFigury.setMaximumSize(new java.awt.Dimension(68, 28));
        jButtonFigury.setMinimumSize(new java.awt.Dimension(68, 28));
        jButtonFigury.setPreferredSize(new java.awt.Dimension(68, 28));
        jButtonFigury.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiguryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stereopsjaLayout = new javax.swing.GroupLayout(stereopsja);
        stereopsja.setLayout(stereopsjaLayout);
        stereopsjaLayout.setHorizontalGroup(
            stereopsjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stereopsjaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(stereopsjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonOkregi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonWiaderko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOczy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBierki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFigury, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        stereopsjaLayout.setVerticalGroup(
            stereopsjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stereopsjaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonOkregi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonWiaderko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOczy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBierki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFigury, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout zakladkaSynoptoforLayout = new javax.swing.GroupLayout(zakladkaSynoptofor);
        zakladkaSynoptofor.setLayout(zakladkaSynoptoforLayout);
        zakladkaSynoptoforLayout.setHorizontalGroup(
            zakladkaSynoptoforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zakladkaSynoptoforLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jednoczesnaPercepcja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fuzja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stereopsja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        zakladkaSynoptoforLayout.setVerticalGroup(
            zakladkaSynoptoforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zakladkaSynoptoforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zakladkaSynoptoforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jednoczesnaPercepcja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fuzja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stereopsja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        zakladki.addTab(labels.getString("synoptiscope"), zakladkaSynoptofor); // NOI18N

        tabelaWynikow.setModel(modelTabeli);
        tabelaWynikow.setToolTipText(labels.getString("tableWithTestResults")); // NOI18N
        jScrollPane2.setViewportView(tabelaWynikow);

        javax.swing.GroupLayout zakladkaWynikiLayout = new javax.swing.GroupLayout(zakladkaWyniki);
        zakladkaWyniki.setLayout(zakladkaWynikiLayout);
        zakladkaWynikiLayout.setHorizontalGroup(
            zakladkaWynikiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zakladkaWynikiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );
        zakladkaWynikiLayout.setVerticalGroup(
            zakladkaWynikiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zakladkaWynikiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        zakladki.addTab(labels.getString("results"), zakladkaWyniki); // NOI18N

        jMenuFile.setText(labels.getString("file")); // NOI18N

        jMenuItemOpen.setText(labels.getString("open")); // NOI18N
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);

        jMenuItemSave.setText(labels.getString("save")); // NOI18N
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemExport.setText(labels.getString("export")); // NOI18N
        jMenuItemExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExport);

        jMenuItemExit.setText(labels.getString("exit")); // NOI18N
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        menu.add(jMenuFile);

        jMenuConfiguration.setText(labels.getString("configuration")); // NOI18N

        jCheckBoxMenuItemPolarisationChanged.setSelected(Test.polarisationChanged);
        jCheckBoxMenuItemPolarisationChanged.setText(labels.getString("changePolarisation")); // NOI18N
        jCheckBoxMenuItemPolarisationChanged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemPolarisationChangedActionPerformed(evt);
            }
        });
        jMenuConfiguration.add(jCheckBoxMenuItemPolarisationChanged);

        jCheckBoxMenuItemDualMonitorWork.setSelected(Test.dualMonitorWork);
        jCheckBoxMenuItemDualMonitorWork.setText(labels.getString("dualMonitorWork")); // NOI18N
        jCheckBoxMenuItemDualMonitorWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemDualMonitorWorkActionPerformed(evt);
            }
        });
        jMenuConfiguration.add(jCheckBoxMenuItemDualMonitorWork);

        jCheckBoxMenuItemShowResult.setSelected(Test.showResult);
        jCheckBoxMenuItemShowResult.setText(labels.getString("showResultOnTest")); // NOI18N
        jCheckBoxMenuItemShowResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemShowResultActionPerformed(evt);
            }
        });
        jMenuConfiguration.add(jCheckBoxMenuItemShowResult);

        menu.add(jMenuConfiguration);

        jMenuHelp.setText(labels.getString("help")); // NOI18N

        jMenuItemHelpTopics.setText(labels.getString("helpTopics")); // NOI18N
        jMenuItemHelpTopics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpTopicsActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemHelpTopics);

        jMenuItemAbout.setText(labels.getString("aboutProgram")); // NOI18N
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAbout);

        menu.add(jMenuHelp);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zakladki, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zakladki, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerticalBracketTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerticalBracketTestActionPerformed
        new pl.rdk.vision2.tests.BracketTest_Vertical(this,false);
}//GEN-LAST:event_jButtonVerticalBracketTestActionPerformed

    private void jButtonHorizontalBracketTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHorizontalBracketTestActionPerformed
        new pl.rdk.vision2.tests.BracketTest_Horizontal(this,false);
}//GEN-LAST:event_jButtonHorizontalBracketTestActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        testKropkowy(1);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButtonCrossTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrossTestActionPerformed
        new pl.rdk.vision2.tests.CrossTest(this,false);

}//GEN-LAST:event_jButtonCrossTestActionPerformed

    private void zapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(new String(labels.getString("savePacientAndExaminationData")));
        fileChooser.addChoosableFileFilter(new MyFileChooserFilterVis());
        int wybor = fileChooser.showSaveDialog(this);
        if (wybor == JFileChooser.APPROVE_OPTION) {
            File plik = fileChooser.getSelectedFile();
            // upewniamy się, czy użytkownik na pewno chce nadpisać
            if(plik.exists()){
                int wybrano = JOptionPane.showConfirmDialog(this, labels.getString("fileExistsErrorText"), labels.getString("fileExistsError"), JOptionPane.OK_CANCEL_OPTION);
                if(wybrano==JOptionPane.CANCEL_OPTION){
                    return;
                }
            }
            try {
                pacjent.save(plik);
                // ustawienie właściwego rozszerzenia
                if(! plik.getName().endsWith(".vis"))
                    plik.renameTo(new File(plik.getPath()+".vis"));
            } catch (Exception e) {
                showError(e);
            }
        }
}//GEN-LAST:event_zapiszActionPerformed

    private void manActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manActionPerformed
        pacjent.setKobieta(false);
}//GEN-LAST:event_manActionPerformed

    private void womanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_womanActionPerformed
        pacjent.setKobieta(true);
}//GEN-LAST:event_womanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new pl.rdk.vision2.tests.PointerTest_Vertical(this);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new pl.rdk.vision2.tests.PointerTest_Horizontal(this);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new pl.rdk.vision2.tests.PointerTest_Double(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new pl.rdk.vision2.tests.TriangleTest(this);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new pl.rdk.vision2.tests.StereoBalanceTest(this);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        testWektograficzny(1);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void wczytajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wczytajActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(new String(labels.getString("loadPatientAndExaminationData")));
        fileChooser.addChoosableFileFilter(new MyFileChooserFilterVis());
        int wybor = fileChooser.showOpenDialog(this);
        if (wybor == JFileChooser.APPROVE_OPTION) {
            File plik = fileChooser.getSelectedFile();
            try {
                /* wczytanie danych */
                pacjent = new PatientData();
                pacjent.load(plik);
                /* wpisanie danych do GUI */
                imie.setText(pacjent.getImie());
                nazwisko.setText(pacjent.getNazwisko());
                woman.setSelected(pacjent.isKobieta());
                man.setSelected(!pacjent.isKobieta());
                wiek.setText(pacjent.getWiek());
                opis.setText(pacjent.getOpis());
                sferaLewa.setText(pacjent.getSferaLewa());
                sferaPrawa.setText(pacjent.getSferaPrawa());
                cylinderPrawy.setText(pacjent.getCylinderPrawy());
                cylinderLewy.setText(pacjent.getCylinderLewy());
                osPrawa.setText(pacjent.getOsPrawa());
                osLewa.setText(pacjent.getOsLewa());
                /* odświeżenie tabeli wyników */
                modelTabeli.fireTableStructureChanged();
            } catch (Exception e) {
                /* wyświetlamy okienko z opisem błędu */
                showError(e);
            }
        }
    }//GEN-LAST:event_wczytajActionPerformed

    private void imieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_imieFocusLost
        pacjent.setImie(imie.getText());
    }//GEN-LAST:event_imieFocusLost

    private void nazwiskoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nazwiskoFocusLost
        pacjent.setNazwisko(nazwisko.getText());
    }//GEN-LAST:event_nazwiskoFocusLost

    private void opisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_opisFocusLost
        pacjent.setOpis(opis.getText());
    }//GEN-LAST:event_opisFocusLost

    private void wiekFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wiekFocusLost
        pacjent.setWiek(wiek.getText());
    }//GEN-LAST:event_wiekFocusLost

    private void sferaPrawaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sferaPrawaFocusLost
        pacjent.setSferaPrawa(sferaPrawa.getText());
    }//GEN-LAST:event_sferaPrawaFocusLost

    private void sferaLewaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sferaLewaFocusLost
        pacjent.setSferaLewa(sferaLewa.getText());
    }//GEN-LAST:event_sferaLewaFocusLost

    private void cylinderPrawyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cylinderPrawyFocusLost
        pacjent.setCylinderPrawy(cylinderPrawy.getText());
    }//GEN-LAST:event_cylinderPrawyFocusLost

    private void cylinderLewyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cylinderLewyFocusLost
        pacjent.setCylinderLewy(cylinderLewy.getText());
    }//GEN-LAST:event_cylinderLewyFocusLost

    private void osPrawaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_osPrawaFocusLost
        pacjent.setOsPrawa(osPrawa.getText());
    }//GEN-LAST:event_osPrawaFocusLost

    private void osLewaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_osLewaFocusLost
        pacjent.setOsLewa(osLewa.getText());
    }//GEN-LAST:event_osLewaFocusLost

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0);
}//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        JOptionPane.showMessageDialog(this, labels.getString("aboutProgramText"), labels.getString("aboutProgram"), JOptionPane.INFORMATION_MESSAGE);
}//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void odlegloscFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_odlegloscFocusLost
        int wartosc = 0;
        try {
            wartosc = Integer.parseInt(odleglosc.getText());
        } catch (NumberFormatException e) {
        } finally {
            if (wartosc == 0) {
                // zachowujemy starą wartość
                odleglosc.setText(Integer.toString(ustawienia.getOdleglosc()));
            } else // bieżemy sprawdzoną nową wartość
            {
                ustawienia.setOdleglosc(wartosc);
            }
        }
    }//GEN-LAST:event_odlegloscFocusLost

    private void odlegloscKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_odlegloscKeyTyped
        obslugaPolaLiczbowego(evt);
    }//GEN-LAST:event_odlegloscKeyTyped

    private void szerokoscKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_szerokoscKeyTyped
        obslugaPolaLiczbowego(evt);
    }//GEN-LAST:event_szerokoscKeyTyped

    private void wysokoscKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wysokoscKeyTyped
        obslugaPolaLiczbowego(evt);
    }//GEN-LAST:event_wysokoscKeyTyped

    private void szerokoscFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_szerokoscFocusLost
        int wartosc = 0;
        try {
            wartosc = Integer.parseInt(szerokosc.getText());
        } catch (NumberFormatException e) {
        } finally {
            if (wartosc == 0) {
                // zachowujemy starą wartość
                szerokosc.setText(Integer.toString(ustawienia.getSzerokosc()));
            } else // bieżemy sprawdzoną nową wartość
            {
                ustawienia.setSzerokosc(wartosc);
            }
        }
    }//GEN-LAST:event_szerokoscFocusLost

    private void wysokoscFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wysokoscFocusLost
        int wartosc = 0;
        try {
            wartosc = Integer.parseInt(wysokosc.getText());
        } catch (NumberFormatException e) {
        } finally {
            if (wartosc == 0) {
                // zachowujemy starą wartość
                wysokosc.setText(Integer.toString(ustawienia.getWysokosc()));
            } else // bieżemy sprawdzoną nową wartość
            {
                ustawienia.setWysokosc(wartosc);
            }
        }
    }//GEN-LAST:event_wysokoscFocusLost

    private void wiekKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wiekKeyTyped
        obslugaPolaLiczbowego(evt);
    }//GEN-LAST:event_wiekKeyTyped

    private void wektograficzneMinutyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wektograficzneMinutyKeyTyped
        obslugaPolaLiczbowego(evt);
}//GEN-LAST:event_wektograficzneMinutyKeyTyped

    private void KropkoweMinutyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KropkoweMinutyKeyTyped
        obslugaPolaLiczbowego(evt);
}//GEN-LAST:event_KropkoweMinutyKeyTyped

    private void osPrawaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_osPrawaKeyTyped
        obslugaPolaLiczbowego(evt);
    }//GEN-LAST:event_osPrawaKeyTyped

    private void osLewaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_osLewaKeyTyped
        obslugaPolaLiczbowego(evt);
    }//GEN-LAST:event_osLewaKeyTyped

    private void wektograficzneMinutyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wektograficzneMinutyFocusLost
        int wartosc = 0;
        try {
            wartosc = Integer.parseInt(wektograficzneMinuty.getText());
        } catch (NumberFormatException e) {
        } finally {
            if (wartosc == 0) {
                // zachowujemy starą wartość
                wektograficzneMinuty.setText(Integer.toString(ustawienia.getWektograficzneMinuty()));
            } else // bieżemy sprawdzoną nową wartość
            {
                ustawienia.setWektograficzneMinuty(wartosc);
            }
            jButton15.setToolTipText(labels.getString("wectographicTest") + " " + wartosc + "'");
        }
}//GEN-LAST:event_wektograficzneMinutyFocusLost

    private void KropkoweMinutyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_KropkoweMinutyFocusLost
        int wartosc = 0;
        try {
            wartosc = Integer.parseInt(KropkoweMinuty.getText());
        } catch (NumberFormatException e) {
        } finally {
            if (wartosc == 0) {
                // zachowujemy starą wartość
                KropkoweMinuty.setText(Integer.toString(ustawienia.getKropkoweMinuty()));
            } else // bieżemy sprawdzoną nową wartość
            {
                ustawienia.setKropkoweMinuty(wartosc);
            }
            jButton22.setToolTipText(labels.getString("dotTest") + " " + wartosc + "'");
        }
}//GEN-LAST:event_KropkoweMinutyFocusLost

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        testWektograficzny(2);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        testWektograficzny(5);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        testWektograficzny(10);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        testWektograficzny(20);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        testWektograficzny(50);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        testWektograficzny(ustawienia.getWektograficzneMinuty());
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        testKropkowy(2);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        testKropkowy(5);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        testKropkowy(10);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        testKropkowy(20);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        testKropkowy(50);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        testKropkowy(ustawienia.getKropkoweMinuty());
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        testWektograficzny(0.5);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        testKropkowy(0.5);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void wektograficznePowtorzeniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wektograficznePowtorzeniaFocusLost
        int wartosc = 0;
        try {
            wartosc = Integer.parseInt(wektograficznePowtorzenia.getText());
        } catch (NumberFormatException e) {
        } finally {
            if (wartosc == 0) {
                // zachowujemy starą wartość
                wektograficznePowtorzenia.setText(Integer.toString(ustawienia.getWektograficznePowtorzenia()));
            } else // bieżemy sprawdzoną nową wartość
            {
                ustawienia.setWektograficznePowtorzenia(wartosc);
            }
        }
}//GEN-LAST:event_wektograficznePowtorzeniaFocusLost

    private void wektograficznePowtorzeniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wektograficznePowtorzeniaKeyTyped
        obslugaPolaLiczbowego(evt);
    }//GEN-LAST:event_wektograficznePowtorzeniaKeyTyped

    private void kropkowePowtorzeniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kropkowePowtorzeniaKeyTyped
        obslugaPolaLiczbowego(evt);
    }//GEN-LAST:event_kropkowePowtorzeniaKeyTyped

    private void kropkowePowtorzeniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kropkowePowtorzeniaFocusLost
        int wartosc = 0;
        try {
            wartosc = Integer.parseInt(kropkowePowtorzenia.getText());
        } catch (NumberFormatException e) {
        } finally {
            if (wartosc == 0) {
                // zachowujemy starą wartość
                kropkowePowtorzenia.setText(Integer.toString(ustawienia.getKropkowePowtorzenia()));
            } else // bieżemy sprawdzoną nową wartość
            {
                ustawienia.setKropkowePowtorzenia(wartosc);
            }
        }
    }//GEN-LAST:event_kropkowePowtorzeniaFocusLost

    private void eksportujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eksportujActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(new String(labels.getString("exportPatientAndExaminationData")));
        fileChooser.addChoosableFileFilter(new MyFileChooserFilterTxt());
        int wybor = fileChooser.showSaveDialog(this);
        if (wybor == JFileChooser.APPROVE_OPTION) {
            File plik = fileChooser.getSelectedFile();
            // upewniamy się, czy użytkownik na pewno chce nadpisać plik
            if(plik.exists()){
                int wybrano = JOptionPane.showConfirmDialog(this, labels.getString("fileExistsErrorText"), labels.getString("fileExistsError"), JOptionPane.OK_CANCEL_OPTION);
                if(wybrano==JOptionPane.CANCEL_OPTION){
                    return;
                }
            }
            try {
                if(Locale.getDefault().equals(new Locale("pl","PL")))
                    pacjent.exportPl(plik);
                else
                    pacjent.exportEn(plik);
                // ustawienie właściwego rozszerzenia
                if(! plik.getName().endsWith(".txt"))
                    plik.renameTo(new File(plik.getPath()+".txt"));
            } catch (Exception e) {
                showError(e);
            }
        }
    }//GEN-LAST:event_eksportujActionPerformed

    private void jButtonLewWKlatceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLewWKlatceActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 1, -4, -2);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonLewWKlatceActionPerformed

    private void jButtonPiesWBudzieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPiesWBudzieActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 2, -2, 56);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonPiesWBudzieActionPerformed

    private void jButtonKoloZPiastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKoloZPiastaActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 3, 0, -1);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonKoloZPiastaActionPerformed

    private void jButtonGwiazdaDawidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGwiazdaDawidaActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 4, 0, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonGwiazdaDawidaActionPerformed

    private void jButtonSamochodWGarazuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSamochodWGarazuActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 5, 0, 54);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonSamochodWGarazuActionPerformed

    private void jButtonLiniaIKropkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLiniaIKropkiActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 6, -20, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonLiniaIKropkiActionPerformed

    private void jButtonZajacZBukietemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZajacZBukietemActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 7, 0, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonZajacZBukietemActionPerformed

    private void jButtonMotylNadKwiatemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMotylNadKwiatemActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 8, 0, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonMotylNadKwiatemActionPerformed

    private void jButtonWedkarzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWedkarzActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 9, 0, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonWedkarzActionPerformed

    private void jButtonGentelmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGentelmanActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 10, 0, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonGentelmanActionPerformed

    private void jButtonOkregiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkregiActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 11, 0, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonOkregiActionPerformed

    private void jButtonWiaderkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWiaderkoActionPerformed
         try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 12, 0, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonWiaderkoActionPerformed

    private void jButtonOczyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOczyActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 13, -40, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonOczyActionPerformed

    private void jButtonBierkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBierkiActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 14, 0, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonBierkiActionPerformed

    private void jButtonFiguryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiguryActionPerformed
        try {
            new pl.rdk.vision2.tests.SynoptiscopeTest(this, 15, -26, 0);
        } catch (Exception ex) {
            showError(ex);
        }
    }//GEN-LAST:event_jButtonFiguryActionPerformed

    private void jButtonCrossTestWithCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrossTestWithCircleActionPerformed
        new pl.rdk.vision2.tests.CrossTest(this,true);
}//GEN-LAST:event_jButtonCrossTestWithCircleActionPerformed

    private void jButtonVerticalBracketTestWithCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerticalBracketTestWithCircleActionPerformed
        new pl.rdk.vision2.tests.BracketTest_Vertical(this,true);
}//GEN-LAST:event_jButtonVerticalBracketTestWithCircleActionPerformed

    private void jButtonHorizontalBracketTestWithCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHorizontalBracketTestWithCircleActionPerformed
        new pl.rdk.vision2.tests.BracketTest_Horizontal(this,true);
}//GEN-LAST:event_jButtonHorizontalBracketTestWithCircleActionPerformed

    private void jMenuItemHelpTopicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpTopicsActionPerformed
        net.sourceforge.helpgui.gui.MainFrame helpFrame;

        // wybór właściwych lokali
        if(Locale.getDefault().equals(new Locale("pl","PL"))){
            helpFrame = new net.sourceforge.helpgui.gui.MainFrame("/docs/help/pl/","plastic");
        }else{
            helpFrame = new net.sourceforge.helpgui.gui.MainFrame("/docs/help/en/","plastic");
        }

        // centrowanie
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        helpFrame.setSize(800, helpFrame.getHeight());
        int w = helpFrame.getWidth();
        int h = helpFrame.getHeight();
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        helpFrame.setLocation(x, y);
        helpFrame.setTitle(new String(labels.getString("helpTitle")));

        // pokazanie okienka
        helpFrame.setVisible(true);

    }//GEN-LAST:event_jMenuItemHelpTopicsActionPerformed

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        wczytajActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        zapiszActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportActionPerformed
        eksportujActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemExportActionPerformed

    private void jCheckBoxMenuItemDualMonitorWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemDualMonitorWorkActionPerformed
        Test.dualMonitorWork = jCheckBoxMenuItemDualMonitorWork.getState();
}//GEN-LAST:event_jCheckBoxMenuItemDualMonitorWorkActionPerformed

    private void jCheckBoxMenuItemPolarisationChangedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemPolarisationChangedActionPerformed
        Test.polarisationChanged = jCheckBoxMenuItemPolarisationChanged.getState();
    }//GEN-LAST:event_jCheckBoxMenuItemPolarisationChangedActionPerformed

    private void jCheckBoxMenuItemShowResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemShowResultActionPerformed
        Test.showResult = jCheckBoxMenuItemShowResult.getState();
    }//GEN-LAST:event_jCheckBoxMenuItemShowResultActionPerformed

    /** uruchomienie testu wektograficznego z odpowiednim rozsunieciem
     *  ze sprawdzeniem zakresu tego rozsunięcia  */
    private void testWektograficzny(double iloscMinut) {
        // obliczamy wielkość rozsunięcia dla bieżącej odległości
        int rozsuniecie = ustawienia.rozsuniecie(iloscMinut);

        if ((rozsuniecie >= Configuration.ROZSUNIĘCIE_MIN) && (rozsuniecie <= Configuration.ROZSUNIĘCIE_MAX)) {
            // zaokrąglenie ilości minut
            String iloscMinutString;
            if (iloscMinut < 1) {
                iloscMinutString = ((new BigDecimal(iloscMinut)).setScale(1, BigDecimal.ROUND_UP)).toString();
            } else {
                iloscMinutString = ((new BigDecimal(iloscMinut)).setScale(0, BigDecimal.ROUND_UP)).toString();
            }
            // wszystko ok, test się wykona
            new pl.rdk.vision2.tests.VectographicTest(this, iloscMinutString, rozsuniecie);
        } else {
            // test się nie wykona, ale damy użytkownikowi razy,
            // czy musi się przysunąć, czy odsunąć
            if (rozsuniecie < Configuration.ROZSUNIĘCIE_MIN) {
                JOptionPane.showMessageDialog(this, labels.getString("toMakeThisTestYouHaveToGoFarterFromMonitor"), labels.getString("warning"), JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, labels.getString("toMakeThisTestYouHaveToGoCloserToMonitor"), labels.getString("warning"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /** uruchomienie testu kropkowego z odpowiednim rozsunieciem
     *  ze sprawdzeniem zakresu tego rozsunięcia  */
    private void testKropkowy(double iloscMinut) {
        // obliczamy wielkość rozsunięcia dla bieżącej odległości
        int rozsuniecie = ustawienia.rozsuniecie(iloscMinut);

        if ((rozsuniecie >= Configuration.ROZSUNIĘCIE_MIN) && (rozsuniecie <= Configuration.ROZSUNIĘCIE_MAX)) {
            // zaokrąglenie ilości minut
            String iloscMinutString;
            if (iloscMinut < 1) {
                iloscMinutString = ((new BigDecimal(iloscMinut)).setScale(1, BigDecimal.ROUND_UP)).toString();
            } else {
                iloscMinutString = ((new BigDecimal(iloscMinut)).setScale(0, BigDecimal.ROUND_UP)).toString();
            }
            // wszystko ok, test się wykona
            new pl.rdk.vision2.tests.RandomDotTest(this, iloscMinutString, rozsuniecie);
        } else {
            // test się nie wykona, ale damy użytkownikowi razy,
            // czy musi się przysunąć, czy odsunąć
            if (rozsuniecie < Configuration.ROZSUNIĘCIE_MIN) {
                JOptionPane.showMessageDialog(this, labels.getString("toMakeThisTestYouHaveToGoFarterFromMonitor"), labels.getString("warning"), JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, labels.getString("toMakeThisTestYouHaveToGoCloserToMonitor"), labels.getString("warning"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /** pozwala na wpisanie jedynie liczb (odrzuca przecinki, kropki i dowolne litery */
    private void obslugaPolaLiczbowego(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
            getToolkit().beep();
            evt.consume();
        }
    }

    /**
     * Wyświetla okienko z błędem
     * @param ex Błąd do obsłużenia. Jego opis zostanie wyświetlony w okienku
     */
    void showError(Exception ex) {
        JOptionPane.showMessageDialog(this, labels.getString("iWouldAppreciateSendingInformationAboutErrorToRdkAtRdkDotPl") + ex.toString(), labels.getString("programError"), JOptionPane.ERROR_MESSAGE);
    }

    private class ModelTabeli extends AbstractTableModel {

        private String[] nazwyKolumn = {labels.getString("data"), labels.getString("testName"), labels.getString("examinatedDisease"), labels.getString("result")};

        /** ilość kolumn w tabeli */
        public int getColumnCount() {
            return nazwyKolumn.length;
        }

        /** ilość rzędów w tabeli */
        public int getRowCount() {
            return pacjent.getIloscWykonanychTestow();
        }

        /** nazwa kolumny */
        @Override
        public String getColumnName(int col) {
            return nazwyKolumn[col];
        }

        /** zawartosc komorki */
        public Object getValueAt(int rzad, int kolumna) {
            switch (kolumna) {
                case 0:
                    return pacjent.getWynik(rzad).getData();
                case 1:
                    return pacjent.getWynik(rzad).getNazwaTestu();
                case 2:
                    return pacjent.getWynik(rzad).getBadanaWada();
                case 3:
                    return pacjent.getWynik(rzad).getWynik();
                default:
                    return new String(labels.getString("incorectColumnNumber"));
            }
        }

        /** typ zawartosci w komorce */
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /** czy edytowalna */
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }

    private class MyFileChooserFilterVis extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File f) {
            String filename = f.getName();
            return filename.endsWith(".vis") || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return labels.getString("visionFiles");
        }
    }
    
    private class MyFileChooserFilterTxt extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File f) {
            String filename = f.getName();
            return filename.endsWith(".txt") || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return labels.getString("textFiles");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField KropkoweMinuty;
    private javax.swing.JTextField cylinderLewy;
    private javax.swing.JTextField cylinderPrawy;
    private javax.swing.JPanel daneOsobowe;
    private javax.swing.JButton eksportuj;
    private javax.swing.JPanel fuzja;
    private javax.swing.JTextField imie;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonBierki;
    private javax.swing.JButton jButtonCrossTest;
    private javax.swing.JButton jButtonCrossTestWithCircle;
    private javax.swing.JButton jButtonFigury;
    private javax.swing.JButton jButtonGentelman;
    private javax.swing.JButton jButtonGwiazdaDawida;
    private javax.swing.JButton jButtonHorizontalBracketTest;
    private javax.swing.JButton jButtonHorizontalBracketTestWithCircle;
    private javax.swing.JButton jButtonKoloZPiasta;
    private javax.swing.JButton jButtonLewWKlatce;
    private javax.swing.JButton jButtonLiniaIKropki;
    private javax.swing.JButton jButtonMotylNadKwiatem;
    private javax.swing.JButton jButtonOczy;
    private javax.swing.JButton jButtonOkregi;
    private javax.swing.JButton jButtonPiesWBudzie;
    private javax.swing.JButton jButtonSamochodWGarazu;
    private javax.swing.JButton jButtonVerticalBracketTest;
    private javax.swing.JButton jButtonVerticalBracketTestWithCircle;
    private javax.swing.JButton jButtonWedkarz;
    private javax.swing.JButton jButtonWiaderko;
    private javax.swing.JButton jButtonZajacZBukietem;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemDualMonitorWork;
    public javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemPolarisationChanged;
    public javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemShowResult;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenuConfiguration;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemExport;
    private javax.swing.JMenuItem jMenuItemHelpTopics;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jednoczesnaPercepcja;
    private javax.swing.JPanel klasyczne;
    private javax.swing.JPanel kropkowe;
    private javax.swing.JTextField kropkowePowtorzenia;
    private javax.swing.JRadioButton man;
    private javax.swing.JMenuBar menu;
    private javax.swing.JTextField nazwisko;
    private javax.swing.JTextField odleglosc;
    private javax.swing.JTextArea opis;
    private javax.swing.JTextField osLewa;
    private javax.swing.JTextField osPrawa;
    private javax.swing.JTextField sferaLewa;
    private javax.swing.JTextField sferaPrawa;
    private javax.swing.JPanel stereopsja;
    private javax.swing.JTextField szerokosc;
    private javax.swing.JTable tabelaWynikow;
    private javax.swing.JPanel wadaRefrakcji;
    private javax.swing.JButton wczytaj;
    private javax.swing.JTextField wektograficzneMinuty;
    private javax.swing.JTextField wektograficznePowtorzenia;
    private javax.swing.JPanel wektoraficzne;
    private javax.swing.JTextField wiek;
    private javax.swing.JRadioButton woman;
    private javax.swing.ButtonGroup wyborPlci;
    private javax.swing.JTextField wysokosc;
    private javax.swing.JPanel zakladkaPacjent;
    private javax.swing.JPanel zakladkaSynoptofor;
    private javax.swing.JPanel zakladkaTesty;
    private javax.swing.JPanel zakladkaUstawienia;
    private javax.swing.JPanel zakladkaWyniki;
    private javax.swing.JTabbedPane zakladki;
    private javax.swing.JButton zapisz;
    // End of variables declaration//GEN-END:variables
}
