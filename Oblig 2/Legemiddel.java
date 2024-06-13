public abstract class Legemiddel { 

    //Den abstrakte superklassen Legemiddel med tilhørende konstruktør og instansvariabler.

    //Vi benytter en statisk int teller for å gi hvert legemiddel en unik ID. De andre instansvariablene blir tilordnet verdier i konstruktøren.

    protected static int teller = 0;
    protected String navn;
    protected int pris;
    protected double virkestoff;
    protected int ID;

    public Legemiddel(String navn, int pris, double virkestoff){
        teller++;
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        ID = teller;
    }

    //return av ID.

    public int hentId(){
        return ID;
    }

    //return av navn;

    public String hentNavn(){
        return navn;
    }

    //return av pris.

    public int hentPris(){
        return pris;
    }

    //return av virkestoff.

    public double hentVirkestoff(){
        return virkestoff;
    } 

    //tilordning av ny pris for legemiddel.

    public void settNyPris(int nyPris){
        pris = nyPris;
    }

    //toString metode med tilhørende informasjon.

    @Override
    public String toString(){
        return (" Navn: " + navn + ". Pris: " + pris + ". Virkestoff: " + virkestoff + ". ID: " + ID);
    }
}