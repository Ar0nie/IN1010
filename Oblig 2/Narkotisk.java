public class Narkotisk extends Legemiddel{

    //subklassen Narkotisk av klassen Legemiddel, med den unike instansvariabelen styrke.

    protected int styrke;

    //I konstruktøren tilordnes verdiene ved hjelp av konstruktøren i superklassen Legemiddel. 
    //Instansvariabelen styrke tilordnes lokalt.

    public Narkotisk(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    //return av styrke.

    public int hentNarkotiskStyrke(){
        return styrke;
    }


    //Enkel toString som benytter superklassens toString metode. I tilegg bruker vi ...
    //.. den unike instansvariabelen styrke fra Narkotisk.

    @Override
    public String toString(){
        return super.toString() + (". Styrke: " + styrke);
        
    }

}