public class Blaa extends Resept {
    
    //subklassen Blaa av Resept, med konstruktør og den unike instansvariabelen farge.

    protected String farge = "Blaa";

    //I likhet med subklassen av Resept, Hvit, benytter vi superklassen Resept sin konstruktør for å tilordne verdiene.

    public Blaa(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    //metoden farge slik som i Resept, returnerer farge for instanser av Blaa.

    @Override
    public String farge(){
        return farge;
    }

    //metoden prisAaBetale slik som i Resept, returnerer prisen som skal betales. Unikt for instanser av Blaa er at de får 75% avslag på..
    //.. prisen, derav betaler de kun prisen* 0.25. Verdien rundes av til nærmeste hele verdi.

    @Override
    public int prisAaBetale(int pris){
        return ((int) (pris*0.25));
    }

    //en toStrisng metode slik som i Respet, med superklassens toString og tileggsinformasjonen Farge.

    @Override
    public String toString(){
        return super.toString() + ("\n Farge:" + farge);
    }
}