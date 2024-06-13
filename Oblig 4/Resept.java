public abstract class Resept implements KanLagres{
    private static int reseptAntall = 0;
    private int id;
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected Pasient pasient;
    protected int reit;
    
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        this.id = ++this.reseptAntall;
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasient = pasient;

        // ugyldig hvis reit er 0
        this.reit = reit;
    }

    public int hentId(){
        return id;
    }

    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }

    public Lege hentLege(){
        return utskrivendeLege;
    }

    public Pasient hentPasient(){
        return pasient;
    }

    public int hentReit(){
        return reit;
    }

    // Forsooker å bruke resepten én gang. Returner false om resepten alt er oppbrukt, ellers returnerer den true.
    public boolean bruk(){
        if (reit > 0){
            reit--;
            return true;
        }else{
            return false;
        }
    }

    // Returnerer reseptens farge. Enten “hvit” eller "blaa"
    abstract public String farge();

    // Returnerer prisen pasienten må betale
    abstract public int prisAaBetale();
}
