public class MilResept extends Hvit {

    //subklassen Milresept av Hvit.

    //Mottar ingen unike verdier, men antallet reit tilordnes den faste verdien 3. Benytter konstruktørene oppover i klassehierarkitet for å tilordne verdiene.
    
    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    //Instanser av MilResept har 100% rabatt, derfor vil metoden prisAaBetale returnere verdien 0.

    @Override
    public int prisAaBetale(int pris){
        return 0;
    }

    //toString fra superklasen med tileggsinformasjon type resept og rabatt.

    @Override
    public String toString(){
        return super.toString() + ("\n Type: Militærresept" + "\n Rabatt: Resepten er gratis!");
    }
}
