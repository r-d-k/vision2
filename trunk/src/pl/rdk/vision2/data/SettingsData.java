package pl.rdk.vision2.data;

import java.math.BigDecimal;

/**
 *
 * @author rdk
 */
public class SettingsData {
    private final int rozmiarKrzyza=240; // [px] ilosc pixeli w krzyzu
    
    private int odleglosc;
    private int szerokosc;
    private int wysokosc;
    private int wektograficzneMinuty;
    private int kropkoweMinuty;
    private int wektograficznePowtorzenia;
    private int kropkowePowtorzenia;
  
  
    public SettingsData(){
        odleglosc=100;                  // [cm] domyslna odleglosc od monitora
        szerokosc=72;                   // [mm] domyslna szerokosc krzyza
        wysokosc=72;                    // [mm] domyslna wysokosc krzyza
        wektograficzneMinuty=75;    // ['] domyslna ilosc minut w tescie wektograficznym
        kropkoweMinuty=75;          // ['] domyslna ilosc minut w tescie kropkowym
        wektograficznePowtorzenia=4; // domyślna ilość powtórzeń
        kropkowePowtorzenia=4;       // domyślna ilość powtórzeń     
    }

    /** oblicza o ile trzeba rozsunac trojkaty dla uzyskania odpowiedniego 
     * kąta widzenia stereoskopowego  */
    public int rozsuniecie(double kat){
        // rozsuniecie w cm
        double wynik_wst=Math.tan(stopnie2radiany(kat/60.0))*odleglosc;
        // przeliczamy na pixele
        wynik_wst=10.0*rozmiarKrzyza*wynik_wst/szerokosc;
        // zaokraglamy do pełnych pixeli
        return (int) Math.round(wynik_wst);
    }
    
        /** oblicza o ile trzeba rozsunac trojkaty dla uzyskania odpowiedniego 
         * kąta widzenia stereoskopowego  
         * wynik jest zaokrąglany do najbliższej parzystej liczby całkowitej*/
    public int rozsuniecieParzyste(double kat){
        // rozsuniecie w cm
        double wynik_wst=Math.tan(stopnie2radiany(kat/60.0))*odleglosc;
        // przeliczamy na pixele
        wynik_wst=10.0*rozmiarKrzyza*wynik_wst/szerokosc;
        // zaokraglamy do najbliższej parzystej
        return 2*((int) Math.round(wynik_wst/2));
    }
      
    /** oblicza anizejkonie */
    public String anizejkonia(int biezaca, int oryginalna){
        double wada=biezaca-oryginalna;
        wada=wada/oryginalna;
        wada=wada*100;
        return Double.toString(((new BigDecimal(wada)).setScale(2, BigDecimal.ROUND_UP)).doubleValue()); 
    }
      
    /** oblicza wadę pionową */
    public String wadaPionowa(int ilePixeli){
        return Double.toString(wada(wysokosc2cm(ilePixeli)));
    }
    
    /** oblicza wadę pozioma */
    public String wadaPozioma(int ilePixeli){
        return Double.toString(wada(szerokosc2cm(ilePixeli)));
    }
    
    /** oblicza wielkosc wady w minutach kątowych */
    private double wada(double ileCentymetrow){
        double wada=ileCentymetrow/odleglosc;
        wada=Math.atan(wada);
        wada=radiany2stopnie(wada);
        wada=wada*60;
        return ((new BigDecimal(wada)).setScale(2, BigDecimal.ROUND_UP)).doubleValue();       
    }
    
    /** przelicza wymiary poziome w pixelach na centymetry */
    private double wysokosc2cm(int ilePixeli){
        return ((double)(wysokosc*ilePixeli))/((double)(rozmiarKrzyza*10));
    }

    /** przelicza wymiary pionowe w pixelach na centymetry */
    private double szerokosc2cm(int ilePixeli){
        return ((double)(szerokosc*ilePixeli))/((double)(rozmiarKrzyza*10));
    }
   
    private double radiany2stopnie(double ileRadianow){
        return ileRadianow*180.0/Math.PI;
    }
    
    private double stopnie2radiany(double ileStopni){
        return ileStopni*Math.PI/180.0;
    }

    public int getKropkoweMinuty() {
        return kropkoweMinuty;
    }

    public void setKropkoweMinuty(int kropkoweMinuty) {
        this.kropkoweMinuty = kropkoweMinuty;
    }

    public int getKropkowePowtorzenia() {
        return kropkowePowtorzenia;
    }

    public void setKropkowePowtorzenia(int kropkowePowtorzenia) {
        this.kropkowePowtorzenia = kropkowePowtorzenia;
    }

    public int getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(int odleglosc) {
        this.odleglosc = odleglosc;
    }

    public int getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(int szerokosc) {
        this.szerokosc = szerokosc;
    }

    public int getWektograficzneMinuty() {
        return wektograficzneMinuty;
    }

    public void setWektograficzneMinuty(int wektograficzneMinuty) {
        this.wektograficzneMinuty = wektograficzneMinuty;
    }

    public int getWektograficznePowtorzenia() {
        return wektograficznePowtorzenia;
    }

    public void setWektograficznePowtorzenia(int wektograficznePowtorzenia) {
        this.wektograficznePowtorzenia = wektograficznePowtorzenia;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }    
}