package pl.rdk.vision2.data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

/** Dane pacjenta oraz wyniki jego badań */
public class PatientData implements Serializable {
    private String imie;
    private String nazwisko;
    private boolean kobieta;
    private String wiek;
    private String opis;
    private String sferaLewa;
    private String sferaPrawa;
    private String cylinderLewy;
    private String cylinderPrawy;
    private String osLewa;
    private String osPrawa;
    private Vector wynikiTestow;
    
    /** konstruktor tworzy pustego pacjenta */
    public PatientData(){
        kobieta=true;
        imie=new String("");
        nazwisko=new String("");
        wiek=new String("0");
        opis=new String("");
        sferaLewa=new String("0,00");
        sferaPrawa=new String("0,00");
        cylinderLewy=new String("0,00");
        cylinderPrawy=new String("0,00");
        osLewa=new String("0");
        osPrawa=new String("0"); 
        wynikiTestow=new Vector();
    }
    
    public void save(File nazwaPliku) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nazwaPliku));
        out.writeBoolean(kobieta);
        out.writeObject(imie);
        out.writeObject(nazwisko);
        out.writeObject(wiek);
        out.writeObject(opis);
        out.writeObject(sferaLewa);
        out.writeObject(sferaPrawa);
        out.writeObject(cylinderLewy);
        out.writeObject(cylinderPrawy);
        out.writeObject(osLewa);
        out.writeObject(osPrawa);
        for(Enumeration e=wynikiTestow.elements(); e.hasMoreElements();) {
            out.writeObject(e.nextElement());	
	}
        out.close();
    }
    
    public void exportPl(File nazwaPliku) throws FileNotFoundException, IOException {
        PrintWriter out= new PrintWriter(new FileWriter(nazwaPliku));
        out.println("DANE PACJENTA");
        out.println("imię: "+imie);
        out.println("nazwisko: "+nazwisko);
        out.println("wiek: "+wiek);
        out.print("płeć: ");
        if(kobieta==true)
            out.println("kobieta");
        else
            out.println("mężczyzna");
        out.println("Opis: "+opis);
        out.println();
        out.println("KOREKCJA OKULAROWA");
        out.println("OP: "+sferaPrawa+"DS "+cylinderPrawy+"DC "+osPrawa+"st.");
        out.println("OL: "+sferaLewa+"DS "+cylinderLewy+"DC "+osLewa+"st.");
        out.println();
        out.println("WYNIKI TESTÓW");
        for(Enumeration e=wynikiTestow.elements(); e.hasMoreElements();) {
            out.println(e.nextElement().toString());	
        }
        out.close();
    }

        public void exportEn(File nazwaPliku) throws FileNotFoundException, IOException {
        PrintWriter out= new PrintWriter(new FileWriter(nazwaPliku));
        out.println("PATIENT DATA");
        out.println("name: "+imie);
        out.println("surname: "+nazwisko);
        out.println("age: "+wiek);
        out.print("sex: ");
        if(kobieta==true)
            out.println("woman");
        else
            out.println("man");
        out.println("Description: "+opis);
        out.println();
        out.println("SPECTACLE CORRECTION");
        out.println("O.D.: "+sferaPrawa+"DS "+cylinderPrawy+"DC "+osPrawa+"deg.");
        out.println("O.S.: "+sferaLewa+"DS "+cylinderLewy+"DC "+osLewa+"deg.");
        out.println();
        out.println("TEST RESULTS");
        for(Enumeration e=wynikiTestow.elements(); e.hasMoreElements();) {
            out.println(e.nextElement().toString());
        }
        out.close();
    }
    
    public void load(File nazwaPliku) throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        ResultData wynik;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nazwaPliku));
        try {
            setKobieta(in.readBoolean());
            setImie(in.readObject().toString());
            setNazwisko(in.readObject().toString());
            setWiek(in.readObject().toString());
            setOpis(in.readObject().toString());
            setSferaLewa(in.readObject().toString());
            setSferaPrawa(in.readObject().toString());
            setCylinderLewy(in.readObject().toString());
            setCylinderPrawy(in.readObject().toString());
            setOsLewa(in.readObject().toString());
            setOsPrawa(in.readObject().toString());
            while(true){               				
                wynik=(ResultData) in.readObject();
                wynikiTestow.addElement(wynik);
            }
	} catch (EOFException endOfFileException) {
            //nic nie robimy (ten błąd oznacza tylko koniec pliku)
	} finally {
            in.close();
	}
    }

    public String getCylinderLewy() {
        return cylinderLewy;
    }

    public void setCylinderLewy(String cylinderLewy) {
        this.cylinderLewy = cylinderLewy;
    }

    public String getCylinderPrawy() {
        return cylinderPrawy;
    }

    public void setCylinderPrawy(String cylinderPrawy) {
        this.cylinderPrawy = cylinderPrawy;
    }

    public String getImie() {
            return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public boolean isKobieta() {
        return kobieta;
    }

    public void setKobieta(boolean kobieta) {
        this.kobieta = kobieta;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOsLewa() {
        return osLewa;
    }

    public void setOsLewa(String osLewa) {
        this.osLewa = osLewa;
    }

    public String getOsPrawa() {
        return osPrawa;
    }

    public void setOsPrawa(String osPrawa) {
        this.osPrawa = osPrawa;
    }

    public String getSferaLewa() {
        return sferaLewa;
    }

    public void setSferaLewa(String sferaLewa) {
        this.sferaLewa = sferaLewa;
    }

    public String getSferaPrawa() {
        return sferaPrawa;
    }

    public void setSferaPrawa(String sferaPrawa) {
        this.sferaPrawa = sferaPrawa;
    }

    public String getWiek() {
        return wiek;
    }

    public void setWiek(String wiek) {
        this.wiek = wiek;
    }
    
    public int getIloscWykonanychTestow(){
        return wynikiTestow.size();
    }
    
    /** zwraca i-ty wynik */
    public ResultData getWynik(int i){
        return (ResultData) wynikiTestow.get(i);
    }

    public void addWynikTestu(ResultData _wynik){
        wynikiTestow.addElement(_wynik);
    }
  
    
    
}

