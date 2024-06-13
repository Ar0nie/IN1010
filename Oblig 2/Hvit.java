public class Hvit extends Resept {
    
    //subklassen Hvit av Resept, med konstruktør og den unike instansvariabelen farge.

    protected String farge = "Hvit";

    //I konstruktøren tilordnes det verdier ved hjelp av superklassen Resept sin konstruktør.

    public Hvit(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    //metoden farge slik som i Resept, returnerer farge for instanser av Hvit.

    @Override
    public String farge(){
        return farge;
    }

    //metoden prisAaBetale slik som i Resept, returnerer prisen som skal betales.

    @Override
    public int prisAaBetale(int pris){
        return pris;
    }

    //En toString metode som returnerer en streng fra superklassen Resept, samt tileggsinformasjonen farge.

    @Override
    public String toString(){
        return super.toString() + ("\n Farge: " + farge);
    }
}
