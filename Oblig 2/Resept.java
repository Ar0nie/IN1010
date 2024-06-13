public abstract class Resept {
    
    //Den abstrakte superklassen Resept med tilhørende konstruktør og instansvariabler.
    //Vi benytter en statisk int teller for å tilordne verdien reseptId og gi hver resept en unik verdi.

    protected static int teller = 0;
    protected int reseptId;
    protected int pasientId;
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int reit;

    //Instansvariablene tilordnes verdi i konstruktøren.

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        teller++;
        reseptId = teller;
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit; 
    }

    //return av reseptId.

    public int hentId(){
        return reseptId;
    }

    //return av en instans av Legemiddel.

    public Legemiddel hentLegemiddel(){
        return legemiddel;
    } 

    //return av en instans av Lege.

    public Lege hentLege(){
        return utskrivendeLege;
    }

    //return av pasientId.

    public int hentPasientId(){
        return pasientId;
    }

    //return av reit, eller antall ganger resepten kan benyttes.

    public int hentReit(){
        return reit;
    }

    //en boolsk metode som reduserer reit antallet med 1 dersom reit har en verdi over 0. Avhengig av if, else sjekken returneres true eller false.

    public boolean bruk(){
        if (reit > 0){
            reit--;
            return true;
        } else {
            return false;
        }
    }

    //abstract metode for å returnere fargen til resepten, dette vil vi tilordne kode i subklassene.

    abstract public String farge();

    //abstract metode for å sjekke prisen som skal betales for en resept. Vil varierer avhengig av subklassen og deres spesifikasjoner.

    abstract public int prisAaBetale(int pris);

    //toString metode som skriver ut relevant informasjon om Resept.

    public String toString(){
        return (" Resept ID: " + reseptId + "\n Legemiddel: " + legemiddel + "\n Utskrivende Lege: " + utskrivendeLege + "\n Pasient ID: " + pasientId + "\n Reit: " + reit);
    }

}
