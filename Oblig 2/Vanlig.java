public class Vanlig extends Legemiddel {
    
    //subklassen Vanlig av Legemiddel, med tilhørende konstruktør og instansvariabler.

    public Vanlig(String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
        
    }

    //En toString metode med tileggsinformasjon om hvilken type legemiddel dette er.

    @Override
    public String toString(){
       return super.toString() + ". Type: Vanlig";
    }
}