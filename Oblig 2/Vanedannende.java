public class Vanedannende extends Legemiddel {

    //Subklassen Vanedannende av Legemiddel, med tilhørende konstruktør og unike instansvariabel styrke.

    protected int styrke;

    //I konstruktøren benytter vi superklassens konstruktør for verdier som deles med superklassen, den unike instansvariabelen styrke..
    //.. tilordnes lokalt i Vanedannende konstruktøren.

    public Vanedannende(String navn, int pris, double virkestoff, int styrke){
        super(navn,pris,virkestoff);
        this.styrke = styrke;
    }

    //return av styrke.

    public int hentVanedannendeStyrke(){
        return styrke;
    }  

    //En toString metode med tillegsinformasjonen, Type og Styrke.

    @Override
    public String toString(){
        return super.toString() + (". Type: Vanedannende . Styrke: " + styrke);
        
    }
    
    
}
