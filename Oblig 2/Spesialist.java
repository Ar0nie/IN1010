public class Spesialist extends Lege implements Godkjenningsfritak{
    
    //Subklassen Spesialist av Lege, med den unike instansvariabelen kontrollID.

    protected String kontrollID;

    //Benytter konstruktøren til superklassen Lege for å tilordne verdien navn, den unike instansvariabel kontrollID tilordnes lokalt.

    public Spesialist(String navn, String kontrollID){
        super(navn);
        this.kontrollID = kontrollID;
    }

    //en return av kontrollID.

    @Override
    public String hentKontrollID(){
        return kontrollID;
    }

    //en toString fra superklassen Lege, samt tileggsinfromasjon slik som lege type, og KontrollID.

    @Override
    public String toString(){
        return super.toString() + "\n Utskrivend lege type: Spesialist \n KontrollID: " + kontrollID;
    }
}
