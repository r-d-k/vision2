package pl.rdk.vision2.tests;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.TexturePaint;

/**
 *
 */
public class Configuration {
    /** nazwa okienta z testem (widoczne po zminimalizowaniu */
    public final static String NAME="Test widzenia obuocznego";
    /** szerokosc okna z testem  (800 pixli)*/
    public final static int MAX_X=800;
    /** wysokosc okna z testem  (600 pixli)*/
    public final static int MAX_Y=600;
    /** jeden pixel **/
    public final static int PIXEL=1;
    /** jednostkowe przesuniecie w pixelach **/
    public final static int STEP=2;
    /** o ile zwiększyć obszar przy repaint (1 pixel)*/
    public final static int OFFSET=1;
    /** linia normalna (1px szerokości)*/
    public final static BasicStroke LINIA_NORMALNA = new BasicStroke(1);
    /** linia potrójna (3px szerokości)*/
    public final static BasicStroke LINIA_POTROJNA = new BasicStroke(3);
    /** linia potrójna (6px szerokości)*/
    public final static BasicStroke LINIA_SZECIOKROTNA = new BasicStroke(6);
    /** linia srednia (15px szerokości) */
    public final static BasicStroke LINIA_SREDNIA = new BasicStroke(15);
    /** szerokość grubej linii w pixelach (300) */
    public final static int LINIA_GRUBA_INT = 300;
    /** linia gruba (300px szerokości) */
    public final static BasicStroke LINIA_GRUBA = new BasicStroke(LINIA_GRUBA_INT);
    /** średnica koła z dziurką (40px) */
    public final static int SREDNICA_KOLA_Z_DZIURKA = 40;
    /** średnica pełnego koła w teście z trójkątami (100px) */
    public final static int SREDNICA_PELNEGO_KOLA = 100;
    /** szerokosc belki w testach krzyżowym i klamrowym (30px) */
    public final static int SZER_BELKI=30;
    /** wysokość belki w testach krzyżowym i klamrowym (440px) */
    public final static int WYS_BELKI=440;
    /** szerokość podziałki w teście wskazówkowym (8px) */
    public final static int SZER_PODZIALKI=8;
    /** wysokość podziałki w teście wskazówkowym (30px) */
    public final static int WYS_PODZIALKI=30;
    /** mniejszy promien podzialki */
    public final static int POINTER_SMALLER_RADIUS=30;
    /** większy promień podziałki */
    public final static int POINTER_BIGGER_RADIUS=255;
    /** odstep miedzy podzialka a wskazowka w teście wskazówkowym (8px)
     *  oraz odstęp między trójkątem a linią w stereoteście */
    public final static int ODSTEP=8;
    /** maksymalna szerokość wskazówki u nasady (przy środku testu) (28px) */
    public final static int SZER_WSKAZOWKI=28;
    /** tyle trzeba dodac do x w testach z zewnętrznym kołem */
    public final static int ROZNICA=MAX_X/2-MAX_Y/2;
    /** tekstura do wypełniania obiektów widocznych okiem PRAWYM */
    public static TexturePaint TEKSTURA;
    /** odstep od ramki w teście z trójkątami */
    public final static int MARGINES=50;
    /** początkowe rozsunięcie trójkątów w minutach kątowych */
    public final static int ROZSUNIECIE=10;
    /** długość boku trójkąta */
    public final static int BOK_TROJKATA=140;
    /** długość wysokości trójkąta */
    public final static int WYSOKOSC_TROJKATA=(int)(BOK_TROJKATA*Math.sqrt(0.75));
    /** pozycjaX wyniku */
    public final static int WYNIK_X=0;
    /** pozycjaY wyniku (ole string będzie rysowany do góry, a nie w dół) */
    public final static int WYNIK_Y=10;
    /** rozmiarX wyniku */
    public final static int WYNIK_SZER=150;
    /** rozmiarY wyniku */
    public final static int WYNIK_WYS=10;
    /** minimalne poziome rozsunięcie testu wektograficznego lub kropkowego */
    public final static int ROZSUNIĘCIE_MIN=2;
    /** maksymalne poziome rozsunięcie testu wektograficznego lub kropkowego */
    public final static int ROZSUNIĘCIE_MAX=BOK_TROJKATA-30;
    /** kolor tła (domyślnie: ŻÓŁTAWY) */
    public static Color KOLOR_TLA = new  Color(236,233,216);
    /** kolor testu (domyślnie: CZARNY) */
    public static Color KOLOR_TESTU = Color.BLACK;
    /** figura widoczna prawym okiem */
    public static int EYE_RIGHT=0;
    /** figura widoczna lewym okiem */
    public static int EYE_LEFT=1;
    /** figura widoczna obuocznie  */
    public static int EYE_BOTH=2;
    /** ziarnistość testów kropkowych */
    public static int ZIARNISTOSC=2;
    /** gestosc kropek 0-brak 1-wszystkie */
    public static double GESTOSC=0.5;
    /** suma składowych RGB powyżej której pixele nie są wyświetlane
     * (chodzi o odcięcie białego i podobnych) */
    public static final int CUTTING_SUM = 755;
}
