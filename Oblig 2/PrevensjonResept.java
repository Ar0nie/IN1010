public class PrevensjonResept extends Hvit {
    
    //subklassen PrevensjonResept av Hvit.

    //konstruktøren benytter superklassenes konstruktør for tilordning av verdier.

    public PrevensjonResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    //I metoden prisAaBetale trekkes det ifra en fast sum tilsvarende 108. deretter sjekker man at verdien på prisen ikke går under tilatt verdi 0.

    @Override
    public int prisAaBetale(int pris){
        pris -= 108;

        if(pris > 0){
            return pris;
        } 
        else {
            return 0;
        }
    }

    //toString fra superklasse med tileggsinformasjonen Type og Rabatt.

    @Override
    public String toString(){
        return super.toString() + ("\n Type: Prevensjons resept\n Rabatt: 108kr for p-resept");
    }
}
