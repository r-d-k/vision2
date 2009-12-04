/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.rdk.vision2.library;

import java.util.ResourceBundle;

/**
 *
 * @author robkar
 */
public class TestName {
    /* niezmienne, numery testow */
    public final static int KRZYZOWY=1;
    public final static int KRZYZOWY_Z_KOLKIEM=2;
    public final static int KLAMROWY_PIONOWY=3;
    public final static int KLAMROWY_PIONOWY_Z_KOLKIEM=4;
    public final static int KLAMROWY_POZIOMY=5;
    public final static int KLAMROWY_POZIOMY_Z_KOLKIEM=6;
    public final static int WSKAZOWKOWY_PIONOWY=7;
    public final static int WSKAZOWKOWY_POZIOMY=8;
    public final static int WSKAZOWKOWY_PODWOJNY=9;
    public final static int TROJKATNY=10;
    public final static int STEREOBALANS=11;
    public final static int WEKTOGRAFICZNY=12;
    public final static int KROPKOWY=13;
    public final static int SYNOPTOFOR_LEW=14;
    public final static int SYNOPTOFOR_PIES=15;
    public final static int SYNOPTOFOR_PIASTA=16;
    public final static int SYNOPTOFOR_KLEPSYDRA=17;
    public final static int SYNOPTOFOR_SAMOCHOD=18;
    public final static int SYNOPTOFOR_LINIA=19;
    public final static int SYNOPTOFOR_KROLIK=20;
    public final static int SYNOPTOFOR_KWIATEK=21;
    public final static int SYNOPTOFOR_KOSCIOL=22;
    public final static int SYNOPTOFOR_ZEGAR=23;
    public final static int SYNOPTOFOR_KOLA=24;
    public final static int SYNOPTOFOR_WIADRO=25;
    public final static int SYNOPTOFOR_OCZY=26;
    public final static int SYNOPTOFOR_BIERKI=27;
    public final static int SYNOPTOFOR_FIGURY=28;
    
    private ResourceBundle labels;
    private static TestName testName;

    private TestName(){
        labels = ResourceBundle.getBundle("pl/rdk/vision2/languages/i18n");
    }

    public static TestName getTestName(){
        if(testName==null)
            testName=new TestName();
        return testName;
    }

    /** zwraca opis testu */
    public String getNazwaTestu(int nrTestu){
        switch(nrTestu){
            case KRZYZOWY:
                return labels.getString("crossTest");
            case KRZYZOWY_Z_KOLKIEM:
                return labels.getString("crossTestWithCentralStimulus");
            case KLAMROWY_PIONOWY:
                return labels.getString("verticalBracketTest");
            case KLAMROWY_PIONOWY_Z_KOLKIEM:
                return labels.getString("verticalBracketTestWithCentralStimulus");
            case KLAMROWY_POZIOMY:
                return labels.getString("horizontalBracketTest");
            case KLAMROWY_POZIOMY_Z_KOLKIEM:
                return labels.getString("horizontalBracketTestWithCentralStimulus");
            case WSKAZOWKOWY_PIONOWY:
                return labels.getString("verticalPointerTest");
            case WSKAZOWKOWY_POZIOMY:
                return labels.getString("horizontalPointerTest");
            case WSKAZOWKOWY_PODWOJNY:
                return labels.getString("doublePointerTest");
            case TROJKATNY:
                return labels.getString("triangleTest");
            case STEREOBALANS:
                return labels.getString("stereobalans");
            case WEKTOGRAFICZNY:
                return labels.getString("wectographicTest");
            case KROPKOWY:
                return labels.getString("dotTest");
            case SYNOPTOFOR_LEW:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("lionInCage"));
            case SYNOPTOFOR_PIES:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("dogInKennel"));
            case SYNOPTOFOR_PIASTA:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("hubInWheel"));
            case SYNOPTOFOR_KLEPSYDRA:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("hourglass"));
            case SYNOPTOFOR_SAMOCHOD:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("carInGarage"));
            case SYNOPTOFOR_LINIA:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("lineAndDot"));
            case SYNOPTOFOR_KROLIK:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("rabbit"));
            case SYNOPTOFOR_KWIATEK:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("flower"));
            case SYNOPTOFOR_KOSCIOL:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("church"));
            case SYNOPTOFOR_ZEGAR:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("clock"));
            case SYNOPTOFOR_KOLA:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("circles"));
            case SYNOPTOFOR_WIADRO:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("bucket"));
            case SYNOPTOFOR_OCZY:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("eyes"));
            case SYNOPTOFOR_BIERKI:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("pickAStick"));
            case SYNOPTOFOR_FIGURY:
                return new String(labels.getString("synoptiscope")+ " : " + labels.getString("figures"));
            default:
                return labels.getString("unknownTest");
        }
    }

    /** zwraca opis badanej wady */
    public String getOpisBadanejWady(int nrTestu){
        switch(nrTestu){
            case KRZYZOWY:
            case KRZYZOWY_Z_KOLKIEM:
                return labels.getString("horizontalOrVerticalPhoria");
            case KLAMROWY_PIONOWY:
            case KLAMROWY_PIONOWY_Z_KOLKIEM:
                return labels.getString("verticalPhoriaOrVerticalAniseikonia");
            case KLAMROWY_POZIOMY:
            case KLAMROWY_POZIOMY_Z_KOLKIEM:
                return labels.getString("horizontalPhoriaOrHorizontalAniseikonia");
            case WSKAZOWKOWY_PIONOWY:
                return labels.getString("verticalPhoria");
            case WSKAZOWKOWY_POZIOMY:
                return labels.getString("horizontalPhoria");
            case WSKAZOWKOWY_PODWOJNY:
                return labels.getString("deviationFromAxisHorizontalOrVertical");
            case TROJKATNY:
                return labels.getString("angleOfStereoscopy");
            case STEREOBALANS:
                return labels.getString("dominationOfEyeOrAngleOfStereoscopy");
            case WEKTOGRAFICZNY:
                return labels.getString("angleOfStereoscopy");
            case KROPKOWY:
                return labels.getString("angleOfStereoscopy");
            case SYNOPTOFOR_LEW:
            case SYNOPTOFOR_PIES:
            case SYNOPTOFOR_PIASTA:
            case SYNOPTOFOR_KLEPSYDRA:
            case SYNOPTOFOR_SAMOCHOD:
            case SYNOPTOFOR_LINIA:
            case SYNOPTOFOR_KROLIK:
            case SYNOPTOFOR_KWIATEK:
            case SYNOPTOFOR_KOSCIOL:
            case SYNOPTOFOR_ZEGAR:
            case SYNOPTOFOR_KOLA:
            case SYNOPTOFOR_WIADRO:
            case SYNOPTOFOR_OCZY:
            case SYNOPTOFOR_BIERKI:
            case SYNOPTOFOR_FIGURY:
                return labels.getString("horizontalOrVerticalPhoria");
            default:
                return labels.getString("unknownTest");
        }
    }
}
