package pl.rdk.vision2.data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import pl.rdk.vision2.library.TestName;



    /** PRZECHOWUJE WYNIK POJEDYNCZEGO TESTU  */
public class ResultData implements Serializable {
    /* PRYWATNE */
    private Date data; 
    private int nrTestu;
    private String wynik;
    
    /** tworzy nowy wynik */
    public ResultData(int nrTestu, String wynik){
        data = new Date();
        this.nrTestu=nrTestu;
        this.wynik=wynik;
    }

    /** zwraca wynik w postaci stringu */
    @Override
    public String toString(){
        String wyn=new String();
        wyn+=getFullData();
        wyn+="\t";
        wyn+=getNazwaTestu();
        wyn+="\t";
        wyn+=getBadanaWada();
        wyn+="\t";
        wyn+=getWynik();
        return  wyn;
    }
    
    /** zwraca datę wykonania testu */
    public String getData(){
        SimpleDateFormat sdf;
        if(isToday(data))
            sdf = new SimpleDateFormat("HH:mm:ss", new Locale("pl","PL"));
        else
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("pl","PL"));
        return sdf.format(data);
    }
    
    /** zwraca pełną datę wykonania testu */
    public String getFullData(){
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("pl","PL"));
        return sdf.format(data);
    }
    
/** zwraca nazwę testu */
    public String getNazwaTestu(){
        return TestName.getTestName().getNazwaTestu(nrTestu);
    }
    
    /** zwraca badaną wadę */
    public String getBadanaWada(){
        return TestName.getTestName().getOpisBadanejWady(nrTestu);
    }
    
    /** zwraca wynik testu */
    public String getWynik(){
        return wynik;
    }
    
    /**  sprawdza, czy data jest dzisiejsza */
    private boolean isToday(Date data){
        Calendar toCheck = new GregorianCalendar();
        toCheck.setTime(data);
        Calendar today = new GregorianCalendar();
        return ((toCheck.get(GregorianCalendar.YEAR) == today.get(GregorianCalendar.YEAR)) 
                && (toCheck.get(GregorianCalendar.MONTH) == today.get(GregorianCalendar.MONTH)) 
                && (toCheck.get(GregorianCalendar.DAY_OF_MONTH) == today.get(GregorianCalendar.DAY_OF_MONTH)));
    }
}
